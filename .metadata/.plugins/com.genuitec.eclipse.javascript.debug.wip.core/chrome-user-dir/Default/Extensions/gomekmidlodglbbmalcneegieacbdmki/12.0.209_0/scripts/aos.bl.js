(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);throw new Error("Cannot find module '"+o+"'")}var f=n[o]={exports:{}};t[o][0].call(f.exports,function(e){var n=t[o][1][e];return s(n?n:e)},f,f.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
/**
 * Package all ABEK background layer libs.
 */
module.exports = {
  
  locale : require('./locale')

};
},{"./locale":2}],2:[function(require,module,exports){
if (typeof browser === "object") chrome = browser;

module.exports = require('../abek/locale')({ // pass browser specific impl.
    
    /**
     * Get raw localization string for key in Chrome
     */
    getRawLocalizedString: function(key) {
      return chrome.i18n.getMessage(key);
    },
    /**
     * Get local resource URL in Chrome
     */
    getLocalResourceURL: function(file) {
      return chrome.extension.getURL(file);
    },
    /**
     * Retrieve browser language - from navigatro obj.
     */
    getRawBrowserLocale : function () {
      return window.navigator.language;
    }

});
},{"../abek/locale":3}],3:[function(require,module,exports){
/*
 * ba - browser specific implementation
 */
module.exports = function(bs) {
  // maping specific languege resources to resolve locales correctly
  // lowerCase(locale) => resource in locales directory
  var SPECIFIC_LANG_MAP = {
      en_gb: 'en_GB',
      pt: 'pt_BR', pt_br: 'pt_BR', pt_pt: 'pt_PT',
      zh: 'zh_TW', zh_tw: 'zh_TW', zh_cn: 'zh_CN'
  };

  // Default browser specific code
  bs = bs || {
    /**
     * Get extension local resource URL
     */
    getLocalResourceURL : function (resourcePath) {
      return resourcePath; // override with browser spec code
    },
    /**
     * Get just the localization string resource
     */
    getRawLocalizedString : function (key) {
      return key; // override with browser spec code
    },
    /**
     * Retrieve browser language
     */
    getRawBrowserLocale : function () {
      return "en"; //require('sdk/l10n/json/core').locale() || "en";
    }

  };

  var rawLocale = bs.getRawBrowserLocale();
  var rawLocaleArr = rawLocale.split('-');
  var browserLang = rawLocaleArr[0];
  var browserLocale = rawLocaleArr[rawLocaleArr.length-1];


  return {
    /**
     * Get extension local resource URL
     */
    getLocalResourceURL : bs.getLocalResourceURL,
    /**
     * Get just the localization string resource
     */
    getRawLocalizedString : bs.getRawLocalizedString,
    /**
     * Get localization string for key
     * @param  {String} key  Key for the language string
     * @param  {String} args [optional] arguments to insert in the resource
     * @return {String}      Translated value
     */
    getLocalizedString : function(key, args) {
      return this.insertInResourceFormat(bs.getRawLocalizedString(key), args);
    },

    /**
     * Replace "%s" placeholders in strings with provided arguments.
     */
    insertInResourceFormat : function(formatted, args) {
        for (var arg in args) {
            formatted = formatted.replace("%s", args[arg]);
        }
        return formatted;
    },

    /**
     * A mean to localize Mustache templates prior they are parsed and used by templating engine.
     * @param template to localize
     * @return localized template
     */
    localizeTemplate: function(template) {
      // img:/pat/to/img.png = provide local path
      // string:resourceKey[,insertParam1[,insertParam2[,insertParam3]]] - provide localized strin with inserted params
      var replacer = function (match, rscType, rscIdPath, p1, p2, p3, offset, string) {
        if (rscType == 'img') {
          return this.getLocalResourceURL(rscIdPath);
        } else if (rscType == 'string') {
          return this.getLocalizedString(rscIdPath, [p1, p2, p3]);
        } else {
          return rscIdPath;
        }
      };

      return template ?
        template.replace(
          /\[\[(img|string):([^,\]]+)(?:,([^,]+)(?:,([^,]+)(?:,([^,]+))?)?)?\]\]/gi,
          replacer.bind(this)
        )
        : template;
    },

    /**
     * Get browser's lang setting.
     */
    getBrowserLang: function() {
      return browserLang;
    },

    /**
     * Get browser's locale setting.
     */
    getBrowserLocale: function() {
      return browserLocale;
    },

    /**
     * Get browser language and adjust it
     *  to match resources specified for the extension
     *  (TODO - use ext. specific definition of resource to adjust)
     */
    getAdjustedBrowserLang: function() {
      var lang = rawLocale.replace("-", "_");
      var slang = SPECIFIC_LANG_MAP[lang.toLowerCase()];
      if (slang) {
        lang = slang;
      } else {
        var pos = lang.indexOf("_");
        if(pos >= 0) {
          lang = lang.substr(0, pos);
        }
      }
      return lang;
    }

  };
};

},{}],4:[function(require,module,exports){
/*******************************************************************************
 *  avast! Online Security plugin ::: Backgroung view manager for AOS panel
 *  (c) 2014-2015 Avast Corp.
 ******************************************************************************/

module.exports = function(ABEK, AOS, AvastWRC, _) {

  var CONSTS = {
    PanelPortId: "BE.Panel",
    RATING_POSITIVE: 100,
    RATING_NEGATIVE: 0,
    RATING_FLAGS_NULL: {
      shopping: 0,
      social: 0,
      news: 0,
      it: 0,
      corporate: 0,
      pornography: 0,
      violence: 0,
      gambling: 0,
      drugs: 0,
      illegal: 0,
	  others: 0
    }
  };

  /* Specify UI Icons for Social networks trackers */
  var DntTrackersIcons = {
     39: 'gplus',
    703: 'facebook',
    704: 'twitter',
    722: 'twitter',
    110: 'in', // linkedIn
    400: 'pin' // Pinterest
    //xxx: 'snapchat'
    //xxx: 'vk'
    //xxx: 'youtube'
  };
  var DefaultTrackerIcon = 'globe';

  var _templateCache = {};

  function addDnttrackersIcons(dntData) {
    _.each(dntData.groups, function(group) {
      group.desc = AvastWRC.bs.getLocalizedString(group.type_desc_key);
      _.each(group.trackers, function(tracker) { 
        tracker.icon = DntTrackersIcons[tracker.id] || DefaultTrackerIcon;
      });
    });
    return dntData;
  }

  function calcDntGroupStates(dntData) {
    _.each(dntData.groups, function(group) {
      var total = group.totalTrackers, active = group.activeTrackers;
      group.allAllowed = (active === 0 && total > 0);
      group.allBlocked = (total === active && total > 0); 
      group.someBlocked = (!(group.allAllowed || group.allBlocked) && total > 0);
    });
    return dntData;
  }

  function sendWebRepVote(url, rating, rating_flags, callback) {
    var flags = _.clone(CONSTS.RATING_FLAGS_NULL);
    if (rating_flags) { 
      //flags = _.extend(flags, rating_flags); 
      _.forOwn( rating_flags, function(val, key) {
        flags[key] = val ? 1 : 0;
      });
    }
    var v = {
      uri : url,
      vote: {
        rating: rating,
        flags : flags
      }
    };
    AOS.Voting.set(url, v, callback);
    _bal.emitEvent('webrep.voted', url, rating, rating_flags);
  }

  // ABEK - BROWSER SPECIFIC
  var PanelBal = {
    initMessaging: function(attachPanelHandler, dettachPanelHandler) {
      chrome.runtime.onConnect.addListener(function(port) {
        if (port.name == CONSTS.PanelPortId) {
          port.onMessage.addListener(function initListener(msgObj) {
            if (msgObj.type === 'init') {
              port.onMessage.removeListener(initListener);
              attachPanelHandler({tabId: msgObj.tabId, url: msgObj.url,
                sendMessage: function(type, msgObj) {
                  msgObj.type = type;
                  port.postMessage(msgObj);
                },
                addMessageHandler: function(handler) {
                  port.onMessage.addListener(function(msgObj) {
                    var type = msgObj.type;
                    if (type) {
                      handler(type, msgObj);
                    }
                  });
                }, 
                addCloseHandler: function(handler) {
                  port.onDisconnect.addListener(handler);
                } 
              });
            }
          });
        }
      }.bind(this));
    },
    templateCache: {}, // make private
    /**
     * Load template.
     * @param key to identify the template for caching
     * @param file to load the template from if not cached
     * @param callback to process the template
     */
    getTemplate: function(key, templateFile, cb) {
      if (_templateCache[key]) {
        cb(_templateCache[key]);
      } else {
        AvastWRC.bs.loadFile(templateFile, function(template) {
          template = ABEK.locale.localizeTemplate(template);  
          _templateCache[key] = template;
          cb(template);
        }.bind(this), true /*no file cache*/);
      }
    }
  };

  //===========================

  function TabPanel (handler) {
    this.tabId = handler.tabId;
    this.url = handler.url;
    this.host =  AvastWRC.bal.getHostFromUrl(handler.url);
    this.handler = handler;
    this.data = {};
    handler.addMessageHandler(this.messageHandler.bind(this));
    handler.addCloseHandler(function () {
      _bal.emitEvent('mainPanel.closed', this.url);
    }.bind(this));
  }

  TabPanel.prototype.initPanel = function() {
    var dntData = addDnttrackersIcons( AvastWRC.bal.DNT.getUIData(this.tabId, this.host) );
    dntData = calcDntGroupStates(dntData);
    var data = {
            security: this.getSecurityStatus(),
            webrep: {
              rate: {}
              // rated: {rating: 'possitive'}
              //reason: {} 
              //thanks: {}
            },
            dnt: dntData
          };
    this.data = data;
    _.each(dntData.groups, function(group) { 
      group.show = ( group.type == 'Social' && group.totalTrackers > 0 ); 
    }); // expand Social group if not empty
    PanelBal.getTemplate('panelTemp', 'common/ui/templates/aos.control.html', function(template) {
      this.handler.sendMessage('initPanel', {
        template: template,
        data: data
      });
    }.bind(this));    
    _bal.emitEvent('mainPanel.opened', {url:this.url, id: this.tabId});
  };

  TabPanel.prototype.setValue = function(keypath, value) {
    this.handler.sendMessage('setValue', {keypath: keypath, value: value});
  };

  TabPanel.prototype.getSecurityStatus = function() {
    var wrc = AvastWRC.Cache.getNoTTL(this.host);
    if(!wrc || !wrc.values) {
      return {
        status : 'unknown',
        description: AvastWRC.bs.getLocalizedString('ratingTextUndefined')
      };
    } else {
      switch(wrc.getRatingCategory()) {
        case AvastWRC.RATING_NONE:
          return {status: 'unknown', description: AvastWRC.bs.getLocalizedString('ratingTextUndefined')};
        case AvastWRC.RATING_GOOD:
            return {status: 'ok', description: AvastWRC.bs.getLocalizedString('ratingTextPositive')};
        case AvastWRC.RATING_AVERAGE:
          return {status: 'attention', description: AvastWRC.bs.getLocalizedString('ratingTextAverage')};
        case AvastWRC.RATING_BAD:
          return {status: 'error', description: AvastWRC.bs.getLocalizedString('ratingTextBad')};
      }
    }
  };

  TabPanel.prototype.setDntGroupShow = function(index, state) {
      this.data.dnt.groups[index].show = state;
      this.setValue('dnt.groups.' + index + '.show', state );
  };    


  TabPanel.prototype.messageHandler = function(type, msgObj) {
    var handle = 'handle_' + type;
    if (typeof this[handle] === 'function') {
      this[handle].call(this, msgObj);
    }
  };

  TabPanel.prototype.handle_action = function (msgObj) {
    var action = msgObj.action, args, handle;
    if (action && action.length > 0) {
      handle = 'handle_action_' + action;
      if (typeof this[handle] === 'function') {
        args = (msgObj.args) ? msgObj.args.slice() : [];
        args.splice(0, 0, msgObj.context);
        this[handle].apply(this, args);
      }
    }
  };

  TabPanel.prototype.handle_viewInit = function (msgObj) {
    AOS.Voting.get(this.url, function (rated) {
      if (rated && rated.vote) {
        this.setValue('webrep', {rated: {positive: (rated.vote.rating > 0) }} );
      }     
    }.bind(this));
  };

  TabPanel.prototype.handle_action_showGroup = function (context, groupType) {
    var enable=null, disable=null, groups = this.data.dnt.groups, group, i;
    for (i = 0; i < groups.length; i++) {
      group = groups[i];
      if (group.type == groupType && group.totalTrackers > 0) { 
        if (group.show)
          disable = i;
        else
          enable = i;
      } else {
        if (group.show)
          disable = i;
      }
    }
    if (disable !== null) this.setDntGroupShow(disable, false);
    if (enable !== null) this.setDntGroupShow(enable, true);
  };

  TabPanel.prototype.handle_action_blockGroup = function (context, groupType, block) {
    var trackersIds = _.map(context.trackers, function(trk) {return trk.id;});
    _bal.emitEvent('request.dntWhitelist', groupType, trackersIds, this.host, block);
  };

  TabPanel.prototype.handle_action_blockTracker = function (context, trackerId, block) {
    _bal.emitEvent('request.dntWhitelist', undefined, trackerId, this.host, block);
  };

  TabPanel.prototype.handle_action_openSettings = function () {
    var optionsPage = AvastWRC.bs.getLocalResourceURL('options.html');
    AvastWRC.bs.openInNewTab(optionsPage);
    _bal.emitEvent('request.open.settings', this.url);
  };

  TabPanel.prototype.handle_action_openHome = function () {
    AvastWRC.bs.openInNewTab("http://www.avast.com");
    _bal.emitEvent('request.open.home', this.url);
  };

  TabPanel.prototype.handle_action_activateDnt = function () {
    _bal.emitEvent('request.dnt.activate', this.url);
  };

  TabPanel.prototype.handle_action_blockDnt = function () {
    _bal.emitEvent('request.dnt.block', this.url);
  };

  TabPanel.prototype.handle_action_revertVote = function () {	  
	  AOS.Voting.get(this.url, function (rated) {
	      if (rated && rated.vote) {
	        this.setValue('webrep', {rated: false, rate: {} } );
	      }     
	    }.bind(this));
	  AOS.Voting.remove(this.url);
  };
  
  TabPanel.prototype.handle_action_ratedPositive = function () {
    sendWebRepVote(this.url, CONSTS.RATING_POSITIVE, undefined, function() {
        this.setValue('webrep', { thanks: {} });
      }.bind(this) 
    );
	
	var _this = this;
	
	setTimeout(function(){
		AOS.Voting.get(_this.url, function (rated) {
			if (rated && rated.vote) {
				_this.setValue('webrep', {rated: {positive: (rated.vote.rating > 0) }} );
			}
		}.bind(_this));
	},3000);
  };

  TabPanel.prototype.handle_action_ratedNegative = function () {
    sendWebRepVote(this.url, CONSTS.RATING_NEGATIVE, undefined, function() {
      this.setValue('webrep', { reason: {
          pornography: false, 
          violence: false,
          gambling: false,
          drugs: false,
          illegal: false,
		  others: false
        } 
      });
    }.bind(this));
  };

  TabPanel.prototype.handle_action_ratingDetails = function (context) {
    sendWebRepVote(this.url, CONSTS.RATING_NEGATIVE, context, function() {
      this.setValue('webrep', { thanks: {} });
    }.bind(this) );
	
	var _this = this;
	
	setTimeout(function(){
		AOS.Voting.get(_this.url, function (rated) {
			if (rated && rated.vote) {
				_this.setValue('webrep', {rated: {positive: (rated.vote.rating > 0) }} );
			}
		}.bind(_this));
	},3000);
  };

  var _bal = null;
  var _tabPanelHandlers = {};

  return {
    init: function(balInst) {
      _bal = balInst;
      PanelBal.initMessaging(function(messagingHandler) {
        var tabPanelHandler = new TabPanel(messagingHandler);
        var tabId = messagingHandler.tabId;
        messagingHandler.addCloseHandler(function() {
          delete _tabPanelHandlers[tabId];
        });
        _tabPanelHandlers[tabId] = tabPanelHandler;
        tabPanelHandler.initPanel();
      });
    },

    /* Register Event handlers */
    registerModuleListeners: function(ee) {
      // ee.on('urlInfo.response', AvastWRC.bal.sp.onUrlInfoResponse.bind(AvastWRC.bal.sp));
      ee.on('dnt.trackers.updated', function(category, trkIds, host, block) {
        if(!_.isArray(trkIds)) {
          trkIds = [trkIds];
        }
        var emitTo = _.filter(_tabPanelHandlers, function(handler) {return handler.host == host;});
        _.each(emitTo, function(handler) {
          var data = handler.data;
          if (data && data.dnt) {
            _.each(data.dnt.groups, function(group, groupIndex) {
              if (category == null || category == group.type) {
                // update trackers
                _.each(group.trackers, function(tracker, trackerIndex) {
                  if (_.contains(trkIds, tracker.id)) {
                    handler.setValue('dnt.groups.' + groupIndex + '.trackers.' + trackerIndex + '.active', block);
                  }
                });
                if (category && category == group.type) {
                  // update group
                  handler.setValue('dnt.groups.' + groupIndex + '.active', block);
                }
              }
            });
          }
        });
      }); // dntTrackers.updated

      ee.on('dnt.activated', function() {
        _.forOwn(_tabPanelHandlers, function(handler, tabId) {
          handler.setValue('dnt.active', true);
        });
      });
      ee.on('dnt.blocked', function() {
        _.forOwn(_tabPanelHandlers, function(handler, tabId) {
          handler.setValue('dnt.active', false);
        });
      });

    },
    
    /**
     * Return related default settings.
     */
    getModuleDefaultSettings: function() {
      return {};
    },

    trace: function (log) {
      log('--- BE.Panel ---');
      var handlers = _.reduce(_tabPanelHandlers, function (sum, handler, key) {return sum + 1; }, 0);
      log('panel handlers: ', handlers);
    }

  };

}; // module.exports
},{}],5:[function(require,module,exports){
/*******************************************************************************
 *  Avast WebRep Voting
 ******************************************************************************/
module.exports = function (AvastWRC) {

    var votesData = {};
    var votesLoaded = false;

    Voting = {
        /* Always get votes from storage. */
        loadVotes : function() {
            var self = this;
            AvastWRC.getStorage("votes", function(votes){
                if(typeof votes === "string") {
                    self.votesData = JSON.parse(votes);
                }
            });
            
            votesLoaded = true;
            return votesData;
        },
        /* Votes lazy loading */
        getVotes: function() {
            if (votesLoaded) {
                return votesData;
            } 
            else {
                return this.loadVotes();
            }
        },
      /**
       * Update vote in local storage.
       */
        updateLocalVotes: function(domain, rating) {
            var votes = this.loadVotes();
            votes[domain] = rating;
            this.save(votes);
        },
        /**
         * Set rating for given domain. Stores rating local and sends it to the backend.
         */ 
        set : function(domain, rating, callback) {
            AvastWRC.setVote(domain, rating, function() {
                this.updateLocalVotes(domain, rating);
                if (callback) callback.apply(this, arguments);
            }.bind(this));
        },
        get : function(domain, callback){
            var votes = this.getVotes();
            if(votes[domain]) { 
                callback(votes[domain]);
            }
        },
        remove : function(domain){    	       
            this.updateLocalVotes(domain, {});
        },
        save : function(votes) {
            votesData = votes;
            AvastWRC.setStorage("votes", JSON.stringify(votes));
        },
    };

    return Voting;

};
},{}],6:[function(require,module,exports){
(function(AvastWRC, _) {

  AvastWRC.bal.registerModule(
    require('../../aos/common/panel-bl')(
      require('../../abek-crx/bl'), 
      { // AOS package
        Voting : require('../../aos/common/voting')(AvastWRC)
      }, 
      AvastWRC, 
      _
    )
  );

}).call(this, AvastWRC, _);
},{"../../abek-crx/bl":1,"../../aos/common/panel-bl":4,"../../aos/common/voting":5}]},{},[6])
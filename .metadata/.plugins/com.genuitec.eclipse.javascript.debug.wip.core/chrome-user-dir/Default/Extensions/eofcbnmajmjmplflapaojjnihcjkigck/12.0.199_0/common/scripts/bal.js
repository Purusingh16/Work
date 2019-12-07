/*******************************************************************************
 *
 *  avast! Online Security plugin
 *  (c) 2013 Avast Corp.
 *
 *  @author: Lucian Corlaciu
 *
 *  Background Core - cross browser
 *
 ******************************************************************************/

(function(_, EventEmitter) {

  // Extension editions
    var DEFAULT_EDITION = 0; // if no ed. determined start with AOS ed.

    var EDITION_FEATURES = [
    // 0 - AOS
        {
            applicationEvents : true, // ev. for gamification
            newUrlInfoVersion : true,
            safePrice : true,
        },
    // 1 - ABOS
        {
            applicationEvents : false, // ev. for gamification
            newUrlInfoVersion : true,
            safePrice : false,
        },
    ];

    var CORE_DEFAULT_SETTINGS = { // core defaults
        current : {
            callerId : 0,  // Not set by default
            userId : null,  // Persisted userId
        },
        features : {},
    };

    if (typeof AvastWRC == "undefined") { AvastWRC = {}; } //AVAST Online Security - namespace

    var localStorage = null; // Browser specific local storage
    var sing; // AvastWRC.bal instance - browser agnostic
    var back; // background script instance - browser specific

    var _forcedEdition = null;

  // Web Reputation
    var RATING_LEVEL = ["Undefined", "Positive", "Average", "Bad",];
    var RATING_COLOR = ["#767683","#0CB754","#F1C80B","#F5203E",];

  // Regexp matching URLs that will be enabled with avast:// protocol actions
    var AOS_URLS_ENABLED_URLS = /^http[s]?\:\/\/aos.avast.com(\:\d+)?\/upgrade(\/)?/;

  // Actions assigned to avast protocol: avast://[action]
  //  - action is in form of message to be send to the background script: bal.js
    var AOS_URLS_ACTIONS = {
        "settings" : { message: "openSettings", data : {}, }, // avast://settings -> open settings page
    };

    var SHOW_WELCOME_PAGE_RULE = function (prevMinor, currMinor) {
    // Stop showing the welcome/update screens until provided with better content
        return false;
    };

    AvastWRC.PHISHING_REDIRECT = AvastWRC.SAFE_ZONE_REDIRECT = "https://www.avast.com";
    AvastWRC.SITE_CORRECT_MSG_REDIRECT = "https://www.avast.com/sitecorrect.html";
    AvastWRC.AVAST_UPGRADE_PAGE_URL = "http://aos.avast.com/upgrade/";

    AvastWRC.CREATE_MESSAGE_BOX_TIMEOUT = 1500;

  /*
   * Definition of libraries to inject into content pages - default libs
   *  - modify using 'modifyInjectLibs'
   */
    var _injectLibs = {
        css: [
            "common/ui/css/extension.css",
        ],
        libs: [
            "common/libs/jquery-3.1.1.js",
            "common/libs/mustache.js",
            "common/libs/eventemitter2.js",
            "common/scripts/templates.js",
            "common/scripts/ial.js",
        ],
        script: "scripts/extension.js",
    };


  /**
   * Alter the DNT defaults to force the DNT optin. - set false
   */
    function _alterDntFeaturesDefaults (settings) {
        _(["dntSocial","dntAdTracking","dntWebAnalytics","dntOthers",]).each(
      function(key) {settings.features[key] = false;}
    );
        settings.features["dnt"] = true;
    }

    AvastWRC.bal = {

        EXT_AOS_ID : 0,
        EXT_ABOS_ID : 1,

        RATING_COLOR : RATING_COLOR,
	
        safePrice: false,
    
        brandingType: 0, 

        reqServices: 0x0000, // services  of UrlInfo

        _bal_modules : [], // initialized modules
        _core_modules : [], // core modules
        _bootstrap_modules : [], // bootstrap modules based on edition config
    /**
     * Register BAL module.
     * @param {Object} module to register
     */
        registerModule: function(module) {
            if (typeof module.bootstrap === "function") {
                this._bootstrap_modules.push(module);
            } else {
                this._core_modules.push(module);
            }
        },
    /**
     * EventEmitter instance to hangle background layer events.
     * @type {Object}
     */
        _ee: new EventEmitter({wildcard:true, delimiter: ".",}),
    /**
     * Register events with instance of EventEmitter.
     * @param  {Object} callback to register with instance of eventEmitter
     * @return {void}
     */
        registerEvents: function(registerCallback, thisArg) {
            if (typeof registerCallback === "function") {
                registerCallback.call(thisArg, this._ee);
            }
        },
    // TODO mean to unregister the events
    /**
     * Emit background event
     * @param {String} event name
     * @param {Object} [arg1], [arg2], [...] event arguments
     */
        emitEvent: function() {
      // delegate to event emitter
            this._ee.emit.apply(this._ee, arguments);
        },
    /**
     * browser type
     * @type {String}
     */
        browser: "",

    /**
     * Get important info about the extension running.
     */
        trace: function (log) {
            _.each(this._bal_modules, function(module) {
                if (typeof module.trace === "function") {
                    module.trace(log);
                }
            });

            console.log("> all listeners ", this._ee.listeners("*").length);
        },

    /**
     * Initialization
     * @param  {String} browserType
     * @param  {Object} _back
     * @return {Object}
     */
        init: function(browserType, _back, locStorage, editionConfig, forceEdition) {
            if(sing){
                return sing;
            }

            _forcedEdition = forceEdition;

            EDITION_FEATURES = _.isArray(editionConfig) ?
        _.merge(EDITION_FEATURES, editionConfig) :
        _.map(EDITION_FEATURES, function (features) { return _.merge(features, editionConfig); });
        // same config for all editions applied to all features

            this.browser = browserType;
            back = _back;
            localStorage = locStorage;
            sing = this;

            this.initEdition( _forcedEdition == null ? DEFAULT_EDITION : _forcedEdition );

            this.settings = new AvastWRC.bal.troughStorage("settings");
            this.mergeInSettings(CORE_DEFAULT_SETTINGS);

            var avastConfig = AvastWRC.getStorage("AvastConfig");
            if (avastConfig) {
                var guids = JSON.parse(avastConfig);
                if (guids) {
                    AvastWRC.CONFIG.GUID = guids.guid;
                    AvastWRC.CONFIG.AUID = guids.auid;
                    AvastWRC.CONFIG.UUID = guids.uuid;
                    AvastWRC.CONFIG.HWID = guids.hwid;

                    if(guids.plg_guid) {                    
                        AvastWRC.CONFIG.PLG_GUID = guids.plg_guid;
                    }
                    else {
                        if(guids.guid != null && guids.hwid != null) {
                            AvastWRC.CONFIG.PLG_GUID = AvastWRC.bal.utils.getRandomUID();
                        }
                        else if(guids.guid != null && guids.hwid == null) {
                            AvastWRC.CONFIG.PLG_GUID = guids.guid;
                            AvastWRC.CONFIG.GUID = null;
                        }                        
                    }
                    var new_guids = {
                        "guid": AvastWRC.CONFIG.GUID,
                        "plg_guid": AvastWRC.CONFIG.PLG_GUID,
                        "auid": AvastWRC.CONFIG.AUID,
                        "hwid": AvastWRC.CONFIG.HWID,
                        "uuid": AvastWRC.CONFIG.UUID,
                    };
                    AvastWRC.setStorage("AvastConfig", JSON.stringify(new_guids));
                }
            }else{                
                AvastWRC.CONFIG.PLG_GUID = AvastWRC.bal.utils.getRandomUID();                
                var guids = {
                    "guid": AvastWRC.CONFIG.GUID,
                    "plg_guid": AvastWRC.CONFIG.PLG_GUID,
                    "auid": AvastWRC.CONFIG.AUID,
                    "hwid": AvastWRC.CONFIG.HWID,
                    "uuid": AvastWRC.CONFIG.UUID,
                };
                AvastWRC.setStorage("AvastConfig", JSON.stringify(guids));
	        }
            Q.fcall(function() {
                return this._core_modules;
            }.bind(this))
        .then(this.initModuleSettings.bind(this))
        .then(this.initModules.bind(this))
        .then(function() {
          // Connect Avast if it listens on the machine
            return AvastWRC.local.connect(this);
        }.bind(this))
        .get("avastEdition")
        .then(this.getCurrentEdition.bind(this))
        .then(this.initEdition.bind(this))
        .then(this.bootstrapInit.bind(this))
        .then(this.initModuleSettings.bind(this))
        .then(this.initModules.bind(this))
        .then(this.afterInit.bind(this))
        .fail(function (e) {
            console.error("Error in bal.init: ", e);
        });

      
            if (_.isArray(editionConfig)) {
    	  this.safePrice = editionConfig[0].safePrice;
    	  this.brandingType = editionConfig[0].brandingType;
            }
            else {
    	  this.safePrice = editionConfig.safePrice;
    	  this.brandingType = editionConfig.brandingType;
            }
        
      /* AOSP-639, AOSP-694*/
            if (this.safePrice && !AvastWRC.getStorage("landingPageShown")) {
                this.openLandingPageTab(this.brandingType);
            }      

            return this;
        },
        initEdition : function (edition) {
            var features = EDITION_FEATURES[edition];

            AvastWRC.CONFIG.EDITION  = edition;
            AvastWRC.CONFIG.FEATURES = features;
            this.reqUrlInfoServices  = features.reqUrlInfoServices;
            AvastWRC.CONFIG.CALLERID = features.callerId;
            AvastWRC.CONFIG.EXT_TYPE = features.extType;
            AvastWRC.CONFIG.EXT_VER  = features.extVer;
            AvastWRC.CONFIG.DATA_VER = features.dataVer;
      
            return Q.fcall(function() { return edition;});
        },
        bootstrapInit : function (edition) {
            var features = EDITION_FEATURES[edition];
            var bootstrapped = _.reduce(this._bootstrap_modules, function(bModules, moduleBootstrap) {
                var module = moduleBootstrap.bootstrap(features);
                if (module) bModules.push(module);
                return bModules;
            }, [], this);
            return Q.fcall(function () { return bootstrapped; });
        },
        initModules : function (modules) {
            _.each(modules, function(module) {
                if (module) {
          // register individual modules - init and register with event emitter
                    if (typeof module.init === "function") module.init(this);
                    if (typeof module.registerModuleListeners === "function") module.registerModuleListeners(this._ee);
                    this._bal_modules.push(module);
                }
            }, this);
            return Q.fcall(function () { return modules; });
        },
        initModuleSettings : function (modules) {
            var defSettings = AvastWRC.bal.getDefaultSettings(modules);
            AvastWRC.bal.mergeInSettings(defSettings);
            AvastWRC.bal.updateOldSettings();
            return Q.fcall(function () { return modules; });
        },
        afterInit : function () {
            _.each(this._bal_modules, function(module) {
        // after init - all modules initialized
                if (typeof module.afterInit === "function") module.afterInit();
                this._bal_modules.push(module);
            }, this);
        },
    /**
     * Called once the local based service get initialized.
     */
        initLocalService: function(port) {
            _.each(this._bal_modules, function(module) {
        // after init - all modules initialized
                if (typeof module.initLocalService === "function") module.initLocalService(port);
            }, this);
        },
    /**
     * Modify the inject libraries of the instance.
     * @param {Function} callback function to modify the libraries to inject.
     */
        modifyInjectLibs: function(modifyCallback) {
            if (typeof modifyCallback === "function") {
                _injectLibs = modifyCallback(_injectLibs);
            }
        },
    /**
     * Get extension definition of libraries to inject into content page.
     */
        getInjectLibs: function() {
            return _injectLibs;
        },
    /**
     * creates the settings object or updates an already present one
     * @return {void}
     */
        mergeInSettings: function(settings) {
            var newSettings = this.settings.get(),
                big, small;

            for(big in settings) {
                if(newSettings[big] === undefined){
                    newSettings[big] = settings[big];
                }
                else {
                    for(small in settings[big]) {
                        if (newSettings[big][small] === undefined) {
                            newSettings[big][small] = settings[big][small];
                        }
                    }
                }
            }
            this.settings.set(newSettings);
        },
    /**
     * updates the stored settings from AvastWRC
     * @return {void}
     *
     * TODO - save and use settings in a single place
     */
        updateOldSettings: function() {
            var settings = this.settings.get();
            AvastWRC.CONFIG.COMMUNITY_IQ = settings.features.communityIQ;
            AvastWRC.CONFIG.ENABLE_SERP = settings.features.serp;
            AvastWRC.CONFIG.ENABLE_SERP_POPUP = settings.features.serpPopup;
            AvastWRC.CONFIG.ENABLE_SAS = settings.features.safeShop;
            AvastWRC.CONFIG.USERID = settings.current.userId;
        },

        getCurrentEdition : function(localAvastEdition) {
            var deferred = Q.defer();
            if (_forcedEdition == null) {
                var settings = this.settings.get();
                var storedEdition = settings.current.edition;
                if (localAvastEdition !== undefined && localAvastEdition !== null) {
                    if (!storedEdition || storedEdition !== localAvastEdition) {
                        settings.current.edition = localAvastEdition;
                        this.settings.set(settings);
                    }
                    deferred.resolve( localAvastEdition );
                } else {
                    deferred.resolve( storedEdition || DEFAULT_EDITION );
                }
            } else {
                deferred.resolve( _forcedEdition );
            }
            return deferred.promise;
        },

    /**
     * Notify the listeners about feature settings change.
     */
        featureSettingChanged: function(key, oldVal, newVal) {
            this._ee.emit("featureChanged." + key, newVal, oldVal);
            this._ee.emit("feature.changed", key, newVal, oldVal);
        },
    /**
     * Hook in listener to register feature settings and enable/disable the functionality.
     * Linstener is triggered first time upon being registered to get current value.
     * @param {String} key of the feature in sttings
     * @param {Function} listener function called with (newVal, [oldVal]), or (currentVal) on registration
     */
        hookOnFeatureChange: function(key, changeListener) {
            this._ee.on("featureChanged." + key, changeListener);
      // run listener to register current settings
            var settings = this.settings.get();
            changeListener(settings.features[key]);
        },
    /**
     * Default settings with default values
     * @return {Object}
     */
        getDefaultSettings: function(modules) {
            return _.reduce (modules,
        function(defaults, module) {
            if (typeof module !== "undefined" 
				&& typeof module.getModuleDefaultSettings === "function") {
                var moduleDefaults = module.getModuleDefaultSettings();
                if (moduleDefaults) {
                    defaults = _.merge(defaults, moduleDefaults);
                }
            }
            return defaults;
        },
        CORE_DEFAULT_SETTINGS
      );
        },
        getLandingPageCode: function (lang, local) {
            if (lang === "af" && local === "za") return "en-za";
            if (lang === "ar" && local === "sa") return "ar-sa";
            if (lang === "ar" && local === "ae") return "en-ae";
            if (lang === "ar") return "ar-ww";
            if (lang === "be") return "ru-ru";
            if (lang === "ca") return "es-es";
            if (lang === "cs") return "cs-cz";
            if (lang === "cy") return "en-gb";
            if (lang === "da") return "da-dk";
            if (lang === "de") return "de-de";
            if (lang === "el") return "el-gr";
            if (lang === "en" && local === "au") return "en-au";
            if (lang === "en" && local === "ca") return "en-ca";
            if (lang === "en" && local === "gb") return "en-gb";
            if (lang === "en" && local === "ph") return "en-ph";
            if (lang === "en" && local === "us") return "en-us";
            if (lang === "en" && local === "za") return "en-za";
            if (lang === "es" && local === "ar") return "es-ar";
            if (lang === "es" && local === "co") return "es-co";
            if (lang === "es" && local === "es") return "es-es";
            if (lang === "es" && local === "mx") return "es-mx";
            if (lang === "es") return "es-ww";
            if (lang === "eu") return "es-es";
            if (lang === "gu") return "en-in";
            if (lang === "fi") return "fi-fi";
            if (lang === "fo" && local === "fo") return "wn-ww";
            if (lang === "fr" && local === "be") return "fr-be";
            if (lang === "fr" && local === "ca") return "fr-ca";
            if (lang === "fr" && local === "ch") return "fr-ch";
            if (lang === "fr") return "fr-fr";
            if (lang === "gl") return "es-es";
            if (lang === "he") return "he-il";
            if (lang === "hi") return "hi-in";
            if (lang === "hu") return "hu-hu";
            if (lang === "id") return "id-id";
            if (lang === "it") return "it-it";
            if (lang === "ja") return "ja-jp";
            if (lang === "kk") return "ru-kz";
            if (lang === "ko") return "ko-kr";
            if (lang === "nb") return "no-no";
            if (lang === "nl" && local === "be") return "nl-be";
            if (lang === "nl") return "nl-nl";
            if (lang === "nn") return "no-no";
            if (lang === "ns") return "en-za";
            if (lang === "ms") return "en-my";
            if (lang === "pa") return "en-in";
            if (lang === "pl") return "pl-pl";
            if (lang === "pt" && local === "br") return "pt-br";
            if (lang === "pt") return "pt-pt";
            if (lang === "ru") return "ru-ru";
            if (lang === "se" && local === "fi") return "fi-fi";
            if (lang === "se" && local === "no") return "no-no";
            if (lang === "se" && local === "se") return "sv-se";
            if (lang === "sk") return "cs-sk";
            if (lang === "sv") return "sv-se";
            if (lang === "ta") return "en-in";
            if (lang === "te") return "en-in";
            if (lang === "tl") return "tl-ph";
            if (lang === "th") return "th-th";
            if (lang === "tr") return "tr-tr";
            if (lang === "tt") return "ru-ru";
            if (lang === "uk") return "uk-ua";
            if (lang === "vi") return "vi-vn";
            if (lang === "qu") return "es-ww";
            if (lang === "zh" && local === "tw") return "zh-tw";
            if (lang === "zh") return "zh-cn";
            if (lang === "zu" && local === "za") return "en-za";
            return "en-ww";
        },

        openLandingPageTab: function(brandingType) {
            var bLocal = ABEK.locale.getBrowserLocale().toLowerCase();
            var bLang = ABEK.locale.getBrowserLang().toLowerCase();
        
            var codePage = this.getLandingPageCode(bLang, bLocal);
            var p_pro = 43;
        
            if(brandingType == AvastWRC.BRANDING_TYPE_AVG) {
        	p_pro = 72;
            }
        
            console.log("lang:"+bLang+" local:"+bLocal+" code:"+codePage);
            //en-us lang-local

            var installedURL = "https://ipm-provider.ff.avast.com/?action=2&p_pro="+p_pro+"&p_elm=297&p_lid=" + codePage + "&p_lng=" + bLang;
            
            AvastWRC.bs.tabExistsWithUrl("completeInstallation", function(tab){                
                AvastWRC.setStorage("landingPageShown", true);
                if(tab) {                
                    AvastWRC.bs.tabRedirect(tab, installedURL);                
                }
                else {
                    AvastWRC.bs.openInNewTab(installedURL);
                }
            });            
        },
    /**
     * Message hub - handles all the messages from the injected scripts
     * @param  {String} type
     * @param  {Object} message
     * @param  {Object} tab
     * @return {void}
     */
        commonMessageHub: function (type, data, tab) {
            if (typeof tab === "undefined") return;

            var url = tab.url || (tab.contentDocument && tab.contentDocument.location
                        ? tab.contentDocument.location.href : null);
            var host = AvastWRC.bal.getHostFromUrl(url);
            switch (type) {
            case "initMe":
                //if needed
                break;
            case "unload":
                //if needed
                break;       
            case "DNTstate":
                sing.DNT.setWhiteList(data.type, data.ids, host, data.allow);
                break;
            case "userVote":
                var v =
                    {
                        uri : data.url,
                        vote: {
                            rating: data.rating,
                            flags : data.flags,
                        },
                    };

                AvastWRC.setVote(data.url, v);
                break;
            case "messageBoxFeedback":
                var settings = AvastWRC.bal.settings.get();
                switch(data.type) {
                case "siteCorrect":
                    var onBeforeReq = AvastWRC.TabReqCache.get(tab.id, "onBeforeReq");
                    onBeforeReq.blocked = false;
                    onBeforeReq.ok = data.ok;
                    AvastWRC.TabReqCache.set(tab.id, "onBeforeReq", onBeforeReq);
                    
                    
                    settings.siteCorrect.declined[data.url_from] = data.ok;
                    if(data.ok){
                        //AvastWRC.bs.tabRedirect(tab, data.url_to);

                        if(data.auto) {
                            settings.features.siteCorrectAuto = true;
                        }

                        // make domain trackable
                        this._ee.emit("message.setDomainTrackable", {host: data.brand,});
                    }              
			        sing.settings.set(settings);
			  
                    //TODO - notify backend about the user selection
                    AvastWRC.bal.aos.SC.reportTypoAccounting(data,
                        data.ok ? AvastWRC.bal.aos.SC.SC_MANUAL_REDIRECT :
                        AvastWRC.bal.aos.SC.SC_MANUAL_REFUSED
                    );
                    
                    setTimeout(function(){
                        var sc_status = AvastWRC.TabReqCache.get(tab.id, "sc_status");
                        var scdata = sc_status.scdata;				
                        if (sc_status == undefined || scdata == undefined)return;
                        var onBeforeReq = AvastWRC.TabReqCache.get(tab.id, "onBeforeReq");
                        if(onBeforeReq == undefined)return;
                        if(onBeforeReq.ok){
                            if(scdata.url_to != undefined && scdata.brand_domain != undefined){
                                AvastWRC.bs.tabRedirect(tab, scdata.url_to);  
                                                        
                                delete(sc_status.scdata);
                                AvastWRC.TabReqCache.set(tab.id, "sc_status", sc_status);
                            }
                                                            
                        }else{
                            if(scdata.url != undefined){
                                AvastWRC.bs.tabRedirect(tab, scdata.url); 
                                                                
                                delete(sc_status.scdata);
                                AvastWRC.TabReqCache.set(tab.id, "sc_status", sc_status);						
                            }					
                        }
                    },1000);     
                    break;
                case "phishing":
                case "malware":
                    if(data.ok){
                        AvastWRC.bs.tabRedirect(tab, AvastWRC.PHISHING_REDIRECT);
                    } else {
                        settings.phishing.trusted[data.url_from] = true;
                        sing.settings.set(settings);
                    }
                    break;
                default:
                    this._ee.emit("message.messageBoxFeedback." + data.type, data, tab);
                }
                break;
            case "openSettings": // open settings page        	
                var optionsPage = AvastWRC.bs.getLocalResourceURL("options.html");
                AvastWRC.bs.openInNewTab(optionsPage);
                break;
            case "closeSettings":
                var lastTabId = AvastWRC.bal.cache.get("lastActivTabId");        	
                AvastWRC.bs.tabExists.call(this, lastTabId, function() {
                    AvastWRC.bs.setActiveTab(lastTabId);
                });
                AvastWRC.bs.closeTab(tab);
                break;
            case "resetSettings": // fallthrough !!!
                if (data.list === undefined) {
                    var newSettings = this.getDefaultSettings(this);            
                    _alterDntFeaturesDefaults(newSettings);
                    sing.settings.set(newSettings);
                    sing.updateOldSettings();
                    this.featureSettingChanged("dnt", false, true);
                }
                else {
                    var def = this.getDefaultSettings(),
                        current = sing.settings.get();

                    for(var feature in data.list) {
                        var key = data.list[feature];
                        if (current.features[key] !== def.features[key]) {
                            sing.featureSettingChanged(key, current.features[key], def.features[key]);
                        }
                        current.features[key] = def.features[key];
                    }
                    sing.settings.set(current);
                }
            case "getSettingList":        	
                var ret = {
                    message : "settingList",
                    data: {
                        title: AvastWRC.bs.getLocalizedString("title"),
                        save: AvastWRC.bs.getLocalizedString("settingsSave"),
                        reset: AvastWRC.bs.getLocalizedString("settingsReset"),
                        list : [],
                    },
                };

                var settings = sing.settings.get();

                for(var feature in settings.features) {
                    var val = settings.features[feature];
                    var item = this.createSettingsItem(feature, val);

                    // Hide an obsolete setting. Will be reenabled by the SP module only
                    // in case the SP module is really registered and active.
                    if (feature === "safeShop") {
                        item.show = false;
                    }

                    _.each(this._bal_modules, function(module) {
                        if (typeof module.modifySettingsItem === "function") {
                            item = module.modifySettingsItem(feature, val, item);
                        }
                    }, this);

                    if (item.show) { ret.data.list.push(item); }
                }

                back.messageTab(tab, ret);
                break;
            case "saveSettings":
                var settings = sing.settings.get();

                for(var feature in data.list){
                    var f = data.list[feature];
                    var o = settings.features[f.key];
                    settings.features[f.key] = f.active;
                    if (o !== f.active) {
                        if(settings.dntAutoBlock && o){
                            settings.dntAutoBlock = f.active;
                        }
                        wl = AvastWRC.bal.DNT.whiteList.get();
                        var cat = f.key.substring(3, f.key.length);
                        for(var host in wl){
                            if(host != "trk"){
                                wl[host] = wl[host] || {};
                                if(wl[host][cat] &&  wl[host][cat]!= undefined) wl[host][cat] = f.active;
                                            
                                    /*// individual tracker 
                                    for(var trkId in wl.trk[host]){
                                    wl.trk[host][trkId] = f.active;
                                    }			*/		
                            }
			            }	
			            AvastWRC.bal.DNT.whiteList.set(wl);
			  
                        sing.featureSettingChanged(f.key, o, f.active);
                    }
                }
                sing.updateOldSettings();
                sing.settings.set(settings);
                break;
            case "openInNewTab":
                AvastWRC.bs.openInNewTab(data.url);
                break;
            case "copyToClipboard":
                AvastWRC.bs.copyToClipboard (data.text);
                break;
            default:
                // emit messages in specific namespace
                this._ee.emit("message." + type, data, tab);
            }
        },

        createSettingsItem: function (feature, value) {
            var interm = false; // (value === -1); // ignoring intermed state
            var active = (interm) ? true : value; // treat intermed as feture is set
            return {
                name        : AvastWRC.bs.getLocalizedString("settings" + feature),
                description : AvastWRC.bs.getLocalizedString("settings" + feature + "Desc"),
                key         : feature,
                active      : active,
                enabled     : true,
                show        : true,
                intermed    : interm,
            };
        },

    /**
     * Detect pages where the extension will handle avast:// protocal URLs.
     * And it applies events to these links to trigger to extension specific functions.
     * Ie. avast://settings opens settings: .../options.html
     * @param {String} page URL
     * @param {Object} relevant tab to process the links
     */
        tabFixAosUrls: function(url, tab) {
            if (AOS_URLS_ENABLED_URLS.test(url)) {
                AvastWRC.bs.accessContent(tab, {
                    message : "fixAosUrls",
                    data: { actions : AOS_URLS_ACTIONS, },
                });
            }
        },

    /**
     * Temporary storage
     * @type {Object}
     */
        cache: {
            map: {},
            add: function(itemKey, itemValue, key) {
                (key ? this.map[key] : this.map)[itemKey] = itemValue;
                return itemValue;
            },
            get: function(itemKey, key) {
                return (key ? this.map[key] : this.map)[itemKey];
            },
            contains: function(itemKey, key) {
                return (key ? this.map[key] : this.map).hasOwnProperty(itemKey);
            },
            delete: function(itemKey, key) {
                delete (key ? this.map[key] : this.map)[itemKey];
            },
            reset: function(key) {
                this.map[key] = {};
            },
        },
    /**
     * Persistent storage
     * @type {Object}
     */
        storage: {
            add: function(itemKey, itemValue) {
                localStorage.setItem(itemKey, JSON.stringify(itemValue));
                return itemValue;
            },
            get: function(itemKey, key) {
                var item = localStorage.getItem(itemKey);
                try {
                    return JSON.parse(item);
                } catch (ex) {
                    return {};
                }
            },
            contains: function(itemKey, key) {
                return localStorage.hasOwnProperty(itemKey);
            },
            delete: function(itemKey, key) {
                delete localStorage[itemKey];
            },
        },
    /**
     * Persistent Storage wrapper
     * @param  {String} key
     * @param  {Object} initializer - in case the key is not present in localStorage
     * @return {Object} - troughStorage instance with get and set
     */
        troughStorage: function(key, initializer) {
            var tmp = null;
            if(!sing.storage.contains(key))
                sing.storage.add(key,initializer || {});
            return {
                get: function() {
                    return tmp || (tmp = sing.storage.get(key));
                },
                set: function(val) {
                    tmp = val;
                    sing.storage.add(key, val);
                },
            };
        },
    /**
     * Helper functions
     */
        isFirefox: function() {
            return sing.browser == "Firefox";
        },
        getBrowserName: function () {
            return sing.browser;
        },
        getHostFromUrl: function(url) {
            if (!url) {
                return undefined;
            }

            var lcUrl = url.toLowerCase();

            if (lcUrl.toLowerCase().indexOf("http") != 0 ||
                lcUrl.toLowerCase().indexOf("chrome") == 0 ||
                lcUrl.toLowerCase().indexOf("data") == 0 ||
                lcUrl.toLowerCase() == "about:newtab" ||
                lcUrl.toLowerCase() == "about:blank")
            {
                return undefined;
            }

            var match = url.match(/:\/\/(www[0-9]?\.)?(.[^/:]+)/);
            return match.length > 2 ? match[2] : undefined;
        },
        getDomainFromHost: function(host){
            return host ? host.split(".").slice(-2).join(".") : undefined;
        },
        getDomainFromUrl: function(url) {
            return AvastWRC.bal.getDomainFromHost(AvastWRC.bal.getHostFromUrl(url));
        },
        jsonToString: function(obj) {
            var s = "";
            for(var key in obj) {
                if(typeof obj[key] == "object") {
                    s += key+"<br />";
                    s += this.jsonToString(obj[key]);
                } else {
                    s += key+": "+obj[key]+"<br />";
                }
            }

            return s;
        },
        tryParseJSON: function(obj) {
            try {
                return JSON.parse(obj);
            }
            catch(e) {
                return obj;
            }
        },
        tabClosed: function(tabId, host) {
            this.cache.delete("dnt_" + tabId);
        },
        defaultErrorHandler: function(obj) {
        },
    /**
     * WebRep Common Core
     * @type {Object}
     */
        WebRep: {
      /**
       * Creates default resources for building the UI
       * @return {Object}
       */
            getDefaults: function() {
                return {
                    close  : AvastWRC.bs.getLocalImageURL("icn_close.png"),
                    btnLearn : AvastWRC.bs.getLocalizedString("sideDetails").toUpperCase(),
                    btnRate : AvastWRC.bs.getLocalizedString("sideRate").toUpperCase(),
                    btnDash : AvastWRC.bs.getLocalizedString("sideDashboard").toUpperCase(),
                    btnSettings : AvastWRC.bs.getLocalizedString("sideSettings").toUpperCase(),
                    rating : {
                        headline: AvastWRC.bs.getLocalizedString("ratingRate"),
                        footer: AvastWRC.bs.getLocalizedString("ratingNoRate"),
                        close : AvastWRC.bs.getLocalImageURL("icn_close_small.png"),
                        elements: [
                            {
                                text: AvastWRC.bs.getLocalizedString("votePositive").toUpperCase(),
                                image: AvastWRC.bs.getLocalImageURL("icnthumbsmall.png"),                                
                            },
                            {
                                text: AvastWRC.bs.getLocalizedString("voteNegative").toUpperCase(),
                                image: AvastWRC.bs.getLocalImageURL("icnthumbdownsmall.png"),                                
                            },
                        ],
                        negative: {
                            close : AvastWRC.bs.getLocalImageURL("icn_close_small.png"),
                            headline: AvastWRC.bs.getLocalizedString("ratingNegative"),
                            button: AvastWRC.bs.getLocalizedString("ratingDone").toUpperCase(),
                            elements: [
                                {
                                    text: AvastWRC.bs.getLocalizedString("pornography"),
                                    data: "pornography",
                                },
                                {
                                    text: AvastWRC.bs.getLocalizedString("violence"),
                                    data: "violence",
                                },
                                {
                                    text: AvastWRC.bs.getLocalizedString("gambling"),
                                    data: "gambling",
                                },
                                {
                                    text: AvastWRC.bs.getLocalizedString("drugs"),
                                    data: "drugs",
                                },
                                {
                                    text: AvastWRC.bs.getLocalizedString("illegal"),
                                    data: "illegal",
                                },
                                {
                                    text: AvastWRC.bs.getLocalizedString("others"),
                                    data: "others",
                                },
                            ],
                        },
                    },
                    thanks : {
                        close : AvastWRC.bs.getLocalImageURL("icn_close_small.png"),
                        image: AvastWRC.bs.getLocalImageURL("icn_checkbig.png"),
                        headline: AvastWRC.bs.getLocalizedString("thanksHeadline"),
                        message: AvastWRC.bs.getLocalizedString("thanksMessage"),
                    },
                };
            },
            /**
             * Computes  WebRep data for a specific host
             * @param  {String} host
             * @return {Object} - data to be used with mustache.js templates for building the UI
             */
            compute: function(host) {
                var wrc = AvastWRC.Cache.getNoTTL(host), color, ret = AvastWRC.bal.WebRep.getDefaults();
                if(!wrc || !wrc.values){
                    ret.icon  = AvastWRC.bs.getLocalImageURL("icn_norating_big.png");
                    ret.text  = AvastWRC.bs.getLocalizedString("ratingTextUndefined");
                    ret.color = RATING_COLOR[RATING_NONE]; //'#767683';
                    ret.close = AvastWRC.bs.getLocalImageURL("icn_close.png");
                }
                else {
                    var val = wrc.values;
                    switch(wrc.getRatingCategory()) {
                    case AvastWRC.RATING_GOOD:
                        ret.icon = AvastWRC.bs.getLocalImageURL("icn_thumbup_big.png");
                        ret.text = AvastWRC.bs.getLocalizedString("ratingTextPositive");
                        break;
                    case AvastWRC.RATING_AVERAGE:
                        ret.icon = AvastWRC.bs.getLocalImageURL("icn_thumbright_big.png");
                        ret.text = AvastWRC.bs.getLocalizedString("ratingTextAverage");
                        break;
                    case AvastWRC.RATING_BAD:
                        ret.icon = AvastWRC.bs.getLocalImageURL("icn_thumbdown_big.png");
                        ret.text = AvastWRC.bs.getLocalizedString("ratingTextBad");
                        break;
                    }

                    ret.color = RATING_COLOR[wrc.getRatingCategory()];
                    ret.details = {
                        close : AvastWRC.bs.getLocalImageURL("icn_close_small.png"),
                        headline: AvastWRC.bs.getLocalizedString("detailsHeadline"),
                        elements: [
                            {
                                text: AvastWRC.bs.getLocalizedString("detailsMalware" + ( val.block == 1 ? "Yes" : "No" )),
                                image: AvastWRC.bs.getLocalImageURL("icn_bug.png"),
                                color: val.block == 1 ? RATING_COLOR[RATING_BAD] : RATING_COLOR[RATING_GOOD],
                                title: "",
                            },
                            {
                                text: AvastWRC.bs.getLocalizedString("detailsPhishing" + ( val.phishing ? "Yes" : "No" )),
                                image: AvastWRC.bs.getLocalImageURL("icn_eye.png"),
                                color: val.phishing > 1 ? RATING_COLOR[RATING_BAD] : RATING_COLOR[RATING_GOOD], //'#F5203E' : '#0CB754',
                                title: "",
                            },
                            {
                                text: AvastWRC.bs.getLocalizedString("ratingCommunity",[AvastWRC.bs.getLocalizedString("ratingLevel" + RATING_LEVEL[wrc.getRatingCategory()]),]),
                                image: AvastWRC.bs.getLocalImageURL("icn_thumblearn.png"),
                                color: RATING_COLOR[wrc.getRatingCategory()],
                                title: val.rating,
                            },
                        ],
                    };
                }

                return ret;
            },
        },

        /* Wraps bal to register to submodule events */
        Core : {
            registerModuleListeners : function (ee) {
                // register for local Avast service
                ee.on("local.init", function(port) {
                    sing.initLocalService(port);
                });
                ee.on("local.paired", function(guid, auid, hwid, uuid) {
                    if (guid !=="" ) AvastWRC.CONFIG.GUID = guid;
                    if (auid !== "") AvastWRC.CONFIG.AUID = auid;
                    if (guid !== "") AvastWRC.CONFIG.HWID = hwid;
                    if (uuid !== "") AvastWRC.CONFIG.UUID = uuid;
                    var guids = {
                        "guid": AvastWRC.CONFIG.GUID,
                        "plg_guid": AvastWRC.CONFIG.PLG_GUID,
                        "auid": AvastWRC.CONFIG.AUID,
                        "hwid": AvastWRC.CONFIG.HWID,
                        "uuid": AvastWRC.CONFIG.UUID,
                    };
                    AvastWRC.setStorage("AvastConfig", JSON.stringify(guids));
                });
            },
        },

    /**
     * AvastWRC.bal specific utilities.
     */
        utils : {
      /**
       * Retrieve localised strings into given data object
       * based on the string ids array.
       * @param {Object} data to load the strings to
       * @param {Array} identifiers of strings to load
       * @return {Object} updated data object
       */
            loadLocalizedStrings : function (data, stringIds) {
                return _.reduce (stringIds, function(res, stringId) {
                    res[stringId] = AvastWRC.bs.getLocalizedString(stringId);
                    return res;
                }, data);
            },

      /**
       * Create local image url for given key/file map.
       * @param {Object} to add local URLs to
       * @param {Object} map key / image file to create the local URLs for
       * @return {Object} updated data object
       */
            getLocalImageURLs : function (data, imagesMap) {
                return _.reduce (imagesMap, function(res, image, key) {
                    res[key] = AvastWRC.bs.getLocalImageURL(image);
                    return res;
                }, data);
            },

      /**
       * Generate random UID.
       */
            getRandomUID : function () {
                var genericGuid = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx";
                var hex = "0123456789abcdef";
                var r = 0;
                var guid = "";
                for (var i = 0; i < genericGuid.length; i++) {
                    if (genericGuid[i] !== "-" && genericGuid[i] !== "4") {
                        r = Math.random() * 16 | 0;
                    }
                    if (genericGuid[i] === "x") {
                        guid += hex[r];
                    } else if (genericGuid[i] === "y") {
                        r &= 0x3;  //  (sample:?0??)
                        r |= 0x8;  // (sample:1???)
                        guid += hex[r];
                    } else {
                        guid += genericGuid[i];
                    }
                }
                return guid;
            },
      /**
       * Generate hash from string.
       */
            getHash(str) {
                var hash = 0;
                if (str.length === 0) return hash;
                for (var i = 0; i < str.length; i++) {
                    var char = str.charCodeAt(i);
                    hash = ((hash << 5) - hash) + char;
                    hash = hash & hash; // Convert to 32bit integer
                }
                return hash;
            },

        }, // utils

    /**
     * Set bal instance with local storage instance.
     * @param {Object} browser local storage instance
     */
        setLocalStorage : function (ls) {
            localStorage = ls;
        },

    /**
     * Check current version and compare with previous version stored.
     * If newer version detected open Avast Welcome page on avast web.
     * @param {Numeric} current extension caller Id
     */
        checkPreviousVersion : function (currentCallerId) {
            var settings = sing.settings.get();
            var previousCallerId = settings.current.callerId;
            if (previousCallerId !== currentCallerId) {
                var prevMinor = previousCallerId % 1000;
                var currMinor = currentCallerId % 1000;

                if ( SHOW_WELCOME_PAGE_RULE(prevMinor, currMinor) ) {
                    AvastWRC.bs.openInNewTab(AvastWRC.AVAST_UPGRADE_PAGE_URL + currentCallerId);
                }

        // block DNT when updating to 7/8
                if (currMinor === 7 || currMinor === 8 || (currMinor > 8 && prevMinor < 7)) {
                    _alterDntFeaturesDefaults(settings);
                    this.featureSettingChanged("dnt", false, true);
                }

        // update saved callerId
                settings.current.callerId = currentCallerId;
                sing.settings.set(settings);
            }
        },

    /**
     * Stores user Id so it is available to subsequent requests and persisted in local storage.
     * @param {String} userid to store
     */
        storeUserId : function (userId) {
            var settings = sing.settings.get();
            settings.current.userId = userId;
            sing.settings.set(settings);
            sing.updateOldSettings(); // refresh settings accessible through AvastWRC
        },

    }; // AvastWRC.bal

  // Init the core module to register for event from sub-modules.
    AvastWRC.bal.registerModule(AvastWRC.bal.Core);

}).call(this, _, EventEmitter2);
/*******************************************************************************
 *  avast! Online Security plugin
 *  (c) 2014 Avast Corp.
 *
 *  Background Layer - SafePrice
 ******************************************************************************/

(function(AvastWRC, _) {

  // Hide time for SafeShop settings - 24hs
    var SAFESHOP_HIDE_TIMEOUT = 24*60*60*1000;

    var SAS_STATUS = {
        NEW : 0,
        OPT_IN : 1,
        OPT_OUT : 2,
    };

    var _safeShopInTab = {};

  /**
   * Parse SafeShop status featur into Avast Offers Proxy status values.
   */
    function parseSafeShopStatusFeature(safeShopVal) {
        return (safeShopVal === -1) ? SAS_STATUS.OPT_IN : //SAS_STATUS.NEW :
      (safeShopVal) ? SAS_STATUS.OPT_IN : SAS_STATUS.OPT_OUT;
    }


    (function (definition) {
        AvastWRC.bal.registerModule({
            bootstrap : function (features) {
                return features.safePrice ? definition() : null;
            },
        });


    })(function () {

        AvastWRC.bal.sp = _.extend( AvastWRC.bal.SP || {}, {

            onUrlInfoResponse : function (url, response, tab, tabUpdate) {
    	  
                var timer = 0;
                var cachedTimer = AvastWRC.TabReqCache.get(tab.id, "timer");
            
                if(cachedTimer != null) timer = Date.now() - cachedTimer;
            
                console.log("onUrlInfoResponse() time " +  timer);
            
                _safeShopInTab[tab.id] = response.values.safeShop;
              
                if (_safeShopInTab[tab.id])
                {    
                    _safeShopInTab[tab.id].count = 0;
		                _safeShopInTab[tab.id].url = url;	
                    if(timer < 50) {
                        setTimeout(function(tab, url, safeShop){	        		         
                            AvastWRC.bal.sp.tabSafeShopCheck(tab.id, tab, url, safeShop);  
                        }, 50, tab, url, _safeShopInTab[tab.id]);
                    }
                    else {
                        AvastWRC.bal.sp.tabSafeShopCheck(tab.id, tab, url, _safeShopInTab[tab.id]); 
                    }
                }
            },

            onPageComplete : function(tabId, tab, url) {
       
                if (_safeShopInTab[tabId]) {
                    var timer = Date.now() - AvastWRC.TabReqCache.get(tab.id, "timer");
                    console.log("onPageComplete() time " +  timer);
                
                    this.tabSafeShopCheck(tabId, tab, url, _safeShopInTab[tabId]);   
                }

                /* Check if request to retrieve domain made and retrive it from tab to make it trackable. */
                var requested = AvastWRC.TabReqCache.get(tabId, "dnt_retrieve_domain");
                if (requested) {
                    var host = AvastWRC.bal.getHostFromUrl(tab.url || tab.contentDocument.location.href);
                    AvastWRC.bal.emitEvent("message.setDomainTrackable", {host: host,});
                    AvastWRC.TabReqCache.set(tabId, "dnt_retrieve_domain", false);
                }
            },

          /**
           * Initiate page data check when safeShop selector received.
           * @param {String} page URL
           * @param {Object} urlInfo response
           * @param {Object} relevant tab to run the check
           */
            tabSafeShopCheck: function(tabId, tab, url, safeShopData) {
                if (!_safeShopInTab[tab.id]){
                    return;
                }		
                _safeShopInTab[tab.id].count++;

                var data = {
                    message: "checkSafeShop",
                    data: {
                        url: url,
                        csl: JSON.parse(safeShopData.selector),
                        //            coupons : (safeShopData.selector.indexOf("VoucherSearch") > -1),
                        tabId: tabId,
                    },
                };
                var timer = Date.now() - AvastWRC.TabReqCache.get(tab.id, "timer");
                console.log("tabSafeShopCheck() time " +  timer);
                AvastWRC.bs.accessContent(tab, data);
            },

            safeShopOffersFound: function(data, tab) {
                if(!_safeShopInTab[tab.id]) {
                    return;
                }

                if(data.scan.name === "RequireError" 
                  && _safeShopInTab[tab.id]
                  && _safeShopInTab[tab.id].count < 5) {
                    console.log("safeShopOffersFound(): " + data.scan.name);

                    if(!AvastWRC.bal.sp.isSafeShopUrl(tab.url)) {
                        return;
                    }
                    
                    var safeShop = _safeShopInTab[tab.id];
                    var url = _safeShopInTab[tab.id].url;
                    var count = _safeShopInTab[tab.id].count * 100;
                    setTimeout(function(tab, url, safeShop){	        		         
                        AvastWRC.bal.sp.tabSafeShopCheck(tab.id, tab, url, safeShop);  
                    }, count, tab, url, safeShop);	
                    return;
                }
                
                delete _safeShopInTab[tab.id];
                this.processSafeShopOffers(tab, data, function(tab, data) {
		            chrome.browserAction.setIcon({ path: "common/ui/icons/logo-safeprice-128.png", tabId: tab.id, });
                    AvastWRC.bs.accessContent(tab, {
                        message: "showSafeShop",
                        data: data,
                    });
                });
            },
            isSafeShopUrl(url) {				
                var domain = AvastWRC.bal.getDomainFromUrl(url);
                if(domain.indexOf("google") != -1
                    && url.indexOf("shop") == -1) {
                    return false;
                }
                return true;
            },

      /**
       * Register a request to retrieve domain and enable to track it.
       */
      registerRetriveDomainRequest: function(tabId, tab) {
        AvastWRC.TabReqCache.set(tabId, 'dnt_retrieve_domain', true);
      },

      safeShopFeedback: function (data,  tab) {
        var settings = AvastWRC.bal.settings.get();
        switch(data.type) {
          case 'safeShopOptin':
            settings.features.safeShop = data.optin;
            AvastWRC.bal.settings.set(settings);
            break;
          case 'safeShopSettings':
            var domain = data.domain;
            var timeout = (new Date()).getTime() + SAFESHOP_HIDE_TIMEOUT;
            switch(data.action) {
              case 'sas-block-coupons-domain':
                settings.safeShop.noCouponDomains[domain] = true;
                break;
              case 'sas-hide-domain':
                settings.safeShop.hideDomains[domain] = timeout;
                break;
              case 'sas-hide-all':
                settings.safeShop.hideAll = timeout;
                break;
              case 'sas-show-domain':
                settings.safeShop.hideDomains[domain] = 0;
                break; 
             case 'sas-show-all':
                settings.safeShop.hideAll = 0;
                break;              
            }
            AvastWRC.bal.settings.set(settings);
            break;
          case 'avast-sas-close':
            if (settings.safeShop.closedByUser[tab.url] != undefined && settings.safeShop.closedByUser[tab.url].closed == 0){
                settings.safeShop.closedByUser[tab.url].closed = 1; 
                chrome.browserAction.setIcon({ path: "common/ui/icons/logo-safeprice-128.png", tabId: tab.id });
                chrome.browserAction.setBadgeText({tabId: tab.id, text: settings.safeShop.closedByUser[tab.url].offerNumber.toString()});
                chrome.browserAction.setBadgeBackgroundColor({color: AvastWRC.bal.brandingType == undefined || AvastWRC.bal.brandingType == AvastWRC.BRANDING_TYPE_AVAST ? "#FF7800" : "#556688"});                   
            }
            AvastWRC.bal.settings.set(settings);
            break; 
          case 'offerRedirect':
            // open URL in new tab
            AvastWRC.bs.openInNewTab (data.url, function (newTab) {
                AvastWRC.bal.sp.registerRetriveDomainRequest(AvastWRC.bs.getTabId(newTab), newTab);
                // report offer to backed
                new AvastWRC.Query.SafeShopPickedOffer({
                    originalRequest: data.originalRequest,
                    offer: data.offer,
                });
            });
            break;
          case "couponRedirect":
            // report coupon to backed
            new AvastWRC.Query.SafeShopPickedOffer({
                originalRequest: data.originalRequest,
                offer: data.coupon,
            });
            break;

        /**
         * SafePrice Coupon was clicked
         * 1. Open the link in a new tab, wait for the redirects to finish (return to original domain)
         * 2. Insert new Bar with coupon_code and coupon_text
         */
        case "safeShopCouponClick":
            AvastWRC.bs.openInNewTab(data.url);


            if (AvastWRC.Utils.getBrowserInfo().isFirefox()) {
                AvastWRC.safeShopCouponActive = {
                    id : AvastWRC.bs.getTabId(tab),
                    code : data.coupon.coupon_code,
                    text : data.coupon.coupon_text,
                    value : data.coupon.value,
                    label : data.coupon.label,
                    expire : data.coupon.coupon_expire_date,
                    freeshipping : data.coupon.coupon_freeshipping,
                };
            }else{
                AvastWRC.bs.getActiveTab(function(tab){
                    AvastWRC.safeShopCouponActive = {
                        id : AvastWRC.bs.getTabId(tab),
                        code : data.coupon.coupon_code,
                        text : data.coupon.coupon_text,
                        value : data.coupon.value,
                        label : data.coupon.label,
                        expire : data.coupon.coupon_expire_date,
                        freeshipping : data.coupon.coupon_freeshipping,
                    };
                });
            }
            break;
          }
        },

      /**
       * Display bar with the coupon instructions
       * @param  {[type]} tab    [description]
       * @param  {[type]} coupon [description]
       * @return {[type]}        [description]
       */
            tabSafeShopCoupon : function(tab, coupon){
                var urlDomain = AvastWRC.bal.getDomainFromUrl(AvastWRC.bs.getTabUrl(tab));

                var settingsLabelsProps = [urlDomain,];

                AvastWRC.bs.accessContent(tab, {
                    message : "showSafeShopCoupon",
                    data : {				  
                        coupon : coupon,
                        images : AvastWRC.bal.utils.getLocalImageURLs({}, {
                            logo: "sas_logo.png", drop: "sas_drop.png", help: "sas_help.png",
                            conf: "sas_conf.png", close: "icn_close.png", arrow: "arrow.png",
                        }),
                        strings : AvastWRC.bal.utils.loadLocalizedStrings( {}, [
                            "sasCouponCodeTitle", "sasClickToCopy", "sasCouponInstructionsTitle", "sasNoCouponCode", "sasCouponCodeCopied",
                        ]),
                        settings : _([
                      ["sas-hide-domain", "sasOptionsDisableOnSite", settingsLabelsProps,],
                      ["sas-hide-all", "sasOptionsDisableAll", settingsLabelsProps,],
                        ]).map(function(def) {
                            return {
                                actionId : def[0],
                                label : AvastWRC.bs.getLocalizedString(def[1], def[2]),
                            };
                        }).valueOf(),
                    },
                });
            },

      /**
       * Process safeShop offers returned for given tab.
       * @param {Object} tab to execute the SafeShop for
       * @param {Object} safeShop data retrieved
       * @param {Function} callback function to receive the prcessed data
       */
            processSafeShopOffers: function(tab, data, callback) {
    	  
        if(AvastWRC.safeShopCouponActive){
            this.tabSafeShopCoupon(tab, AvastWRC.safeShopCouponActive);
            delete AvastWRC.safeShopCouponActive;
            return;
        }

        var settings = AvastWRC.bal.settings.get();
        var features = settings.features;
        var urlDomain = AvastWRC.bal.getDomainFromUrl(data.url);
        var status = parseSafeShopStatusFeature(features.safeShop);

        var VoucherSearch = _.any(data.csl.plugins, function(p) {return (p[0] === "VoucherSearch");});

        var queryOptions = {
          url: data.url,
          query: data.scan,
          status: status,
          VoucherSearch : VoucherSearch,
          country: 'de', // use country for testing only, otherwise GeoIP devised / 1st lvl domain name, 'us' for 'com'
          referrer: data.referrer,
          callback : function(offersResponse) {
            var timestamp = (new Date()).getTime();
            var domainTimeout = settings.safeShop.hideDomains[urlDomain] || 0;
            var allTimeout = settings.safeShop.hideAll || 0;
			var iconClicked = settings.safeShop.iconClicked || 0;
			
            if (!offersResponse.offers || offersResponse.offers.length === 0) {return;}

            var detailsToClosed = {offerNumber: offersResponse.offers.length,
                                  closed: 0}
            settings.safeShop.closedByUser[data.url] = detailsToClosed;
         

 			if ( iconClicked == 0 && (domainTimeout > timestamp || allTimeout > timestamp)) {
              chrome.browserAction.setIcon({ path: "common/ui/icons/logo-safeprice-128.png", tabId: tab.id });
		  	  chrome.browserAction.setBadgeText({tabId: tab.id, text: offersResponse.offers.length.toString()});
		  	  chrome.browserAction.setBadgeBackgroundColor({color: AvastWRC.bal.brandingType == undefined || AvastWRC.bal.brandingType == AvastWRC.BRANDING_TYPE_AVAST ? "#FF7800" : "#556688"});
              return;
            }
            
            if (iconClicked == 1 ){
				settings.safeShop.iconClicked = 0;
				AvastWRC.bal.settings.set(settings);
			}
			
            // group the offers by category: Product, Voucher,...
                        var offers = _.groupBy(offersResponse.offers, function(item) {return item.category;});

                        var safeShopBestTitle, safeShopBestButton, safeShopOffers, firstProduct, save;
                        var products = _(offers["Product"]).sortBy("price");

                        if (products.size() > 0) {
                            firstProduct = products.first().valueOf();
                            if (firstProduct.saving) {
                // best product elsewhere
                                safeShopBestTitle = AvastWRC.bs.getLocalizedString("safeShopBestTitleCheaperFound");
                                safeShopBestButton = AvastWRC.bs.getLocalizedString("safeShopBestButtonSave",
                  ["", firstProduct.saving, firstProduct.affiliate,]);
                            } else {
                // best product on the page
                                safeShopBestTitle = AvastWRC.bs.getLocalizedString("safeShopBestTitleBestHere");
                                safeShopBestButton = AvastWRC.bs.getLocalizedString("safeShopBestButtonNextOffer",
                  [firstProduct.fprice, firstProduct.affiliate,]);
                            }
                            safeShopOffers =  AvastWRC.bs.getLocalizedString("safeShopOffers",
                    [products.size(), firstProduct.fprice,]);
                        }

                        var dispProducts = products.valueOf();

                        var coupons = offers["Voucher"] || [];

                        var couponsSorted = _(coupons).sortBy(function(i) {return i.price || 0;}).reverse();
                        var bestCoupon = coupons.length > 0 ? couponsSorted.first().valueOf() : null;


                        var settingsLabelsProps = [urlDomain,];
                        var showHelp = (features.safeShop === -1) && (Math.floor(AvastWRC.CONFIG.CALLERID/1000) !== 8);
                        var showData = {
			  avastBranding: AvastWRC.bal.brandingType == undefined || AvastWRC.bal.brandingType == AvastWRC.BRANDING_TYPE_AVAST ? true : false,
                            domain : urlDomain,
                            showHelp: showHelp,
                            discreetSlider : false,
                            discreet : true,
                            isNew : (features.safeShop === -1),
                            products : dispProducts,
                            firstProduct : firstProduct,
                            coupon : [],
                            coupons : couponsSorted.valueOf(),
                            couponsTitle : (coupons.length > 0 && dispProducts.length <= 0),
                            bestCouponUrl: ( bestCoupon ? bestCoupon.url : "" ),
              // hasOffers : dispOffers.length > 0,
              // hasCoupons : coupons.length > 0,
                            images : AvastWRC.bal.utils.getLocalImageURLs({}, {
                                logo: "sas_logo.png", drop: "sas_drop.png", help: "sas_help.png",
                                conf: "sas_conf.png", close: "icn_close.png", arrow: "arrow.png",
                            }),
                            strings : AvastWRC.bal.utils.loadLocalizedStrings( {
                                safeShopBestTitle: safeShopBestTitle,
                                safeShopBestButton: safeShopBestButton,
                                safeShopOffers: safeShopOffers,
                                safeShopCoupons: AvastWRC.bs.getLocalizedString("safeShopCoupons",
                    [coupons.length,]),
                                safeShopCouponsTitle: AvastWRC.bs.getLocalizedString("sasCouponsTitle",
                    [coupons.length,]),
                                safeShopCouponsSaving: (bestCoupon && bestCoupon.value && bestCoupon.value.length>0) ?
                    AvastWRC.bs.getLocalizedString("sasCouponsSaving", [bestCoupon.value,]) : "",
                            }, [
                                "sasHintBestOffer", "sasHintBestOfferDesc",
                                "sasHintOtherOffers", "sasHintOtherOffersDesc",
                                "sasHintCoupons", "sasHintCouponsDesc",
                                "sasHintSettings", "sasHintSettingsDesc",
                                "sasPromoNewBadge", "sasProductName",
                                "sasPromoDescription", "sasPromoAction",
                                "sasShippingLabel", "sasCouponCodeTitle",
                                "sasClickToCopy", "sasCouponInstructionsTitle",
                                "sideSettings", "sasAddOnInfo","sasRecommendedOfferTitle", 
                                "sasRecommendedOfferMessage",
                            ]),
              // list settings actions
                            settings : _([
                //['sas-block-coupons-domain', 'sasOptionsNeverShowOnSite', settingsLabelsProps],
                ['sas-hide-domain','sasOptionsDisableOnSite', settingsLabelsProps, (domainTimeout < timestamp)? 'show': 'hide'],
                ['sas-show-domain', 'sasOptionsEnableOnSite', settingsLabelsProps, (domainTimeout > timestamp)? 'show': 'hide'],
                ['sas-hide-all','sasOptionsDisableAll', settingsLabelsProps, (allTimeout < timestamp)? 'show': 'hide'],
                ['sas-show-all','sasOptionsEnableAll', settingsLabelsProps, (allTimeout > timestamp)? 'show': 'hide']
                ]).map(function(def) {
                  return {
                    actionId : def[0],
                    label : AvastWRC.bs.getLocalizedString(def[1], def[2]),
                    display: def[3]
                  };
                }).valueOf(),
              safeShopData: data,
              safeShopOffers: dispProducts,
              safeShopCoupons: coupons,
              showSettings: (Math.floor(AvastWRC.CONFIG.CALLERID/1000) !== 8),
              originalQuery: {
                url: data.url,
                query: data.scan,
                status: status
              }
            };
            callback(tab, showData);
          }
        };

        new AvastWRC.Query.SafeShopOffer(queryOptions); // query Avast Offers Proxy

      }, // processSafeShopOffers

      /* Register SafePrice Event handlers */
            registerModuleListeners: function(ee) {
                ee.on("urlInfo.response", AvastWRC.bal.sp.onUrlInfoResponse.bind(AvastWRC.bal.sp));
                ee.on("page.complete", AvastWRC.bal.sp.onPageComplete.bind(AvastWRC.bal.sp));
                ee.on("message.safeShopFeedback", AvastWRC.bal.sp.safeShopFeedback.bind(AvastWRC.bal.sp));
                ee.on("message.safeShopOffersFound", AvastWRC.bal.sp.safeShopOffersFound.bind(AvastWRC.bal.sp));
            },

            modifySettingsItem: function(feature, value, item) {
        // Ensure that the setting is shown on options.html page
                if (feature === "safeShop") {
                    item.show = true;
                }
                return item;
            },

      /**
       * Return SafePrice related default settings.
       */
      getModuleDefaultSettings: function() {
        return {
          safeShop : {
            noCouponDomains : {}, // {"domain":true}
            hideDomains : {}, // {"domain":timeout}
            hideAll : 0, // hide until
            iconClicked : 0, // to know if the SP icon was clicked
            closedByUser : [] /*{"url":{offerNumber: (number of offers we have), closed: (1 if closed)}} 
								reason: if the user intentionallity closed the bar we show on the badge 
                                the nummer of offers we have for that url (on clic of the icon the bar will appear again)*/
          },
          features : {
            safeShop : -1 // NEW (-1), true = opt-in (default), false = opt-out
          }
        };
      }

    }); // SP

    return AvastWRC.bal.sp;
  });

    
}).call(this, AvastWRC, _);
/* globals chrome, XMLHttpRequest, self */

class ASDetector {
    
    constructor (blockref) {
    	this.pastEvents = {};
        this.listeners = [];
        this.blockref = blockref || [ new RegExp('\.*&afsrc=1|\\?afsrc=1'),
                new RegExp('.*jdoqocy.com'),
                new RegExp('.*tkqlhce.com'),
                new RegExp('.*dpbolvw.net'),
                new RegExp('.*anrdoezrs.net'),
                new RegExp('.*kqzyfj.com')];
        this.ciuvo_rex = [new RegExp('.*ciuvo\.com'), new RegExp('.*localhost:8002')];
        
        this.NEW_EVENT_THRESHOLD_TIME = 800;
        this.TAB_EVENT_EXPIRATION_TIME = 10 * 1000;
    }
    
        /**
         * Add a new navigation event of the tab's main frame.
         * 
         * @param tabId
         *            the tabId for this navigation event (required)
         * @param url
         *            the url for this navigation event (required)
         * @param requestId
         *            the request-id if available. It helps recognizing multiple
         *            urls which actually belong to one navigation event because
         *            of redirects. (optional)
         * @param timestamp
         *            the timestamp in ms of the navigation event. It is usefull
         *            for recognizing events which belong together (optional).
         * @returns true if the current chain of navigation events has been
         *          marked as affiliate source. False otherwise.
         */
        onNavigationEvent (tabId, url, requestId, timestamp) {
        	timestamp = timestamp || Date.now();

            var newEvent = true;
            var lastEvent = this.getLastEvent(tabId);

            // try to detect if this is a new navigation event
            if (typeof requestId !== 'undefined') {
                if (requestId == lastEvent.requestId) {
                    newEvent = false;
                }
            }

            // those damn JS redirects make requestId unreliable
            var delta = timestamp - lastEvent.timestamp;
            if (delta < this.NEW_EVENT_THRESHOLD_TIME) {
                newEvent = false;
            }

            // update timestamp in any case
            lastEvent.timestamp = timestamp;

            // create a new event if one has been detected
            if (newEvent) {
                lastEvent.isAfsrc = false;
                lastEvent.isFromCiuvo = false;
                lastEvent.requestId = requestId;
            }
            // detect that the url is from a ciuvo extension
            for (var i = 0; i < this.ciuvo_rex.length; ++i) {
                if (this.ciuvo_rex[i].exec(url)) {
                    lastEvent.isFromCiuvo = true;
                }
            }
            if (lastEvent.isFromCiuvo) {
                // ignore afsrc if ciuvo itself triggered the coupon-click
                lastEvent.isAfsrc = false;
            } else {
                // check if this is a event that marks an affiliate source
                for (var i = 0; i < this.blockref.length; i++) {
                    if (this.blockref[i].exec(url)) {
                        lastEvent.isAfsrc = true;
                    }
                }
            }

            return lastEvent.isAfsrc;
        }

        /**
         * be nice, clean up a bit after ourselves
         */
        cleanupExpiredTabs () {
        	 now = Date.now();
             for ( var tabId in this.pastEvents) {
                 if (this.pastEvents.hasOwnProperty(tabId)) {
                     var event = this.pastEvents[tabId];
                     if ((now - event.timestamp) > this.TAB_EVENT_EXPIRATION_TIME) {
                         delete this.pastEvents[tabId];
                     }
                 }
             }
        }

        /**
         * @param tabId
         *            the tab's id
         * @returns the last navigation event or an empty one
         */
        getLastEvent (tabId) {
        	 var lastEvent = this.pastEvents[tabId];
             if (typeof lastEvent === 'undefined') {
                 lastEvent = {
                     isAfsrc : false,
                     requestId : undefined,
                     isFromCiuvo : false,
                     timestamp : 0
                 };
                 this.pastEvents[tabId] = lastEvent;
             }
             return lastEvent;
        }

        /**
         * @param tabId the id of the tab to be checked for the affiliate source
         * @param cleanup will clear the affiliate source flag since displays are allowed
         *          on subsequent requests
         * @returns true if the current chain of navigation events has been
         *          marked as affiliate source. False otherwise.
         */
        isAffiliateSource (tabId, cleanup) {
        	 var isAfsrc = this.getLastEvent(tabId).isAfsrc;
             if (cleanup) {
                 delete this.pastEvents[tabId];
             }

             return isAfsrc;
        }
}

AvastWRC.bs.ciuvoASdetector = AvastWRC.bs.ciuvoASdetector || new ASDetector();
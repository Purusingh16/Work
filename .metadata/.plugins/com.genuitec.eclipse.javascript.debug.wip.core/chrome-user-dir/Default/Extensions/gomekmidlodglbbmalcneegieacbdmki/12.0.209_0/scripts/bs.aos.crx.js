/*******************************************************************************
 *  avast! browsers extensions
 *  (c) 2012-2014 Avast Corp.
 *
 *******************************************************************************
 *
 *  Background Browser Specific - Core Chrome Extensions functionality
 *
 ******************************************************************************/

(function (_) {


    var bal = null; //AvastWRC.bal instance - browser agnostic

    var hostInTab = [];
    var scriptInTab = [];

    /**
     * User has change from tab to tab or updated an url in the tab
     *
     * @param  {String} url    Site url loaded into the tab
     * @param  {Object} tab    Tab object reference
     * @param  {String} change Status of the tab (loading or undefined)
     * @return {void}
     */
    function urlInfoChange(url, tab, change, tabUpdated) {
        if (AvastWRC.CONFIG.ENABLE_WEBREP_CONTROL) {
            var urlDetails = [url];

            if (tab.id) {
                urlDetails = {
                    url: url,
                    referer: AvastWRC.TabReqCache.get(tab.id, "referer"),
                    tabNum: tab.id,
                    windowNum: tab.windowId,
                    reqServices: bal.reqUrlInfoServices,
                    tabUpdated: tabUpdated,
                    originHash: AvastWRC.bal.utils.getHash(url + tab.id + tab.windowId),
                    origin: AvastWRC.TabReqCache.get(tab.id, "origin"),
                    customKeyValue: AvastWRC.Queue.get("pageTitle")
                };
            }

            // perform urlinfo
            AvastWRC.get(urlDetails, function (res) {
                AvastWRC.bal.emitEvent("urlInfo.response", url, res[0], tab, tabUpdated);
            });
        }
        if (tabUpdated && AvastWRC.bal.DNT && AvastWRC.bal.DNT.initTab) {
            AvastWRC.bal.DNT.initTab(tab.id);
        }
    }


    /**
     * User updates URL  in the browser (clicking a link, etc.) Question: why is it also triggered for unloaded tabs
     *
     * @param  {Number} tabId      Tab Identification
     * @param  {Object} changeInfo state of loading {status : "loading | complete", url: "http://..."}  - url property appears only with status == "loading"
     * @param  {Object} tab        Tab properties
     * @return {void}
     */
    function onTabUpdated(tabId, changeInfo, tab) {
    	AvastWRC.bs.tabExists.call(this, tabId, function() {
	        // ignore unsuported tab urls like chrome://, about: and chrome.google.com/webstore - these are banned by google.
	        // and disable the browser extension for those tabs
	        if (!AvastWRC.bs.checkUrl(tab.url)) {	            
	            chrome.browserAction.disable(tabId);
	            return;
	        }
	
	        //enable the browser extension
	        chrome.browserAction.enable(tabId);
			
			//reset the badge AOS
        var settings = AvastWRC.bal.settings.get();
        if(settings.features["dnt"] == false){
            chrome.browserAction.setBadgeText({tabId: tabId, text: ""});
        }
			//reset the badge SP
        if(settings.safeShop != undefined){
            var timestamp = (new Date()).getTime();
		        var urlDomain = AvastWRC.bal.getDomainFromUrl(tab.url);
	            var domainTimeout = settings.safeShop.hideDomains[urlDomain] || 0;
	            var allTimeout = settings.safeShop.hideAll || 0;
            var barclosedByUser = settings.safeShop.closedByUser[tab.url] || {};
            if (!(domainTimeout > timestamp || allTimeout > timestamp || barclosedByUser.closed == 1)){
                chrome.browserAction.setBadgeText({tabId: tabId, text: ""});
            }
        }
			
	        var host = bal.getHostFromUrl(tab.url);
	
	        if (changeInfo.status === "loading") {
	        	console.log("onTabUpdated() status: " + changeInfo.status);
            AvastWRC.TabReqCache.set(tab.id, "timer", Date.now());
				
	            urlInfoChange(tab.url, tab, changeInfo.status, true);
	            if (host) {
	                delete scriptInTab[tab.id];
	            }
	        } else if (changeInfo.status === "complete") {
	        	
	        	var timer = Date.now() - AvastWRC.TabReqCache.get(tab.id, "timer");
            console.log("onTabUpdated()  status: " + changeInfo.status + " time " +  timer);
				
	            if (hostInTab[tabId] === undefined) {
	                urlInfoChange(tab.url, tab, changeInfo.status, true);
	            }
	            AvastWRC.bal.emitEvent("page.complete", tabId, tab, tab.url);
	        }
	        if (host) {
	            hostInTab[tabId] = host;
	        }
    	});
    }

    /**
     * User changes tab focus
     *
     * @param  {Object} tab        Tab object
     * @param  {Object} changeInfo [description]
     * @return {void}
     */
    function onSelectionChanged(tabId, changeInfo) {
    	AvastWRC.bs.tabExists.call(this, tabId, function() {
	        chrome.tabs.get(tabId, function (tab) {
	            // ignore unsuported tab urls like chrome://, about: and chrome.google.com/webstore - these are banned by google.

	            if (!AvastWRC.bs.checkUrl(tab.url)) {	                
	                chrome.browserAction.disable(tabId);
	                return;
	            }
	            //enable the browser extension
            chrome.browserAction.enable(tabId);
				
				//reset the badge AOS
            var settings = AvastWRC.bal.settings.get();
            if(settings.features["dnt"] == false){
                chrome.browserAction.setBadgeText({tabId: tabId, text: ""});
            }
				//reset the badge SP
            if(settings.safeShop != undefined){
                var timestamp = (new Date()).getTime();
			        var urlDomain = AvastWRC.bal.getDomainFromUrl(tab.url);
		            var domainTimeout = settings.safeShop.hideDomains[urlDomain] || 0;
		            var allTimeout = settings.safeShop.hideAll || 0;
                var barclosedByUser = settings.safeShop.closedByUser[tab.url] || {};
                if (!(domainTimeout > timestamp || allTimeout > timestamp || barclosedByUser.closed == 1)){
                    chrome.browserAction.setBadgeText({tabId: tabId, text: ""});
                }
            }
				
	            urlInfoChange(tab.url, tab, changeInfo.status, false);
	        });
    	});
    }

    function onActivated(activeInfo, changeInfo) {
        
    	AvastWRC.bs.tabExists.call(this, activeInfo.tabId, function() {
	        chrome.tabs.get(activeInfo.tabId, function (tab) {
	            // ignore unsuported tab urls like chrome://, about: and chrome.google.com/webstore - these are banned by google.	            
	            if (!AvastWRC.bs.checkUrl(tab.url)) {	                
	                chrome.browserAction.disable(activeInfo.tabId);
	                return;
	            }
	            //enable the browser extension
	            chrome.browserAction.enable(activeInfo.tabId);
				
				//reset the badge AOS
            var settings = AvastWRC.bal.settings.get();
            if(settings.features["dnt"] == false){
                chrome.browserAction.setBadgeText({tabId: activeInfo.tabId, text: ""});
            }
				//reset the badge SP
            if(settings.safeShop != undefined){
                var timestamp = (new Date()).getTime();
			        var urlDomain = AvastWRC.bal.getDomainFromUrl(tab.url);
		            var domainTimeout = settings.safeShop.hideDomains[urlDomain] || 0;
		            var allTimeout = settings.safeShop.hideAll || 0;
                var barclosedByUser = settings.safeShop.closedByUser[tab.url] || {};
                if (!(domainTimeout > timestamp || allTimeout > timestamp || barclosedByUser.closed == 1)){
                    chrome.browserAction.setBadgeText({tabId: activeInfo.tabId, text: ""});
                }
            }
				
	            if (typeof changeInfo == "undefined") {
	                changeInfo = {};
	                changeInfo.status = "complete";
	            }
	            urlInfoChange(tab.url, tab, changeInfo.status, false);
	        });
    	});
    }

    function onRedirect(info) {
    	AvastWRC.bs.tabExists.call(this, info.tabId, function(){
	        chrome.tabs.get(info.tabId, function (tab) {
	            // ignore unsuported tab urls like chrome://, about: and chrome.google.com/webstore - these are banned by google.	            
	            if (!AvastWRC.bs.checkUrl(tab.url)) {	                
	                chrome.browserAction.disable(info.tabId);
	                return;
	            }
	            //enable the browser extension
	            chrome.browserAction.enable(info.tabId);
				
				//reset the badge AOS
            var settings = AvastWRC.bal.settings.get();
            if(settings.features["dnt"] == false){
                chrome.browserAction.setBadgeText({tabId: info.tabId, text: ""});
            }
				//reset the badge SP
            if(settings.safeShop != undefined){
                var timestamp = (new Date()).getTime();
			        var urlDomain = AvastWRC.bal.getDomainFromUrl(tab.url);
		            var domainTimeout = settings.safeShop.hideDomains[urlDomain] || 0;
		            var allTimeout = settings.safeShop.hideAll || 0;
                var barclosedByUser = settings.safeShop.closedByUser[tab.url] || {};
                if (!(domainTimeout > timestamp || allTimeout > timestamp || barclosedByUser.closed == 1)){
                    chrome.browserAction.setBadgeText({tabId: info.tabId, text: ""});
                }
            }
				
	            console.log(info.statusCode + " REDIRECT from " + info.url + " to " + info.redirectUrl);
	
	            urlInfoChange(info.url, tab, null, AvastWRC.gpb.All.EventType.SERVER_REDIRECT);
	        });
    	});
    }
	
	/**
     * User clic SP icon when it is on hide mode
     *
     * @param  {Object} tab        Tab object
     * @return {void}
     */
    function onClicked(tab) {
    	AvastWRC.bs.tabExists.call(this, tab.id, function() {
	        // ignore unsuported tab urls like chrome://, about: and chrome.google.com/webstore - these are banned by google.
	        // and disable the browser extension for those tabs
	        if (!AvastWRC.bs.checkUrl(tab.url)) {	            
	            chrome.browserAction.disable(tab.id);
	            return;
	        }
			
        var settings = AvastWRC.bal.settings.get();
	        
	        var timestamp = (new Date()).getTime();
	        var urlDomain = AvastWRC.bal.getDomainFromUrl(tab.url);
        var domainTimeout = settings.safeShop.hideDomains[urlDomain] || 0;
        var allTimeout = settings.safeShop.hideAll || 0;      
        var barclosedByUser = settings.safeShop.closedByUser[tab.url] || {};
        if (domainTimeout > timestamp || allTimeout > timestamp || barclosedByUser.closed == 1){
            settings.safeShop.iconClicked = 1;
            if (barclosedByUser.closed == 1){
                settings.safeShop.closedByUser[tab.url].closed = 0;
                settings.safeShop.closedByUser[tab.url].offersNumber = 0;
                chrome.browserAction.setBadgeText({tabId: tab.id, text: ""});
            }
            AvastWRC.bal.settings.set(settings);
            urlInfoChange(tab.url, tab, false, false);
            AvastWRC.bal.emitEvent("page.complete", tab.id, tab, tab.url);				
        }
    	});
    }

    /**
     * Forwards all the messages to the browser agnostic core
     */
    function messageHub(request, sender, reply) {
        bal.commonMessageHub(request.message, request, sender.tab);
    }

    /**
     * Injects all the needed scripts to a tab and sends a message
     */
    function accessContent(tab, data) {
        if (scriptInTab[tab.id] === undefined) {
            scriptInTab[tab.id] = true;
            var options = {
                tab: tab,
                callback: function () { AvastWRC.bs.messageTab(tab, data); }
            };
            _.extend(options, AvastWRC.bal.getInjectLibs());

            if (AvastWRC.bs.ciuvoASdetector && AvastWRC.bs.ciuvoASdetector.isAffiliateSource(tab.id, true)) {
                console.log("afsrc=1 detected, standing down");
            } else {
                AvastWRC.bs.inject(options);
            }

        }
        else {
            AvastWRC.bs.messageTab(tab, data);
        }
    }


    /*****************************************************************************
     * bs - override the common browser function with ext. specific
     ****************************************************************************/
    _.extend(AvastWRC.bs,
        {
            accessContent: accessContent,

            /**
             * Get host of the tab.
             */
            getHostInTab: function (tabId) {
                return hostInTab[tabId];
            },

            /**
             * Set host of the tab.
             */
            setHostInTab: function (tabId, host) {
                hostInTab[tabId] = host;
            },

            getLocalStorage(key, callback){                  
                chrome.storage.local.get(key, function(result){
                    if(typeof result === "object" && result[key]) {
                        callback(result[key]);
                    }
                    else{
                        callback(null);
                    }
                });            
                return;
            },
            
            setLocalStorage(key, data) {                
                var storage = {};
                storage[key] = data;
                chrome.storage.local.set(storage);            
            }

        });

    /*****************************************************************************
     * bs.aos - browser specific AOS functionality
     ****************************************************************************/
    AvastWRC.bs.core = AvastWRC.bs.core || {};
    _.extend(AvastWRC.bs.core, // Browser specific
        {
            /**
             * Function called on BAL initialization to initialize the module.
             */
            init: function (balInst) {
                bal = balInst;

                chrome.tabs.onUpdated.addListener(onTabUpdated);
                chrome.tabs.onActivated.addListener(onActivated);

                chrome.tabs.onRemoved.addListener(AvastWRC.onTabRemoved);

                // chrome.webNavigation might also be an option, but it has a bug that affects google search result page: https://bugs.chromium.org/p/chromium/issues/detail?id=115138
                chrome.webRequest.onBeforeRedirect.addListener(onRedirect, { urls: ["http://*/*", "https://*/*"], types: ["main_frame"] });

				//clic on SP icon
                chrome.browserAction.onClicked.addListener(onClicked);
				
                chrome.runtime.onMessage.addListener(messageHub);

                chrome.webRequest.onSendHeaders.addListener(
                    AvastWRC.onSendHeaders,
                    { urls: ["http://*/*", "https://*/*"] },
                    ["requestHeaders"]
                );
            },
            /**
             * Called after initialization to kick some functionality on start.
             */
            // afterInit: function () {
            //   AvastWRC.bal.checkPreviousVersion(AvastWRC.CONFIG.CALLERID);
            // },

            /* Register SafePrice Event handlers */
            registerModuleListeners: function (ee) {

            }


        }); // AvastWRC.bs.aos

    AvastWRC.bal.registerModule(AvastWRC.bs.core); 
}).call(this, _);
/*******************************************************************************
 *  avast! browsers extensions
 *  (c) 2012-2014 Avast Corp.
 *
 *  Background Browser Specific - AOS specific
 *
 ******************************************************************************/

(function(_) {

    var bal = null; //AvastWRC.bal instance - browser agnostic

    var RATING_ICONS = ["status-none.png","status-ok.png","status-attention.png","status-warning.png"];
    // 0 - NONE, 1 - GOOD, 2 - AVERAGE, 3 - BAD
  
    var timeSlot = 200;
    var isDomainFilter = true; // is Domain filter activated then allow only domains from list

    var classNameBlackList = ["btn", "btn-sm", "btn-block", "btn-secondary", "btn-lg"];
    var currentPosition = {}; //{ windowId: windowId, hostname: hostname, domain: domain, tabId: tab.id };
    var pendingActions = {};
    var userAction = null;
  
    var ajaxFilter = {
        urls: ["http://*/*", "https://*/*"],
        types: ["main_frame", "xmlhttprequest"]
    };

  /**
   * Update toolbar button
   *
   * @param  {Object} urlinfo Instance of UrlInfo class
   * @param  {Object} tab     Tab object properties
   * @return {void}
   */
    function updateButton(url, urlinfo, tab) {
        var ratingText = urlinfo.getRatingString();
        var weightText = urlinfo.getWeightString();
        var iconString = RATING_ICONS[urlinfo.getRatingCategory()];

    // is the tab still opened?
        AvastWRC.bs.tabExists.call(this, tab.id, function(){
            chrome.browserAction.setIcon({ path : "common/ui/icons/" + iconString, tabId:tab.id});
            var title = "Avast - " + AvastWRC.bs.getLocalizedString(ratingText) + " " + AvastWRC.bs.getLocalizedString(weightText);
            if (!AvastWRC.Utils.getBrowserInfo().isEdge()) {
                chrome.browserAction.setTitle({ title: title, tabId: tab.id });
            }
        });
    }

  /**
   * Event handler to run and inject SERP colouring rules.
   * @param {Object} details    triggered event details
   * @return {void}
   */
    function onTabUpdated(tabId, info, tab) {
        if (info.status === "complete" && AvastWRC.CONFIG.ENABLE_WEBREP_CONTROL && AvastWRC.CONFIG.ENABLE_SERP && AvastWRC.bal.search) {
            setTimeout(function () { AvastWRC.bal.search.checkSearch(tab); }, 1000);  // Google renders the page through JavaScript, so we better wait
        }
        currentPosition.tabId = tabId;
        currentPosition.domain = AvastWRC.bal.getDomainFromUrl(tab.url);
    }
  
  /**
   * Event handler for ajax requests.
   * @param {Object} details triggered event details
   * @return {void}
   */
    function onCommitted(details) {
  	AvastWRC.bs.tabExists.call(this, details.tabId, function(){
	        chrome.tabs.get(details.tabId, function (tab) {
	            // ignore unsuported tab urls like chrome://, about: and chrome.google.com/webstore - these are banned by google.
	            
	            if (!AvastWRC.bs.checkUrl(tab.url)) {	                
	                chrome.browserAction.disable(details.tabId);
	                return;
	            }
	            //enable the browser extension	            
	            chrome.browserAction.enable(details.tabId);	            
	
	            if (details.transitionType !== undefined && details.transitionType !== "auto_subframe") {
	
	                var origin = {
	                    url: details.url,
	                    windowNum: tab.windowId,
	                    tabNum: details.tabId,
	                    origin: AvastWRC.bs.getOrigin(details.transitionType, details.transitionQualifiers),
	                    hash: AvastWRC.bal.utils.getHash(details.url + details.tabId + tab.windowId)
	                };
	
	                console.log("onCommitted() hash:" + origin.hash + " origin:" + origin.origin + " url:" + origin.url);
	                AvastWRC.TabReqCache.set(details.tabId, "origin", origin);
	            }
	
	        });
  	});
    }  

    function filterClassName(name) {
        if (!_.isString(name) || name.length === 0 || name.indexOf(" ") === -1) return name;
        var names = name.split(" ");
        var results = "";
        for (var n in names) {
            if (classNameBlackList.indexOf(names[n]) === -1) {
                results += " " + names[n];
            }
        }
        return results.trim();
    }

    function updateCurrentWindowId() {
        chrome.tabs.query({ "windowId": chrome.windows.WINDOW_ID_CURRENT, "active" : true },
          function (tabInfo) {
              if (!_.isArray(tabInfo) || tabInfo.length === 0) {
                  return;
              }
              currentPosition.windowId = tabInfo[0].windowId;
              currentPosition.tabId = tabInfo[0].id;
              currentPosition.domain = AvastWRC.bal.getDomainFromUrl(tabInfo[0].url);
              //console.log("ajax currentPosition new: ", currentPosition);
          });
    }

   /**
   * Event handler to catch Ajax request.
   * @param {Object} details    triggered event details
   * @return {void}
   */
    function onBeforeRequest(details) {

        var requestId = details.requestId;
        var tabId = details.tabId;
        var method = details.method;
        var type = details.type;
        var url = details.url;	  
	  
	  if(type === "main_frame")
	  {
		  var blockOnBeforeRequest = AvastWRC.TabReqCache.get(tabId, "onBeforeReq");
		  if(blockOnBeforeRequest && blockOnBeforeRequest.blocked == true && url != AvastWRC.SITE_CORRECT_MSG_REDIRECT){
      return {cancel: true};
		  } 
	  }
        if (currentPosition && currentPosition.tabId === tabId) {
        
            var domain = AvastWRC.bal.getDomainFromUrl(url);

            if (type === "xmlhttprequest" && currentPosition.domain === domain) {
                pendingActions[requestId] = details;
              //console.log("ajax new pendingActions: " + requestId);
            } else {
                pendingActions = {};
                userAction = null;
            }
        }
    }

    /**
    * Event handler to catch Ajax request.
    * @param {Object} details    triggered event details
    * @return {void}
    */
    function onResponseStarted(details) {
        var tabId = details.tabId;
        var method = details.method;
        var requestId = details.requestId;

        if (currentPosition && currentPosition.tabId === tabId) {
            switch (method) {
            case "GET":
            case "POST":
            case "PUT":
            case "DELETE":
                  
                if (pendingActions[requestId] && userAction) {
                    var req = pendingActions[requestId];

                    var keys = [
                          //{ key: 'url', value: req.url },
                          { key: "request", value: "ajax" },
                          //{ key: 'text', value: userAction.text },
                          //{ key: 'node', value: userAction.node },
                          { key: "className", value: filterClassName(userAction.className) },
                          { key: "method", value: req.method }];


                    if (isDomainFilter) {
                        var domain = AvastWRC.bal.getDomainFromUrl(req.url);
                        var host = AvastWRC.bal.getHostFromUrl(req.url);
                        if (AvastWRC.bs.allowedDomains.indexOf(domain) === -1 && AvastWRC.bs.allowedDomains.indexOf(host) === -1) {
                        	  console.log("skip ajax request", JSON.stringify(keys));
                            break;
                        }
                    }

                    var urlDetails = {
                        url: req.url,
                        tabNum: tabId,
                        windowNum: currentPosition.windowId,
                        customKeyValue: keys
                    };

                    console.log("send ajax to UrlInfo requestId: " + requestId, JSON.stringify(keys));
                    AvastWRC.get(urlDetails, function (res) {
                    });

                    setTimeout(function () {
                        return userAction = null;
                    }, timeSlot);
                }
            }
        }
    }

    function onCompleted(details) {
        var tabId = details.tabId;
        var requestId = details.requestId;

        if (currentPosition && currentPosition.tabId === tabId) {
            delete pendingActions[requestId];
        }
    }

    function onErrorOccurred(details) {
        var error = details.error;
        var requestId = details.requestId;
        var tabId = details.tabId;
            
        if (details.type === "main_frame" 
    	  || details.type === "xmlhttprequest"
    	  && (currentPosition && currentPosition.tabId === tabId)) {
            delete pendingActions[requestId];
        }
    }

    function onMessage (request, sender, sendResponse) {
        updateCurrentWindowId();
        userAction = request;
        console.log("ajax userAction", JSON.stringify(userAction));
      
        var type = request.type || "";
        var tab = sender.tab;
        if(type === "pageTitle")
	  {
    	  var url = tab.url || (tab.contentDocument && tab.contentDocument.location
    		        ? tab.contentDocument.location.href : null);
    	  var host = AvastWRC.bal.getHostFromUrl(url);
    	  
    	  var keys = [
			             { key: "title", value: request.title},
			           	 {key: "host", value: host}
			         ];
    	  AvastWRC.Queue.set("pageTitle", keys);
	  }
    }

    /**
     * Sidebar data generator
     */
    function openSidebar(tab) {
        var host = AvastWRC.bs.getHostInTab(tab.id) || bal.getHostFromUrl(tab.url);
        AvastWRC.bs.setHostInTab(tab.id, host);

        var data = {
            message : "populate",
            data: {
                dnt    : bal.DNT.compute(tab.id, host),
                webrep : bal.WebRep.compute(host)
            }
        };
        AvastWRC.bs.accessContent(tab, data);
    }
  /**
   * Extension button handler
   */
    function actionClicked() {
        AvastWRC.bs.getActiveTab( openSidebar );
    }

  /**
   * On Before Request handler - used by DNT feature
   * Synchronous - Blocking !!!
   */
    function checkDNT(request) {
	  
        if(request.type !== "main_frame" &&
      bal.DNT.isTracking(
        request.url,
        AvastWRC.bs.getHostInTab(request.tabId),
        request.tabId))
    {
            if (request.type == "sub_frame") {
                return { redirectUrl: "about:blank" };
            }
            else if (request.type == "image") {
                return {
                    redirectUrl: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAFElEQVR4XgXAAQ0AAABAMP1L30IDCPwC/o5WcS4AAAAASUVORK5CYII="
                };
            }
            else {
                var mock =AvastWRC.Utils.resolveLocalMock(request.url);
                if (mock) {
                    return {
                        redirectUrl : chrome.extension.getURL("common/mocks/" + mock)
                    };
                } else {
                    return {cancel: true};
                }
            }
        }
        else {
            return {cancel: false};
        }
    }
 
  /*****************************************************************************
   * bs.aos - browser specific AOS functionality
   ****************************************************************************/
    AvastWRC.bs.aos = AvastWRC.bs.aos || {};
    _.extend(AvastWRC.bs.aos, // Browser specific
        {
    /**
     * Function called on BAL initialization to initialize the module.
     */
            init: function (balInst) {
                bal = balInst;

                chrome.tabs.onUpdated.addListener(onTabUpdated);
                chrome.webNavigation.onCommitted.addListener(onCommitted);
      
                chrome.browserAction.onClicked.addListener(actionClicked);

                chrome.webRequest.onBeforeRequest.addListener(onBeforeRequest, ajaxFilter, ["blocking"]);
                chrome.webRequest.onResponseStarted.addListener(onResponseStarted, ajaxFilter, ["responseHeaders"]);
                chrome.webRequest.onCompleted.addListener(onCompleted, ajaxFilter, ["responseHeaders"]);
                chrome.webRequest.onErrorOccurred.addListener(onErrorOccurred, {urls: ["http://*/*", "https://*/*"]});
                chrome.runtime.onMessage.addListener(onMessage);


                bal.hookOnFeatureChange("dnt", function(enabled) {    	
                    if (enabled) {        	
        	chrome.webRequest.onBeforeRequest.addListener(checkDNT,
        			{urls: ["http://*/*", "https://*/*"]}, ["blocking"]);
                    } else {
        	chrome.webRequest.onBeforeRequest.removeListener(checkDNT);
        	AvastWRC.bal.DNT.resetAllTabs();
                    }    	
                }.bind(this));
            },
    /**
     * Called after initialization to kick some functionality on start.
     */
            afterInit: function () {
                AvastWRC.bal.checkPreviousVersion(AvastWRC.CONFIG.CALLERID);
            },

    /* Register SafePrice Event handlers */
            registerModuleListeners: function(ee) {
                ee.on("badgeInfoUpdated",
        AvastWRC.Utils.throttle(
          function(tab_id, host, getData) {
              var data = getData(tab_id, host); // {text: ..., color: ...}
              if(data) {
                  chrome.browserAction.setBadgeBackgroundColor({tabId: tab_id, color: data.color });
                  chrome.browserAction.setBadgeText({tabId: tab_id, text: data.text});
              }
          },
        100)
      );

      // update bowser action button
                ee.on("urlInfo.response", updateButton);
            }


        }); // AvastWRC.bs.aos

    AvastWRC.bal.registerModule(AvastWRC.bs.aos);

}).call(this, _);


(function (_) {
    
    AvastWRC.bal.modifyInjectLibs(function (injectLibs) {
        if (injectLibs && injectLibs.css) {
            //injectLibs.css.push('common/ui/css/style.modal.css');
        }
        return injectLibs;
    });
    
}).call(this, _);

(function (_) {
    
    AvastWRC.bs = AvastWRC.bs || {};
    _.extend(AvastWRC.bs, // Browser specific
        {
            allowedDomains : [
                "3wishes.com",
                "53.com",
                "7forallmankind.com",
                "aa.com",
                "accorhotels.com",
                "acmoore.com",
                "acura.com",
                "acuvue.com",
                "adamsgolf.com",
                "additionelle.com",
                "adidas.com",
                "adidasgolf.com",
                "adventuresbydisney.com",
                "aerin.com",
                "aeromexico.com",
                "agjeans.com",
                "agoda.com",
                "airbnb.com",
                "airbnb.fr",
                "alange-soehne.com",
                "alaskaair.com",
                "albertaferretti.com",
                "aldenshoe.com",
                "aldo.com",
                "aldoshoes.com",
                "alexandermcqueen.com",
                "allenedmonds.com",
                "ally.com",
                "alternahaircare.com",
                "always.com",
                "americancrew.com",
                "americanexpress.com",
                "ana.co.jp",
                "andrewchristian.com",
                "anneklein.com",
                "arcteryx.com",
                "aria.com",
                "ariat.com",
                "armani.com",
                "armanicasa.com",
                "armaniexchange.com",
                "asda-photo.co.uk",
                "asda.com",
                "asdatyres.co.uk",
                "asics.com",
                "att.com",
                "audiusa.com",
                "aussiebum.com",
                "aveeno.com",
                "avenue.com",
                "avianca.com",
                "axe.com",
                "azamaraclubcruises.com",
                "azzaro.com",
                "babolat.com",
                "backstreetmerch.com",
                "balenciaga.com",
                "balenciagafragrance.com",
                "bally.com",
                "balmain.com",
                "bananarepublic.com",
                "bankofamerica.com",
                "barneys.com",
                "bbt.com",
                "bcbg.com",
                "bearpaw.com",
                "beatsbydre.com",
                "bebe.com",
                "bellagio.com",
                "belstaff.com",
                "benefitcosmetics.com",
                "benetton.com",
                "benjerry.com",
                "bershka.com",
                "bestpricewholesale.co.in",
                "bestwestern.com",
                "birkenstock.com",
                "blair.com",
                "blancpain.com",
                "bluefly.com",
                "bluemercury.com",
                "bluemercury.com",
                "blundstone.com",
                "bmoharris.com",
                "bmwusa.com",
                "bnymellon.com",
                "bodenusa.com",
                "bongo.com",
                "bonton.com",
                "bookingbuddy.com",
                "bottegaveneta.com",
                "bpi-sa.com",
                "brahmin.com",
                "braun.com",
                "bravissimo.com",
                "breguet.com",
                "breyers.com",
                "brioni.com",
                "britishairways.com",
                "brooksrunning.com",
                "buckle.com",
                "buffalojeans.com",
                "buick.com",
                "bulgari.com",
                "burberry.com",
                "burtsbees.com",
                "bustedtees.com",
                "buycostumes.com",
                "cableone.net",
                "cadillac.com",
                "calvinklein.com",
                "calvinklein.us",
                "campmor.com",
                "canadagoose.com",
                "canali.com",
                "candies.com",
                "capitalone.com",
                "carhartt.com",
                "carnival.com",
                "carolinaherrera.com",
                "carolsdaughter.com",
                "cartier.com",
                "catfootwear.com",
                "cathaypacific.com",
                "cavenders.com",
                "celebritycruises.com",
                "celine.com",
                "century21.com",
                "centurylink.com",
                "centurylinkquote.com",
                "champssports.com",
                "chanel.com",
                "chapstick.com",
                "charlotterusse.com",
                "charter.com",
                "chase.com",
                "cheapoair.com",
                "cheaptickets.com",
                "chevrolet.com",
                "chicos.com",
                "childrensplace.com",
                "chippewaboots.com",
                "chloe.com",
                "choicehotels.com",
                "christopherandbanks.com",
                "cinemark.com",
                "citi.com",
                "citizensbank.com",
                "claires.com",
                "clairol.com",
                "clarinsusa.com",
                "clarisonic.com",
                "clarksusa.com",
                "cleanandclear.com",
                "cledepeaubeaute.com",
                "cnd.com",
                "coldwellbankerhomes.com",
                "colehaan.com",
                "colgate.com",
                "columbia.com",
                "comcast.com",
                "comparecards.com",
                "copaair.com",
                "coppertone.com",
                "cosmopolitanlasvegas.com",
                "costacruise.com",
                "covergirl.com",
                "cox.com",
                "credit.com",
                "creditcards.com",
                "creditkarma.com",
                "cremedelamer.com",
                "crest.com",
                "cricketwireless.com",
                "crowneplaza.com",
                "cruiseoceania.com",
                "crystalcruises.com",
                "ctrip.com",
                "ctshirts.com",
                "cunard.com",
                "currentelliott.com",
                "customink.com",
                "davidsbridal.com",
                "davidyurman.com",
                "debeers.com",
                "debenhams.com",
                "debshops.com",
                "decolar.com",
                "degreedeodorant.com",
                "delta.com",
                "destinationxl.com",
                "diadora.com",
                "dickies.com",
                "dionwired.co.za",
                "dior.com",
                "direct.asda.com",
                "directv.com",
                "discountdance.com",
                "discover.com",
                "discovercard.com",
                "dish.com",
                "disneycruise.disney.go.com",
                "disneyparks.disney.go.com",
                "disneytravelagents.com",
                "disneyvacations.com",
                "dkny.com",
                "dockers.com",
                "dodge.com",
                "dolcegabbana.com",
                "dollskill.com",
                "domperignon.com",
                "donnakaran.com",
                "dooney.com",
                "dorothyperkins.com",
                "doublehboots.com",
                "dove.com",
                "dressbarn.com",
                "drjays.com",
                "drmartens.com",
                "dvf.com",
                "easyspirit.com",
                "ecco.com",
                "electrohogar.lider.cl",
                "elizabetharden.com",
                "ellesse.com",
                "emirates.com",
                "emuaustralia.com",
                "equipmentfr.com",
                "eresparis.com",
                "errea.com",
                "eshakti.com",
                "esprit.com",
                "essie.com",
                "etro.com",
                "evaair.com",
                "expedia.com",
                "fallwinter2017-berluti.com",
                "famousfootwear.com",
                "farfetch.com",
                "fashiontofigure.com",
                "fatface.com",
                "fekkai.com",
                "fendi.com",
                "ferragamo.com",
                "fiatusa.com",
                "figleaves.com",
                "fila.com",
                "flyasiana.com",
                "footaction.com",
                "ford.com",
                "forevermark.com",
                "forplaycatalog.com",
                "forzieri.com",
                "fourpointsnorwood.com",
                "fredericks.com",
                "freepeople.com",
                "frontier.com",
                "frontierbundles.com",
                "gapfactory.com",
                "garnierusa.com",
                "geoffreybeene.com",
                "geox.com",
                "giorgioarmanibeauty-usa.com",
                "givenchy.com",
                "givenchybeauty.com",
                "glenmorangie.com",
                "gojane.com",
                "goldmansachs.com",
                "goldstar.com",
                "groceries.asda.com",
                "gucci.com",
                "guess.com",
                "hannaandersson.com",
                "harrywinston.com",
                "hayneedle.com",
                "headandshoulders.com",
                "hellmanns.com",
                "hennessy.com",
                "herbalessences.com",
                "hermes.com",
                "herroom.com",
                "herveleger.com",
                "hickeyfreeman.com",
                "hilton.com",
                "hiltonworldwide.com",
                "hollandamerica.com",
                "hollister.com",
                "honda.com",
                "hotelplanner.com",
                "hotels.com",
                "hotelscombined.com",
                "hottopic.com",
                "hotwire.com",
                "houseofcaress.com",
                "hsbc.com",
                "hublot.com",
                "hugoboss.com",
                "humblebundle.com",
                "hunterboots.com",
                "huntington.com",
                "hyatt.com",
                "hyundaiusa.com",
                "ibis.com",
                "icebreaker.com",
                "iconixbrand.com",
                "ihg.com",
                "indianweddingsaree.com",
                "infinitiusa.com",
                "intercontinental.com",
                "izod.com",
                "jackwills.com",
                "jaeger-lecoultre.com",
                "jbrandjeans.com",
                "jeep.com",
                "jergens.com",
                "jetblue.com",
                "jimmychoo.com",
                "jinx.com",
                "jlrforms.com",
                "jnj.com",
                "jny.com",
                "jockey.com",
                "johnvarvatos.com",
                "joie.com",
                "joma-sport.com",
                "jomalone.com",
                "josbank.com",
                "journeys.com",
                "jpmorganchase.com",
                "jumeirah.com",
                "kappa.com",
                "karmaloop.com",
                "kayak.com",
                "keds.com",
                "kelme.com",
                "kempinski.com",
                "kennethcole.com",
                "kenzo.com",
                "key.com",
                "kia.com",
                "kingsizedirect.com",
                "kitandace.com",
                "klm.com",
                "klondikebar.com",
                "koreanair.com",
                "kswiss.com",
                "lacoste.com",
                "lancome-usa.com",
                "landroverusa.com",
                "laperla.com",
                "lasenza.com",
                "lauramercier.com",
                "leatherup.com",
                "lecoqsportif.com",
                "lee.com",
                "leecooper.com",
                "lenscrafters.com",
                "levi.com",
                "lhrcollection.com",
                "lider.cl",
                "lids.com",
                "liptontea.com",
                "livingproof.com",
                "loewe.com",
                "loewshotels.com",
                "londonfog.com",
                "longines.com",
                "longtallsally.com",
                "lorealparisusa.com",
                "lorealusa.com",
                "lottoteamsport.com",
                "louisvuitton.com",
                "lovelywholesale.com",
                "lq.com",
                "luckybrand.com",
                "lufthansa.com",
                "lululemon.com",
                "lulus.com",
                "luxurycollectiondestinations.com",
                "macron.com",
                "magnumicecream.com",
                "maille.com",
                "makemechic.com",
                "makemytrip.com",
                "makeupforever.com",
                "makro.co.za",
                "mamasandpapas.com",
                "mandarinoriental.com",
                "mango.com",
                "marcjacobs.com",
                "marcjacobsfragrances.com",
                "marmot.com",
                "marni.com",
                "marriott.com",
                "marshallsonline.com",
                "massmart.co.za",
                "mastercard.com",
                "matchesfashion.com",
                "materialgirl.com",
                "maxstudio.com",
                "maybelline.com",
                "mbusa.com",
                "menards.com",
                "mercure.com",
                "merrell.com",
                "metropcs.com",
                "mgmgrand.com",
                "missselfridge.com",
                "miumiu.com",
                "mizunocda.com",
                "mizunousa.com",
                "mobile.asda.com",
                "moncler.com",
                "money.asda.com",
                "monki.com",
                "montblanc.com",
                "moosejaw.com",
                "morganstanley.com",
                "moschino.com",
                "motel6.com",
                "mothercare.com",
                "mountainhardwear.com",
                "movado.com",
                "msccruisesusa.com",
                "mtb.com",
                "muddjeans.com",
                "muglerusa.com",
                "myrobeez.com",
                "narscosmetics.com",
                "nautica.com",
                "ncl.com",
                "nelly.com",
                "nerdwallet.com",
                "neutrogena.com",
                "newbalance.com",
                "neweracap.com",
                "newlook.com",
                "nexxus.com",
                "ninaricci.com",
                "ninewest.com",
                "nissanusa.com",
                "northerntrust.com",
                "novotel.com",
                "nyandcompany.com",
                "oakley.com",
                "olay.com",
                "omegawatches.com",
                "omnihotels.com",
                "onetravel.com",
                "op.com",
                "opi.com",
                "opticians.asda.com",
                "oralb.com",
                "orbitz.com",
                "orvis.com",
                "oscardelarenta.com",
                "oshkosh.com",
                "pacorabanne.com",
                "pacsun.com",
                "pajar.com",
                "panerai.com",
                "pantene.com",
                "patagonia.com",
                "patek.com",
                "paulmitchell.com",
                "persol.com",
                "pestana.com",
                "philosophy.com",
                "piaget.com",
                "pnc.com",
                "pomellato.com",
                "porsche-design.us",
                "prada.com",
                "priceline.com",
                "prilosecotc.com",
                "primark.com",
                "princess.com",
                "promgirl.com",
                "pullandbear.com",
                "puma.com",
                "qatarairways.com",
                "rackroomshoes.com",
                "radisson.com",
                "rado.com",
                "rag-bone.com",
                "ray-ban.com",
                "rbc.com",
                "rbcwealthmanagement.com",
                "realtor.com",
                "rebelcircus.com",
                "rebelsmarket.com",
                "redfin.com",
                "redken.com",
                "redmond.life",
                "redroof.com",
                "redwingshoes.com",
                "reebok.com",
                "regions.com",
                "regmovies.com",
                "reiss.com",
                "relaischateaux.com",
                "revlon.com",
                "revolve.com",
                "richardmille.com",
                "rimmellondon.com",
                "ritzcarlton.com",
                "riu.com",
                "roamans.com",
                "rockport.com",
                "rockyboots.com",
                "rocskincare.com",
                "rogaine.com",
                "rolex.com",
                "rossstores.com",
                "royal-hawaiian.com",
                "royalbank.com",
                "royalcaribbean.com",
                "rssc.com",
                "ryanair.com",
                "sallyhansen.com",
                "samedelman.com",
                "samsclub.cn",
                "santanderbank.com",
                "sassoon.com",
                "saucony.com",
                "schwab.com",
                "seabourn.com",
                "seatgeek.com",
                "secret.com",
                "sexyhair.com",
                "shangri-la.com",
                "sheplers.com",
                "shinola.com",
                "shiseido.com",
                "shoecarnival.com",
                "shoedazzle.com",
                "shoemall.com",
                "shoes.com",
                "shop.diesel.com",
                "shop.guess.com",
                "shopstyle.com",
                "silversea.com",
                "simpleskincare.com",
                "singaporeair.com",
                "sk-ii.com",
                "skyscanner.com",
                "skyscanner.net",
                "sneakerhead.com",
                "sofitel.com",
                "softmoc.com",
                "sorel.com",
                "sothebysrealty.com",
                "southwest.com",
                "spectrum.com",
                "sperry.com",
                "sportika.com",
                "sportsdirect.com",
                "sportsshoes.com",
                "sprint.com",
                "starwoodhotels.com",
                "statestreet.com",
                "stellamccartney.com",
                "stoneisland.com",
                "straighttalk.com",
                "stregisbali.com",
                "stregisfamilytraditions.com",
                "striderite.com",
                "stuartweitzman.com",
                "stubhub.com",
                "suave.com",
                "subaru.com",
                "suddenlink.com",
                "suitsupply.com",
                "suncountry.com",
                "sunglasshut.com",
                "sunsetkeycottages.com",
                "suntrust.com",
                "swatch.com",
                "swimoutlet.com",
                "swimsuitsforall.com",
                "t-mobile.com",
                "tagheuer.com",
                "tajhotels.com",
                "tampax.com",
                "taylormadegolf.com",
                "tdbank.com",
                "teacollection.com",
                "tedbaker.com",
                "tesla.com",
                "the-seiyu.com",
                "theartofshaving.com",
                "thefryecompany.com",
                "thenorthface.com",
                "thepointsguy.com",
                "therooseveltneworleans.com",
                "thewalkingcompany.com",
                "thomaspink.com",
                "threadless.com",
                "ticketmaster.com",
                "tickets.com",
                "ties.com",
                "tillys.com",
                "timewarnercable.com",
                "tissotwatches.com",
                "tjx.com",
                "tmlewin.com",
                "tods.com",
                "tomford.com",
                "tommy.com",
                "tommybahama.com",
                "toniandguy.com",
                "topman.com",
                "topshop.com",
                "torrid.com",
                "toyoko-inn.com",
                "travelocity.com",
                "travelzoo.com",
                "tresemme.com",
                "tripadvisor.com",
                "tripadvisor.es",
                "trivago.com",
                "truereligion.com",
                "trulia.com",
                "tumi.com",
                "turkishairlines.com",
                "umbro.com",
                "uniformadvantage.com",
                "unionbank.com",
                "uniqlo.com",
                "urbandecay.com",
                "us.asos.com",
                "us.jimmychoo.com",
                "us.maxmara.com",
                "usa.tommy.com",
                "usaa.com",
                "usbank.com",
                "uscellular.com",
                "valentino.com",
                "vancleefarpels.com",
                "vans.com",
                "vaseline.us",
                "venus.com",
                "verawang.com",
                "verawangonweddings.com",
                "verizon.com",
                "verizonwireless.com",
                "versace.com",
                "viaspiga.com",
                "vibram.com",
                "vikingcruises.com",
                "viktor-rolf.com",
                "villagehatshop.com",
                "virginmobileusa.com",
                "visa.com",
                "vividseats.com",
                "vudu.com",
                "vw.com",
                "wal-martchina.com",
                "waldorfastoriaparkcity.com",
                "waldorfnewyork.com",
                "walmart.ca",
                "walmart.com.ar",
                "walmart.com.br",
                "walmart.com.mx",
                "walmartchile.cl",
                "wella.com",
                "wellsfargo.com",
                "westingovernormorris.com",
                "westinriverfrontbeavercreek.com",
                "westinshanghai.com",
                "westinstfrancis.com",
                "wetseal.com",
                "whitesboots.com",
                "whitestuff.com",
                "wickedweasel.com",
                "wigwamarizona.com",
                "wilsonsleather.com",
                "windsorstore.com",
                "windstarcruises.com",
                "womensmarketing.com",
                "woolrich.com",
                "wrangler.com",
                "wyndhamhotels.com",
                "xfinity.com",
                "yandy.com",
                "yonexusa.com",
                "yoox.com",
                "ysl.com",
                "yslbeautyus.com",
                "zalando.com",
                "zara.com",
                "zegna.us",
                "zillow.com",
                "zyrtec.com",
                "aerlingus.com",
                "aerolineas.com.ar",
                "airberlin.com",
                "alfaromeo.co.uk",
                "alfaromeo.cz",
                "alfaromeo.sk",
                "alfaromeousa.com",
                "alpha-armouring.com",
                "athleta.gap.com",
                "audicanada.ca",
                "autotrader.com",
                "ballarddesigns.com",
                "bananarepublic.ca",
                "bluetree.com.br",
                "bobbibrowncosmetics.com",
                "buick.ca",
                "cadillaccanada.ca",
                "carfax.com",
                "cargurus.com",
                "chevrolet.ca",
                "drivetime.com",
                "edmunds.com",
                "enterprise.co.uk",
                "enterprise.com",
                "evans.co.uk",
                "ford.ca",
                "foxrentacar.com",
                "frontgate.com",
                "gap.eu",
                "gapcanada.ca",
                "gm.ca",
                "guess.eu",
                "henribendel.com",
                "hipmunk.com",
                "hondacertified.com",
                "jackspade.com",
                "katespade.com",
                "kayak.co.uk",
                "kayak.fr",
                "kbb.com",
                "kidsfootlocker.com",
                "lastminute.com",
                "lincoln.com",
                "maserati.us",
                "mini.ca",
                "mitsubishicars.com",
                "next.co.uk",
                "pier1.com",
                "ramtrucks.com",
                "runnerspoint.com",
                "smartusa.com",
                "sonicautomotive.com",
                "subaru.ca",
                "toyota.com",
                "truecar.com",
                "tunisair.com.tn",
                "united.com",
                "usadmc.com",
                "vauxhall.co.uk",
                "virginamerica.com",
                "yatra.com",
                "anntaylor.com",
                "net-a-porter.com",
                "payless.com",
                "petsmart.com",
                "petfooddirect.com",
                "peapod.com",
                "petco.com",
                "bestbuy.com", 
                "walmart.com", 
                "target.com", 
                "costco.com", 
                "bjs.com", 
                "jet.com", 
                "netflix.com", 
                "flipkart.com", 
                "snapdeal.com", 
                "samsclub.com",
                "intuit.com", 
                "turbotax.com", 
                "hrblock.com",
                "taxact.com", 
                "freetaxusa.com", 
                "taxslayer.com", 
                "jacksonhewitt.com",
                "homedepot.com",
                "lowes.com",
                "kohls.com",
                "sears.com",
                "overstock.com",
                "macys.com",
                "neimanmarcus.com",
                "nordstrom.com",
                "tjx.com",
                "etsy.com",
                "hulu.com",
                "ebay.com",
                "dickssportinggoods.com",
                "finishline.com",
                "walgreens.com",
                "kmart.com",
                "dollartree.com",
                "biglots.com",
                "familydollar.com",
                "alibaba.com",
                "1800contacts.com",
                "1800flowers.com",
                "1800petmeds.com",
                "petsupplies.com",
                "1sale.com",
                "6pm.com",
                "abercrombie.com",
                "abercrombiekids.com",
                "academy.com",
                "acehardware.com",
                "adorama.com",
                "advanceautoparts.com",
                "advocare.com",
                "aeropostale.com",
                "albertsons.com",
                "aldogroup.com",
                "amazon.com",
                "ae.com",
                "americangirl.com",
                "amway.com",
                "anntaylor.com",
                "anthropologie.com",
                "apple.com",
                "artofbeauty.com",
                "asos.com",
                "athleta.com",
                "autonation.com",
                "autozone.com",
                "aveda.com",
                "avoncompany.com",
                "bhphotovideo.com",
                "backcountry.com",
                "bananarepublic.gap.com",
                "bareescentuals.com",
                "barenecessities.com",
                "barnesandnoble.com",
                "basspro.com",
                "bathandbodyworks.com",
                "beachbody.com",
                "beautyencounter.com",
                "bedbathandbeyond.com",
                "belk.com",
                "bergdorfgoodman.com",
                "beyondtherack.com",
                "bigfishgames.com",
                "birchbox.com",
                "birthdayexpress.com",
                "bloomingdales.com",
                "blueapron.com",
                "bluenile.com",
                "bodybuilding.com",
                "boostmobile.com",
                "bootbarn.com",
                "bose.com",
                "bostonproper.com",
                "boxed.com",
                "brooksbrothers.com",
                "build.com",
                "buy.com",
                "buybuybaby.com",
                "buythecase.com",
                "cabelas.com",
                "cafepress.com",
                "carmax.com",
                "carters.com",
                "casa.com",
                "cdw.com",
                "chegg.com",
                "chewy.com",
                "chicosfas.com",
                "choxi.com",
                "christianbook.com",
                "clinique.com",
                "coach.com",
                "coffeeforless.com",
                "coldwatercreek.com",
                "converse.com",
                "craftsy.com",
                "crateandbarrel.com",
                "creativemarket.com",
                "crocs.com",
                "crutchfield.com",
                "cvs.com",
                "doterra.com",
                "davidstea.com",
                "deandeluca.com",
                "dell.com",
                "deluxe.com",
                "dermstore.com",
                "diapers.com",
                "dillards.com",
                "disneystore.com",
                "dollargeneral.com",
                "dollarshaveclub.com",
                "doortodoororganics.com",
                "doversaddlery.com",
                "drsfostersmith.com",
                "drugstore.com",
                "dsw.com",
                "duluthtrading.com",
                "dunkindonuts.com",
                "elfcosmetics.com",
                "eastbay.com",
                "eddiebauer.com",
                "esalon.eu.com",
                "esteelauder.com",
                "express.com",
                "fab.com",
                "fabletics.com",
                "fairwaymarket.com",
                "fanatics.com",
                "fedex.com",
                "fitbit.com",
                "folica.com",
                "footlocker.com",
                "footsmart.com",
                "forever21.com",
                "fragrancenet.com",
                "freshdirect.com",
                "ftd.com",
                "fye.com",
                "gamefly.com",
                "gamestop.com",
                "gap.com",
                "garmin.com",
                "garnethill.com",
                "gillette.com",
                "gilt.com",
                "gnc.com",
                "godiva.com",
                "play.google.com",
                "gopro.com",
                "grainger.com",
                "groupon.com",
                "gymboree.com",
                "hm.com",
                "hhgregg.com",
                "hannaford.com",
                "harley-davidson.com",
                "harristeeter.com",
                "harryanddavid.com",
                "harrys.com",
                "hautelook.com",
                "hearstmagazines.com",
                "heb.com",
                "hellofresh.com",
                "hickoryfarms.com",
                "hokaoneone.com",
                "hollandandbarrett.com",
                "hollisterco.com",
                "hp.com",
                "hsn.com",
                "hy-vee.com",
                "iherb.com",
                "istyles.com",
                "jcpenney.com",
                "jcrew.com",
                "jjill.com",
                "jefferspet.com",
                "jjbuckley.com",
                "joann.com",
                "justfab.com",
                "shopjustice.com",
                "klwines.com",
                "katespade.co.uk",
                "keurig.com",
                "kiehls.com",
                "kingarthurflour.com",
                "kroger.com",
                "llbean.com",
                "ladyfootlocker.com",
                "lancome.com",
                "landsend.com",
                "lanebryant.com",
                "lego.com",
                "lenovo.com",
                "levistrauss.com",
                "lindt-spruengli.com",
                "livenation.com",
                "loft.com",
                "lordandtaylor.com",
                "lowes.com",
                "lowesfoods.com",
                "ltdcommodities.com",
                "shop.lululemon.com",
                "maccosmetics.com",
                "madison-reed.com",
                "marykay.com",
                "meijer.com",
                "meredith.com",
                "michaelkors.com",
                "microsoft.com",
                "modcloth.com",
                "monoprice.com",
                "mrporter.com",
                "munchery.com",
                "myotcstore.com",
                "naturebox.com",
                "nautilus.com",
                "nespresso.com",
                "net-a-porter.com",
                "netgrocer.com",
                "newegg.com",
                "nike.com",
                "nordstrom.com",
                "nordstromrack.com",
                "nutrisystem.com",
                "officedepot.com",
                "oldnavy.com",
                "omahasteaks.com",
                "onekingslane.com",
                "onlineshoes.com",
                "orientaltrading.com",
                "outpost.com",
                "pandora.net",
                "panerabread.com",
                "partycity.com",
                "payless.com",
                "peapod.com",
                "petco.com",
                "petflow.com",
                "petfooddirect.com",
                "petsmart.com",
                "planetfitness.com",
                "polaris.com",
                "poshmark.com",
                "potterybarn.com",
                "potterybarnkids.com",
                "prescriptives.com",
                "pricechopper.com",
                "proflowers.com",
                "proplants.com",
                "pch.com",
                "pureformulas.com",
                "puritan.com",
                "quill.com",
                "qvc.com",
                "radioshack.com",
                "raleys.com",
                "ralphlauren.com",
                "redenvelope.com",
                "rei.com",
                "restorationhardware.com",
                "pcrichard.com",
                "riteaid.com",
                "rockauto.com",
                "rue21.com",
                "ruelala.com",
                "safeway.com",
                "saksfifthavenue.com",
                "saksoff5th.com",
                "sallybeauty.com",
                "sanrio.com",
                "nourish.schnucks.com",
                "schwans.com",
                "searsholdings.com",
                "sephora.com",
                "berries.com",
                "shoebuy.com",
                "shop.com",
                "shopbop.com",
                "shopko.com",
                "shoprite.com",
                "sierratradingpost.com",
                "siriusxm.com",
                "skechers.com",
                "skincarerx.com",
                "skinstore.com",
                "snapfish.com",
                "soap.com",
                "society6.com",
                "soma.com",
                "sony.com",
                "soul-cycle.com",
                "stamps.com",
                "staples.com",
                "stevemadden.com",
                "swansonvitamins.com",
                "talbots.com",
                "target.com",
                "teespring.com",
                "thebodyshop-usa.com",
                "thechildrensplace.com",
                "thecontainerstore.com",
                "thefreshmarket.com",
                "honest.com",
                "thelimited.com",
                "menswearhouse.com",
                "therealreal.com",
                "thevitaminshoppe.com",
                "thinkgeek.com",
                "thrivemarket.com",
                "ticketfly.com",
                "tiffany.com",
                "tigerdirect.com",
                "timberland.com",
                "tinyprints.com",
                "tirerack.com",
                "toms.com",
                "toryburch.com",
                "toshiba.com",
                "toysrus.com",
                "tracfone.com",
                "ugg.com",
                "ulta.com",
                "underarmour.com",
                "urbanoutfitters.com",
                "verabradley.com",
                "victoriassecret.com",
                "vince.com",
                "vitacost.com",
                "vitaminworld.com",
                "wag.com",
                "warbyparker.com",
                "wayfair.com",
                "wegmans.com",
                "weightwatchers.com",
                "westelm.com",
                "whitehouseblackmarket.com",
                "wholefoodsmarket.com",
                "wildtangent.com",
                "williams-sonoma.com",
                "wine.com",
                "wineexpress.com",
                "wish.com",
                "womanwithin.com",
                "woot.com",
                "wwe.com",
                "zappos.com",
                "zulily.com",
                "asda.com",
                "walmart.com.ar",
                "walmart.com.br",
                "walmart.ca",
                "walmartchile.cl",
                "wal-martchina.com",
                "the-seiyu.com",
                "walmart.com.mx",
                "massmart.co.za",
                "barneys.com"
            ]
        });
    
}).call(this, _);
/*******************************************************************************
 *  avast! browsers extensions
 *  (c) 2012-2014 Avast Corp.
 *
 *  Background Browser Specific - AOS specific - module for stadalone execution
 *
 ******************************************************************************/

(function(AvastWRC, chrome, _) {

  var EDITIONS_CONFIG = [
    // AOS
    { extType: AvastWRC.EXT_TYPE_AOS,  callerId: 1026, reqUrlInfoServices: 0xBF, extVer: 15, dataVer: 15 } // AOS (WR, P, B, SC)
  ];

  var _bal = null;

  /**
   * Definiion of supported extensions the AOS connects with .
   * Provide following function:
   *   extMatch - function to match the extension based on extension Info object
   *   msgHandle - function to handle message from the linked extension
   */
  var EXT_EXTENSIONS = [
    { // handle SP ext.
      linked : false,
      id : null,
      extMatch : function (extInfo) {
        return /SafePrice/.test(extInfo.name);
      },
      msgHandle : function (request, sender, sendResponse) {
        if (request.msg === 'event') { // pass sent events to emitter
          AvastWRC.bal.emitEvent(request.event, request);
        }
      }
    }
  ];

  var _activatedExt = {};

  // function initSafePrice

  /**
   * Link matched extension on install or enable.
   */
  function findExtDesc (extInfo) {
    return _.find(EXT_EXTENSIONS, function(extd) {return extd.extMatch(extInfo);});
  }

  /**
   *
   * @param {Object} extDesc - can be either extDesc from EXT_EXTENSIONS or exteInfo from chrome management.
   */
  function initExt (extDesc, extInfo) {
    if (extInfo.id) {
      chrome.runtime.sendMessage(extInfo.id, {msg: 'init', sender_id: chrome.runtime.id },
        function(response) {
          extDesc.id = extInfo.id;
          extDesc.linked = true;
          _activatedExt[extInfo.id] = extDesc;
        }
      );
    }
  }

  function onStarted (extInfo) {
    var extDesc = findExtDesc(extInfo);
    if (extDesc) {
      initExt(extDesc, extInfo);
    }
  }

  function onFinished (extId) {
    var extDesc = _activatedExt[extId];
    if (extDesc) {
      extDesc.linked = false;
      extDesc.id = null;
      delete _activatedExt[extId];
    }
  }

  AvastWRC.bs.aos.sa = AvastWRC.bs.aos.sa || {};
   _.extend(AvastWRC.bs.aos.sa, // Browser specific
    {
      /**
       * Function called on BAL initialization to initialize the module.
       */
      init: function (balInst) {

        _bal = balInst;

        // find extensions to control
        // chrome.management.getAll(function(extInfos) {
        //   _(EXT_EXTENSIONS)
        //     .map(function(extDesc) {
        //       var extInfo = _.find(extInfos, extDesc.extMatch);
        //       return (extInfo && extInfo.enabled) ? [extDesc, extInfo] : null;
        //     })
        //     .compact()
        //     .each(function(d) {
        //       initExt(d[0], d[1]);
        //     });
        // });

        // chrome.management.onInstalled.addListener(onStarted);
        // chrome.management.onEnabled.addListener(onStarted);
        // chrome.management.onUninstalled.addListener(onFinished);
        // chrome.management.onDisabled.addListener(function(extInfo) { onFinished(extInfo.id); });

        // chrome.runtime.onMessageExternal.addListener(
        //   function(request, sender, sendResponse) {
        //     var extDesc = _activatedExt[sender.id];
        //     extDesc.msgHandle(request, sender, sendResponse);
        //   }
        // );

        // chrome.runtime.onSuspend.addListener(function () {
        //   _.forOwn(_activatedExt, function(extDesc, id) {
        //     chrome.runtime.sendMessage(id, {msg: 'close', sender_id: chrome.runtime.id });
        //   });
        // });
    },

  }); // AvastWRC.bs.aos.sa

  AvastWRC.bal.registerModule(AvastWRC.bs.aos.sa);


  AvastWRC.init( EDITIONS_CONFIG[0].callerId ); // initialize the avastwrc modules - default callerId to AOS
  // Start background page initilizing BAL core
  AvastWRC.bal.init('Chrome', AvastWRC.bs, localStorage, EDITIONS_CONFIG);

}).call(this, AvastWRC, chrome, _);

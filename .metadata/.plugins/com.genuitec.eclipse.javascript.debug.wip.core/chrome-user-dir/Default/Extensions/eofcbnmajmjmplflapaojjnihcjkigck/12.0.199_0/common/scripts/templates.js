/*******************************************************************************
 *  avast! Online Security plugin - Mustache.js HTML Templates - cross browser
 *  (c) 2014 Avast Corp.
 ******************************************************************************/

var AvastWRC = AvastWRC || {};


AvastWRC.Templates = {
  /**
   * Process templates declaration and append templates to container
   */
  add: function (declaration) {
    function addPart(acc, part) {
      if (part instanceof Array) {
        for (var i = 0; i < part.length; i++) {
          addPart(acc, part[i]);
        }
      } else if (part instanceof Object) {
        // reference within declaration
        if (part.temp) {
          var temp = declaration[part.temp] || AvastWRC.Templates[part.temp];
          addPart(acc, (part.sect !== undefined) ? temp[part.sect] : temp);
        }
      } else {
        acc.push(part);
      }
    }

    for (var temp in declaration) {
      var parts = [];
      addPart(parts, declaration[temp]);
      this[temp] = parts.join('\n');
    }
  }
};

/*------------------------ SafeShop bar UI templates -------------------------*/
AvastWRC.Templates.add(
{ // --- Templates Declaration
  safeShopBar : [[
    '<div class="avast-extension-safeshop-bar avast-sas {{#coupon}}avast-sas-coupon{{/coupon}} {{#discreet}}avast-sas-discreet{{/discreet}} {{#discreetSlider}}avast-sas-discreet-animated{{/discreetSlider}}">',
      '<div class="avast-sas-the-bar">',
      //<!-- logo -->
      '<h1 class="avast-sas-block avast-sas-logo avast-sas-orange">',
        '<a href= {{#avastBranding}}"http://www.avast.com"{{/avastBranding}}{{^avastBranding}}"http://www.avg.com"{{/avastBranding}} class="avast-sas-icon" target="_blank" style="background-image: url({{images.logo}});">{{strings.sasProductName}}</a>',
      '</h1>',

      '{{#coupon}}',
        '<div class="avast-sas-block avast-sas-rating avast-sas-orange">',
            '{{#coupon.value}}',
              '<div class="avast-sas-rating-button">',
                '<h3>{{coupon.value}}</h3>',
              '</div>',
            '{{/coupon.value}}',
            '{{#coupon.label}}',
              '<h2>{{coupon.label}}</h2>',
            '{{/coupon.label}}',
        '</div>',

        '{{#coupon.code}}',
          '<div class="avast-sas-block avast-sas-code avast-sas-orange">',
			'<h3>{{strings.sasCouponCodeTitle}}</h3>',
			'<div class="avast-sas-code-button"><h3>{{coupon.code}}</h3></div>',
			'<span>{{strings.sasClickToCopy}}</span>',            			
          '</div>',
        '{{/coupon.code}}',

        '{{^coupon.code}}',
          '<div class="avast-sas-block avast-sas-code avast-sas-orange" id="coupon-code">',
            '<h3><strong>{{strings.sasNoCouponCode}}</strong></h3>',
          '</div>',
        '{{/coupon.code}}',

		//'<div class="avast-sas-block avast-sas-instructions">',
          ////'<h2>{{strings.sasCouponInstructionsTitle}}</h2>',
            //'<p>{{coupon.text}}</p>',
        //'</div>',
      '{{/coupon}}',

      //<!-- best product - call2action -->
      '{{#products.length}}',
      '<div class="avast-sas-block avast-sas-orange">',
        '<h2 class="avast-sas-left avast-sas-text">{{strings.safeShopBestTitle}}</h2>',
        '<a class="avast-sas-offer-link" href="{{firstProduct.url}}" id="avast-sas-best-offer-link">',
        '<div class="avast-sas-button">{{strings.safeShopBestButton}}</div>',
        '</a>',
      '</div>',

      //<!-- other products -->
      '<div class="avast-sas-block avast-sas-drop-button" id="avast-sas-offers">',
        '<h3 class="avast-sas-left">{{strings.safeShopOffers}}</h3>',
        '<i class="avast-sas-icon avast-sas-drop-icon" style="background-image: url({{images.drop}});"></i>',
      '</div>',
      '{{/products.length}}',

      '{{#couponsTitle}}',
      '<div class="avast-sas-block avast-sas-orange" id="avast-sas-coupons-title">',
        '<a class="avast-sas-coupon-link" href="{{bestCouponUrl}}" id="avast-sas-best-offer-link">',
        '<div class="avast-sas-button" title="{{strings.safeShopCouponsTitle}} {{strings.safeShopCouponsSaving}}">{{strings.safeShopCouponsTitle}} {{strings.safeShopCouponsSaving}}</div>',
        '</a>',
      '</div>',
      '{{/couponsTitle}}',

      //<!-- coupons -->
      '{{#coupons.length}}',
      '<div class="avast-sas-block avast-sas-drop-button" id="avast-sas-coupons">',
        '<h3 class="avast-sas-left">{{strings.safeShopCoupons}}</h3>',
        '<i class="avast-sas-icon avast-sas-drop-icon" style="background-image: url({{images.drop}});"></i>',
      '</div>',
      '{{/coupons.length}}',

      // <!-- close -->
      '<div class="avast-sas-block avast-sas-close avast-sas-block-right" id="avast-sas-close">',
        '<i class="avast-sas-icon" style="background-image: url({{images.close}});"></i>',
      '</div>',

      // <!-- help -->
      '<div class="avast-sas-block avast-sas-help avast-sas-block-right" id="avast-sas-help">',
        '<i class="avast-sas-icon" style="background-image: url({{images.help}});"></i>',
      '</div>',

      // <!-- settings ??? -->
      '<div class="avast-sas-block avast-sas-settings avast-sas-block-right" id="avast-sas-settings">',
        '<i class="avast-sas-icon" style="background-image: url({{images.conf}});"></i>',
      '</div>',

      // <!-- info -->
      '<div class="avast-sas-block avast-sas-info" id="avast-sas-info">',
        '<h4>{{strings.sasAddOnInfo}}</h4>',
      '</div>',
      '</div>'
      ],
      '<div class="avast-sas-confirm" id="avast-sas-copied-confirm">{{strings.sasCouponCodeCopied}}</div>',
      {temp: 'safeShopOffers'},
      {temp: 'safeShopCoupons'},
      {temp: 'safeShopHelp'},
      {temp: 'safeShopSettings'},
      [
    '</div>'
  ]],
  // SafeShop Products dropdown
  safeShopOffers : [
    //<!-- other products - dropdown -->
    '<div class="avast-sas-drop" id="avast-sas-offers-drop">',

      //<!-- list item -->
      '{{#products}}',
	    '{{#recommended}}',
          '<a href="{{url}}" class="avast-sas-list avast-sas-offer-link-recommended-offer" target="_blank">',
            '<p class="avast-sas-list-badge avast-sas-text">{{saving}}</p>',
            '<p class="avast-sas-list-price avast-sas-text">',
              '<strong title="{{fprice}}">{{fprice}}</strong>',
              '<span title="{{strings.sasShippingLabel}} {{shipping}}">{{strings.sasShippingLabel}} {{shipping}}</span>',
            '</p>',
            '<p class="avast-sas-list-desc avast-sas-text">',
              '<span class="avast-sas-list-description" title="{{label}}">{{label}}</span>',
              '<span class="avast-sas-list-stock avast-sas-availability-{{availability_code}}" title="{{availability}}">{{availability}}</span>',
            '</p>',	
		    '<p class="avast-sas-list-logo-recommended-offer">',
		      '{{#affiliate_image}}',
			    '<img src="{{affiliate_image}}">',
			    '<span title="{{strings.sasRecommendedOfferTitle}}">{{strings.sasRecommendedOfferMessage}}</span>',
		      '{{/affiliate_image}}',
		      '{{^affiliate_image}}',
			    '<span title="{{strings.sasRecommendedOfferTitle}}">{{strings.sasRecommendedOfferMessage}}</span>',
		      '{{/affiliate_image}}',
		     '</p>',
		   '</a>',
		 '{{/recommended}}',
         '{{^recommended}}',
          '<a href="{{url}}" class="avast-sas-list avast-sas-offer-link" target="_blank">',
            '<p class="avast-sas-list-badge avast-sas-text">{{saving}}</p>',
            '<p class="avast-sas-list-price avast-sas-text">',
              '<strong title="{{fprice}}">{{fprice}}</strong>',
              '<span title="{{strings.sasShippingLabel}} {{shipping}}">{{strings.sasShippingLabel}} {{shipping}}</span>',
            '</p>',
            '<p class="avast-sas-list-desc avast-sas-text">',
              '<span class="avast-sas-list-description" title="{{label}}">{{label}}</span>',
              '<span class="avast-sas-list-stock avast-sas-availability-{{availability_code}}" title="{{availability}}">{{availability}}</span>',
            '</p>',	
		    '{{#affiliate_image}}',
			  '<p class="avast-sas-list-logo">',
		        '<img src="{{affiliate_image}}">',
			  '</p>',
			'{{/affiliate_image}}',		     
		   '</a>',
		 '{{/recommended}}', 
      '{{/products}}',

    '</div>'
  ],
  // SafeShop coupons dropdown
  safeShopCoupons : [
    //<!-- coupons - dropdown -->
    '<div class="avast-sas-drop" id="avast-sas-coupons-drop">',
      //<!-- list item -->
      '{{#coupons}}',
      '<a href="{{url}}" class="avast-sas-list avast-sas-coupon-link">',
        '<p class="avast-sas-list-badge">{{value}}</p>',
        '<p class="avast-sas-list-desc avast-sas-text">',
          '<strong title="{{coupon_text}}">{{label}}</strong>',
          //'<span title="{{desc}}">{{desc}}</span>',
        '</p>',
      '</a>',
      '{{/coupons}}',
    '</div>'
  ],
  // SafeShop help overlay
  safeShopHelp : [
    // <!-- help dropdown -->
    // <!-- to show dropdown add class "avast-sas-drop-show" -->
	'<div class="avast-sas-new avast-sas-drop" id="avast-sas-help-drop">',

	  // <!-- hint -->
	  '<div class="avast-sas-hint" id="avast-sas-hint-best-offer">',
		'<img class="avast-sas-hint-arrow" src="{{images.arrow}}"/>',
		'<h3>{{strings.sasHintBestOffer}}</h3>',
		'<p>{{strings.sasHintBestOfferDesc}}</p>',
	  '</div>',
	  // <!-- hint -->
	  '{{#products.length}}',
	  '<div class="avast-sas-hint" id="avast-sas-hint-compare-prices">',
		'<img class="avast-sas-hint-arrow" src="{{images.arrow}}"/>',
		'<h3>{{strings.sasHintOtherOffers}}</h3>',
		'<p>{{strings.sasHintOtherOffersDesc}}</p>',
	  '</div>',
	  '{{/products.length}}',

	  // <!-- hint -->
	  '{{#coupons.length}}',
	  '<div class="avast-sas-hint" id="avast-sas-hint-coupons">',
		'<img class="avast-sas-hint-arrow avast-sas-hint-arrow-left" src="{{images.arrow}}"/>',
		'<h3>{{strings.sasHintCoupons}}</h3>',
		'<p>{{strings.sasHintCouponsDesc}}</p>',
	  '</div>',
	  '{{/coupons.length}}',

	  '<div class="avast-sas-hint-right" id="avast-sas-hint-settings">',
		'<img class="avast-sas-hint-arrow" src="{{images.arrow}}"/>',
		'<h3>{{strings.sasHintSettings}}</h3>',
		'<p>{{strings.sasHintSettingsDesc}}</p>',
	  '</div>',

	  // <!-- promo part -->
	  '<div class="avast-sas-promo">',
		'<h2><span>{{strings.sasPromoNewBadge}}</span>{{strings.sasProductName}}</h2>',
		'<p>{{strings.sasPromoDescription}}</p>',
		'<div class="avast-sas-button avast-sas-promo-button" id="avast-sas-promo-action">{{strings.sasPromoAction}}</div>',
		'{{#showSettings}}<div class="avast-sas-optout-button"><a id="avast-sas-promo-settings">{{strings.sideSettings}}</a></div>{{/showSettings}}',
	  '</div>',
	'</div>'
  ],
  // SafeShop settings drop down
  safeShopSettings : [
    //<!-- settings - dropdown -->
    '<ul class="avast-sas-right-drop" id="avast-sas-settings-drop">',
      //<!-- settings action items -->
      '{{#settings}}',
        '<li class="avast-sas-settings-list avast-sas-text {{#display}}individial-setting-{{display}}{{/display}}" id="{{actionId}}">{{label}}</li>',
      '{{/settings}}',
    '</ul>'
  ],
  // -- SafeShop bar UI template - just bar for IE
  safeShopBarIE : [
    {temp: 'safeShopBar', sect: 0},
    {temp: 'safeShopBar', sect: 5}
  ]
  // -- templates declaration --
});

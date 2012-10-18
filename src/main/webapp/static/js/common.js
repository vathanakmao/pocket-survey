/*
 * Included functions in common.js is general use. 
 */


/**
 * Get access token from html header
 * @returns
 */

function getAccessToken() {
	return $("head").data('access_token');
}

/**
 * Get api url from localStorage object
 * @returns
 */
function getApiUrl(){
	return localStorage.getItem("apiUrl");
}

/**
 * Get Oauth url from localStorage object
 * 
 * @returns string of Oauth url
 */
function getOauthUrl(){
	return localStorage.getItem("oauthUrl");
}

/**
 * Get Signin url from localStorage object
 * @returns
 */
function getSigninUrl(){
	return localStorage.getItem("signinUrl");
}

/**
 * Store access token in header tag
 * @param oauthUrl
 */
function setAccessToken(access_token) {
	$("head").data("access_token",access_token);
}

/**
 * Store api url in localStorage object
 * @param apiUrl
 */
function setApiUrl(apiUrl){
	localStorage.setItem("apiUrl",apiUrl);
}

/**
 * Store Oauth url in localStorage object
 * @param oauthUrl
 */
function setOauthUrl(oauthUrl){
	localStorage.setItem("oauthUrl",oauthUrl);
}

/**
 * Store signin url in localStorage object
 * @param signinUrl
 */
function setSigninUrl(signinUrl){
	localStorage.setItem("signinUrl",signinUrl);
}

/**
 * 
 * @param name
 * @returns {Boolean}
 */
function getFragmentByName(name) {

    var match = RegExp('[&#]' + name + '=([^&]*)')
                    .exec(window.location.hash);

    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}

/**
 * 
 * @param name
 * @returns {Boolean}
 */
function getParameterByName(name) {

    var match = RegExp('[?&]' + name + '=([^&]*)')
                    .exec(window.location.search);

    return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
}
/*************************************************************
**	create base backend api class for next extend
*************************************************************/

function APIRequest() {}

/* PackageBackendAPI class extend BaseBackendAPI class*/
APIRequest.prototype = new BaseJSNetwork();

APIRequest.prototype.baseBackendUrl = getApiUrl();

APIRequest.prototype.oauthUrl = getOauthUrl();
	
APIRequest.prototype.getMe = function(requestData,responseHandler,failureHandler) {
										var requestUrl = this.oauthUrl + "user/me";
										this.getRequest(requestUrl, requestData, responseHandler, failureHandler)
									}

APIRequest.prototype.registerFederated = function(requestData,responseHandler,failureHandler) {
												var requestUrl = this.baseBackendUrl + "federated";
												this.getRequest(requestUrl, requestData, responseHandler, failureHandler);
										}

APIRequest.prototype.getProfilePage = function(requestData,responseHandler,failureHandler){
											var requestUrl = this.baseBackendUrl + "profile/v10";
											this.getRequest(requestUrl, requestData, responseHandler, failureHandler);
										}
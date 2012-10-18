/*************************************************************
**	create base backend api class for next extend
*************************************************************/

function BaseJSNetwork() {}
	
BaseJSNetwork.prototype.getRequest = function(requestUrl,requestData,responseHandler,failureHandler) {
										$.get(requestUrl , requestData, function(response){
											responseHandler(response);												
										},"json")
										.error(function(jqXHR, textStatus, errorThrown){
											failureHandler(jqXHR, textStatus, errorThrown);
										});
									}

BaseJSNetwork.prototype.postRequest = function(requestUrl,requestData,responseHandler,failureHandler) {
											$.post(requestUrl , requestData, function(response){
												responseHandler(response);
											},"json")
											.error(function(jqXHR, textStatus, errorThrown){
												failureHandler(jqXHR, textStatus, errorThrown);
											});
										}
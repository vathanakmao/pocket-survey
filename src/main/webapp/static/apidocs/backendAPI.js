jQuery.ajaxSetup( {
	cache: false,
	data: null
});

function backendAPI() {
	this.backendUrl = "http://pocket-survey.appspot.com/api/apidocs/";

	this.no_more_requests = false;

	this.makeRequest = function(type,url,dataType,data,errMsg) {
		if(!this.no_more_requests){
			var response = null;
			var request = jQuery.ajax({
				async: false,
				type: type,
				url: this.backendUrl + url,
				crossDomain: true,
				accept: "*", 
				data: data,
				dataType: dataType,
				success: function(data, textStatus, jqXHR) {
					response = data;
				},
				error: function(jqXHR, textStatus, errorThrown) {
				},
				complete: function(){
					return this;
				}
			});
			if(request.status != 200){
				return this.handleError(request,errMsg);
			}else{
				return response;
			}

		}
	};
	this.handleError = function(request,errMsg){
		switch(request.status){
			case 401:
				alert('Your current session has expired please log back in.');
				this.no_more_requests = true;
				location.replace('/');
				break;
			default:
				if(typeof(errMsg) != 'undefined'){
					if(typeof(errMsg) == "object"){
						if(typeof(errMsg[request.status]) != 'undefined'){
							alert(errMsg[request.status]);
						}else{
							alert('An error occured, please try again.');
						}
					}else{
						alert(errMsg);
					}
				}else{
					alert('An error occured, please try again.');
				}
		}
		return 'error';
	}
}

    


var projectAPI = new backendAPI();

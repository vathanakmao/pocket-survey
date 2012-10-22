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

    

/*
variables
		"name":"domain"
			"description":""
			"dataType":"String"
			"paramType":"path"
		"name":"surveyId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"responseId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"answers"
			"description":""
			"dataType":"java.lang.String[]"
			"paramType":"query"
count = 4
*/
backendAPI.prototype.create = function(domain,surveyId,responseId,data) {
	var type = "POST";









	var url = "survey/v10/"+surveyId+"/response/v10/"+responseId+"/answer/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"domain"
			"description":"the domain (used for Multi-tenancy)"
			"dataType":"String"
			"paramType":"path"
		"name":"surveyId"
			"description":"the survey's id"
			"dataType":"Long"
			"paramType":"path"
		"name":"responseId"
			"description":"the response's id"
			"dataType":"Long"
			"paramType":"path"
		"name":"id"
			"description":"the id of the entity to retrieve"
			"dataType":"Long"
			"paramType":"path"
count = 4
*/
backendAPI.prototype.get = function(domain,surveyId,responseId,id) {
	var type = "GET";
	var data = {};












	var url = "survey/v10/"+surveyId+"/response/v10/"+responseId+"/answer/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"pageSize"
			"description":"default is 10"
			"dataType":"int"
			"paramType":"query"
		"name":"cursorKey"
			"description":"null to get first page"
			"dataType":"Serializable"
			"paramType":"query"
count = 2
*/
backendAPI.prototype.getPage = function(data) {
	var type = "GET";
	var url = "survey/v10/{surveyId}/response/v10/{responseId}/answer/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"id"
			"description":"the id of the entity to update"
			"dataType":"Long"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.update = function(id) {
	var type = "POST";
	var data = {};



	var url = "survey/v10/{surveyId}/response/v10/{responseId}/answer/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"domain"
			"description":""
			"dataType":"String"
			"paramType":"path"
		"name":"surveyId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
count = 2
*/
backendAPI.prototype.create = function(domain,surveyId) {
	var type = "POST";
	var data = {};






	var url = "survey/v10/"+surveyId+"/question/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"id"
			"description":"the id of the entity to retrieve"
			"dataType":"Long"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.get = function(id) {
	var type = "GET";
	var data = {};



	var url = "survey/v10/{surveyId}/question/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"pageSize"
			"description":"default is 10"
			"dataType":"int"
			"paramType":"query"
		"name":"cursorKey"
			"description":"null to get first page"
			"dataType":"Serializable"
			"paramType":"query"
count = 2
*/
backendAPI.prototype.getPage = function(data) {
	var type = "GET";
	var url = "survey/v10/{surveyId}/question/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"id"
			"description":"the id of the entity to update"
			"dataType":"Long"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.update = function(id) {
	var type = "POST";
	var data = {};



	var url = "survey/v10/{surveyId}/question/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"domain"
			"description":""
			"dataType":"String"
			"paramType":"path"
		"name":"surveyId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"answers"
			"description":""
			"dataType":"java.lang.String[]"
			"paramType":"query"
count = 3
*/
backendAPI.prototype.create = function(domain,surveyId,data) {
	var type = "POST";






	var url = "survey/v10/"+surveyId+"/response/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"id"
			"description":"the id of the entity to retrieve"
			"dataType":"Long"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.get = function(id) {
	var type = "GET";
	var data = {};



	var url = "survey/v10/{surveyId}/response/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"pageSize"
			"description":"default is 10"
			"dataType":"int"
			"paramType":"query"
		"name":"cursorKey"
			"description":"null to get first page"
			"dataType":"Serializable"
			"paramType":"query"
count = 2
*/
backendAPI.prototype.getPage = function(data) {
	var type = "GET";
	var url = "survey/v10/{surveyId}/response/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"id"
			"description":"the id of the entity to update"
			"dataType":"Long"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.update = function(id) {
	var type = "POST";
	var data = {};



	var url = "survey/v10/{surveyId}/response/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"domain"
			"description":""
			"dataType":"String"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.create = function(domain) {
	var type = "POST";
	var data = {};



	var url = "survey/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"id"
			"description":"the id of the entity to retrieve"
			"dataType":"Long"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.get = function(id) {
	var type = "GET";
	var data = {};



	var url = "survey/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"pageSize"
			"description":"default is 10"
			"dataType":"int"
			"paramType":"query"
		"name":"cursorKey"
			"description":"null to get first page"
			"dataType":"Serializable"
			"paramType":"query"
count = 2
*/
backendAPI.prototype.getPage = function(data) {
	var type = "GET";
	var url = "survey/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"id"
			"description":"the id of the entity to update"
			"dataType":"Long"
			"paramType":"path"
count = 1
*/
backendAPI.prototype.update = function(id) {
	var type = "POST";
	var data = {};



	var url = "survey/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};


var projectAPI = new backendAPI();

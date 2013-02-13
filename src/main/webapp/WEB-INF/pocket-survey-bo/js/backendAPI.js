jQuery.ajaxSetup( {
	cache: false,
	data: null
});

function backendAPI() {
	this.backendUrl = "http://pocket-survey.appspot.com/api/leepritchard/";

	this.no_more_requests = false;

	this.makeRequest = function(type,url,dataType,data,errMsg) {

		data._expects=200;
		if(!this.no_more_requests){
			var response = null;
			var request = jQuery.ajax({
				async: false,
				type: type,
				url: this.backendUrl + url,// + "?_expects=200",
				crossDomain: true,
				accept: "*", 
				data: data,
				dataType: dataType,
				success: function(data, textStatus, jqXHR) {
					console.log("success");
					response = data;
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log("error");
				},
				complete: function(jqXHR, textStatus, errorThrown){
					console.log(this.url);
					console.log(jqXHR.getAllResponseHeaders());
					console.log("complete");
					return this;
				}
			});
			console.log(request.status);
			console.log(response);



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
							if(errMsg[request.status] != "noerror")
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
		"name":"versionId"
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
count = 5
*/
backendAPI.prototype.AnswerController_create = function(domain,surveyId,versionId,responseId,data) {
	var type = "POST";

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/response/v10/"+responseId+"/answer/v10";
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
		"name":"versionId"
			"description":""
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
count = 5
*/
backendAPI.prototype.AnswerController_get = function(domain,surveyId,versionId,responseId,id) {
	var type = "GET";
	var data = {};

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/response/v10/"+responseId+"/answer/v10/"+id;
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
backendAPI.prototype.AnswerController_getPage = function(data) {
	var type = "GET";
	var url = "survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer/v10";
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
backendAPI.prototype.AnswerController_update = function(id) {
	var type = "POST";
	var data = {};



	var url = "survey/v10/{surveyId}/version/v10/{versionId}/response/v10/{responseId}/answer/v10/"+id;
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"questionId"
			"description":"the question's id"
			"dataType":"Long"
			"paramType":"path"
count = 4
*/
backendAPI.prototype.OptionController_create = function(surveyId,versionId,questionId,data) {
	var type = "POST";
	//var data = {};


	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10/"+questionId+"/option/v10";
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"questionId"
			"description":"the question's id"
			"dataType":"Long"
			"paramType":"path"
		"name":"id"
			"description":"the id of the entity to retrieve"
			"dataType":"Long"
			"paramType":"path"
count = 5
*/
backendAPI.prototype.OptionController_get = function(domain,surveyId,versionId,questionId,id) {
	var type = "GET";
	var data = {};



	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10/"+questionId+"/option/v10/"+id;
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"questionId"
			"description":"the question's id"
			"dataType":"Long"
			"paramType":"path"
		"name":"pageSize"
			"description":"default is 10"
			"dataType":"int"
			"paramType":"query"
		"name":"cursorKey"
			"description":"null to get first page"
			"dataType":"Serializable"
			"paramType":"query"
count = 6
*/
backendAPI.prototype.OptionController_getPage = function(domain,surveyId,versionId,questionId,data) {
	var type = "GET";


	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10/"+questionId+"/option/v10";
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"questionId"
			"description":"the question's id"
			"dataType":"Long"
			"paramType":"path"
		"name":"id"
			"description":"the id of the entity to update"
			"dataType":"Long"
			"paramType":"path"
count = 5
*/
backendAPI.prototype.OptionController_update = function(domain,surveyId,versionId,questionId,id) {
	var type = "POST";
	var data = {};

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10/"+questionId+"/option/v10/"+id;
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
count = 3
*/
backendAPI.prototype.QuestionController_create = function(surveyId,versionId,question) {
	var type = "POST";
	var data = {
		question:question
	};

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10";
	var dataType = "json";
	var errMsg = [];
	errMsg[0] = "noerror";
	var response = this.makeRequest(type,url,dataType,data,errMsg);
	//var response = this.makeRequest(type,url,dataType,data);
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"id"
			"description":"the id of the entity to retrieve"
			"dataType":"Long"
			"paramType":"path"
count = 4
*/
backendAPI.prototype.QuestionController_get = function(domain,surveyId,versionId,id) {
	var type = "GET";
	var data = {};

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10/"+id;
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"pageSize"
			"description":"default is 10"
			"dataType":"int"
			"paramType":"query"
		"name":"cursorKey"
			"description":"null to get first page"
			"dataType":"Serializable"
			"paramType":"query"
count = 5
*/
backendAPI.prototype.QuestionController_getPage = function(surveyId,versionId,data) {
	var type = "GET";

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};




backendAPI.prototype.QuestionController_delete = function(surveyId,versionId,id) {
	var type = "DELETE";
	var data = {};

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10/"+id;
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"id"
			"description":"the id of the entity to update"
			"dataType":"Long"
			"paramType":"path"
count = 4
*/
backendAPI.prototype.QuestionController_update = function(domain,surveyId,versionId,id) {
	var type = "POST";
	var data = {};

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/question/v10/"+id;
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"formAnswers"
			"description":"if form-encoded, these are the inner answers"
			"dataType":"java.lang.String[]"
			"paramType":"query"
		"name":"questionIds"
			"description":"if form-encoded, these are the inner questionIds to answers"
			"dataType":"java.lang.Long[]"
			"paramType":"query"
count = 5
*/
backendAPI.prototype.ResponseController_createFromForm = function(domain,surveyId,versionId,data) {
	var type = "POST";


	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/response/v10";
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
count = 3
*/
backendAPI.prototype.ResponseController_createFromJSON = function(domain,surveyId,versionId) {
	var type = "POST";
	var data = {};


	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/response/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};


backendAPI.prototype.new_get = function() {
	var type = "GET";
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
backendAPI.prototype.ResponseController_get = function(id) {
	var type = "GET";
	var data = {};

	var url = "survey/v10/{surveyId}/version/v10/{versionId}/response/v10/"+id;
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
backendAPI.prototype.ResponseController_getPage = function(data) {
	var type = "GET";
	var url = "survey/v10/{surveyId}/version/v10/{versionId}/response/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"extMeetingId"
			"description":"the specified meeting's external id"
			"dataType":"String"
			"paramType":"query"
		"name":"answers"
			"description":"set to true to get inner answers"
			"dataType":"boolean"
			"paramType":"query"
		"name":"pageSize"
			"description":"default is 10"
			"dataType":"int"
			"paramType":"query"
		"name":"cursorKey"
			"description":"null to get first page"
			"dataType":"Serializable"
			"paramType":"query"
count = 4
*/
backendAPI.prototype.ResponseController_getPageByExtMeetingId = function(data) {
	var type = "GET";
	var url = "survey/v10/{surveyId}/version/v10/{versionId}/response/v10";
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"surveyId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"id"
			"description":"the id of the entity to updateFromForm"
			"dataType":"Long"
			"paramType":"path"
		"name":"formAnswers"
			"description":"if form-encoded, these are the inner answers"
			"dataType":"java.lang.String[]"
			"paramType":"query"
		"name":"questionIds"
			"description":"if form-encoded, these are the inner questionIds to answers"
			"dataType":"java.lang.Long[]"
			"paramType":"query"
count = 5
*/
backendAPI.prototype.ResponseController_updateFromForm = function(surveyId,versionId,id,data) {
	var type = "POST";

	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/response/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

/*
variables
		"name":"surveyId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"id"
			"description":"the id of the entity to updateFromForm"
			"dataType":"Long"
			"paramType":"path"
count = 3
*/
backendAPI.prototype.ResponseController_updateFromJSON = function(surveyId,versionId,id) {
	var type = "POST";
	var data = {};


	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/response/v10/"+id;
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
backendAPI.prototype.SurveyController_create = function(title) {
	var type = "POST";
	var data = {
		title:title
	};

	//Using other system
	var url = "survey/v10";
//	var url = "crudsurvey/v10";

	var dataType = "json";
	var errMsg = [];
	errMsg[0] = "noerror";
	var response = this.makeRequest(type,url,dataType,data,errMsg);
	//var response = this.makeRequest(type,url,dataType,data);
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
backendAPI.prototype.SurveyController_get = function(id) {
	var type = "GET";
	var data = {};

	var url = "survey/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};

backendAPI.prototype.SurveyController_delete = function(id) {
	var type = "DELETE";
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
backendAPI.prototype.SurveyController_getPage = function(data) {
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
backendAPI.prototype.SurveyController_update = function(id) {
	var type = "POST";
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
		"name":"domain"
			"description":""
			"dataType":"String"
			"paramType":"path"
		"name":"surveyId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
		"name":"fromVersionId"
			"description":""
			"dataType":"Long"
			"paramType":"query"
		"name":"description"
			"description":""
			"dataType":"String"
			"paramType":"query"
count = 4
*/
backendAPI.prototype.VersionController_create = function(domain,surveyId,data) {
	var type = "POST";






	var url = "survey/v10/"+surveyId+"/version/v10";
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
backendAPI.prototype.VersionController_get = function(id) {
	var type = "GET";
	var data = {};



	var url = "survey/v10/{surveyId}/version/v10/"+id;
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
		"name":"versionId"
			"description":""
			"dataType":"Long"
			"paramType":"path"
count = 3
*/
backendAPI.prototype.VersionController_getCsv = function(domain,surveyId,versionId) {
	var type = "GET";
	var data = {};









	var url = "survey/v10/"+surveyId+"/version/v10/"+versionId+"/csv";
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
backendAPI.prototype.VersionController_getPage = function(data) {
	var type = "GET";
	var url = "survey/v10/{surveyId}/version/v10";
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
backendAPI.prototype.VersionController_update = function(id) {
	var type = "POST";
	var data = {};



	var url = "survey/v10/{surveyId}/version/v10/"+id;
	var dataType = "json";
	//var errMsg = [];
	//var response = this.makeRequest(type,url,dataType,data,errMsg);
	var response = this.makeRequest(type,url,dataType,data);
	return response;
};


var projectAPI = new backendAPI();

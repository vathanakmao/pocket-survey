




//Get data
function backendAPI_admin_get(domain,surveyId,versionId,responseId,id){
	//getData
	var data = projectAPI.get(domain,surveyId,versionId,responseId,id);
	//add data to table
	$("#JAnswer").tmpl(data).appendTo("#get-JAnswer-output");
}

//Get data
function backendAPI_admin_getPage(){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data);
	//add data to table
	$("#JAnswer").tmpl(data).appendTo("#getPage-JAnswer-output");
}

//Get data
function backendAPI_admin_get(domain,surveyId,versionId,questionId,id){
	//getData
	var data = projectAPI.get(domain,surveyId,versionId,questionId,id);
	//add data to table
	$("#JOption").tmpl(data).appendTo("#get-JOption-output");
}

//Get data
function backendAPI_admin_getPage(domain,surveyId,versionId,questionId){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data,domain,surveyId,versionId,questionId);
	//add data to table
	$("#JOption").tmpl(data).appendTo("#getPage-JOption-output");
}

//Get data
function backendAPI_admin_get(domain,surveyId,versionId,id){
	//getData
	var data = projectAPI.get(domain,surveyId,versionId,id);
	//add data to table
	$("#JQuestion").tmpl(data).appendTo("#get-JQuestion-output");
}

//Get data
function backendAPI_admin_getPage(domain,surveyId,versionId){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data,domain,surveyId,versionId);
	//add data to table
	$("#JQuestion").tmpl(data).appendTo("#getPage-JQuestion-output");
}

//Get data
function backendAPI_admin_deleteJsonp(id){
	//getData
	var data = projectAPI.deleteJsonp(id);
	//add data to table
	$("#JResponse").tmpl(data).appendTo("#deleteJsonp-JResponse-output");
}

//Get data
function backendAPI_admin_get(id){
	//getData
	var data = projectAPI.get(id);
	//add data to table
	$("#JResponse").tmpl(data).appendTo("#get-JResponse-output");
}

//Get data
function backendAPI_admin_getPage(){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data);
	//add data to table
	$("#JResponse").tmpl(data).appendTo("#getPage-JResponse-output");
}

//Get data
function backendAPI_admin_getPageByExtMeetingId(){
	//getData
	var data = {};
	data.extMeetingId = $("#extMeetingId").val();
	data.answers = $("#answers").val();
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPageByExtMeetingId(data);
	//add data to table
	$("#JResponse").tmpl(data).appendTo("#getPageByExtMeetingId-JResponse-output");
}

//Get data
function backendAPI_admin_deleteJsonp(id){
	//getData
	var data = projectAPI.deleteJsonp(id);
	//add data to table
	$("#JSurvey").tmpl(data).appendTo("#deleteJsonp-JSurvey-output");
}

//Get data
function backendAPI_admin_get(id){
	//getData
	var data = projectAPI.get(id);
	//add data to table
	$("#JSurvey").tmpl(data).appendTo("#get-JSurvey-output");
}

//Get data
function backendAPI_admin_getPage(){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data);
	//add data to table
	$("#JSurvey").tmpl(data).appendTo("#getPage-JSurvey-output");
}

//Get data
function backendAPI_admin_get(id){
	//getData
	var data = projectAPI.get(id);
	//add data to table
	$("#JVersion").tmpl(data).appendTo("#get-JVersion-output");
}

//Get data
function backendAPI_admin_getCsv(domain,surveyId,versionId){
	//getData
	var data = projectAPI.getCsv(domain,surveyId,versionId);
	//add data to table
	$("#JAnswer").tmpl(data).appendTo("#getCsv-JAnswer-output");
}

//Get data
function backendAPI_admin_getPage(){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data);
	//add data to table
	$("#JVersion").tmpl(data).appendTo("#getPage-JVersion-output");
}


//TODO: generate sortable tables for get functions
//TODO: generate css file
//TODO: generate forms for post and put
//TODO: link all sections to menu system





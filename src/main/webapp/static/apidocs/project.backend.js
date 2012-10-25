




//Get data
function backendAPI_admin_get(domain,surveyId,responseId,id){
	//getData
	var data = projectAPI.get(domain,surveyId,responseId,id);
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
function backendAPI_admin_get(domain,surveyId,questionId,id){
	//getData
	var data = projectAPI.get(domain,surveyId,questionId,id);
	//add data to table
	$("#JOption").tmpl(data).appendTo("#get-JOption-output");
}

//Get data
function backendAPI_admin_getPage(domain,surveyId,questionId){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data,domain,surveyId,questionId);
	//add data to table
	$("#JOption").tmpl(data).appendTo("#getPage-JOption-output");
}

//Get data
function backendAPI_admin_get(domain,surveyId,id){
	//getData
	var data = projectAPI.get(domain,surveyId,id);
	//add data to table
	$("#JQuestion").tmpl(data).appendTo("#get-JQuestion-output");
}

//Get data
function backendAPI_admin_getPage(domain,surveyId){
	//getData
	var data = {};
	data.pageSize = $("#pageSize").val();
	data.cursorKey = $("#cursorKey").val();
	data = projectAPI.getPage(data,domain,surveyId);
	//add data to table
	$("#JQuestion").tmpl(data).appendTo("#getPage-JQuestion-output");
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


//TODO: generate sortable tables for get functions
//TODO: generate css file
//TODO: generate forms for post and put
//TODO: link all sections to menu system





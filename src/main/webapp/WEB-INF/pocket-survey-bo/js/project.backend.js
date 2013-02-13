window.version = 1;


function local_storage() {
  try {
    return 'localStorage' in window && window['localStorage'] !== null;
  } catch (e) {
    return false;
  }
}

function getUrlVars() {
	 var vars = {};
	 var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
		  vars[key] = value;
	 });
	 return vars;
}

function get_mysurveys(fromStorage){
	if(typeof(fromStorage) == "undefined"){
		fromStorage = false;
	}
	var data = {
		pageSize:100
	}

	if(local_storage()){
		if(typeof(localStorage.mysurveys) != "undefined" && fromStorage == true){
			var surveys = JSON.parse(localStorage.mysurveys);
		}else{
			var surveys = projectAPI.SurveyController_getPage(data);
			localStorage.mysurveys = JSON.stringify(surveys);
		}
	}else{
		var surveys = projectAPI.SurveyController_getPage(data);
	}
//	window.sorted_surveys = Array();
//	for(survey in surveys.items){
//		window.sorted_surveys[surveys.items[survey].id] = surveys.items[survey];
//	}

	return surveys;
}

 
function populate_mysurveys(fromStorage,editing){
	var has_id = false;
	var id = getUrlVars()['id'];

	if(typeof(id) != "undefined"){
		has_id = true;
	}
	if(typeof(editing) == "undefined"){
		editing = false;
	}


	surveys = get_mysurveys(fromStorage);
	var no_active_survey = true;
	for(survey in surveys.items){
		if(typeof(surveys.items[survey].title) != "undefined"){
			active = "";
			if(has_id){
			//	alert(id+" == "+surveys.items[survey].id);
				if(id == surveys.items[survey].id){
					no_active_survey = false;
					active = "class='active' ";
					current = surveys.items[survey];
					if(editing){

						populate_editor(current);

			

					}
				}
			}

			$('#my_surveys').append('<li '+active+'><a href="survey.html?id='+surveys.items[survey].id+'">'+surveys.items[survey].title+'<span class="delete" rel="'+surveys.items[survey].id+'">x</span></a></li>');
		}else{
			active = "";
			if(has_id){
			//	alert(id+" == "+surveys.items[survey].id);
				if(id == surveys.items[survey].id){
					active = "class='active' ";
				}
			}

			$('#my_surveys').append('<li '+active+'><a href="survey.html?id='+surveys.items[survey].id+'"> -- <span class="delete" rel="'+surveys.items[survey].id+'">x</span></a></li>');

		}
	}
	if(no_active_survey){
		if(typeof(getUrlVars()['id']) != "undefined"){
			alert('the surevey your looking for doesn\'t exsist please try again.');
			window.location = "index.html";
		}
	}

	$(".delete").live('click',function(event){
		event.preventDefault();
		if(confirm("Are you sure you want to delete this survey?")){
			var del = projectAPI.SurveyController_delete($(this).attr('rel'));
			//console.log(del);
			if(del != 'error'){
				$(this).parent().remove();
				get_mysurveys();
			}	
		}
	});

	console.log(surveys);
}

function populate_editor(survey){
	setTimeout(function(){

		var question_content = "<h1>"+current.title+"</h1>";
		question_content += "<h2>Questions<span class='question_new'>Add New Question</span></h2>";


		var data = {
			pageSize:100
		}
var survey = projectAPI.SurveyController_get(current.id);

console.log("current:");
console.log(survey);

var version = "null";
if(typeof(survey.versions) != "undefined"){
	window.version = survey.versions.pop().id;
}
console.log(version);
console.log("end of current");



		var questions = projectAPI.QuestionController_getPage(current.id,window.version,data);
		for(question in questions.items){
			if(questions.items[question].surveyId == survey.id)
question_content += "<span class='question'>"+questions.items[question].question+"<span class='question_edit' rel='"+questions.items[question].id+"'>Edit</span><span class='question_del' rel='"+questions.items[question].id+"'>Delete</span></span>";
		}
/*
		question_content += "<span class='question'>What is your name?<span class='question_edit' rel='"+current.id+"'>Edit</span><span class='question_del' rel='"+current.id+"'>Delete</span></span>";

		question_content += "<span class='question'>What is your age?<span class='question_edit' rel='"+current.id+"'>Edit</span><span class='question_del' rel='"+current.id+"'>Delete</span></span>";

*/
		$('#question_list').append("<div id='question_content'></div>");
		//$('#question_content').html(question_content);

		

		var $mci = $('#question_content');
		$mci.html(question_content);
		$mci.css({'width':'auto','height':'auto', 'padding':'15px 25px'});
		var contentHeight = $mci.height();
		$mci.css({'height':'0','padding':'0'});
		$mci.animate({'opacity':1,'height':contentHeight+'px'}, 500);
		$("#spinner").animate({'opacity':0}, 500);

		$(".question_edit").live('click',function(){
			var question_id = $(this).attr('rel');
			$("#save_question").attr('rel',question_id);
			

	
			$("#editMyQuestion").modal('show');
		});

		$(".question_del").live('click',function(){


	projectAPI.QuestionController_delete(survey.id,window.version,$(this).attr('rel'));



		});




















	},50);

	$(".question_new").live('click',function(){
	$("#save_question").removeAttr('rel');
		$('#editMyQuestion .modal-header h3').html('Create New Question');
		var question_form = "";

		question_form += '<label for="question_text">Enter question:</label><input type="text" name="question_text" value="" id="question_text" />';

		question_form += '<ul class="nav nav-pills" id="question_response"><li class="dropdown">  <a class="dropdown-toggle" id="drop4" role="button" data-toggle="dropdown" href="#">Select Response Type <b class="caret"></b></a><ul id="menu1" class="dropdown-menu" role="menu" aria-labelledby="drop4">';
		question_form += '<li><a tabindex="-1" href="#plain_text">Plain Text</a></li>';
		question_form += '<li><a tabindex="-1" href="#dropdown">Dropdown</a></li>';
		question_form += '<li><a tabindex="-1" href="#checkboxes">Checkboxes</a></li>';
		question_form += '<li><a tabindex="-1" href="#radio_buttons">Radio Buttons</a></li>';
//		question_form += '<li class="divider"></li>';
//		question_form += '<li><a tabindex="-1" href="#">Separated link</a></li>';
		question_form += '</ul></li></ul>';


question_form += '<div id="response_type_container"><div id="response_type_content">';


question_form += '<div id="question_responseContent" class="tab-content">';

question_form += '<div class="tab-pane fade" id="plain_text"><p></p></div>';

question_form += '<div class="tab-pane fade" id="dropdown"><p><h4>Options<span class="add_new_option" rel="dropdown">Add new option</span></h4></p></div>';

question_form += '<div class="tab-pane fade" id="checkboxes"><p>Add options:</p></div>';

question_form += '<div class="tab-pane fade" id="radio_buttons"><p>Add options:</p></div>';

question_form += '<div class="tab-pane fade active in" id="dropdown2"></div>';

question_form += '</div>';

question_form += '</div></div>';


		
		$('#editMyQuestion .modal-body').html(question_form);
	


		$('#question_response a').click(function (e) {
			e.preventDefault();
			$('#question_response #drop4').html(this.innerText);
			$(this).tab('show');
		})

		$('.add_new_option').click(function (e) {
			e.preventDefault();
			var input_number = $("#"+$(this).attr('rel')+" input").length/2;


			var new_option = '<tr><td><input id="'+$(this).attr('rel')+'_ans_'+input_number+'" type="text" /></td><td><input id="'+$(this).attr('rel')+'_val_'+input_number+'" type="text" /></td><td class="remove">x</td></tr>';


			if(input_number == 0){
$("#"+$(this).attr('rel')).append('<table  id="dropdown_responses" border="0" cellspacing="0" cellpadding="0"><thead><tr><th>Response Text</th><th>value</th><th></th></tr><thead><tbody>'+new_option+'</tbody></table>');

			}else{
$("#dropdown_responses").append(new_option)
			}

		});
	$('.remove').live('click',function (e) {
		console.log('Remove clicked');
		$(this).parent().css('display','none');
		$(this).parent().find('input').attr('rel','removed');
	});
		


		$("#editMyQuestion").modal('show');
	});

	$("#save_question").live('click',function(){
		console.log("clicked to save question on survey:"+survey.id);
		var active_type = $("#menu1 .active a");
		if(typeof($(this).attr('rel')) != 'undefined'){

console.log("save updated ("+$(this).attr('rel')+")");

var questionId = $(this).attr('rel');
		}else{



		console.log("html = "+active_type.html());
		console.log("href = "+active_type.attr('href'));

var questionId = $(this).attr('rel');

		console.log("save new ("+$(this).attr('rel')+")");


		var question = projectAPI.QuestionController_create(survey.id,window.version,$('#question_text').val());
console.log("question: "+question);
		}


$(active_type.attr('href')+" input").each(function(){
	if($(this).attr('rel') != 'removed'){

		var data = {
			label:this.value
		}


//TODO create response types for the multi options responses.lu
		projectAPI.OptionController_create(survey.id,window.version,questionId,data);
console.log(question);






		if(this.id.indexOf('val')>0){
			console.log("val = "+this.value);
		}else{
			console.log("Create response type:");
			console.log("ans = "+this.value);
		}


	}
});




	});
}


function valid_survey_name(name){
	surveys = get_mysurveys(true);

	for(survey in surveys.items){
		if(typeof(surveys.items[survey].title) != "undefined"){
			if(name == surveys.items[survey].title){
				return false;
			}
		}
	}
	return true;
}

function create_new_survey(name){
	var new_survey = projectAPI.SurveyController_create(name);


	var surveys = get_mysurveys(true);
	surveys.items.push(new_survey);
	if(local_storage()){
		localStorage.mysurveys = JSON.stringify(surveys);
	}

	
	return new_survey;
}




/*
	incorrect auto generated functions
*/

/*
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

*/



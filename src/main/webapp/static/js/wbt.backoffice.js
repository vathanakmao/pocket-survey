/***********************************************************

Javascript Controller for handling event from view and
also generate dynamic data which got from model as well

************************************************************/

var apiRequester = new APIRequest();


/************************************
 * 			General Modules  		* 
 ************************************/

/**
 * Set listener event to specific html list
 * 
 * @param button
 * @param handler
 */
function setOnClickListener(button,handler){
	button.click(function(){
		handler(button);
	})
}

/**
 * Set listener event to specific html list
 * 
 * @param listId
 * @param eventHandler
 */
function setListItemListener(listId,eventHandler){
	$("#" + listId + " li:not(:first)").click(function(){
		$("#" + listId + " li").removeClass("active");
		$(this).addClass("active");
		eventHandler($(this),listId);
	});
}

/************************************
 * 			Signin Modules  		* 
 ************************************/
function registerFederated(accessToken,providerId){
	var registeredToken = {access_token : accessToken}
	apiRequester.getMe(registeredToken, function(user){
		var request = {
						access_token : accessToken,
						providerId: providerId,
						providerUserId: user.id
					   }

		apiRequester.registerFederated(request, function(){
			console.log("completly federated");
		}, failureHandler);
		
	}, failureHandler);
}

/************************************
 * 			User Modules  			* 
 ************************************/

/**
 * Get profiles from backend in first time
 */
function getProfilePage(){
	var requestData = {};
	apiRequester.getProfilePage(requestData, function(profiles){
		manageLocalProfileData(profiles);
		populateProfiles(profiles.items);		
	}, failureHandler);
	
}

/**
 * Manage profile data for local use
 * 
 * @param profiles
 */
function manageLocalProfileData(profiles){
	$("#userMoveNext").data("cursorKey",profiles.cursorKey);
	if(profiles.items.length > 0){
		profiles.items.sort(profileComparableByNameAsc);
		$("#userSearchResult").data("sortedProfiles",profiles.items);
	}
}

/**
 * populate user profile list
 * @param profiles
 */
function populateProfiles(profileItems){
	// clear old data
	$('#userSearchResult li:not(:first)').remove();
	$.map(profileItems,function(profile,index){
		$("#userSearchResult").append($("<li></li>").text(profile.name).data("profile",profile));
	});
	setListItemListener("userSearchResult",onClickListItemListener);
}

/**
 * Automatically bind profile property to input field of user page
 * 
 * @param profile
 */
function populateUserDetails(profile){
	$("#userPanelCenter input").each(function(){
		$(this).val(profile[$(this).attr("id").substring("user_".length)]);
		console.log("name :" + profile[$(this).attr("id").substring("user_".length)]);
	});
}

/* Call back method */
/**
 * Get next profiles
 * 
 * @param button
 */
function moveNext(button){
	var requestData = {pageSize: 10,cursorKey: button.data("cursorKey")};
	apiRequester.getProfilePage(requestData, function(profiles){
		populateProfiles(profiles.items);
		manageLocalProfileData(profiles);
	},failureHandler);
}

/**
 * onClick item of list handler method	 
 * 
 * @param item
 * @param parentId
 */
function onClickListItemListener(item,parentId){
	var profile = item.data("profile");
	populateUserDetails(profile)
	console.log("parent id : " + parentId);
}

/**
 * Sort profiles as Ascending
 * 
 * @param element
 * @returns {Boolean}
 */
function sortAscending(element){
	if(element.attr("class").search("active-ascending") > -1){
		return false;
	}
	var profiles = $("#userSearchResult").data("sortedProfiles").reverse();
	populateProfiles(profiles);
	// upload profiles to list storage
	$("#userSearchResult").data("sortedProfiles",profiles);
	//remove active class from descending sort
	$("#userSearchResult span").removeClass("active-decending");
	element.addClass("active-ascending");
}

/**
 * Sort profiles as Descending
 * 
 * @param element
 * @returns {Boolean}
 */
function sortDescending(element){
	if(element.attr("class").search("active-decending") > -1){
		return false;
	}
	var profiles = $("#userSearchResult").data("sortedProfiles").reverse();
	populateProfiles(profiles);
	// upload profiles to list storage
	$("#userSearchResult").data("sortedProfiles",profiles);
	// remove active class from ascending sort
	$("#userSearchResult span").removeClass("active-ascending");
	element.addClass("active-decending");
}

/**
 * Comparable function from profile
 * 
 * @param profile1
 * @param profile2
 * @returns {Number}
 */
function profileComparableByNameAsc(profile1,profile2){
	  if (profile1.name.toLowerCase() < profile2.name.toLowerCase())
		     return -1;
		  if (profile1.name.toLowerCase() > profile2.name.toLowerCase())
		    return 1;
		  return 0;
}

/**
 * 
 */
function failureHandler(){
	
}
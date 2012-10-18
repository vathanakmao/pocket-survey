
function getLocation(divId, locationIdID) {
    var id = $(locationIdID).val();
    var body = new Object();
    body.access_token = getAccessToken();
    $(divId).empty();
    
    $.getJSON(getApiUrl() + "location/v10/" + id, body)
    .fail(function(jqXHR, textStatus){
        $(divId).html(jqXHR.status);
    })
    .done(function(loc) {
        $(divId).html($.toJSON( loc ));
    });
}

function getLocationPage(tableId, cursorKeyId) {
    var cursorKey = $(cursorKeyId).val();
    var body = new Object();
    body.access_token = getAccessToken();
    if (cursorKey) {
        body.cursorKey = cursorKey;
    }
    else {
        $(tableId).empty();
    }
    
    $.getJSON(getApiUrl() + "location/v10", body)
    .done(function(page) {
        $(cursorKeyId).val(page.cursorKey);
        $.map(page.items, function(loc, index) {
            $(tableId).append('<tr id="i_' + loc.id + '" >' +
                '<td>' + loc.id + '</td>' +
                '<td>' + loc.description + '</td>' +
                '<td>' + loc.extID + '</td>' +
                '<td>' + loc.name + '</td>' +
                '</tr>');
        })
    });
}

function loadLocation(id) {
    var body = new Object();
    body.access_token = getAccessToken();
    
    $.getJSON(getApiUrl() + "location/v10/" + id, body)
    .fail(function(jqXHR, textStatus){
        $("#updateLocationBody").data("location", null);
    })
    .done(function(loc) {
        $("#updateLocationBody").data("location", loc);
        $("#updateLocationId").val(loc.id);
        $("#updateLocationDescription").val(loc.description);
        if (loc.latLong) {
            $("#updateLocationLatitude").val(loc.latLong.latitude);
            $("#updateLocationLongitude").val(loc.latLong.longitude);
        }
        else {
            $("#updateLocationLatitude").val("");
            $("#updateLocationLongitude").val("");
        }
        // make id read-only
        $("#updateLocationId").attr("readonly", "readonly");
    });
}

function updateLocation(id) {
    
    var j = $("#updateLocationBody").data("location");
    if (j && j.id == id) {
        // update JSON object with form details
        j.description = $("#updateLocationDescription").val();
        var latitude = $("#updateLocationLatitude").val();
        var longitude = $("#updateLocationLongitude").val();
        if (0 < latitude.length && 0 < longitude.length) {
            j.latitude = parseFloat(latitude);
            j.longitude = parseFloat(longitude);
        }
        else {
            j.latLong = null;
        }
        
        // populate request body
        j.access_token = getAccessToken();
        j.id = id;
        
        $.post(getApiUrl() + "location/v10/" + id, j)
        .fail(function(jqXHR, textStatus) {
            $("#updateLocationResponse").html(jqXHR.status);
        })
        .done(function(data) {
            $("#updateLocationResponse").html($.toJSON( data ));
            // make id read-write
            $("#updateLocationId").removeAttr("readonly");
        });
    }
    else {
        alert('You must enter a valid location id');
    }
}

function createLocation() {
    
    var j = new Object();

    // update JSON object with form details
    j.description = $("#createLocationDescription").val();
    var latitude = $("#createLocationLatitude").val();
    var longitude = $("#createLocationLongitude").val();
    if (0 < latitude.length && 0 < longitude.length) {
        j.latitude = parseFloat(latitude);
        j.longitude = parseFloat(longitude);
    }
    else {
        j.latLong = null;
    }

    // populate request body
    j.access_token = getAccessToken();

    $.post(getApiUrl() + "location/v10", j)
    .fail(function(jqXHR, textStatus) {
        $("#createLocationResponse").html(jqXHR.status);
    })
    .done(function(data, textStatus) {
        $("#createLocationResponse").html(textStatus);
    });
}


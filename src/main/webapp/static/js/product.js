
function getProduct(divId, productIdID) {
    var id = $(productIdID).val();
    var body = new Object();
    body.access_token = getAccessToken();
    $(divId).empty();
    
    $.getJSON(getApiUrl() + "product/v10/" + id, body)
    .fail(function(jqXHR, textStatus){
        $(divId).html(jqXHR.status);
    })
    .done(function(product) {
        $(divId).html($.toJSON( product ));
    });
}

function getProductPage(tableId, cursorKeyId) {
    var cursorKey = $(cursorKeyId).val();
    var body = new Object();
    body.access_token = getAccessToken();
    if (cursorKey) {
        body.cursorKey = cursorKey;
    }
    else {
        $(tableId).empty();
    }
    
    $.getJSON(getApiUrl() + "product/v10", body)
    .done(function(page) {
        $(cursorKeyId).val(page.cursorKey);
        $.map(page.items, function(product, index) {
            $(tableId).append('<tr id="i_' + product.id + '" >' +
                '<td>' + product.id + '</td>' +
                '<td>' + product.extID + '</td>' +
                '<td>' + product.name + '</td>' +
                '<td>' + product.categoryName + '</td>' +
                '<td>' + product.description + '</td>' +
                '<td>' + product.imageUrl + '</td>' +
                '</tr>');
        })
    });
}

function autoSuggestProducts(tableId, cursorKeyId, prefix) {
    var cursorKey = $(cursorKeyId).val();
    var body = new Object();
    body.access_token = getAccessToken();
    body.prefix = prefix;
    if (cursorKey) {
        body.cursorKey = cursorKey;
    }
    else {
        $(tableId).empty();
    }
    
    $.getJSON(getApiUrl() + "product/v10", body)
    .done(function(page) {
        $(cursorKeyId).val(page.cursorKey);
        $.map(page.items, function(name, index) {
            $(tableId).append('<tr>' +
                '<td>' + name + '</td>' +
                '</tr>');
        })
    });
}


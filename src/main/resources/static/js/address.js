function sendAjaxRequest() {
    var country = $("#country").val();
    $.get( "/regions?country=" + country, function( data ) {
        $("#region").empty();
        data.forEach(function(item, i) {
            var option = "<option value = " + item.getId() + ">" + item.getName() +  "</option>";
            $("#region").append(option);
        });
    });
};
$(document).ready(function() {
    $("#country").change(function() {
        sendAjaxRequest();
    });
});
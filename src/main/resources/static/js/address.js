function sendAjaxRequest() {
    var countryId = $("#country").val();
    $.get( "/regions", { countryId: countryId}, function( cities ) {
        $("#region").empty();
        console.log(cities);
        cities.forEach(function(item) {
            var option =
                "<option value = " + item.id + ">"
                + item.name +  "</option>";
            $("#region").append(option);
        });
    });
};
$(document).ready(function() {
    $("#country").change(function() {
        sendAjaxRequest();
    });
});
function getCitiesRequst() {
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
}
var masks = [];
var phoneMask = '';
function getPrefixRequst() {
    var countryId = $("#country").val();
    $.get( "/prefix", { countryId: countryId}, function( prefix ) {
        console.log(masks);
        var operatorCode = prefix.length > 1 ? '00' : '000';
        phoneMask = '+{' + prefix + '}(' + operatorCode + ')000-00-00'
        masks.forEach(function (value) {
            value.updateOptions({
                mask: phoneMask
            });
        });
    });
}
$(document).ready(function() {
    document.querySelectorAll('.phone').forEach(function (value) {
        //value.removeEventListener('change');
        var newMask = IMask( value, {
            mask: ''
        });
        masks.push(newMask)
    });
    getCitiesRequst();
    getPrefixRequst();
    document.getElementById('country')
        .addEventListener('change',
            function (ev) {
                    getCitiesRequst();
                    getPrefixRequst();
        });
    var phoneNumbersContainer = document.getElementById("numbers-container");
    document.getElementById("add-phone").addEventListener("click", function (ev) {
        var inputContainer = document.createElement('div');
        inputContainer.classList.add('input-container');
        inputContainer.innerHTML="<input required class=\"phone\"\n" +
            "                   th:name=\"phonenumber\"\n" +
            "                   type=\"tel\" name=\"phone\">\n" +
            "                <div class=\"i-container\"> <i class=\"material-icons remove\">remove_circle_outline</i></div>";
        phoneNumbersContainer.appendChild(inputContainer);
        var newMask = IMask( inputContainer.getElementsByClassName('phone')[0], {
            mask: phoneMask
        });
        masks.push(newMask)
        inputContainer.getElementsByClassName("remove")[0].addEventListener('click',function (ev) {
            phoneNumbersContainer.removeChild(inputContainer);
        });
    });
    var logo = document.getElementById('logo');
    document.getElementById('logo-input').addEventListener('change', function (ev) {
        logo.src = ev.target.value;
    });
});
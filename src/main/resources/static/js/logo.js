$(document).ready(function() {
    var logo = document.getElementById('logo');
    document.getElementById('logo-input').addEventListener('change', function (ev) {
        logo.src = ev.target.value;
    });
});
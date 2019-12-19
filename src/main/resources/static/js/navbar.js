var logInHtml = '<button data-toggle="modal" data-target="#singInModal" type="button" class="btn navbar-btn navbar-btn-dark" id="sing-in-btn">\n' +
    '                <div class="i-container"><i class="material-icons">face</i></div>\n' +
    '                Войти\n' +
    '            </button>';
var officeHtml = '<form action="/private-office/cnetwork" method="get" class="form-inline">' +
    '<button type="submit" class="btn navbar-btn navbar-btn-dark" id="sing-in-btn">\n' +
    '                <div class="i-container"><i class="material-icons">home</i></div>\n' +
    '                Кабинет\n' +
    '            </button>' +
    '</form>';
$(document).ready(function() {
    $.get("/username")
        .always(function (res) {
            console.log(res);
            document.getElementById('sing-in-btn-container').innerHTML =
                res === '' ? logInHtml : officeHtml;
        });
});
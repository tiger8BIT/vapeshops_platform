$(document).ready(function() {
    $.get("/username")
        .always(function (res) {
            console.log(res);
            document.getElementById('sing-in-btn').innerText = res == null ? Войти : res;
        });
});
function createBrandRequest() {
    var name = $("#brand-name").val();
    var info = $("#brand-info").val();
    var logo = $("#logo-input").val();
    $.post("/add/brand/get", {name: name, info: info, logo: logo})
        .done(function (brand) {
            var option =
                "<option selected='true' value = " + brand.id + ">"
                + brand.name + "</option>";
            $("#brands").append(option);
            $("#brand-name").val('');
            $("#brand-info").val('');
            $("#logo-input").val('');
            $("#brand-result > p").replaceWith('<p>Брэнд успешно добавлен</p>');
            $("#brand-result").css("background-color", "lightgreen");
        })
        .fail(function (error) {
            console.log(error.responseText);
            $("#brand-result > p").replaceWith('<p>' + error.responseText + '</p>');
            $("#brand-result").css("background-color", "coral");
        })
        .always(function () {
            document.getElementById('brand-result').scrollIntoView(true);
        });
}
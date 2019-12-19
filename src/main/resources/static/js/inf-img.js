var index = -1;
function getCarouselIndicatorsInnerHtml(index){
    var el = document.createElement('li');
    el.setAttribute('data-target', '#carouselExampleIndicators');
    el.setAttribute('data-slide-to', index);
    return el;
}
function getCarouselInnerHtml() {
    var el = document.createElement('div');
    el.classList.add('carousel-item');
    el.classList.add('active');
    el.innerHTML = '<img class="d-block w-100">';
    return el;
}
var inputContainerInnerHtml = '<input required class="image"\n' +
    '                   th:name="images"\n' +
    '                   type=\"url\" name="images">\n' +
    '                <div class="i-container"> <i class="material-icons remove">remove_circle_outline</i></div>';
$(document).ready(function() {
    var firstImageDiv =  document.getElementById('first-image-div');
    var firstImageInput = document.getElementById('first-image-input');
    var firstImage = document.getElementById('first-image');
    var carouselExampleIndicators = document.getElementById('carouselExampleIndicators');
    var carouselIndicators = document.getElementsByClassName("carousel-indicators")[0];
    var carouselInner = document.getElementsByClassName("carousel-inner")[0];
    var imagesContainer = document.getElementById("images-container");
    var id = document.getElementById('img-id').value;
    console.log(id);
    $.get("/product/images", {id : id}, function( images ) {
        console.log(images);
        images.forEach(function(item) {
            index++;
            var carouselIndicatorsInnerHtml = getCarouselIndicatorsInnerHtml(index);
            var carouselInnerHtml = getCarouselInnerHtml();
            var image = carouselInnerHtml.getElementsByTagName('img')[0];
            carouselIndicators.appendChild(carouselIndicatorsInnerHtml);
            carouselInner.appendChild(carouselInnerHtml);
            image.src = item;
        });
    });
});
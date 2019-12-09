var index = 0;
function getCarouselIndicatorsInnerHtml(index){
    var el = document.createElement('li');
    el.setAttribute('data-target', '#carouselExampleIndicators');
    el.setAttribute('data-slide-to', index);
    return el;
}
function getCarouselInnerHtml() {
    var el = document.createElement('div');
    el.classList.add('carousel-item');
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
    firstImageInput.addEventListener('change', function (ev) {
        firstImage.src = ev.target.value;
    });
    var carouselExampleIndicators = document.getElementById('carouselExampleIndicators');
    var carouselIndicators = document.getElementsByClassName("carousel-indicators")[0];
    var carouselInner = document.getElementsByClassName("carousel-inner")[0];
    var imagesContainer = document.getElementById("images-container");
    document.getElementById("add-image").addEventListener("click", function (ev) {
        var inputContainer = document.createElement('div');
        inputContainer.classList.add('input-container');
        inputContainer.innerHTML=inputContainerInnerHtml;
        imagesContainer.appendChild(inputContainer);
        index++;
        var carouselIndicatorsInnerHtml = getCarouselIndicatorsInnerHtml(index);
        var carouselInnerHtml = getCarouselInnerHtml();
        var image = carouselInnerHtml.getElementsByTagName('img')[0];
        carouselIndicators.appendChild(carouselIndicatorsInnerHtml);
        carouselInner.appendChild(carouselInnerHtml);
        inputContainer.getElementsByClassName("remove")[0].addEventListener('click',function (ev) {
            if(!firstImageDiv.classList.contains('active')){
                firstImageDiv.classList.add('active');
            }
            imagesContainer.removeChild(inputContainer);
            carouselIndicatorsInnerHtml.remove();
            carouselInnerHtml.remove();
            index--;
        });
        inputContainer.getElementsByTagName("input")[0].addEventListener('change', function (ev) {
            image.src = ev.target.value;
        });
    });
});
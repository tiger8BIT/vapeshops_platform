$(document).ready(function() {
    var cards = document.getElementsByClassName('card');

    for (let item of cards) {
        item.onclick = function(e){
            var id = item.getElementsByClassName('e-id')[0].value;
            window.open('/info/eliquid?id=' + id);
        }
    }
});
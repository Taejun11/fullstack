const list = document.getElementById('banner');
const listLi = document.querySelectorAll('#banner li');
var total = listLi.length;
var li_width = 640;
var num = 0;


list.append(listLi[0].cloneNode(true));
document.querySelector('#next').addEventListener('click', function(){
    if (num == 3) {
        num = 0;
        list.style.transition = 'none';
        list.style.marginLeft = 0;
    }
    setTimeout(function(){
        num++;
        list.style.transition = 'margin-left 0.5s';
        list.style.marginLeft = -li_width * num + 'px';
    }, 50);

});


document.querySelector('#prev').addEventListener('click', function(){
    if (num == 0) {
        num = 3;
        list.style.transition = 'none';
        list.style.marginLeft = 0;
    }
    setTimeout(function(){
        num--;
        list.style.transition = 'margin-left 0.5s';
        list.style.marginLeft = -li_width * num + 'px';
    }, 50);
});
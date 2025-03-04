const tabs = document.querySelectorAll('.tab_menu li'); //탭 버튼
const tabList = document.querySelectorAll('#tabContent > div'); //탭 내용

tabs.forEach(function(tab, i){
    tab.addEventListener('click', function(e){
        e.preventDefault(); //링크금지, a 태그와 연관되면 꼭 써야 함
        tabs.forEach(function(item){
            item.classList.remove('active');
        });
        tabs[i].classList.add('active');
    });

    tab.addEventListener('click', function(e){
        e.preventDefault(); //링크금지, a 태그와 연관되면 꼭 써야 함
        tabList.forEach(function(item){
            item.classList.remove('on');
        });
        tabList[i].classList.add('on');
    });
});
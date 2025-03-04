const targetLink = document.querySelectorAll('.tab_menu li a'); //탭 버튼
const tabContent = document.querySelectorAll('#tabContent > div'); //탭 내용

targetLink.forEach(function(link){
    link.addEventListener('click', function(e){
        e.preventDefault(); //링크금지, a 태그와 연관되면 꼭 써야 함
        let orgtarget = e.target.getAttribute('href');
        // 클릭한 개체(e.target)
        // getAttribute: href, src 속성 등을 읽어옴
        // alert(orgtarget);
        let tabTarget = orgtarget.replace('#', '');
        // #tab1의 #을 빈 문자열로 대체
        // alert(tabTarget);

        tabContent.forEach(function(content){
            content.style.display = 'none';
        });
        document.getElementById(tabTarget).style.display = 'block';
        // 클릭한 탭만 보이게 설정
        targetLink.forEach(function(link2){
            link2.classList.remove('active');
        });
        e.target.classList.add('active');
    });
});
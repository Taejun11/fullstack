$(function(){
    // 메인 배너 슬라이드
    var banner_bx = $('#slide ul').bxSlider({
        auto:true,
    });

    // 메뉴탭 클릭
    $('.menu_tab ul li').click(function(){
        if ($(this).hasClass('active') == false) {
            $('.menu_tab ul li').removeClass('active');
            $(this).addClass('active');
        }
        return false;
    });

    var menu_bx = $('.subway_menu_slide').bxSlider({
        auto:false,
        pager:false,
        moveSlides:4,//한번에 슬라이드되는 사진 수
        minSlides:4,
        maxSlides:4,
        slideWidth:260,//슬라이드 한 장의 이미지 넓이
        slideMargin:10,//슬라이드 사이 여백
        infiniteLoop:false,
        touchEnabled:false,
    });
    $('.subway_menu_slide li').click(function(){
        if ($(this).hasClass('active') == false) {
            $('.subway_menu_slide li').removeClass('active');
            $(this).addClass('active');
        }
        return false;
    });
    // 처음엔 디스플레이 none하고 처음 것만 block 넣음
    // 클릭하면 if로 디스플레이 none, block 넣기
});
$(function(){
    // 메인 배너 슬라이드
    var banner_bx = $('#slide ul').bxSlider({
        auto:true,
        controls:false,
        touchEnabled:false,

    });
    $(this).click(function(){//모든 클릭요소 클릭시 화면 위로 올라가는 현상 제거
        return false;
    });

    // 메뉴탭 클릭
    $('.menu_tab ul li').click(function(){
        var i = $(this).index();
        if ($(this).hasClass('active') == false) {
            $('.menu_tab ul li').removeClass('active');
            $(this).addClass('active');
            $('.subway_menu_slide').removeClass('active');
            $('.subway_menu_slide').eq(i).addClass('active');
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

    $('.sponsor_slide > div').bxSlider({
        auto:false,
        pager:true,
        moveSlides:1,//한번에 슬라이드되는 사진 수
        minSlides:1,
        maxSlides:1,
        infiniteLoop:false,
        touchEnabled:false,
    });
    
});
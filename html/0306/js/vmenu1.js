$(function(){
    // $('.sub').css('display', 'none');
    $('.sub').hide();
    $('.sub').eq(0).show();

    $('.m_menu > li > a').click(function(e){
        e.preventDefault();
        var kkk = $(this).next('.sub').css('display');
        // 클릭 다음에 있는 요소의 display 상태를 반환함
        // alert(kkk);
        if(kkk == 'none'){
            $('.sub').slideUp();
            $(this).next('.sub').slideDown();
        }
    });
});
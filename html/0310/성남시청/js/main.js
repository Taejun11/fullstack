$(function(){
    var slider = $('.slider').bxSlider({
        auto:true,
        controls:false,
        pager:false,
        onSlideAfter:function(){
            var k = slider.getCurrentSlide();
            $('.count span').text(k + 1);
        },
    });

    $('.prev').click(function(){
        slider.goToPrevSlide();
        return false;
    });
    $('.next').click(function(){
        slider.goToNextSlide();
        return false;
    });
    $('.stop').click(function(){
        if($(this).hasClass('on') == false){
            $(this).addClass('on');
            slider.stopAuto();
        }else{
            $(this).removeClass('on');
            slider.startAuto();
        }
    });
});
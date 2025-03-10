$(function(){
    $(window).scroll(function(){
        var sct = $(this).scrollTop();
        $('.s_top').text(sct);
        if ((sct >= 400)&&(sct <= 1200)) {
            $('.left1').addClass('on');
        }else{
            $('.left1').removeClass('on');
        }
        if ((sct >= 900)&&(sct <= 1800)) {
            $('.right1').addClass('on');
        }
        else{
            $('.right1').removeClass('on');
        }

        // if (sct >= 2700) {
        //     $('.s4_cover > div').addClass('active');            
        // }else{
        //     $('.s4_cover > div').removeClass('active');            
        // }
        if (sct >= 2700) {
            $('.s4_1').addClass('active');    
            setTimeout(function(){
                $('.s4_2').addClass('active');

            },400);
            setTimeout(function(){
                $('.s4_3').addClass('active');    

            },800);
            setTimeout(function(){
                $('.s4_4').addClass('active');    

            },1200);
        }else{
            $('.s4_cover > div').removeClass('active');            
        }
    });
});
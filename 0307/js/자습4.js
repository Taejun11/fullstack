$(function(){
    $('.main > ul > li').hide();
    $('.main').hover(function(){
        $('.main > ul > li').slideDown();
    }, function(){
        $('.main > ul > li').slideUp();
    });
});
$(function(){
    var visual = $('#brandVisual > ul > li'); //큰 사진
    var button = $('#buttonList > li'); //페이지 버튼
    var current = 0; //현재의 인덱스번호 기억
    var id;
    var i = 0;

    button.click(function(){
        i = $(this).index(); //클릭한 버튼의 인덱스번호
        // alert(i);
        button.removeClass('on');
        button.eq(i).addClass('on');
        move();
        return false;
    });
    function move(){
        if (current == i) {
            return;
            //현재 활성화된 버튼과 클릭한 버튼이 같으면 아무것도 안하고 빠져나감
        }
        var cu = visual.eq(current); //현재 사진
        var ne = visual.eq(i);       //슬라이드되어 들어올 사진
        cu.css('left', '0').stop().animate({'left':'-100%'}, 500);
        ne.css('left', '100%').stop().animate({'left':'0%'}, 500);
        current = i;
    }
    timer();
    function timer(){
        id = setInterval(function(){
            var n = current + 1;
            if(n == 3){
                n = 0;
            }
            button.eq(n).trigger('click');
            // n번째 버튼을 강제로 클릭
        }, 3000);
    }
});
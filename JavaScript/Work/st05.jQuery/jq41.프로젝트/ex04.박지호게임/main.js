

"use strict";

var boat = $('.boat');
var lion1 = $('#lion1');
var lion2 = $('#lion2');
var lion3 = $('#lion3');
var rab1 = $('#rab1');
var rab2 = $('#rab2');
var rab3 = $('#rab3');
var isDrag = false;
var x=0,y=0;
var px=0,py=0;
var befo = null;

var MYAPP = {
      imgs : null              // 이미지 목록을 저장할 변수
    , selectPanel : null       // 선택 영역 패널을 저장할변수
    , containerArea : null     // 선택 영역 패널의 left, top, right, bottom을 저장할 변수

    , dragTarget : null        // 드래그 되는 이미지 저장하는 변수
    , dragTF     : 0           // 드래그 유무를 저장하는 변수

    , startImgX : 0        // 드래그 시작 위치을 저장할 변수
    , startImgY : 0        // 드래그 시작 위치을 저장할 변수
    , zIndex : 100         // 드래그 되는 이미지를 최상위로 올리기 위해 사용되는 변수 시작값은 100으로 시작  클릭할때마다 1씩 증가
};

// 초기화 메서드
MYAPP.init = function() {
    // 선택 영역 패널
    this.selectPanel = $('.boat');

    this.containerArea = {
        left   : $(this.selectPanel).offset().left ,
        top    : $(this.selectPanel).offset().top  ,
        right  : $(this.selectPanel).offset().left + $(this.selectPanel).width()  ,
        bottom : $(this.selectPanel).offset().top  + $(this.selectPanel).height()
    }
};
$(document).ready(function() {

  $('#rulexp').hide();
  $('#rulbtn').click(function(event) {
    $('#rulexp').fadeToggle();
  });

  $('#boatArea').on('mousedown',function(e) {
      px = e.pageX;
      py = e.pageY;
      isDrag = true;
      movebt( $(this) );
      return false;
  })
  $('.char').on('mousedown',function() {

      MYAPP.dragTarget = $(this);
      MYAPP.dragTF     = true   ;

      // 시작 위치 값 저장
      var offset = MYAPP.dragTarget.offset();

      MYAPP.startImgX = e.pageX - offset.left;
      MYAPP.startImgY = e.pageY - offset.top ;

      // 드래그 되는 이미지를 맨 위에 배치시키기 위해서
      // z-index 를 사용
      MYAPP.zIndex = MYAPP.zIndex +1;

      MYAPP.dragTarget.css( 'z-index', MYAPP.zIndex );

      // mousemove 이벤트 활성화
      movech();
      upch();
  })

});



var movech = function(){
  $(document).mousemove(function(event){
    console.log(event.pageX + ',' + event.pageY );

    if( MYAPP.dragTF === true ){
        // 드래그 중인 이미지의 x, y 좌표 계산
        var endX = e.pageX - MYAPP.startImgX;
        var endY = e.pageY - MYAPP.startImgY;

        // 드래그 중인 이미지의 표시 위치 변경
        MYAPP.dragTarget.offset( {left:endX, top: endY });

        // 기본 기능 취소
        return false;
    }
  });

};
var upch = function(){

  $(document).mouseup(function() {

    var aft = $(befo);
    if( aft.attr('class') == "boat" ){
      if( $('#boatArea').has($('.char')).length>0 ){
        befo.css({
          left:110,
          top:-10
        })
        befo.appendTo($('#boatArea'));
      }
      else{
        befo.css({
          left:40,
          top:-10
        })
        befo.appendTo($('#boatArea'));
      }
    }
    isDrag = false;

    // 이벤트 제거
    $(document).off();
    //$(befo).off('mousemove,mouseup');
  });
}
var movebt = function(boat) {
      boat.mousemove(function(e) {
          if(isDrag){
              x= $(this).offset().left -( px-e.pageX );
              y= $(this).offset().top -( py-e.pageY );
              px = e.pageX;
              py = e.pageY;
              $(this).offset({
                      "left":x,
                      "top":y
              })
              return false;
          }
      }).mouseup(function(){
          $('.char').off('mousedown');
          $('.char').off('mousemove');
          isDrag = false;
          return false;
      });
}

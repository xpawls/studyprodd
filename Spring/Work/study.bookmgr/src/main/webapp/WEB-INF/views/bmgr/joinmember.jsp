<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- <link rel="stylesheet" type="text/css" -->
<!--     href="/resources/stylesheet/bookcss.css"> -->
<style type="text/css">
/* header */
div.nblabel {
    width: 100px;
    height: auto;
}
</style>
<link rel="stylesheet" type="text/css"
    href="/resources/stylesheet/bookcss.css">
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resources/js/bookjs.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#idmatch').click(function(e){
			var id = $('input[name="memID"]').val();
			
			$.ajax({
			    url : '/bmgr/newID'
			    , data: {'memID':id}        // 사용하는 경우에는 { data1:'test1', data2:'test2' }
			    , type: 'post'       // get, post
			    , timeout: 30000    // 30초
			    , dataType: 'json'  // text, html, xml, json, jsonp, script
			    , beforeSend : function() {
			         // 통신이 시작되기 전에 이 함수를 타게 된다.
			    }
			}).done( function(data, textStatus, xhr ){
			    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
			    if(data===0){
			    	alert('사용 가능한 아이디입니다.');
			    	$('input[name="memID"]').addClass('matchOK');
			    }
			    else{
			    	alert('이미 존재하는 아이디 입니다.');
			    	$('input[name="memID"]').val('');
			    }
			}).fail( function(xhr, textStatus, error ) {
			    // 통신이 실패했을 때 이 함수를 타게 된다.
			}).always( function(data, textStatus, xhr ) {
			    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
			});
		});
		
		$('#submit').click(function(e){
			var input = $('.jmip');
			for(var i=0; i<input.length; i++){
				if($(input[i]).val()===''){
					$('.jmip').next('label').remove();
					$(input[i]).after('<label>입력하세요</label>');
					return false;
				}
			}

			if($('input[name="memPW"]').val()!==$('input[name="pwmatch"]').val()){
                alert('비밀번호가 일치하지 않습니다.');
                $('input[name="pwmatch"]').focus();
                return false;
            }
            else if(!$('input[name="memID"]').hasClass('matchOK')){
                alert('아이디 중복 검사를 해 주세요');
                return false;
            }
			

            
		});
	});
	
</script>
</head>
<body>
    
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="aside.jsp"></jsp:include>
    <div id="container">
    <form action="joinmembercmp" method="post" enctype="application/x-www-form-urlencoded" id="joinform">
        <div class="nblabel">아이디</div>
        <input name="memID" type="text" class="jmip">
        <input id="idmatch" type="button" value="아이디중복확인"><br> 
        <div class="nblabel">패스워드</div><input name="memPW" type="password" class="jmip"><br> 
        <div class="nblabel">패스워드 확인</div><input name="pwmatch" type="password" class="jmip"><br> 
        <div class="nblabel">이름</div><input name="memName" type="text" class="jmip"><br> 
            <div class="nblabel">주민번호</div><input name="memPriNum1" type="text" class="jmip">-
            <input name="memPriNum2" type="text" class="jmip"><br>
             <div class="nblabel">전화번호</div>
             <input name="memPhone1" type="text"  class="jmip">-
             <input name="memPhone2" type="text" class="jmip">-
             <input name="memPhone3" type="text"  class="jmip"><br>
        <div class="nblabel">이메일</div><input name="memEmail" type="text" class="jmip"><br> 
             <input
            id="submit" type="submit" value="등록">
    </form>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>


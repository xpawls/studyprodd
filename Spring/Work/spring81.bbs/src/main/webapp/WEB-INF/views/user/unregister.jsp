<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="Keywords" content="탈퇴" />
<meta name="Description" content="탈퇴" />
<title>탈퇴</title>
<link rel="stylesheet" href="/resources/css/screen.css" type="text/css" />
<script type="text/javascript" src="/resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(document).ready(function(event){
	$('input[type="submit"]').click(function(event){
		var email = $('input[name="email"]').val();
		var passwd = $('input[name="passwd"]').val();
		if(email===''){
			alert('email을 입력하세요!');
			$('input[name="email"]').focus();
			return false;
		}
		else if(passwd===''){
            alert('패스워드를 입력하세요!');
            $('input[name="passwd"]').focus();
            return false;
        }
		else {
			$.ajax({
	            url : '/rest/checkuseremailpw'
	            , data: {'email' : email, 'passwd' : passwd}        // 사용하는 경우에는 { data1:'test1', data2:'test2' }
	            , type: 'get'       // get, post
	            , timeout: 30000    // 30초
	            , dataType: 'json'  // text, html, xml, json, jsonp, script
	            , beforeSend : function() {
	                // 통신이 시작되기 전에 이 함수를 타게 된다.
	            }
	        }).done( function(data, textStatus, xhr ){
	            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
	            if(data===0){

	                alert('email혹은 패스워드가 일치하지 않습니다.');
	                return false;
	            }
	            else{
	            	$('#byeForm').submit();
	            }
	        }).fail( function(xhr, textStatus, error ) {
	            // 통신이 실패했을 때 이 함수를 타게 된다.
	        }).always( function(data, textStatus, xhr ) {
	            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
	        });
			
		}
	});
});
</script>
        
</head>
<body>

<div id="wrap">
<div id="header"><%@ include file="../inc/header.jsp"%>
        </div>

        <div id="main-menu"><%@ include
                file="../inc/main-menu.jsp"%></div>

    <div id="container">
        <div id="content" style="min-height: 800px;">

            <!-- 본문 시작 -->
            <div id="url-navi">회원</div>
            
            <h1>탈퇴</h1>
            <form id="byeForm" action="./unregister" method="post" onsubmit="return check()">
            <table>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" /></td>   
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="passwd" /></td>  
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="확인" /></td>
            </tr>
            </table>
            </form>
            <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
        <div id="sidebar"><%@ include file="../inc/bbs-menu.jsp"%></div>

        <div id="extra"><%@ include file="../inc/extra.jsp"%></div>

        <div id="footer"><%@ include file="../inc/footer.jsp"%>
        </div>
</div>

</body>
</html>

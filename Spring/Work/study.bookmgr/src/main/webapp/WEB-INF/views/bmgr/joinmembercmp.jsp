<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<!-- <link rel="stylesheet" type="text/css" -->
<!--     href="/resources/stylesheet/bookcss.css"> -->
<style type="text/css">
/* header */
div.nblabel {
    width: 100px;
    height: auto;
}
</style>

<link rel="stylesheet" type="text/css" href="/resources/stylesheet/bookcss.css">
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#goHome').click(function(event){
			location.href="/";
		});
		
		$('#logIn').click(function(event){
            location.href="/bmgr/login";
        });
		
	});
</script>
</head>
<body>
    
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="aside.jsp"></jsp:include>
    <div id="container">
        <h1>환영합니다!</h1>
        <div> ${bookname} 님의 가입이 완료 되었습니다.</div>
        <br>
        <input type="button" value="메인으로" name="goHome" id="goHome">
        <input type="button" value="로그인" name="logIn" id="logIn">
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


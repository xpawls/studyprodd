<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css"
    href="/resources/stylesheet/bookcss.css">
<style type="text/css">
/* header */
div.nblabel {
    width: 100px;
    height: auto;
}

.logregi input {
    margin: 10px;
}

</style>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resources/js/bookjs.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
// 	    $('#submit').click(function(event) {
	    	
//         });
	});
</script>
</head>
<body>


    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="aside.jsp"></jsp:include>
    <div id="container" class="logregi" >
    <h2>로그인</h2>
    <form action="login" method="post"
                    enctype="application/x-www-form-urlencoded">
                    <p style="margin: 0; padding: 0;">
                        <input type="hidden" name="url" value="${url }" />
                    </p>
        <div class="nblabel">아이디</div>
        <input name="memID" type="text" class="jmip">
        <br> 
        <div class="nblabel">패스워드</div><input name="memPW" type="password" class="jmip"><br> 
        <input id="submit" type="submit" value="Login">
        
        <a href="/bmgr/idpwfind">아이디/비밀번호 찾기</a>
    </form>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


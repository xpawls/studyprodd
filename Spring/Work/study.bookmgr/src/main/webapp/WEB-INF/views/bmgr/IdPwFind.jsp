<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
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
    <h2>아이디/비밀번호 찾기</h2>
    <div><label>아이디 찾기</label>
    <c:if test="${not empty id }">
    <div style="color: blue">아이디는 ${id } 입니다</div>
    </c:if>
    <form action="/bmgr/idfind" method="post"
                    enctype="application/x-www-form-urlencoded">
        <div class="nblabel">이름</div><input name="memName" type="text" class="jmip"><br> 
            <div class="nblabel">주민번호</div><input name="memPriNum1" type="text" class="jmip">-
            <input name="memPriNum2" type="password" class="jmip"><br>
             <input
            id="idfind" type="submit" value="아이디찾기">
    </form>
    </div>
    
    <div><label>비밀번호 찾기</label>
    <c:if test="${not empty pw }">
    <div style="color: blue">비밀번호는 ${pw } 입니다</div>
    </c:if>
    <form action="/bmgr/pwfind" method="post"
                    enctype="application/x-www-form-urlencoded">
        <div class="nblabel">아이디</div>
        <input name="memID" type="text" class="jmip">
        <br> 
        <div class="nblabel">이름</div><input name="memName" type="text" class="jmip"><br> 
            <div class="nblabel">주민번호</div><input name="memPriNum1" type="text" class="jmip">-
            <input name="memPriNum2" type="password" class="jmip"><br>
             <input
            id="pwfind" type="submit" value="비밀번호찾기">
        
    </form>
    </div>
    
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


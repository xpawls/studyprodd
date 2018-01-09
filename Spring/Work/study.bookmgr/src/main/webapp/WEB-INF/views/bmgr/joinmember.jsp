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
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
// 	    $('#submit').click(function(event) {
	    	
//         });
	});
</script>
</head>
<body>
    <form action="joinmembercmp" method="post">
        <div class="nblabel">이름</div><input name="memName" type="text"><br> 
            <div class="nblabel">주민번호</div><input name="memPriNum1" type="text">-<input name="memPriNum2" type="text"><br>
             <div class="nblabel">전화번호</div><input name="memPhone1" type="text">-<input name="memPhone2" type="text">-<input name="memPhone3" type="text"><br>
        <div class="nblabel">이메일</div><input name="memEmail" type="text"><br> 
             <input
            id="submit" type="submit" value="등록">
    </form>
</body>
</html>


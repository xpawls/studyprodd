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
    <form action="newbookcmp" method="post">
        <div class="nblabel">제목</div><input name="bookname"
            type="text"><br> <div class="nblabel">출판사</div><input
            name="publisher" type="text"><br> <div
            class="nblabel">장르</div><input name="category" type="text"><br>
        <div class="nblabel">작가</div><input name="author"
            type="text"><br> <div class="nblabel">가격</div><input
            name="price" type="text"><br> <input
            id="submit" type="submit" value="등록">
    </form>
</body>
</html>


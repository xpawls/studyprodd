<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>도서 대여</title>
<link rel="stylesheet" type="text/css" href="/resources/stylesheet/bookcss.css">
<style type="text/css">
/* header */
div.nblabel {
    width: 100px;
    height: auto;
}
</style>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		
	});
</script>
</head>
<body>
    <form action="/bmgr/brrbookcmp" method="post" id="form">
        <div class="nblabel">번호</div>
        <input name="no" type="text" value="${brrbook.no }" readonly="readonly"><br>
        <div class="nblabel">제목</div>
        <input name="bookname" type="text" value="${brrbook.bookname }" readonly="readonly"><br>
        <div class="nblabel">출판사</div>
        <input name="publisher" type="text"
            value="${brrbook.publisher }" readonly="readonly"><br>
        <div class="nblabel">장르</div>
        <input name="category" type="text" value="${brrbook.category }" readonly="readonly"><br>
        <div class="nblabel">작가</div>
        <input name="author" type="text" value="${brrbook.author }" readonly="readonly"><br>
        <span>위의 도서를 대여합니다.</span><br>
        <input id="submit" type="submit" value="대여">

    </form>
    <br>
</body>
</html>


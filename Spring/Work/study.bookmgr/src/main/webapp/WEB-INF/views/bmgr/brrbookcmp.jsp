<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>도서 대여완료</title>
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
		$('#cmpclose').click(function(event){
			window.open("about:blank","_self").close();
		});
	});
</script>
</head>
<body>
    <div> ${bookname} 의 대여가 완료 되었습니다.</div>
    <br>
    <input type="button" value="확인" name="cmpclose" id="cmpclose">
</body>
</html>


<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/spring/loginmodel" method="post"
        enctype="application/x-www-form-urlencoded">
        <label for="name">이름 : <input type="text" name="name" /></label>
        <label for="pw">비밀번호 : <input type="text" name="pw" /></label>
        <input type="submit" value="전송" />
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/el/el04" method="post"
        enctype="application/x-www-form-urlencoded">
        숫자 1 : <input type="text" name="num1"> <br> 숫자 2 :
        <input type="text" name="num2" value="${param.num1}"> <br> <input
            type="submit" value="전송">
    </form>
</body>
</html>
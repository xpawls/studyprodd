<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="code" value="800" scope="request" />
<c:set var="name" value="sdfa1123 dfa"  scope="request" />


<jsp:forward page="jstl03.jsp">
<jsp:param name="price" value="2314apd" />
<jsp:param name="browser" value="내꺼" />
</jsp:forward>
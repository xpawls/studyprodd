
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="aside">
    
    <c:if test="${not empty bookaside }">
    <ul id="maintab">
        <li><a href="#" name="#bookpage">도서</a></li>
        <c:if test="${not empty mgr }">
        <li><a href="#" name="#memberpage">회원</a></li>
        </c:if>
        <li><a href="#" name="#rentpage">대여목록</a></li>
    </ul>
    <c:if test="${not empty mgr }">
    <ul id="mgrtab">
        <li><a href="/bmgr/newbook">도서등록</a></li>
        <li><a href="/bmgr/joinmember">회원등록</a></li>
        <li>대여</li>
    </ul>
    </c:if>
    </c:if>
    <c:if test="${asidetype == notice}">
    <ul id="mgrtab">
        <li><a href="/bmgr/bookboard/notice">공지사항</a></li>
        <li><a href="/bmgr/bookboard/subject">일정</a></li>
    </ul>
    </c:if>
    
    
</div>

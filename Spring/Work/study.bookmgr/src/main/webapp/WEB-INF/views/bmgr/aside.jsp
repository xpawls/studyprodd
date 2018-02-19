
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="aside">
    
    <c:if test="${not empty bookaside }">
    <ul id="maintab" class="asidebar">
        <li><a href="#" name="#bookpage">도서</a></li>
        <c:if test="${not empty mgr }">
        <li><a href="#" name="#memberpage">회원</a></li>
        </c:if>
        <li><a href="#" name="#rentpage">대여목록</a></li>
    </ul>
    <c:if test="${not empty mgr }">
    <ul  class="asidebar">
        <li><a href="/bmgr/newbook">도서등록</a></li>
        <li><a href="/bmgr/joinmember">회원등록</a></li>
    </ul>
    </c:if>
    </c:if>
    <c:if test="${asidetype eq 'notice' or asidetype eq 'subject'}">
    <ul  class="asidebar">
        <li><a href="/bmgr/bookboard/notice">공지사항</a></li>
        <li><a href="/bmgr/bookboard/subject">일정</a></li>
    </ul>
    </c:if>
    <c:if test="${asidetype eq 'free' or asidetype eq 'qna'}">
    <ul  class="asidebar">
        <li><a href="/bmgr/bookboard/free">자유게시판</a></li>
        <li><a href="/bmgr/bookboard/qna">질문게시판</a></li>
    </ul>
    </c:if>
    
    <c:if test="${asidetype eq 'complain' or asidetype eq 'needbook'}">
    <ul  class="asidebar">
        <li><a href="/bmgr/bookboard/complain">건의사항</a></li>
        <li><a href="/bmgr/bookboard/needbook">도서요청</a></li>
    </ul>
    </c:if>
    
    
</div>

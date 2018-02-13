 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div id="header">
        <h2>도서도서관</h2>
        
        
        
        <ul id="headmenu">
            <li><a href="/">메인</a></li>
            <li>ㅣ</li>
            <li><a href="/bmgr/bookboard/notice">도서관정보</a></li>
            <li>ㅣ</li>
            <li><a href="/bmgr/mainpage">도서</a></li>
            <li>ㅣ</li>
            <li><a href="/bmgr/bookboard/free">게시판</a></li>
            <li>ㅣ</li>
            <li><a href="/bmgr/bookboard/complain">도움</a></li>
        </ul>
        
        <c:choose>
        <c:when test="${empty user }">
            <input type="button" value="로그인" id="headLoginBtn">
            <input type="button" value="회원가입"  name="joinmember"  id="joinmember">
        </c:when>
        <c:otherwise>
            <span> ${user.memName }님</span>
            <br>
            <input type="button" value="로그아웃" id="headLogoutBtn">
            <input type="button" value="회원정보수정"  name="memberinfo"  id="memberinfo">
        </c:otherwise>
        </c:choose>
    </div>
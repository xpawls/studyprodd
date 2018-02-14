<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>도서관</title>
    <link rel="stylesheet" type="text/css"
    href="/resources/stylesheet/bookcss.css">
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resources/js/bookjs.js"></script>
<script type="text/javascript">
var goView = function(bno,boardcd){
	location.href="/bmgr/bookboardview/"+boardcd+'/'+bno;
};
</script>

<style type="text/css">
 .miniboard { margin: 10px;}
 .miniboard th, td { font-size: small; text-align: left; }
 .miniboard td { border: black solid 1px;}
 #mininoti {
    float: left;
 } 
 #minisub {
    float: left;
 }
 
  #minifree {
    clear: both;
    float: left;
 }
  #miniqna {
    float: left;
 }
 
  
  #minicomp {
    clear: both;
    float: left;
 }
  #minineed {
    float: left;
 }
</style>
</head>
<body>
    <jsp:include page="bmgr/header.jsp"></jsp:include>
    <div id="maincontainer">
        <h1>환영합니다</h1>
       <div class="miniboard" id="mininoti"><b><a href="/bmgr/bookboard/notice">공지사항</a></b>
        
            <table>
                <tr class="sthead">
                    <th width="80px">작성일</th>
                    <th width="200px">제목</th>
                    <th width="70px">아이디</th>
                </tr>
            <c:forEach var="board" items="${notilist }" varStatus="status">
                    <tr>
                        <td>${board.updatedt }</td>
                        <td><a href="javascript:goView('${board.bno }','notice')">${board.title }</a>
                            <c:if test="${board.commentNum > 0 }">
                                <span class="bbs-strong">[${board.commentNum }]</span>
                            </c:if></td>
                        <td>${board.memid }</td>
                    </tr>
                </c:forEach>
                </table>
        </div>
        
        <div class="miniboard" id="minisub"><b><a href="/bmgr/bookboard/subject">일정</a></b>
        
            <table>
                <tr class="sthead">
                    <th width="80px">작성일</th>
                    <th width="200px">제목</th>
                    <th width="70px">아이디</th>
                </tr>
            <c:forEach var="board" items="${subjectlist }" varStatus="status">
                    <tr>
                        <td>${board.updatedt }</td>
                        <td><a href="javascript:goView('${board.bno }','subject')">${board.title }</a>
                            <c:if test="${board.commentNum > 0 }">
                                <span class="bbs-strong">[${board.commentNum }]</span>
                            </c:if></td>
                        <td>${board.memid }</td>
                    </tr>
                </c:forEach>
                
                </table>
        </div>
        
        
        <div class="miniboard" id="minifree"><b><a href="/bmgr/bookboard/free">자유게시판</a></b>
        
            <table>
                <tr class="sthead">
                    <th width="80px">작성일</th>
                    <th width="200px">제목</th>
                    <th width="70px">아이디</th>
                </tr>
            <c:forEach var="board" items="${freelist }" varStatus="status">
                    <tr>
                        <td>${board.updatedt }</td>
                        <td><a href="javascript:goView('${board.bno }','free')">${board.title }</a>
                            <c:if test="${board.commentNum > 0 }">
                                <span class="bbs-strong">[${board.commentNum }]</span>
                            </c:if></td>
                        <td>${board.memid }</td>
                    </tr>
                </c:forEach>
                </table>
        </div>
        
        
        <div class="miniboard" id="miniqna"><b><a href="/bmgr/bookboard/qna">질문게시판</a></b>
        
            <table>
                <tr class="sthead">
                    <th width="80px">작성일</th>
                    <th width="200px">제목</th>
                    <th width="70px">아이디</th>
                </tr>
            <c:forEach var="board" items="${qnalist }" varStatus="status">
                    <tr>
                        <td>${board.updatedt }</td>
                        <td><a href="javascript:goView('${board.bno }','qna')">${board.title }</a>
                            <c:if test="${board.commentNum > 0 }">
                                <span class="bbs-strong">[${board.commentNum }]</span>
                            </c:if></td>
                        <td>${board.memid }</td>
                    </tr>
                </c:forEach>
                </table>
        </div>
        
        
        <div class="miniboard" id="minicomp"><b><a href="/bmgr/bookboard/complain">건의사항</a></b>
        
            <table>
                <tr class="sthead">
                    <th width="80px">작성일</th>
                    <th width="200px">제목</th>
                    <th width="70px">아이디</th>
                </tr>
            <c:forEach var="board" items="${complainlist }" varStatus="status">
                    <tr>
                        <td>${board.updatedt }</td>
                        <td><a href="javascript:goView('${board.bno }','complain')">${board.title }</a>
                            <c:if test="${board.commentNum > 0 }">
                                <span class="bbs-strong">[${board.commentNum }]</span>
                            </c:if></td>
                        <td>${board.memid }</td>
                    </tr>
                </c:forEach>
                </table>
        </div>
        
        <div class="miniboard" id="minineed"><b><a href="/bmgr/bookboard/needbook">도서요청</a></b>
        
            <table>
                <tr class="sthead">
                    <th width="80px">작성일</th>
                    <th width="200px">제목</th>
                    <th width="70px">아이디</th>
                </tr>
            <c:forEach var="board" items="${needlist }" varStatus="status">
                    <tr>
                        <td>${board.updatedt }</td>
                        <td><a href="javascript:goView('${board.bno }','needbook')">${board.title }</a>
                            <c:if test="${board.commentNum > 0 }">
                                <span class="bbs-strong">[${board.commentNum }]</span>
                            </c:if></td>
                        <td>${board.memid }</td>
                    </tr>
                </c:forEach>
                </table>
        </div>
        
    </div>
    <jsp:include page="bmgr/footer.jsp"></jsp:include>
</body>
</html>

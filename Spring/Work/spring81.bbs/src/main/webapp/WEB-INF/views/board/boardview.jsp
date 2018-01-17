<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<head>
<meta charset="utf-8" />
<meta name="Keywords" content="게시판 상세보기" />
<meta name="Description" content="게시판 상세보기" />
<link rel="stylesheet" href="/resources/css/screen.css" type="text/css"
    media="screen" />
<title>${boardNm }</title>
<script type="text/javascript" src="/resources/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(document).ready(function(e){
	$('.boardlist').click(function(e){
		window.location.href = '/board/boardlist';
	});
    $('.boardwrite').click(function(e){
        window.location.href = '/board/boardwrite';
    });
    $('.boardmodify').click(function(e){
        window.location.href = '/board/boardmodify?boardcd=${board.boardcd}';
    });
    $('.boarddelete').click(function(e){
    	
    });
});
</script>

</head>
<body>

    <div id="wrap">

        <div id="header"><%@ include file="../inc/header.jsp"%>
        </div>

        <div id="main-menu"><%@ include
                file="../inc/main-menu.jsp"%></div>
        <div id="container">
            <div id="content" style="min-height: 800px;">

                <!-- 본문 시작 -->
                <h1>Board View</h1>
                <div id="error_message">

                        <c:if test="${not empty msg }">
                            <p style="color: red;">정보 삭제를 실패했습니다.</p>
                        </c:if>
                    </div>
                    
                <div id="bbs">
                    <table>
                        <tr>
                            <th style="text-align: left; width: 100px;">Borad
                                Name</th>
                            <th style="text-align: left; color: #555;">${board.boardnm }</th>
                        </tr>
                        <tr>
                            <th style="text-align: left; width: 100px;">Board
                                Code</th>
                            <th style="text-align: left; color: #555;">${board.boardcd }</th>
                        </tr>
                        <tr>
                            <th style="text-align: left; width: 100px;">Use
                                YN</th>
                            <th style="text-align: left; color: #555;"><input
                                type="checkbox" name="UseYN"
                                readonly="readonly"
                                <c:if test="${board.useYN}">checked="checked"</c:if> />
                            </th>
                        </tr>
                    </table>
                </div>

                <div style="text-align: left; padding-bottom: 15px;">
                    <input type="button" class="boardlist" value="목록" />
                    <input type="button" class="boardwrite" value="추가" />
                    <input type="button" class="boardmodify" value="수정" />
                    <input type="button" class="boarddelete" value="삭제" />
                </div>
                <!--  본문 끝 -->

            </div>
            <!-- content 끝 -->

        </div>
        <!--  container 끝 -->
        <div id="sidebar"><%@ include file="../inc/bbs-menu.jsp"%></div>

        <div id="extra"><%@ include file="../inc/extra.jsp"%></div>

        <div id="footer"><%@ include file="../inc/footer.jsp"%>
        </div>
    </div>


</body>
</html>

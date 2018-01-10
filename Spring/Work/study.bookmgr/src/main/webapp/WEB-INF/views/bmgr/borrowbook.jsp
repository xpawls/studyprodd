<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>도서 대여</title>
<link rel="stylesheet" type="text/css"
    href="/resources/stylesheet/bookcss.css">
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

        $('body').on('click', '#brmsbtn', function() {
        	$('#form').attr('action', '/bmgr/brmseach');
            $('#form').submit();
        });
        $('body').on('click', '#submit', function() {
            $('#form').attr('action', '/bmgr/brrbookcmp');
            $('#form').submit();
        });
// 	    $('#brmsbtn').click(function(event){
// 	    	$('#form').attr('action', '/bmgr/brmseach');
// 	    	$('#form').submit();
// 	    });
// 	    $('#submit').click(function(event){
//             $('#form').attr('action', '/bmgr/brrbookcmp');
//             $('#form').submit();
//         });
	});
</script>
</head>
<body>
    <form action="brrbookcmp" method="post" id="form">
        <div class="nblabel">번호</div>
        <input name="no" type="text" value="${brrbook.no }"><br>
        <div class="nblabel">제목</div>
        <input name="bookname" type="text" value="${brrbook.bookname }"><br>
        <div class="nblabel">출판사</div>
        <input name="publisher" type="text"
            value="${brrbook.publisher }"><br>
        <div class="nblabel">장르</div>
        <input name="category" type="text" value="${brrbook.category }"><br>
        <div class="nblabel">작가</div>
        <input name="author" type="text" value="${brrbook.author }"><br>
        <div class="nblabel">회원번호</div>
        <input name="memNo" type="text" value="${brlistm.memNo }"><br>
        <input type="button" name="searchbrmem" value="검색" id="brmsbtn">
        <input id="submit" type="button" value="대여">

    </form>
    <br>

    <table class="maintable">
        <thead>
            <tr>
                <td>no.</td>
                <td>이름</td>
                <td>주민번호</td>
                <td>전화번호</td>
                <td>이메일</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="brmemlist" items="${brlistm }"
                varStatus="ind">
                <tr>
                    <td class="brmtd">${brmemlist.memNo }</td>
                    <td class="brmtd">${brmemlist.memName }</td>
                    <td class="brmtd">${brmemlist.memPriNum }</td>
                    <td class="brmtd">${brmemlist.memPhone }</td>
                    <td class="brmtd">${brmemlist.memEmail }</td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
</body>
</html>


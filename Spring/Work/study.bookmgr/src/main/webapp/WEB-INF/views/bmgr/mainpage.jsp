<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 페이지</title>
<link rel="stylesheet" type="text/css"
    href="/resources/stylesheet/bookcss.css">
<style type="text/css">

</style>
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	var page = '${open}';
	$(document).ready(function() {
		$('#mainbody>div').hide();
		$(page).show();
		$('#maintab>li').click(function(event) {
			$('#mainbody>div').hide();
			var name = $(this).children('a').attr('name');
			$(name).show();
		});
		$('#newbook').click(function(event) {
			window.open('newbook', 'width=300px,height=300px', '_blank');
		});
		$('#joinmember').click(function(event) {
			window.open('joinmember', 'width=300px,height=300px', '_blank');
		});
		
		// 도서 페이지 도구툴
		$('#bsbtn').click(function(event) {
			var selec = $('#bsselect>option').val();
			$('#bsrhform').submit();

		});
		$('body').on('mouseover', 'td.btd', function() {
			$(this).parent('tr').children('td').addClass('tablehover');
		});
		$('body').on('mouseout', 'td.btd', function() {
			$('td.btd').removeClass('tablehover');
		});
		$('body').on('click', 'td.btd', function() {
			var no = $(this).parent('tr').children('td').eq(0).text();
			$('input[name="no"]').val(no);
			var name = $(this).parent('tr').children('td').eq(1).text();
			$('input[name="bookname"]').val(name);
			var category = $(this).parent('tr').children('td').eq(2).text();
			$('input[name="category"]').val(category);
			var author = $(this).parent('tr').children('td').eq(3).text();
			$('input[name="author"]').val(author);
			var publisher = $(this).parent('tr').children('td').eq(4).text();
			$('input[name="publisher"]').val(publisher);
			var price = $(this).parent('tr').children('td').eq(5).text();
			$('input[name="price"]').val(price);
		});
		$('#bmbtn').click(function(event) {
			$('#btxtbox').attr('action', '/bmgr/modibook').submit();
		});
		$('#bdbtn').click(function(event) {
			$('#btxtbox').attr('action', '/bmgr/delbook').submit();
		});
        $('#brrbtn').click(function(event) {
            $('#btxtbox').attr("action", "/bmgr/borrowbook");
            $('#btxtbox').attr("method", "post");
            $('#btxtbox').attr("target", "도서대여");
            window.open("", "도서대여", "height=500, width=900, menubar=no, scrollbars=yes, resizable=no, toolbar=no, status=no, left=50, top=50");
            $('#btxtbox').submit();    

        });
        
        

		// 멤버 페이지 도구툴
		$('#msbtn').click(function(event) {
			$('#msrhform').submit();

		});
		$('body').on('mouseover', 'td.mtd', function() {
			$(this).parent('tr').children('td').addClass('tablehover');
		});
		$('body').on('mouseout', 'td.mtd', function() {
			$('td.mtd').removeClass('tablehover');
		});
		$('body').on('click', 'td.mtd', function() {
			var memNo = $(this).parent('tr').children('td').eq(0).text();
			$('input[name="memNo"]').val(memNo);
			var memName = $(this).parent('tr').children('td').eq(1).text();
			$('input[name="memName"]').val(memName);
			var memPriNum = $(this).parent('tr').children('td').eq(2).text();
			$('input[name="memPriNum"]').val(memPriNum);
			var memPhone = $(this).parent('tr').children('td').eq(3).text();
			$('input[name="memPhone"]').val(memPhone);
			var memEmail = $(this).parent('tr').children('td').eq(4).text();
			$('input[name="memEmail"]').val(memEmail);
		});
		$('#mmbtn').click(function(event) {
			$('#mtxtbox').attr('action', '/bmgr/modimem').submit();
		});
		$('#mdbtn').click(function(event) {
			$('#mtxtbox').attr('action', '/bmgr/delmem').submit();
		});

		// 대여 페이지 도구툴

		$('body').on('mouseover', 'td.brtd', function() {
			$(this).parent('tr').children('td').addClass('tablehover');
		});
		$('body').on('mouseout', 'td.brtd', function() {
			$('td.brtd').removeClass('tablehover');
		});
		$('body').on('click', 'td.brtd', function() {
			var brno = $(this).parent('tr').children('td').eq(0).text();
			$('input[name="brno"]').val(brno);
		});
	});
</script>
</head>
<body>
    <header>
    <div>
        <input type="button" name="joinmember" value="회원가입"
            id="joinmember"> <input type="button" name="newbook"
            value="도서등록" id="newbook"> <input type="button"
            name="refresh" value="새로고침"> <input type="button"
            name="exit" value="종료">
        <hr>
    </div>
    </header>
    <aside id="mainaside">
    <table id="renttableS">
        <thead>
            <tr>
                <td>이름</td>
                <td>책제목</td>
                <td>대여날짜</td>
            </tr>

        </thead>
        <tbody>
            <c:forEach var="brrlist" items="${listbrr }" varStatus="ind">
                <tr>
                    <td class="brtd">${brrlist.memname }</td>
                    <td class="brtd">${brrlist.bookname }</td>
                    <td class="brtd">${brrlist.borrowdate }</td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
    </aside>
    <div id="mainbody">
        <ul id="maintab">
            <li><a href="#" name="#bookpage">도서</a></li>
            <li><a href="#" name="#memberpage">회원</a></li>
            <li><a href="#" name="#rentpage">대여목록</a></li>
        </ul>
        <div id="bookpage" class="maintabpage">
            <form action="" method="post" id="btxtbox">
                <div class="label">no</div>
                <input type="text" name="no">
                <div class="label">책제목</div>
                <input type="text" name="bookname">
                <div class="label">장 르</div>
                <input type="text" name="category">
                <div class="label">작 가</div>
                <input type="text" name="author">
                <div class="label">출판사</div>
                <input type="text" name="publisher">
                <div class="label">가 격</div>
                <input type="text" name="price">
            </form>
            <div id="bpgtool">
                <select id="bsselect">
                    <option value="no">번호</option>
                    <option value="bookname">제목</option>
                    <option value="publisher">출판사</option>
                    <option value="author">작가</option>
                </select>
                <form action="bseach" method="post" id="bsrhform">
                    <input type="text" name="searchtext" id="searchtext">
                </form>
                <input type="button" name="searchbook" value="검색"
                    id="bsbtn"> <input type="button"
                    name="modifybook" value="수정" id="bmbtn"> <input
                    type="button" name="deletebook" value="삭제"
                    id="bdbtn"> <input type="button"
                    name="rentbook" value="대여" id="brrbtn">
            </div>
            <table class="maintable">
                <thead>
                    <tr>
                        <td>no.</td>
                        <td>제목</td>
                        <td>장르</td>
                        <td>작가</td>
                        <td>출판사</td>
                        <td>가격</td>
                        <td>대여</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="booklist" items="${list }"
                        varStatus="ind">
                        <tr>
                            <td class="btd">${booklist.no }</td>
                            <td class="btd">${booklist.bookname }</td>
                            <td class="btd">${booklist.category }</td>
                            <td class="btd">${booklist.author }</td>
                            <td class="btd">${booklist.publisher }</td>
                            <td class="btd">${booklist.price }</td>
                            <td class="btd">${booklist.borrow_yn }</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div id="memberpage" class="maintabpage">
            <form action="" method="post" id="mtxtbox">
                <label><div class="label">no</div> <input
                    type="text" name="memNo"></label> <label><div
                        class="label">이름</div> <input type="text"
                    name="memName"></label> <label><div
                        class="label">주민번호</div>
                    <input type="text" name="memPriNum"></label> <label><div
                        class="label">전화번호</div>
                    <input type="text" name="memPhone"></label> <label><div
                        class="label">메일주소</div>
                    <input type="text" name="memEmail"></label>
            </form>
            <div id="mpgtool">
                <select>
                    <option value="memNo">번호</option>
                    <option value="memName">이름</option>
                    <option value="memEmail">Email</option>
                    <option value="memPhone">전화번호</option>
                </select>
                <form action="mseach" method="post" id="msrhform">
                    <input type="text" name="msearchtext"
                        id="msearchtext">
                </form>
                <input type="button" name="searchmem" value="검색"
                    id="msbtn"> <input type="button"
                    name="modifymem" value="수정" id="mmbtn"> <input
                    type="button" name="deletemem" value="삭제" id="mdbtn">
            </div>


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
                    <c:forEach var="memlist" items="${listm }"
                        varStatus="ind">
                        <tr>
                            <td class="mtd">${memlist.memNo }</td>
                            <td class="mtd">${memlist.memName }</td>
                            <td class="mtd">${memlist.memPriNum }</td>
                            <td class="mtd">${memlist.memPhone }</td>
                            <td class="mtd">${memlist.memEmail }</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div id="rentpage" class="maintabpage">
            <form action="brrcmp" method="post">
                <input type="text" name="brno"> <input
                    type="submit" value="반납완료" name="brrsubmit">
            </form>
            <table class="maintable">

                <thead>
                    <tr>
                        <td>no.</td>
                        <td>이름</td>
                        <td>전화번호</td>
                        <td>주민번호</td>
                        <td>이메일</td>
                        <td>제목</td>
                        <td>출판사</td>
                        <td>장르</td>
                        <td>작가</td>
                        <td>책번호</td>
                        <td>대여날짜</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="brrlist" items="${listbrr }"
                        varStatus="ind">
                        <tr>
                            <td class="brtd">${brrlist.brno }</td>
                            <td class="brtd">${brrlist.memname }</td>
                            <td class="brtd">${brrlist.memphone }</td>
                            <td class="brtd">${brrlist.memprinum }</td>
                            <td class="brtd">${brrlist.mememail }</td>
                            <td class="brtd">${brrlist.bookname }</td>
                            <td class="brtd">${brrlist.publisher }</td>
                            <td class="brtd">${brrlist.category }</td>
                            <td class="brtd">${brrlist.author }</td>
                            <td class="brtd">${brrlist.bookno }</td>
                            <td class="brtd">${brrlist.borrowdate }</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</body>
</html>


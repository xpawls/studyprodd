<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 관리 페이지</title>
    <link rel="stylesheet" type="text/css" href="/resources/stylesheet/bookcss.css">
    <style type="text/css">
        /* header */
        header input { width: 100px; height: 50px; text-align: center; }

        #mainaside { float: left; width: 300px; height: 700px; border: 1px solid black; }
        #renttableS { width: 290px; }

        /* body */
        #mainbody { float: left; width: 800px; height: 700px; }
        #maintab>li { display: inline-block; background-color: grey; }
        #renttableS td { border: 1px solid grey; }
        .label { width: 80px; height: auto; margin: 1px; }
        label>input { float: left; margin: 5px;}
        #bpgtool { clear: both; margin: 10px; }

        /* bookpage */
        #mainbody>div>label { display: block; margin: 10px; }
        #mainbody { border: 1px black solid; }
        .maintabpage { background-color: skyblue; height: 645px; }
        .maintable { width: 790px; }
        .maintable, .maintable td{ border: 1px solid black; }
        .tablehover { background-color: lightgreen;}

    </style>
    <script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#mainbody>div').hide();
            $('#bookpage').show();
            $('#maintab>li').click(function(event) {
                $('#mainbody>div').hide();
                var name = $(this).children('a').attr('name');
                $(name).show();
            });
            $('#newbook').click(function(event) {
            	window.open('newbook', 'width=300px,height=300px', '_blank');
            });
            
            $('#bsbtn').click(function(event) {
            	$('#bsrhform').submit();
            	
            });
            
            $('#maintable td').mouseover(function() {
            	$(this).parent('tr').children('td').addClass('tablehover');
            });
            $('#maintable td').mouseout(function() {
                $('#maintable').find('td').removeClass('tablehover');
            });
        });
    </script>
</head>
<body>
    <header>
        <div>
            <input type="button" name="joinmember" value="회원가입">
            <input type="button" name="newbook" value="도서등록" id="newbook">
            <input type="button" name="refresh" value="새로고침">
            <input type="button" name="exit" value="종료">
            <hr>
        </div>
    </header>
    <aside id="mainaside">
        <table id="renttableS">
            <tbody>
                <tr>
                <td>이름</td>
                <td>책제목</td>
                <td>대여날짜</td>
            </tr>
            <tr>

            </tr>
            </tbody>

        </table>
    </aside>
    <div id="mainbody">
        <ul id="maintab">
            <li><a href="#" name="#bookpage">도서</a></li>
            <li><a href="#" name="#memberpage">회원</a></li>
            <li>대여목록</li>
        </ul>
        <div id="bookpage" class="maintabpage">
            <label><p class="label">책제목</p><input type="text" name="bookname"></label>
            <label><p class="label">장 르</p><input type="text" name="category"></label>
            <label><p class="label">작 가</p><input type="text" name="author"></label>
            <label><p class="label">출판사</p><input type="text" name="publisher"></label>
            <label><p class="label">가 격</p><input type="text" name="price"></label>
            <div id="bpgtool">
                <select>
                    <option value="no">번호</option>
                    <option value="bookname">제목</option>
                    <option value="publisher">출판사</option>
                    <option value="author">작가</option>
                </select>
                <form action="bseach" method="post" id="bsrhform">
                <input type="text" name="searchtext" id="searchtext">
                </form>
                <input type="button" name="searchbook" value="검색" id="bsbtn">
                <input type="button" name="modifybook" value="수정">
                <input type="button" name="deletebook" value="삭제">
                <input type="button" name="rentbook" value="대여">
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
                <c:forEach var="booklist" items="${list }" varStatus="ind">
                <tr>
                        <td>${booklist.no }</td>
                        <td>${booklist.bookname }</td>
                        <td>${booklist.category }</td>
                        <td>${booklist.author }</td>
                        <td>${booklist.publisher }</td>
                        <td>${booklist.price }</td>
                        <td>${booklist.borrow_yn }</td>
                    </tr>
                </c:forEach>
                    
                </tbody>
            </table>
        </div>
        <div id="memberpage" class="maintabpage">
            <label><p class="label">이름  </p> <input type="text" name="bookname"></label>
            <label><p class="label">주민번호</p><input type="text" name="category"></label>
            <label><p class="label">전화번호</p><input type="text" name="author"></label>
            <label><p class="label">메일주소</p><input type="text" name="publisher"></label>
        </div>
        <div id="rentpage" class="maintabpage"></div>
    </div>
</body>
</html>


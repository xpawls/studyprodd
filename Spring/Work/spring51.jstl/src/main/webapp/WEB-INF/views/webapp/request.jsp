<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta name="view-port"
    content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<title>Mobile Project</title>
<link rel="apple-touch-icon-precomposed" sizes="114x114"
    href="${pageContext.request.contextPath}/resources/images/app_icon.png" />
<link rel="apple-touch-icon-precomposed"
    href="${pageContext.request.contextPath}/resources/images/app_icon.png" />
<!-- <link href="stucss.css" rel="stylesheet" type="text/css"/> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/stylesheet/common.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"  ></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"  ></script>
<script type="text/javascript">
        $(document).ready(function() {
            $('.btn_send').click(function(event) {
                var inp = $('input.req_input');
                for (var i = 0; i < inp.length; i++) {
                    var com = $(inp[i]).val();
                    if(com===""){
                        alert($(inp[i]).attr('name')+'을(를) 입력해주세요.');
                        inp[i].focus();
                        break;
                    }
                }
            });

        });
    </script>
</head>

<body>
<section id="page1" data-role="page">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content" data-role="content">
        <div class="s_main">
            <h2 class="sub_tit helv bold">REQUEST(폼 유효성 검사)</h2>
            <span class="m_tit bold">궁금하세요? 질문해주세요.</span>
            <form id="frm_request" action="" method="post" enctype="application/x-www-form-urlencoded">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="req_box">
                    <colgroup>
                        <col width="60px" />
                        <col />
                    </colgroup>
                    <tr>
                        <th>작성자</th>
                        <td>
                            <input name="name" type="text" class="req_input">
                        </td>
                    </tr>
                    <tr>
                        <th>E-mail</th>
                        <td>
                            <input name="email" type="email" class="req_input">
                        </td>
                    </tr>
                    <tr>
                        <th>연락처</th>
                        <td>
                            <input name="phone" type="tel" class="req_input">
                        </td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            <input name="addr" type="search" class="req_input">
                        </td>
                    </tr>
                    <tr>
                        <th>나이</th>
                        <td>
                            <input name="age" type="number" class="req_input">
                        </td>
                    </tr>
                    <tr>
                        <th>비밀번호</th>
                        <td>
                            <input name="pwd" type="password" class="req_input">
                        </td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td>
                            <input name="title" type=""  class="req_input">
                        </td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea name="content" cols="" rows="" class="req_long"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="btn_center">
                            <input type="button" class="btn_send" value="SEND" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>


    <jsp:include page="footer.jsp"></jsp:include>
</section>
</body>
</html>
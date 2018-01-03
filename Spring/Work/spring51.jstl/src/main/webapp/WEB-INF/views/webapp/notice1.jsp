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
</head>

<body>
<section id="page1" data-role="page">
    <jsp:include page="header.jsp"></jsp:include>
    <div data-role="content">
        <div class="s_main">
            <h2 class="sub_tit helv bold">NOTICE</h2>
            <span class="m_tit bold">모바일웹 공지사항입니다.</span>
            <ul class="pr_list">
                <li><a href="notice2" class="pr_link"><strong>&lt;어비 모바일&gt; 출간!!</strong><span class="pr_date verd">2011.10.03</span></a></li>
                <li><a href="notice2" class="pr_link"><strong>함께 즐기는 공부 모임 탄생!</strong><span class="pr_date verd">2011.10.03</span></a></li>
                <li><a href="notice2" class="pr_link"><strong>최고의 공부 공유자</strong><span class="pr_date verd">2011.10.03</span></a></li>
                <li><a href="notice2" class="pr_link"><strong>웹표준과 모바일의 관계</strong><span class="pr_date verd">2011.10.03</span></a></li>
                <li><a href="notice2" class="pr_link"><strong>어비와 송태민</strong><span class="pr_date verd">2011.10.03</span></a></li>
            </ul>
            <div class="page_nav helv">
                <p class="numb">
                    <span class="now_p">1</span>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                </p>
                <a class="next_p" href="#"><em>다음</em></a>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</section>
</body>
</html>
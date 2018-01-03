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
    <div class="content" data-role="content">
        <div class="s_main">
            <h2 class="sub_tit helv bold">PROJECT</h2>
            <div class="m_cont">
                <span class="m_tit bold">프로젝트 리스트</span>
                <ul class="pro_list">
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_01.png" />
                            <span>Sample01</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_02.png" />
                            <span>Sample02</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_03.png" />
                            <span>Sample03</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_04.png" />
                            <span>Sample04</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_05.png" />
                            <span>Sample05</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_06.png" />
                            <span>Sample06</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_07.png" />
                            <span>Sample07</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_08.png" />
                            <span>Sample08</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_09.png" />
                            <span>Sample09</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_10.png" />
                            <span>Sample10</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_11.png" />
                            <span>Sample11</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/images/s02_thumb_12.png" />
                            <span>Sample12</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</section>
</body>
</html>
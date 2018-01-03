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
    <div data-role="content" class="content" class="m_bg">
        <div class="s_main">
            <h2 class="sub_tit helv bold">OUR STORY</h2>
            <div class="m_cont">
                배움이 있으면 반듯이 공유가 되어야 한다고 생각합니다. 모바일의 세계는 계속 발전하고 있으며 우리는 앞으로도 계속 공부를 하면서 살아야 합니다. 새로운
                기술과 트랜드를 두려움이 아닌 즐거움으로 받아 드리는 것이 인생을 즐기는 것이라고 생각합니다.
                <span class="play">
                 <video controls width="100%">
                  <!-- Safari/Chrome 브라우저일 경우, 지원하는 MP4 파일을 재생합니다 -->
                  <source src="viedo.mp4" type="video/mp4"/>
                     <!-- HTML5 video요소를 지원하지 않는 브라우저의 경우 플래시 무비를 사용합니다 -->
                  <!--img src="images/m1_02_imgx2.png" width="286" height="168"/-->
                 </video>
                </span>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</section>
</body>
</html>
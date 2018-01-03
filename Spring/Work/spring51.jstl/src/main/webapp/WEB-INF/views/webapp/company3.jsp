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
            <h2 class="sub_tit helv bold">LOCATION</h2>
            <div id="map-canvas" style="height:330px;"></div>

            <table width="100%" border="0" cellspacing="0" cellpadding="0" class="ad_box">
                <colgroup>
                    <col width="80px" />
                    <col />
                </colgroup>
                <tr>
                    <th>Address</th>
                    <td>서울시 강남구 강남대로</td>
                </tr>
                <tr>
                    <th>Tel</th>
                    <td>
                        <span class="tab_text">02.1234.5678</span>
                        <input type="button" class="btn_base btn_tel" value="통화하기" onClick="location.href='tel:0212345678';" />
                    </td>
                </tr>
                <tr>
                    <th>E-mail</th>
                    <td>
                        <span class="tab_text">aaa@aa.co.kr</span>
                        <input type="button" class="btn_base btn_email" value="이메일 보내기" onClick="location.href='mailto:aaa@aa.co.kr';" />
                    </td>
                </tr>
            </table>
        </div>
    </div>
    <script type="text/javascript">
        function mapf(){
            var cen = new google.maps.LatLng(37.497078, 127.028582);
            var mapOptions = {
                zoom: 17,
                center: cen,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var marker = new google.maps.Marker({
                position : cen,
                map : map
            });
            var map = new google.maps.Map(document.getElementById('map-canvas'),mapOptions);
        }

    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBbK-fOCX49nf6afO8ZOxeCaQTi3ZUraVw&callback=mapf"></script>

    <jsp:include page="footer.jsp"></jsp:include>
</section>
</body>
</html>
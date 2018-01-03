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
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/stylesheet/common.css">
<script type="text/javascript"
    src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('dd').hide();
		$('dl.rec_list>dt').click(function(event) {
			var re = $(this).nextAll();
			for (var i = 0; i < re.length; i++) {
				if (re[i].tagName.toUpperCase() === 'DD') {
					$(re[i]).slideToggle();
				} else {
					break;
				}
			}

		});
	});
</script>
</head>

<body>
    <section id="page1" data-role="page"> <jsp:include
        page="header.jsp"></jsp:include>
    <div class="content" data-role="content">
        <div class="s_main">
            <h2 class="sub_tit helv bold">RECRUIT(아코디언효과)</h2>
            <div class="m_cont">
                <dl class="rec_list">
                    <dt>PASSION</dt>
                    <dd>자기가 하는 모든 일을 적극적으로 열심히 수행하는 사람</dd>
                    <dd>일에 대해 몰입할 수 있는 사람</dd>
                    <dd>인터넷 관련 분야에 관심이 많고 이 분야를 발전시키는 일에 재미와 보람을
                        느끼는 사람</dd>

                    <dt>CREATIVITY</dt>
                    <dd>새로운 아이디어를 창출해 낼 수 있는 능력을 갖춘 사람</dd>
                    <dd>기존 서비스의 틀에 얽매이지 않고 사고할 수 있는 사람</dd>
                    <dd>서비스, User interface, 디자인, 기술 등이 창의적인 사람</dd>

                    <dt>INNOVATION</dt>
                    <dd>어떤 일이든지 새로운 분야와 새로운 방식을 찾아서 더 좋은 방향으로 해결하려고
                        하는 사람</dd>
                    <dd>급변하는 인터넷 산업에 빠르고 능동적으로 대처할 수 있는 사람</dd>
                </dl>
            </div>
        </div>
    </div>


    <jsp:include page="footer.jsp"></jsp:include> </section>
</body>
</html>
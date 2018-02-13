<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<!-- <link rel="stylesheet" type="text/css" -->
<!--     href="/resources/stylesheet/bookcss.css"> -->
<style type="text/css">
/* header */
div.nblabel {
    width: 100px;
    height: auto;
}
</style>
<link rel="stylesheet" type="text/css"
    href="/resources/stylesheet/bookcss.css">
<script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resources/js/bookjs.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		
		$('#submit').click(function(e){
			var input = $('.jmip');
			for(var i=0; i<input.length; i++){
				if($(input[i]).val()===''){
					$('.jmip').next('label').remove();
					$(input[i]).after('<label>입력하세요</label>');
					return false;
				}
			}

            

            
		});
	});
	
</script>
</head>
<body>
    
    <jsp:include page="header.jsp"></jsp:include>
    <jsp:include page="aside.jsp"></jsp:include>
    <div id="container">
    <form action="/bmgr/modifymember" method="post" enctype="application/x-www-form-urlencoded" id="joinform">
        <input type="hidden" value="${user.memID }">
        <div class="nblabel">이름</div><input name="memName" type="text" class="jmip" value="${user.memName }"><br> 
            <div class="nblabel">주민번호</div><input name="memPriNum1" type="text" class="jmip" value="${memPriNum1 }">-
            <input name="memPriNum2" type="password" class="jmip" value="${memPriNum2 }"><br>
             <div class="nblabel">전화번호</div>
             <input name="memPhone1" type="text"  class="jmip" value="${memPhone1 }">-
             <input name="memPhone2" type="text" class="jmip" value="${memPhone2 }">-
             <input name="memPhone3" type="text"  class="jmip" value="${memPhone3 }"><br>
        <div class="nblabel">이메일</div><input name="memEmail" type="text" class="jmip" value="${user.memEmail }"><br> 
             <input
            id="submit" type="submit" value="등록">
    </form>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>


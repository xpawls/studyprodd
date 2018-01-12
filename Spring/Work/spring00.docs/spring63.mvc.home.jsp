<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <p>  The time on the server is ${serverTime}. </p>
      

    <h2> HomeController </h2> 
    <a href="spring/helloworld" target="_blank">/spring/helloworld</a> <br />
    <a href="spring/sayhello" target="_blank">/spring/sayhello</a> <br />  
    <hr />
    
    <a href="spring/redirect" target="_blank">/spring/helloworld redirect 테스트</a> <br />
    <a href="spring/forward" target="_blank">/spring/helloworld forward 테스트</a> <br />
    <hr>
    
    <a href="spring/querystring?name=test&phone=1244" target="_blank">/spring/querystring?name=test&phone=1244</a> <br />
    <a href="spring/pathvalue/test" target="_blank">/spring/pathvalue/test</a> <br />
    <a href="spring/pathvalue/test/1244" target="_blank">/spring/pathvalue/test/1244</a> <br />
    <hr />
    
    <a href="spring/login" target="_blank">@RequestParam 을 이용한 /spring/login</a> <br /> 
    <hr>
    
    <a href="spring/loginmodel" target="_blank">@ModelAttribute 를 이용한 /spring/login</a> <br /> 
    <hr>
   
        
</body>
</html>

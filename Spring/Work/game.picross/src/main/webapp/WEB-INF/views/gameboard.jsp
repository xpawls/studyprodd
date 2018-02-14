<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>game</title>
    <style type="text/css">
        .block {
            width: 172px;
            height: 162px;
        }
        #gamebox td {
            border: 1px grey solid; 
         }
         td {
            width: 30px;
            height: 30px;
            padding: 0px;
            text-align: center;
         }
         #gamebox td:hover {
            background: aqua;
         }
         
         #gamebox td:active {
            background: navy;
         }
         #dummy {
            float: left;
         }
         #topbar {
            float: left;
         }
         #topbar td {
            border-left: solid grey 1px;
            border-right: solid grey 1px;
         }
         #leftbar {
            clear: both;
            float: left;
         }
         
         #leftbar td {
            border-top: solid grey 1px;
            border-bottom: solid grey 1px;
         }
         #gamebox {
            float: left;
         }
         .selec {
            background: orange;
         }
    </style>
    <script type="text/javascript" src="/resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
    $(document).ready(function(e){
    	$('#gamebox td').click(function(e){
    		if($(this).hasClass('selec')){
    			$(this).removeClass('selec');
    		}
    		else{
    			$(this).addClass('selec');
    		}
    		
    		var ans = $('.ans');
    		var count = 0;
    		for(var i=0; i<ans.length; i++){
    			if($(ans[i]).hasClass('selec')){
    				count++;
    			}
    			if(count==ans.length){
    				alert('clear!');
    			}
    		}
    		
    	});
    });
    </script>
</head>
<body>
<h1>
	stage1
</h1>
<div class="block" id="dummy"></div>

<!-- 상위 바 -->
<table class="block" id="topbar">
    <tbody>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>

<!-- 왼쪽 바 -->
<table class="block" id="leftbar">
    <tbody>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>
<table class="block" id="gamebox">
    <tbody>
        <tr>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
        </tr>
        <tr>
            <td></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td class="ans"></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td></td>
        </tr>
        <tr>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
            <td class="ans"></td>
        </tr>
    </tbody>
</table>
</body>
</html>

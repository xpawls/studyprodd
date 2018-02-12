<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>글 수정</title>
    <link rel="stylesheet" type="text/css"
    href="/resources/stylesheet/bookcss.css">

    
    <style type="text/css">
        .portfolio { width: 555px; margin-left: 292.500px;}
        table {  width: 555px;}
        table tr {background: #36CBD4; }
        table td { text-align: center;}
        .sthead {  border-top: solid, 2px, black;  border-bottom: solid, 2px, black; }
        
        #qnatexta { width: 550px;}
        
         #texta { width: 550px;}
    </style>
     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script type="text/javascript">
    var goList = function() {
        location.href = "/bmgr/bookboardview/${boardcd}?searchWord=${searchWord}&curPage=${curPage}";
                
    };

    </script>
    
  </head>
  <body>
    
      <%@ include file="header.jsp"%>
      <%@ include file="aside.jsp"%>
    
    
    
    <div class="portfolio">
        <div class="container">
            <div id="container">
            <div id="content" style="min-height: 800px;">
                <div id="url-navi">BBS</div>

                <!-- 본문 시작 -->
                <div id="bbs">
                    <h2>${boardcd }</h2>
                    
                    <form id="modifyForm" action="${actionurl }" method="post" enctype="multipart/form-data" >
                        <h2>
                        <input type="hidden" name="boardcd" value="${boardcd }">
                        </h2>
                        <p style="margin: 0; padding: 0;">
                            <input type="hidden" name="bno" value="${bno }" />
                            <input type="hidden" name="curPage" value="${curPage }" />
                            <input type="hidden" name="searchWord" value="${searchWord }" />
                        </p>
                        <table id="write-form">
                            <tr>
                                <td>제목</td>
                                <td><input type="text" name="title" size="50"
                                    value="${thisBoard.title }" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><textarea name="content" rows="17" id="texta">${thisBoard.content }</textarea>
                                </td>
                            </tr>
                            
                        </table>
                        <div style="text-align: center; padding-bottom: 15px;">
                            <input type="submit" value="전송" /> 
                            <input type="button" value="상세보기" onclick="goView()" /> 
                            <input type="button" value="목록" onclick="goList()" />
                        </div>
                    </form>
                </div>
                <!--  본문 끝 -->

            </div>
            <!-- content 끝 -->
            
        </div>
        <!--  container 끝 -->
                    
        </div>
    </div>
   
    
    
      <%@ include file="footer.jsp"%>
    
   
  </body>
</html>
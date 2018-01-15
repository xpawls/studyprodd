<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="Keywords" content="회원 가입" />
    <meta name="Description" content="회원 가입" />
    <title>회원 가입</title>
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" />
            
</head>
<body>

<div id="wrap">

    <div id="container">
        <div id="content" style="min-height: 800px;">

            <!-- 본문 시작 -->
            <div id="url-navi">회원</div>
            
            <h1>회원 가입</h1>
            <form id="signUpForm" action="register" method="post" >
                <table>
                    <tr>
                        <td style="width: 200px;">사용자 아이디</td>
                        <td style="width: 390px">
                            <input type="text" name="userid" style="width: 70%;" id="userid" />
                            <input type="button" value="아이디 중복 조회" id="checkuserid"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 200px;">이름(Full Name)</td>
                        <td style="width: 390px"><input type="text" name="name" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>비밀번호(Password)</td>
                        <td><input type="password" name="passwd" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>비밀번호 확인(Confirm)</td>
                        <td><input type="password" name="confirm" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                    <tr>
                        <td>이동전화(Mobile)</td>
                        <td><input type="text" name="mobile" style="width: 99%;" disabled="disabled" /></td>
                    </tr>
                </table>
                <div style="text-align: center;padding-bottom: 15px;">
                    <input type="submit" value="확인" />
                </div>
            </form>
            <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
   
</div>

</body>
</html>

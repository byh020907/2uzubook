<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../CSS/register-style.css">
</head>
<body>
    <div class="register-wrap">
        <h1> Register</h1>
        <div class="box1">
        	<form action="/2uzubook/joinAction" method="post">
            <input type="text" placeholder="Name" name="name" />
            <input type="text" placeholder="학번 (ex.10101)" name="student_id"/>
            <br>
             <select name="gender">
            	<option selected="selected">성별</option>
            	<option value="male">남자</option>
            	<option value="female">여자</option>
            </select>
            <select name="major">
            	<option selected="selected">학과 선택</option>
            	<option value="공통과">공통과</option>
            	<option value="소프트웨어 개발과">소프트웨어 개발과</option>
            	<option value="임베디드 개발과">임베디드 개발과</option>
            	<option value="정보보안과">정보보안과</option>
            </select>
            <input type="text" placeholder="New Id" name="id"/>
            <input type="text" placeholder="New Password" name="password"/>
            <p font-size="5px">4~12자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다.</p>
            <input type="text" placeholder="Comfirm Password" name="comfirm_password"/>
            <input type="text" placeholder="Email" name="email"/>
            <button type="submit">Join</button>
            </form>
        
        </div>
    </div>




</body>
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
        	<form action="JoinAction" method="post">
            <input type="text" placeholder="Name" name="name" />
            <input type="text" placeholder="Serial" name="serial"/>
            <input type="text" placeholder="New Id" name="id"/>
            <input type="text" placeholder="New Password" name="np"/>
            <p font-size="5px">4~12자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다.</p>
            <input type="text" placeholder="Comfirm Password" name="cp"/>
            <input type="text" placeholder="Email" name="email"/>
            <button type="submit">Join</button>
            </form>
        
        </div>
    </div>




</body>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../CSS/login-style.css">
</head>
<body>
    <div class="login-wrap">
    <h1>Login</h1>
    <ul style="list-style-type:none">
        <li class="one" style="display:inline">Student</li>
        <li style="display:inline">Company</li>
        
        </ul>
        <div class="form" style="float:left;">
        <form action="loginAction.jsp" method="post">
        <input type="text" placeholder="Username" name="un" />
        <input type="password" placeholder="Password" name="pw" />
        <button type="submit"> Sign in </button>
        </form>
        <a href="#"> <p> Don't have an account? Register </p></a>
        </div>
    <div class="form2" style="float:left; ">
        <form action="loginAction.jsp" method="post">
        <input type="text" placeholder="Serial" name="sn"/>
        <button type="submit"> Sign in </button>
        </form>
        <a href="#"> <p> Don't have an Serial?</p></a>
        </div>
</div>

</body>
</html>
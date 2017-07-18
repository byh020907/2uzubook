<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
     <link rel="stylesheet" type="text/css" href="../CSS/search.css">   
 <link rel="stylesheet" type="text/css" href="../CSS/input2.css">
 
</head>
<body>
        
<!-- Nav -->
<nav id="nav">
    <ul>
        <li class="one"><a href="index.jsp">Home</a></li>
        <li class="one"><a href="index.jsp">Resume</a>
    <ul>
        <li><a href="#">1학년 resume &hellip;</a>
    <ul>
        <li><a href="first-common.jsp">공통과</a></li>
    </ul></li>
        <li><a href="#">2학년 resume &hellip;</a>
    <ul>
        <li><a href="second-software.jsp">소프트웨어 개발과</a></li>
        <li><a href="second-embeded.jsp">임베디드 개발과</a></li>
        <li><a href="second-security.jsp">정보보안과</a></li>
    </ul>
    </li>
        <li><a href="#">3학년 resume &hellip;</a>
    <ul>
        <li><a href="third-software.jsp">소프트웨어 개발과</a></li>
        <li><a href="third-embeded.jsp">임베디드 개발과</a></li>
        <li><a href="third-security.jsp">정보보안과</a></li>
    </ul></li>
										
    </ul>
    </li>
								
        <li class="one"><a href="no-sidebar.jsp">Login</a></li>
    </ul>
</nav>


<center>
    <p class="p1 one">2uzuBook</p>
    <ul class="ul1">
    <li class="li1" ><input type=text class="searchbox" size="50"></li>
    <li class="li1"><button class="box"><img src="../Image/Search/temp.png" class="img1"></button></li>
    </ul>
    <div class="rul">
    <br>
    <br>
    <br>
    <a onclick="this.nextSibling.style.display=(this.nextSibling.style.display=='none')?'block':'none';" href="javascript:void(0)">
    <button type="button" class="box2">고급 검색</button>
    </a><div style="DISPLAY: none">
    학년
    <label><input type="radio" name='grade1' value='grade'>1학년</label>
    <label><input type="radio" name='grade2' value='grade'>2학년</label>
    <label><input type="radio" name='grade3' value='grade'>3학년</label>
    <br>
    성별
    <label><input type="radio" value='sex1'>여자</label>
    <label><input type="radio" value='sex2'>남자</label>
    <br>
    지역
    <select name="dd">
        <option value="em">없음</option>
        <option value="Daejeon">대전</option>
        <option value="Seoul">서울</option>
        <option value="b">부산</option>
        <option value="en">인천</option>
    </select>
    <br>
    언어
    <select name="ss">
        <option value="java">java</option>
        <option value="c">c</option>
        <option value="ru">ruby</option>
        <option value="python">python</option>
    
    </select>
    <br>
    <a onclick="this.parentNode.style.display='none';" href="javascript:void(0)">
        <button type="button">접기</button>
    </a></div>  
    </div>
</center>
    
</body>
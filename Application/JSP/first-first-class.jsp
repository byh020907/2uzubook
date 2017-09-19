<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.ArrayList"%>
<%!
	class Student
	{
		String name;
		String oneline;
		String StuImg;
		Student(String name,String oneline,String StuImg)
		{
			this.name =name;
			this.oneline=oneline;
			this.StuImg=StuImg;
		}
	}
%>
<%
	request.setCharacterEncoding("UTF-8");
	JSONArray jsonArray = (JSONArray) request.getAttribute("JSONArray");
	System.out.println(jsonArray);

	
	ArrayList<Student> students = new ArrayList<Student>();
	
	for (int i = 0; i < jsonArray.size(); i++) {
		JSONObject jobj = (JSONObject) jsonArray.get(i);
		students.add(new Student((String) jobj.get("name"),(String)jobj.get("oneline"),(String)jobj.get("StuImg")));
	}	
%>
<!DOCTYPE HTML>
<html>
<head>
<title>FirstGrade</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="../JS/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="/2uzubook/CSS/main.css" />
<link rel="stylesheet" href="/2uzubook/CSS/Classroom.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="../CSS/ie8.css" /><![endif]-->
</head>
<style>
#element {
	display: inline-block;
	margin: 0px 10px 30px 10px;
}

#image {
	width: 100px;
	height: 130px;
}
</style>
<body class="right-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header">

			<!-- Inner -->
			<div class="inner">
				<header>
					<h1>
						<a href="index.jsp" id="logo">1학년 1반</a>
					</h1>
				</header>
			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="index.jsp">Resume</a>
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
								</ul></li>
							<li><a href="#">3학년 resume &hellip;</a>
								<ul>
									<li><a href="third-software.jsp">소프트웨어 개발과</a></li>
									<li><a href="third-embeded.jsp">임베디드 개발과</a></li>
									<li><a href="third-security.jsp">정보보안과</a></li>
								</ul></li>

						</ul></li>
					<li><a href="resume_input.jsp">Resume Write</a></li>
				</ul>
			</nav>

		</div>

		<!-- Main -->
		<div class="wrapper style1">

			<div id="container" class="container" style="text-align: center">
			
			<div id="con1">
			<%
			for(int i=1;i<21;i++)
			{
				%>
				<img src="<%=students.get(i-1).StuImg.replaceAll(" ", "\") %>" id="image" border="1"/>
					<a><%=students.get(i-1).name%></a>
					<%=students.get(i-1).oneline%> 
				
			<% 
				if(i%3==0)
				{
			%>
					<br clear=left>
			<%
				}
			}%>	
			
			</div>
			</div>
		</div>

		
		

	</div>

	<div>
		<!-- Footer -->

	</div>

	<!-- Scripts -->
	<script src="/2uzubook/JS/js/jquery.min.js"></script>
	<script src="/2uzubook/JS/js/jquery.dropotron.min.js"></script>
	<script src="/2uzubook/JS/js/jquery.scrolly.min.js"></script>
	<script src="/2uzubook/JS/js/jquery.onvisible.min.js"></script>
	<script src="/2uzubook/JS/js/skel.min.js"></script>
	<script src="/2uzubook/JS/js/util.js"></script>
	<!--[if lte IE 8]><script src="/2uzubook/JS/js/ie/respond.min.js"></script><![endif]-->
	<script src="/2uzubook/JS/js/main.js"></script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.*"%>

<%
		request.setCharacterEncoding("UTF-8");
		JSONArray jsonArray = (JSONArray) request.getAttribute("JSONArray");
		JSONArray keywordArray = (JSONArray) request.getAttribute("keyword");
		System.out.println(jsonArray+"//"+keywordArray);
%>
<!DOCTYPE HTML>
<html>
<head>
<title>2UZUBOOK DSM</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
</head>

<body class="left-sidebar">
	<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Inner -->
			<div class="inner">
				<header>
					<h1>
						<a href="index.jsp" id="logo">DSM 2UZUBOOK</a>
					</h1>
				</header>
			</div>
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="login.html">로그인 / 회원가입</a></li>
					<li><a href="#">For Student</a>
						<ul>
							<li><a href="myresume.jsp">내 레주메 보기</a></li>
							<li><a href="myresume_manage.html">레주메 내용 관리</a></li>
						</ul></li>
					<li><a href="#">For Company</a>
						<ul>
							<li><a href="search.html">학생 찾기</a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
		<!-- Main -->
		<div class="wrapper style1">
			<div class="container">
				<div class="row 200%">
					<div class="3u 12u(mobile)" id="sidebar">
						<hr class="first" />
						<section>
							<header>
								<h3>내가 찾는 인재들</h3>
							</header>
                            
						</section>
                        
						<hr />
						<form id="print_form" method="post" action="/2uzubook/printAction"></form>
                        <footer> <a href="" class="button" onclick="go_print()"> 전체 레주메 인쇄</a> </footer>
					</div>
					<div class="9u 12u(mobile) important(mobile)" id="content">
						<article id="main">
							<header>
								<h2>Search Result</h2>
								<p>
									<strong>검색어 : </strong>
										<%
										for(int j=0;j<keywordArray.size();j++)
										{
										%>
											<%=(String)keywordArray.get(j)%> , 
										<% 
										}
										%>
								</p>
							</header>
							<div class="row">
							<%
								for(int i=0;i<jsonArray.size();i++)
								{
									JSONObject object=(JSONObject)jsonArray.get(i);
								%>
									<div class="6u 12u(mobile)">
										<div class="row"
											OnClick="location.href=''" style="cursor: pointer;">
											<div class="4u">
												<a href="/2uzubook/SeeStudentResume?id="+data[i].id+ class="image fit"><img src="images/student/stu2.jpg"
													alt="" /></a>'<header><h3><a href="/2uzubook/SeeStudentResume?id='+data[i].id+'"">'
									+ data[i].name + '</a></h3></header>'
											</div>
											<div class="8u">
												<h3 class="text-center"><%=object.get("stu_id")%> <%=object.get("name")%></h3>
													<%
													for(int j=0;j<keywordArray.size();j++)
													{
													%>
														<%=(String)keywordArray.get(j)%> , 
													<% 
													}
													%>
											</div>
										</div>
									</div>
								<% 	
								}
							%>
								
								
							</div>
						</article>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<div id="footer">
			<div class="container">
				<div class="row">
					<div class="12u">

						<!-- Contact -->
						<section class="contact">
							<header>
								<h3>2UZUBOOK 학생과 기업을 이어주는 책</h3>
							</header>
							<p>대덕소프트웨마이스터고등학교 34111)대전광역시 유성구 가정북로 76(장동 23-9) 교무실 ☎ :
								042-866-8822</p>
							<ul class="icons">
								<li><a href="#" class="icon fa-facebook"><span
										class="label">Facebook</span></a></li>
								<li><a href="#" class="icon fa-github"><span
										class="label">Twitter</span></a></li>
							</ul>
						</section>

						<!-- Copyright -->
						<div class="copyright">
							<ul class="menu">
								<li>&copy; DSM 2UZUBOOK. All rights reserved.</li>
							</ul>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- Scripts -->
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.dropotron.min.js"></script>
	<script src="js/jquery.scrolly.min.js"></script>
	<script src="js/jquery.onvisible.min.js"></script>
	<script src="js/skel.min.js"></script>
	<script src="js/util.js"></script>
	<!--[if lte IE 8]><script src="js/ie/respond.min.js"></script><![endif]-->
	<script src="js/main.js"></script>
	<script>
	function go_print()
	{
		$("print_form").submit();
	}
	</script>
</body>

</html>
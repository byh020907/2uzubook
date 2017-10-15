<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = (String) session.getAttribute("id");
	String serialKey = (String) session.getAttribute("serialKey");
	System.out.println(id);
%>
<%
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
					<li><a href="index.jsp">Home</a></li>
					<li id="login_status">
						<%
							if (id == null && serialKey==null) {
						%><a href="login.jsp">로그인 / 회원가입</a> <%
							} else {
						%><a href="logoutAction">로그아웃</a> <%
							}
						%>
					</li>
					<li><a href="#">For Student</a>
						<ul>
						<%
							if(id==null){
						%>
						<li><a href="login.jsp">내 레주메 보기</a></li>	
						<li><a href="login.jsp">레주메 내용 관리</a></li>	
						<%
						}else{
						%>
						<li><form action="/2uzubook/myresume" method="post" id="frm1"><a href="#" onClick="go();">내 레주메 보기</a></form></li>	
						<li><a href="myresume_manage.html">레주메 내용 관리</a></li>
						<%} %>
						</ul></li>
					<li><a href="#">For Company</a>
						<ul>
						<%if(serialKey==null){ %>
							<li><a onclick="com_alert();" href="login.jsp">학생찾기</a></li>	
						<%} else{%>
							<li><a href="search.jsp">학생 찾기</a></li>
						<%} %>
						</ul>
					</li>
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
						<form id="print_form" method="post" action="/2uzubook/printAction">
								<input type="hidden" value="" name="jsonArray"/>
						</form>
                        <footer> <a class="button" onclick="go_print();"> 전체 레주메 인쇄</a> </footer>
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
									<div class="6u 12u(mobile)" OnClick="location.href='/2uzubook/SeeStudentResume?id=<%=object.get("id")%>'">
										<div class="row" style="cursor: pointer;">
											<div class="4u">
												<a class="image fit"><img src="images/student/stu2.jpg"
													alt="" /></a>
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
								<li><a href="https://www.facebook.com/%EB%8C%80%EB%8D%95%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4%EB%A7%88%EC%9D%B4%EC%8A%A4%ED%84%B0%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90-463920667081098/" class="icon fa-facebook"><span
										class="label">Facebook</span></a></li>
								<li><a href="https://github.com/DSM-HS/StudentCouncil" class="icon fa-github"><span
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
	$(document).ready(function() {
		var json = <%=jsonArray%>;
		$('#print_form input').val(JSON.stringify(json));
	});
	function go_print()
	{
		$('#print_form').submit();
	}
	function go() {
        var frm = document.getElementById('frm1');
        console.log('hel');
        frm.submit();
    }
	</script>
</body>

</html>
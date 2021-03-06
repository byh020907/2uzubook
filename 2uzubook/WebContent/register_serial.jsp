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
						<li><a href="myresume_manage.jsp">레주메 내용 관리</a></li>
						<li><form action="/2uzubook/OneInput" method="post" id="oneInput"></form><a href="#" onClick="input_go()">한번에 입력하기</a></li>
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
								<h3>시리얼코드 요청하기</h3>
							</header>
						</section>
						<hr />
					</div>
					<div class="9u 12u(mobile) important(mobile)" id="content">
						<article id="main">
							<header>
								<h2>
									<a href="#">Serial Code</a>
								</h2>
								<p>학생들의 레주메를 보려면 학교측에서 시리얼 코드를 부여받아야 합니다.</p>
							</header>
							<div class="row">
								<div class="10u 12u(mobile)">
									<h3 class="text-center mb-3">학생 정보 입력</h3>
									<div class="row">
										<div class="10u form1">
											<form action="/2uzubook/joinAction/company" method="post"
												style="margin-top: 20px;">
												<div class="form-group">
													<label class="col-md-4 control-label" for="CompanyName">회사
														이름</label>
													<div class="col-md-4">
														<input id="CompanyName" name="CompanyName" type="text"
															placeholder="" class="form-control input-md" required="">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-4 control-label" for="CompanyEmail">E-Mail
														Address (이메일 주소로 시리얼 코드를 보내드립니다.)</label>
													<div class="col-md-4">
														<input id="CompanyEmail" name="CompanyEmail" type="text"
															placeholder="" class="form-control input-md" required="">
													</div>
												</div>
												<!-- Button -->
												<div class="form-group">
													<label class="col-md-4 control-label" for="Submit"></label>
													<div class="col-md-4">
														<button id="Submit" name="Submit" class="btn btn-primary">요청하기</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
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
	 function go() {
         var frm = document.getElementById('frm1');
         console.log('hel');
         frm.submit();
     }
	 function input_go(){
			var frm=$('#oneInput');
			console.log('hel');
			frm.submit();
		}
	</script>
</body>

</html>
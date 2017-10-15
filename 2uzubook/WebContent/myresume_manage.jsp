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
						<li><form action="/2uzubook/myresume" method="post" id="frm1"><a href="#" onClick="go2();">내 레주메 보기</a></form></li>	
						<li><a href="myresume_manage.jsp">레주메 내용 관리</a></li>
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
								<h3>레주메 작성하기</h3>
							</header>
						</section>
						<hr />
					</div>
					<div class="9u 12u(mobile) important(mobile)" id="content">
						<article id="main">
							<header>
								<h2>Resume</h2>
								<p>자신의 개발 활동을 기록해서 기업에게 보여주세요! 확실하고 솔직하게 자신을 나타낼 수 있도록 정성스럽게
									적어주세요.</p>
							</header>
							<div class="row">
								<div class="6u 12u(mobile)">
									<div class="row" id="modal_pop" Onclick="go(1);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img
												src="images/student/license2.png" alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">자격증</h3>
											IT 관련 분야의 자격증
										</div>
									</div>
                                </div>
                                <div class="6u 12u(mobile)">
									<div class="row" id="modal_pop" Onclick="go(5);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img
												src="images/student/license2.png" alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">시험</h3>
											토익, TOPCIT 등
										</div>
									</div>
                                </div>
								<div class="6u 12u(mobile)">
									<div class="row" Onclick="go(2);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img
												src="images/student/trophy2.png" alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">수상경력</h3>
											대회나 공모전, 학교에서 수상한 상
										</div>
									</div>
								</div>
								<div class="6u 12u(mobile)">
									<div class="row" onClick="go(6);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img
												src="images/student/lecture.png" alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">대외참여</h3>
											대회 참여, IT관련 대외참여 경험, 컨퍼런스 같은 활동
										</div>
									</div>
								</div>
								
								<div class="6u 12u(mobile)">
									<div class="row" onClick="go(4);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img src="images/student/bulb.png"
												alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">프로젝트</h3>
											자신이 진행하거나 참여한 프로젝트
										</div>
									</div>
								</div>
								<div class="6u 12u(mobile)">
									<div class="row" onClick="go(3);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img src="images/student/circle.png"
												alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">동아리</h3>
											학교나 외부 동아리, 단체 커뮤니티 활동
										</div>
									</div>
								</div>
								<div class="6u 12u(mobile)">
									<div class="row" onClick="go(8);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img src="images/student/etc.png"
												alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">봉사</h3>
											봉사활동
										</div>
									</div>
								</div>
                                <div class="6u 12u(mobile)">
									<div class="row" onClick="go(7);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img src="images/student/etc.png"
												alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">독서</h3>
											독서활동
										</div>
									</div>
								</div>
                                 <div class="6u 12u(mobile)">
									<div class="row" onClick="go(9);" style="cursor: pointer;">
										<div class="4u">
											<a class="image fit"><img src="images/student/interest.png"
												alt="" /></a>
										</div>
										<div class="8u">
											<h3 class="text-center">관심분야</h3>
											관심분야 및 사진 추가
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
		<form method="post" action="/2uzubook/SelectResume" id="frm"></form>
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
	function button_add() 
	{
		var str=$("#license").val();
		var str2=$("#startdate").val();
		var tag='<lable>'+str+'</lable>';
		var tag1='<br>';
		var tag2='<lable>'+str2+'</lable>';
		$("#licen_name").append(tag);
		$("#licen_name").append(tag1);
		$
		
		$("#licen_date").append(tag2);
		$("#licen_date").append(tag1);
		$("#license").val('');
		$("#startdate").val('');
		
}
	function go(part)
	{
		var frm=$("#frm");
		var tag='<input type="hidden" value="'+part+'" name="part"/>';
		frm.append(tag);
		frm.submit();
		frm.empty();
	}
	function go2(){
		var frm=document.getElementById('frm1');
		console.log('hel');
		frm.submit();
	}
</script>
</body>

</html>
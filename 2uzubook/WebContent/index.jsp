<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");
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

<body class="homepage">
	<div id="page-wrapper">
		<!-- Header -->
		<div id="header">
			<!-- Inner -->
			<div class="inner">
				<header>
					<h1>
						<a href="/" id="logo">DSM 2UZUBOOK</a>
					</h1>
					<hr />
					<p>대덕 소프트웨어 마이스터고 학생들의 레주메 사이트</p>
				</header>
			</div>
			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li id="login_status">
						<%
							if (id == null) {
						%><a href="login.html">로그인 / 회원가입</a> <%
							} else {
						%><a href="logoutAction">로그아웃</a> <%
							}
						%>
					</li>
					<li><a href="#">For Student</a>
						<ul>
							<li><form action="/2uzubook/myresume" method="post" id="frm1"><a href="#" onClick="go();">내 레주메 보기</a></form></li>
							<li><a href="myresume_manage.html">레주메 내용 관리</a></li>
						</ul></li>
					<li><a href="#">For Company</a>
						<ul>
							<li><a href="search.html">학생 찾기</a></li>
							<li><a href="right-sidebar.html">시리얼 관리</a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
		<!-- Banner -->
		<section id="banner">
			<header>
				<h2>
					대덕SW마이스터고등학교 <strong>자랑스런 학생들</strong>.
				</h2>
				<p>그들이 직접 작성한 그들의 레주메들. 놀랍지만 이들은 모두 고등학생입니다.</p>
			</header>
		</section>
		<!-- Carousel -->
		<script src="js/jquery.min.js"></script>
		<section class="carousel">
			<div class="reel" id="part1">
				<script>
					function a(data) {
						for (var i = 0; i < 10; i++) {
							var $article = $('<article id="art'+i+'"></article>');
							var $a = $('<a href="#" class="image featured"><img src="/2uzubook/images/student/stu'
									+ (i + 1)
									+ '.jpg" alt="" height="235" /></a>');
							var $h = $('<header><h3><a href="#">'
									+ data[i].name + '</a></h3></header>');
							var $p = $('<p>' + data[i].major + '<br/>'
									+ data[i].student_id + '</p>');
							$('#part1').append($article);
							$('#art' + i).append($a);
							$('#art' + i).append($h);
							$('#art' + i).append($p);
						}
					}
				</script>
			</div>
		</section>
		<!-- Features -->
		<div class="wrapper style1">
			<section id="features" class="container special">
				<header>
					<h2>대덕소프트웨어마이스터고등학교</h2>
					<p>학과 소개</p>
				</header>
				<div class="row">
					<article class="4u 12u(mobile) special">
						<a href="first-common.jsp" class="image featured"><img
							src="images/debate.jpg" alt="" height="235" /></a>
						<header>
							<h3>
								<a href="#">소프트웨어과</a>
							</h3>
						</header>
						<p>SW분야 경쟁력 제고를 통한 하드웨어와 소프트웨어, 그리고 서비스 융합력이 있는 SW인재 육성을 목표로
							공통계열로 선발하여 공통 기본교육과정을 운영한 후 학생의 적성, 희망, 산업체의 수요 등을 고려하여 2학년부터
							전공학과를 선택 후 심화 과정 이수</p>
					</article>
					<article class="4u 12u(mobile) special">
						<a href="second-software.jsp" class="image featured"><img
							src="images/debate2.JPG" alt="" height="235" /></a>
						<header>
							<h3>
								<a href="#">임베디드SW과</a>
							</h3>
						</header>
						<p>SW에 대한 기본적인 이해를 바탕으로 SW 개발 도구 및 기법을 활용하여 SW분석, 설계, 구현, 시험,
							유지/보수 등의 업무를 수행할 수 있는 응용 SW 개발자 양성을 목표로 한다.</p>
					</article>
					<article class="4u 12u(mobile) special">
						<a href="third-software.jsp" class="image featured"><img
							src="images/debate3.jpg" alt="" height="235" /></a>
						<header>
							<h3>
								<a href="#">정보보안과</a>
							</h3>
						</header>
						<p>SW 및 HW에 대한 기본적인 이해를 바탕으로 임베디드SW 구현을 위한 펌웨어/OS시스템/플랫폼/응용
							SW의 개발, 시험, 유지･보수를 수행할 수 있는 임베디드SW 개발자 양성을 목표로 한다.</p>
					</article>
				</div>
			</section>
		</div>
		<!-- Main -->
		<div class="wrapper style2">
			<article id="main" class="container special">
				<a href="#" class="image featured"><img src="images/header5.jpg"
					alt="" /></a>
				<header>
					<h2>
						<a href="#">대덕소프트웨어마이스터고등학교는...</a>
					</h2>
					<p>"꿈과 열정이 가득한 행복한 학교"</p>
				</header>
				<p>우리학교는 2014년 4월 3일 소프트웨어 산업 발전을 선도할 인재 양성을 목표로 국내 최초로
					정부부처(미래창조과학부) 참여형 ‘소프트웨어 마이스터고’로 선정 되었습니다. 이에 따라 우리학교는 소프트웨어 분야에
					자질이 있거나 또 관심이 있는 학생들을 2015학년도 4.6 대 일, 2016학년도 4.3 대 일의 경쟁을 거쳐 각
					80명으로 이미 선발한 바 있으며, 본교가 추구하고 있는 인재상과 소프트웨어 산업에 대한 이해를 돕기 위한 신입생
					부트캠프를 부모님들이 참석하신 가운데 성황리에 마친바 있습니다.</p>
				<footer>
					<a href="http://dsmhs.djsch.kr/main.do" class="button">자세히 알아보기</a>
				</footer>
			</article>
		</div>
		<!-- Footer -->
		<div id="footer">
			<div class="container">
				<div class="row">
					<!-- Posts -->
					<section class="6u 12u(mobile)">
						<header>
							<h2 class="icon fa-file circled">
								<span class="label">Posts</span>
							</h2>
						</header>
						<ul class="divided">
							<li>
								<article class="post stub">
									<header>
										<h3>회사가 학생의 레주메를 보는 방법</h3>
									</header>
									↓
								</article>
							</li>
							<li>
								<article class="post stub">
									<header>
										<h3>
											<a href="login.html">로그인&회원가입 페이지에 들어가 시리얼 코드를 입력한다.</a>
										</h3>
									</header>
									↓
								</article>
							</li>
							<li>
								<article class="post stub">
									<header>
										<h3>
											<a href="search.html">검색페이지에서 원하는 인재를 검색한다.</a>
										</h3>
									</header>
								</article>
							</li>
							<li>
								<article class="post stub">
									<header>
										<h3>
											<a href="register_serial.html">* 시리얼 코드를 부여받을려면 여기를
												클릭하세요! *</a>
										</h3>
									</header>
								</article>
							</li>
						</ul>
					</section>
					<section class="6u 12u(mobile)">
						<header>
							<h2 class="icon fa-file circled">
								<span class="label">Posts</span>
							</h2>
						</header>
						<ul class="divided">
							<li>
								<article class="post stub">
									<header>
										<h3>학생이 레주메를 쓰는 방법</h3>
									</header>
									↓
								</article>
							</li>
							<li>
								<article class="post stub">
									<header>
										<h3>
											<a href="login.html">로그인&회원가입 페이지에 들어가 로그인한다.</a>
										</h3>
									</header>
									↓
								</article>
							</li>
							<li>
								<article class="post stub">
									<header>
										<h3>
											<a href="myresume_manage.html">레주메 내용관리에서 자신의 레주메를 작성한다.</a>
										</h3>
									</header>
								</article>
							</li>
							<li>
								<article class="post stub">
									<header>
										<h3>
											<a href="register.html">* 회원가입을 하려면 여기를 클릭하세요! *</a>
										</h3>
									</header>
								</article>
							</li>
						</ul>
					</section>
				</div>
				<hr />
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
		$("document").ready(function() {
			$.ajax({
				url : '/2uzubook/indexAction',
				type : 'post',
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						console.log(data[i].name);
						a(data);
					}
				},
				dataType : 'json'
			});
		});
		function go(){
			var frm=document.getElementById('frm1');
			console.log('hel');
			frm.submit();
		}
	</script>
</body>

</html>
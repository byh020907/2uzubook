<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");
	System.out.println(id);
%>
<!DOCTYPE HTML>
<!--
	Helios by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>2UZUBOOK DSM</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="../JS/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../CSS/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="../CSS/ie8.css" /><![endif]-->
</head>
<body class="homepage">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header">

			<!-- Inner -->
			<div class="inner">
				<header>
					<h1>
						<a href="index.jsp" id="logo">DSM 2UZUBOOK</a>
					</h1>
					<hr />
					<p>대덕 소프트웨어 마이스터고 학생들의 레주메 사이트</p>
				</header>

			</div>

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="index.jsp">Home</a></li>
					<li><a href="#">Resume</a>
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

					<li id="login_after"></li>
				</ul>
			</nav>

		</div>

		<!-- Banner -->
		<section id="banner">
			<header>
				<h2>
					대덕SW마이스터고등학교 <strong>자랑스런 학생들</strong>.
				</h2>
				<p>그들이 직접 작성한 그들의 레주메들 . 놀랍지만 이들은 모두 고등학생입니다.</p>
			</header>
		</section>

		<!-- Carousel -->
		<section class="carousel">
			<div class="reel">

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu1.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">박광호</a>
						</h3>
					</header>
					<p>
						Software Development <br /> 2학년 1반 1번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu2.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">김선재</a>
						</h3>
					</header>
					<p>
						공통과 <br />1학년 3반 19번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu3.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">이다현</a>
						</h3>
					</header>
					<p>
						Embeded Development <br />3학년 3반 5번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu4.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">백성일</a>
						</h3>
					</header>
					<p>
						Information Security <br />2학년 4반 14번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu5.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">박진주</a>
						</h3>
					</header>
					<p>
						Information Security <br />3학년 4반 8번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu6.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">김영인</a>
						</h3>
					</header>
					<p>
						Embeded Development <br />2학년 3반 5번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu7.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">이윤진</a>
						</h3>
					</header>
					<p>
						공통과 <br />1학년 2반 19번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu8.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">박하늘</a>
						</h3>
					</header>
					<p>
						공통과 <br />1학년 1반 8번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu9.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">지혜리</a>
						</h3>
					</header>
					<p>
						공통과 <br />1학년 2반 12번
					</p>
				</article>

				<article>
					<a href="#" class="image featured"><img
						src="../Image/student/stu1.jpg" alt="" height="235" /></a>
					<header>
						<h3>
							<a href="#">김보경</a>
						</h3>
					</header>
					<p>
						Software Development <br /> 2학년 2반 5번
					</p>
				</article>

			</div>
		</section>

		<!-- Main -->


		<!-- Features -->
		<div class="wrapper style1">

			<section id="features" class="container special">
				<header>
					<h2>우리 학생들의 레주메를 언제 어디서나 보세요</h2>
					<p>종이로 된 레주메보다 훨 편리해진 2UZUBOOK!</p>

				</header>
				<div class="row">
					<article class="4u 12u(mobile) special">
						<a href="first-common.jsp" class="image featured"><img
							src="../Image/index/debate.jpg" alt="" height="235" /></a>
						<header>
							<h3>
								<a href="#">1학년</a>
							</h3>
						</header>
						<p>SW분야 경쟁력 제고를 통한 하드웨어와 소프트웨어, 그리고 서비스 융합력이 있는 SW인재 육성을 목표로
							공통계열로 선발하여 공통 기본교육과정을 운영한 후 학생의 적성, 희망, 산업체의 수요 등을 고려하여 2학년부터
							전공학과를 선택 후 심화 과정 이수</p>
					</article>
					<article class="4u 12u(mobile) special">
						<a href="second-software.jsp" class="image featured"><img
							src="../Image/index/debate2.JPG" alt="" height="235" /></a>
						<header>
							<h3>
								<a href="#">2학년</a>
							</h3>
						</header>
						<p>SW에 대한 기본적인 이해를 바탕으로 SW 개발 도구 및 기법을 활용하여 SW분석, 설계, 구현, 시험,
							유지/보수 등의 업무를 수행할 수 있는 응용 SW 개발자 양성을 목표로 한다.</p>
					</article>
					<article class="4u 12u(mobile) special">
						<a href="third-software.jsp" class="image featured"><img
							src="../Image/index/debate3.jpg" alt="" height="235" /></a>
						<header>
							<h3>
								<a href="#">3학년</a>
							</h3>
						</header>
						<p>SW 및 HW에 대한 기본적인 이해를 바탕으로 임베디드SW 구현을 위한 펌웨어/OS시스템/플랫폼/응용
							SW의 개발, 시험, 유지･보수를 수행할 수 있는 임베디드SW 개발자 양성을 목표로 한다.</p>
					</article>
				</div>
			</section>

		</div>

		<!-- Scripts -->
			<script src="../JS/jquery.min.js"></script>
			<script src="../JS/jquery.dropotron.min.js"></script>
			<script src="../JS/jquery.scrolly.min.js"></script>
			<script src="../JS/jquery.onvisible.min.js"></script>
			<script src="../JS/skel.min.js"></script>
			<script src="../JS/util.js"></script>
			<!--[if lte IE 8]><script src="../JS/ie/respond.min.js"></script><![endif]-->
			<script src="../JS/main.js"></script>
			<script>
			window.onload=function(){
				var tag1  = '<a href="login.jsp">Login</a>';
				var tag2 = '<a href="profile.jsp">MY PAGE</a>';
				var val="<%=id%>";
				if(val=="null")
					{
						$("#login_after").html(tag1);
						console.log("ht");
					}
				else
				{
					$("#login_after").html(tag2);
				}
			};
			
			
			</script>
	</body>
</html>

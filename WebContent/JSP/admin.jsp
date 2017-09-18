<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Helios by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Admin</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="/2uzubook/CSS/table.css">
<!--[if lte IE 8]><script src="../JS/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../CSS/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="../CSS/ie8.css" /><![endif]-->
</head>
<body class="right-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header">

			<!-- Inner -->
			<div class="inner">
				<header>
					<h1>
						<a href="index.jsp" id="logo">시리얼 관리 </a>
					</h1>
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
					<li><a href="resume_write.jsp">Resume Write</a></li>
				</ul>
			</nav>

		</div>

		<!-- Main -->
		<div class="wrapper style1">

			<div class="container">
				<div class="row 200%">
					<div class="8u 12u(mobile)" id="content">
						<article id="main">
							<header>
							<table class="request" id="company">
									<thead>
										<tr>
											<th scope="cols">회사명</th>
											<th scope="cols">요청 날짜</th>
											
											
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">삼성</th>
											<td>2017.1.1</td>
										
										</tr>
										<tr>
											<th scope="row">구글</th>
											<td>2017.2.3</td>
										
										</tr>
										<tr>
											<th scope="row">마이크로소프트</th>
											<td>2017.3.5</td>
										
										</tr>
									</tbody>
								</table>
								<table class="approved">
									<thead>
										<tr>
											<th scope="cols">회사명</th>
											<th scope="cols">요청 날짜</th>
											<th scope="cols">시리얼 코드</th>
											
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">삼성</th>
											<td>2017.1.1</td>
											<td>A8372nfs</td>
										</tr>
										<tr>
											<th scope="row">구글</th>
											<td>2017.2.3</td>
											<td>B93724ndf</td>
										</tr>
										<tr>
											<th scope="row">마이크로소프트</th>
											<td>2017.3.5</td>
											<td>Cddji8335</td>
										</tr>
									</tbody>
								</table>
							</header>
						</article>
					</div>
				</div>


				<article class="4u 12u(mobile) special"></article>
			</div>
		</div>

	</div>

	<!-- Footer -->

	</div>

	<!-- Scripts -->
	<script src="../JS/js/jquery.min.js"></script>
	<script src="../JS/js/jquery.dropotron.min.js"></script>
	<script src="../JS/js/jquery.scrolly.min.js"></script>
	<script src="../JS/js/jquery.onvisible.min.js"></script>
	<script src="../JS/js/skel.min.js"></script>
	<script src="../JS/js/util.js"></script>
	<!--[if lte IE 8]><script src="../JS/js/ie/respond.min.js"></script><![endif]-->
	<script src="../JS/js/main.js"></script>

</body>
</html>
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
		<title>FirstGrade</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="../JS/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../CSS/main.css" />
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
								<h1><a href="index.jsp" id="logo">1학년 2반</a></h1>
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
										  </ul>
									</li>
										<li><a href="#">3학년 resume &hellip;</a>
										<ul>
												<li><a href="third-software.jsp">소프트웨어 개발과</a></li>
												<li><a href="third-embeded.jsp">임베디드 개발과</a></li>
												<li><a href="third-security.jsp">정보보안과</a></li>
										  </ul>
									  </li>

								  </ul>
								</li>
							<li><a href="resume_input.jsp">Resume Write</a></li>
							</ul>
						</nav>

				</div>

			<!-- Main -->
		  <div class="wrapper style1">

				<div id="container" class="container" style="text-align:center">

				</div>
			</div>

			<script>

				for(var i=0;i<20;i++){

					var div=document.createElement("div");

					div.id = "element";

					var image=new Image();
					image.src="../Image/student/stu"+(i%7+1)+".jpg";
					image.id="image";

					var text=document.createElement("input");
					text.value="이름";
					text.id="name";

					div.appendChild(image);
					div.innerHTML += "<br>";
					div.appendChild(text);

					document.getElementById("container").appendChild(div);
				}

			</script>

		</div>

		<div>
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

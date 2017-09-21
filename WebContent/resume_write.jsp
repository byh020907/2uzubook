<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@ page import="dao.Database"%>
<%
	Database database = Database.getInstance();
%>
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>2uZuBook - DSM</title>
<link rel="stylesheet" href="../CSS/resume_writeStyle.css" />
<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="../CSS/freelancer.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
#ClickButton {
	width: 175px;
	height: 50px;
	background-color: #38B885;
	position: absolute;
	right: 30px;
	top: 30px;
	border-radius: 7.5px; //
	border: 1px solid red;
	cursor: pointer;
	display: table;
}

#ClickHere {
	color: floralwhite;
	font-size: 2.5rem;
	display: table-cell;
	vertical-align: middle;
}
</style>
</head>

<body id="page-top" class="index">
	<div id="skipnav">
		<a href="#maincontent">Skip to main content</a>
	</div>

	<!-- Navigation -->
	<nav id="mainNav"
		class="navbar navbar-default navbar-fixed-top navbar-custom">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="#page-top">2uzuBook &lt;DSM&gt;</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="hidden"><a href="#page-top"></a></li>
					<li class="page-scroll"><a href="#portfolio">Portfolio</a></li>
					<li class="page-scroll"><a href="#about">About</a></li>
					<li class="page-scroll"><a href="#contact">Contact</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!-- Header -->
	<header>
		<div class="container" id="maincontent" tabindex="-1">
			<div class="row">
				<div class="col-lg-12">
					<form action="profileAction.png" method="post">
						<button class="btn">
							<img class="img-responsive" src="../Image/portfolio/plus.png"
								alt="">
						</button>
						<div class="intro-text">
							<input type="text" placeholder="Username" name="name" />
							<hr class="star-light">
							<span class="skills"> <select class="box1">
									<option>1</option>
									<option>2</option>
									<option>3</option>
							</select> 학년 <select class="box2">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
							</select> 반 <select class="box3">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
									<option>13</option>
									<option>14</option>
									<option>15</option>
									<option>16</option>
									<option>17</option>
									<option>18</option>
									<option>19</option>
									<option>20</option>
									<option>21</option>
							</select> 번 <br> <select>
									<option>공통과정</option>
									<option>소프트웨어 개발</option>
									<option>임베디드 개발</option>
									<option>정보보안</option>
							</select> 과 <br> <br>
							</span>
							<button class="btn2" type="submit">submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</header>

	<!-- Portfolio Grid Section -->
	<section id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>
						Portfolio
						<div id="ClickButton">
							<span id="ClickHere">한눈에 보기</span>
						</div>
					</h2>
					<div>
						<hr class="star-primary">
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal1" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x">관심분야</i>
								</div>
							</div> <img src="../Image/portfolio/Interest_area.png"
							class="img-responsive" alt="Interest">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal2" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x">자격증</i>
								</div>
							</div> <img src="../Image/portfolio/Certificate.png"
							class="img-responsive" alt="License">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal3" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x">대외참여</i>
								</div>
							</div> <img src="../Image/portfolio/Competition.png"
							class="img-responsive" alt="Circus tent">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal4" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x">수상경력</i>
								</div>
							</div> <img src="../Image/portfolio/Award.png" class="img-responsive"
							alt="Game controller">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal5" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x">프로젝트, 동아리</i>
								</div>
							</div> <img src="../Image/portfolio/Project.png" class="img-responsive"
							alt="Safe">
						</a>
					</div>
					<div class="col-sm-4 portfolio-item">
						<a href="#portfolioModal6" class="portfolio-link"
							data-toggle="modal">
							<div class="caption">
								<div class="caption-content">
									<i class="fa fa-search-plus fa-3x">기타</i>
								</div>
							</div> <img src="../Image/portfolio/Activity_out.png"
							class="img-responsive" alt="Submarine">
						</a>
					</div>
				</div>
			</div>
	</section>

	<!-- About Section -->
	<section class="success" id="about">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2>대회 공모전</h2>
					<hr class="star-light">
				</div>
			</div>
			<div class="row">
				<div class="col-lg-offset-2 col-lg-9">
					<p>⦁2016 스마트 앱 첼린지STAC (2016. 5. 21.)</p>
					<p>⦁제 2회 국제 수리 과학 창의대회 (2016. 10. 08.)</p>
					<p>⦁제 1회 NYPC 넥슨 청소년 프로그래밍 대회 (2016. 8. 31.)</p>
					<p>⦁대한민국 소프트웨어 융합 해카톤 (2016. 9. 1. ~ 2016. 9. 4.)</p>
					<p>⦁제 1회 충남대학교 동아리 소프트웨어 경진 대회 (2016. 11. 7.)</p>
					<p>⦁엘지 사이언스 과학 UCC (2016. 11. 30.)</p>
					<p>⦁제 1회 교내 꿈 발표 대회(2016. 11. 25)</p>
					<p>⦁DSM 공모전 (2017. 3. 3.)</p>
				</div>
				<div class="col-lg-4"></div>
				<div class="col-lg-8 col-lg-offset-2 text-center"></div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="text-center">
		<div class="footer-above">
			<div class="container">
				<div class="row">
					<div class="footer-col col-md-4">
						<h3>Location</h3>
						<p>대전광역시 유성구 가정북로 76(장동 23-9)</p>
					</div>
					<div class="footer-col col-md-4">
						<h3>Around the Web</h3>
						<ul class="list-inline">
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Facebook</span><i class="fa fa-fw fa-facebook"></i></a>
							</li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Google Plus</span><i
									class="fa fa-fw fa-google-plus"></i></a></li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Twitter</span><i class="fa fa-fw fa-twitter"></i></a>
							</li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Linked In</span><i class="fa fa-fw fa-linkedin"></i></a>
							</li>
							<li><a href="#" class="btn-social btn-outline"><span
									class="sr-only">Dribble</span><i class="fa fa-fw fa-dribbble"></i></a>
							</li>
						</ul>
					</div>
					<div class="footer-col col-md-4">
						<h3>개발자</h3>
						<p>2학년 소프트웨어개발과</p>
						<p>김소연</p>
						<p>박규리</p>
						<p>배용호</p>
						<p>윤정현</p>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-below">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">Copyright &copy; Your Website 2016</div>
				</div>
			</div>
		</div>
	</footer>

	<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
	<div
		class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
		<a class="btn btn-primary" href="#page-top"> <i
			class="fa fa-chevron-up"></i>
		</a>
	</div>

	<!-- Portfolio Modals -->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>관심 분야</h2>
							<hr class="star-primary">
							
							<form action="/2uzubook/resumeInputAction" method="post">
								<img src="../Image/portfolio/Security"
									class="img-responsive img-centered" alt="">
									<input type="hidden" name="type" value="1"/> 
									<input type="text" placeholder="관심분야 1" name="one" /> 
									<input type="text" placeholder="관심분야 2" name="two" /> 
									<input type="text" placeholder="관심분야 3" name="three" /> 
									<input type="submit" value="Submit" />
							</form>
							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>자격증</h2>
							<div id="pre_set_license" style="display:none">
								<input type="text" placeholder="자격증 명"mname="licenseName" /> 
								<input type="text" placeholder="취득 날짜" name="licenseDate" /> 
								<input type="text" placeholder="점수 (어학 관련만)" name="jumsu" />
								<input type="button" value="삭제" onclick="remove_item('license_field',this)" /><br>
							</div>
							<hr class="star-primary">
							<img src="../Image/portfolio/Certificate.png"
								class="img-responsive img-centered" alt="">
							<form action="/2uzubook/resumeInputAction" method="post">
								<div id="licence_div">
								<input type="hidden" name="type" value="2"/> 
									<ul id="ul_licence">
										<li>
										<div id="license_field">
										</div>
										
										</li>
									</ul>
									<input type="button" value="추가" onclick="add_item('pre_set_license','license_field')" />
									<input type="submit" value="Submit" />
								</div>
							</form>
							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>대외 참여</h2>
							<div id="pre_set_conference" style="display:none">
								<input type="text" placeholder="컨퍼런스 명" name="conference" /> 
											<input type="text" placeholder="참여 날짜" name="conferenceDate" />
								<input type="button" value="삭제" onclick="remove_item('conference_field',this)" /><br>
							</div>
							<hr class="star-primary">
							<img src="../Image/portfolio/circus.png" class="img-responsive img-centered" alt="">
							<form action="/2uzubook/resumeInputAction" method="post">
								<div id="attend_div">
								<input type="hidden" name="type" value="3"/> 
									<ul id="ul_attend">
										<li>
											<div id="conference_field">
											</div>
										</li>
									</ul>
									<input type="button" value="추가" onclick="add_item('pre_set_conference','conference_field')"/> 
									<input type="submit" value="Submit" />
								</div>
							</form>
							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>수상경력</h2>
							<div id="pre_set_award" style="display:none">
								<input type="text" placeholder="대회명" name="awardName" />
								<input type="text" placeholder="수상 등급(ex.대상, 금상...)" name="award" /> 
								<input type="text" placeholder="대회 참여 날짜" name="awardDate" />
								<input type="button" value="삭제" onclick="remove_item('award_field',this)" /><br>
							</div>
							<hr class="star-primary">
							<img src="../Image/portfolio/game.png"
								class="img-responsive img-centered" alt="">
							<form action="/2uzubook/resumeInputAction" method="post">
								<div id="award_div">
								<input type="hidden" name="type" value="4"/> 
									<ul id="ul_award">
										<li>
											<div id="award_field"></div>
										</li>
									</ul>
									<input type="button" value="추가" onclick="add_item('pre_set_award','award_field')" /> <input
										type="submit" value="Submit" />
								</div>
							</form>


							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>Project, 동아리</h2>
							<div id="pre_set_project" style="display:none">
								<input type="text" placeholder="프로젝트 명" name="projectName" /> 
								<input type="text" placeholder="프로젝트 시작 날짜(ex.1930/03/02)" name="projectStartDate" /> 
								<input type="text" placeholder="프로젝트 끝난 날짜(ex.1930/03/02)" name="projectFinishDate" /> 
								<input type="text" placeholder="프로젝트 간단 설명" name="projectContent" />
								<input type="button" value="삭제" onclick="remove_item('project_field',this)" /><br>
							</div>
							<div id="pre_set_circle" style="display:none">
								<input type="text" placeholder="동아리명" name="circleName" /> 
								<input type="text" placeholder="프로젝트 시작 날짜(ex.1930/03/02)" name="circleStartDate" /> 
								<input type="text" placeholder="프로젝트 끝난 날짜(ex.1930/03/02)" name="circleFinishDate" /> 
								<input type="text" placeholder="동아리 간단 설명" name="circleContent" />
								<input type="button" value="삭제" onclick="remove_item('circle_field',this)" /><br>
							</div>
							<hr class="star-primary">
							<img src="../Image/portfolio/safe.png"
								class="img-responsive img-centered" alt="">
							<form action="/2uzubook/resumeInputAction" method="post">
								<div id="project_div">
								<input type="hidden" name="type" value="5"/> 
									<ul id="ul_project">
										<li>
											<div id="project_field"></div>
										</li>
										<li>
											<div id="circle_field"></div>
										</li>
									</ul>
									<input type="button" value="프로젝트 추가" onclick="add_item('pre_set_project','project_field')" /> 
									<input type="button" value="동아리 추가" onclick="add_item('pre_set_circle','circle_field')" /> 
									<input type="submit" value="Submit" />
								</div>
							</form>

							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<div class="close-modal" data-dismiss="modal">
				<div class="lr">
					<div class="rl"></div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-lg-offset-2">
						<div class="modal-body">
							<h2>기타</h2>
							<div id="pre_set_volunteer" style="display:none">
								<input type="text" placeholder="봉사활동명" name="volunteerName" /> 
								<input type="text" placeholder="봉사 활동 날짜" name="volunteerDate" />
								<input type="button" value="삭제" onclick="remove_item('volunteer_field',this)" /><br>
							</div>
							<div id="pre_set_hobby" style="display:none">
								<input type="text" placeholder="취미 1" name="hobbyName" /> 
								<input type="text" placeholder="취미 2" name="hobbyName" />
								<input type="button" value="삭제" onclick="remove_item('hobby_field',this)" /><br>
							</div>
							<div id="pre_set_read" style="display:none">
								<input type="text" placeholder="책 명" name="readingName" /> 
								<input type="text" placeholder="독서 날짜" name="readingDate" />
								<input type="button" value="삭제" onclick="remove_item('read_field',this)" /><br>
							</div>
							<hr class="star-primary">
							<img src="../Image/portfolio/submarine.png"
								class="img-responsive img-centered" alt="">
							<form action="/2uzubook/resumeInputAction" method="post">
								<div id="etc_div">
								<input type="hidden" name="type" value="6"/> 
									<ul id="ul_etc">
										<li>
											<div id="volunteer_field"></div>
										</li>
										<li>
											<div id="read_field"></div>
										</li>
										<li>
											<div id="hobby_field"></div>
										</li>
									</ul>
										<input type="button" value="봉사 활동 추가" onclick="add_item('pre_set_volunteer','volunteer_field')" /> 
										<input type="button" value="독서 활동 추가" onclick="add_item('pre_set_read','read_field')" /> 
										<input type="button" value="취미 활동 추가" onclick="add_item('pre_set_hobby','hobby_field')" /> 
										<input type="submit" value="Submit" />
								</div>
							</form>

							<ul class="list-inline item-details">
								<li>Client: <strong><a
										href="http://startbootstrap.com">Start Bootstrap</a> </strong>
								</li>
								<li>Date: <strong><a
										href="http://startbootstrap.com">April 2014</a> </strong>
								</li>
								<li>Service: <strong><a
										href="http://startbootstrap.com">Web Development</a> </strong>
								</li>
							</ul>
							<button id="btnSubmit" type="button" class="btn btn-default"
								data-dismiss="modal">
								<i class="fa fa-times"></i> Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="../JS/jqBootstrapValidation.js"></script>
	<script src="../JS/contact_me.js"></script>

	<!-- Theme JavaScript -->
	<script src="../JS/freelancer.min.js"></script>
	<script>
		function add_item(str,str2){
			var div=document.createElement('div');
			div.innerHTML=document.getElementById(str).innerHTML;
			document.getElementById(str2).appendChild(div);
			console.log("hll");
		}
		function remove_item(str,obj){
			document.getElementById(str).removeChild(obj.parentNode);
		}
	</script>
</body>

</html>

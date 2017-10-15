<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/search.css" />
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
								<h3>검색해주세요</h3>
							</header>
						</section>
						<hr />
						흥미분야, 사용언어, 대회 참여 혹은 수상경력등을 입력해 보세요!
					</div>
					<div class="9u 12u(mobile) important(mobile)" id="content">
						<article id="main">
							<header>
								<h2>
									<a href="#">Search</a>
								</h2>
								<p>검색을 통해 원하는 인재를 정확하고 빠르게 찾아낼 수 있습니다.</p>
							</header>
							<div class="row">
								<div class="12u 12u(mobile)">
									<div class="row">
										<div class="8u form1">
											<form id="search_form" action="/2uzubook/searchAction"
												method="post" style="margin-top: 20px;"><div id="loc"></div></form>
												<div class="search_div">
												<ul id="input_list">
													<li id="this_li"><input id="search_box" list="data_list" class="form-control mb-2" type="text"
													placeholder="ex) 남자, 게임, c++" name="q"></li>
												</ul>
												</div>
												<datalist id="data_list">
												</datalist>
												
										</div>
										<div class="4u">
											<button class="btn btn-outline-success mb-2"
												onclick="go_servlet();"
												style="height: 59px; margin-top: 23px;">search</button>
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
	<script src="js/search.js"></script>
	<script>
	var tag_input='<li id="this_li"><input id="search_box" list="data_list" class="form-control mb-2" type="text" placeholder="ex) 남자, 게임, c++" name="q"></li>';
	var count=0;
	$(function(){
		$.ajax({
			url : '/2uzubook/search_test',
				type : 'post',
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						console.log(data[i].name);
						tag='<option value="'+data[i].name+'" id="'+data[i].id+'"></option>';
						$('#data_list').append(tag);
					}
				},
				dataType : 'json'
		});
	});
	$(document).on("keyup","#search_box",function(event){
		if(event.keyCode==32)
		{
			count++;
			console.log("hell");
			var val_search=$('#search_box').val().trim();
			
			var find_val='option[value="'+val_search+'"]';
			console.log(find_val);
			var val_data=$(find_val).attr('id');
			console.log(val_data+'datalist');
			var tag_div='<li><div class="span_style">'+val_search+'<div class="part"><input class="key" type="hidden" value="'+val_data+'"/><button class="delete_btn" onclick="delete_keyword(this)">x</button></div></div></li>';
			$('li').remove('#this_li');
			$('#input_list').append(tag_div);
			$('#input_list').append(tag_input);
		}
	});
	function delete_keyword(obj)
	{
		count--;
		$(obj).parent().parent().parent().remove();
	}
	function go_servlet()
	{
		var i=0
		for(;i<count;i++)
		{
			var temp=$("#input_list").find("li").eq(i).find('.key').val();
			var tag='<input type="hidden" value="'+temp+'" name="keyword"/>';
			console.log(temp);
			$("#loc").append(tag);
		}
		if(i==0)
		{
			alert('data를 하나 이상 입력하세요');	
		}else{
			$("#search_form").submit();		
		}
	}
	function go() {
        var frm = document.getElementById('frm1');
        console.log('hel');
        frm.submit();
    }
	</script>
</body>

</html>
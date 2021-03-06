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
					</h1> </header>
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
                                <h3>회원가입 해주세요</h3> </header>
                        </section>
                        <hr /> </div>
                    <div class="9u 12u(mobile) important(mobile)" id="content">
                        <article id="main">
                            <header>
                                <h2>
									<a href="#">Register</a>
								</h2>
                                <p>회원가입을 하시면 2UZUBOOK의 수많은 기능을 모두 사용하실 수 있습니다.</p>
                            </header>
                            <div class="row">
                                <div class="10u 12u(mobile)">
                                    <h3 class="text-center mb-3">학생 정보 입력</h3>
                                    <div class="row">
                                        <div class="10u form1">
                                            <form action="/2uzubook/joinAction/student" method="post" style="margin-top: 20px;">
                                                <div class="form-group">
                                                    <label class="control-label" for="name">이름</label>
                                                    <input name="name" type="text" class="form-control" required> </div>
                                                <div class="form-group">
                                                    <label class="control-label" for="gender">성별 선택</label>
                                                    <select name="gender" class="form-control">
                                                        <option value="남">남자</option>
                                                        <option value="여">여자</option>
                                                    </select>
                                                </div>
                                                <div id="loc" class="form-group">
                                                    <label class="control-label" for="email">E-Mail Address</label>
                                                    <input id="email" name="email" type="text" class="form-control" required>
                                                    <div class="col-md-4" style="margin-top: 5px;">
                                                        <input type="button" id="email_confi" onclick="email_confirm(); return false;" value="이메일 인증" class="btn btn-primary"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label" for="id">ID</label>
                                                    <input id="id" name="id" class="form-control" type="text" required>
                                                    <div class="col-md-4" style="margin-top: 5px;">
                                                        <input type="button" id="id_confirm" value="중복 확인" class="btn btn-primary">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="password">비밀번호</label>
                                                    <div class="col-md-4">
                                                        <input id="password" name="password" type="password" class="form-control" required> </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="password2">비밀번호 확인</label>
                                                    <div class="col-md-4">
                                                        <input id="password2" name="password2" type="password" class="form-control" required onkeyup="password_check();"> </div>
                                                </div>
                                                <div id="result"></div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="a">입학년도</label>
                                                    <div class="col-md-4">
                                                        <input name="adm_year" type="text" placeholder="ex) 2016" class="form-control" required> </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="stu_id">학번</label>
                                                    <div class="col-md-4">
                                                        <input name="stu_id" type="text" placeholder="ex) 20101" class="form-control" required> </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="intro">자기소개 한줄</label>
                                                    <div class="col-md-4">
                                                        <input name="intro" type="text" placeholder="20자 이내" class="form-control" required> </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="major">학과 선택</label>
                                                    <div class="col-md-4">
                                                        <select name="major" class="form-control">
                                                            <option value="1">공통과정</option>
                                                            <option value="2">sw개발과</option>
                                                            <option value="3">임베디드개발과</option>
                                                            <option value="4">정보보안과</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-4 control-label" for="Submit"></label>
                                                    <div class="col-md-4">
                                                        <button type="submit" class="btn btn-primary">가입하기</button>
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
                                <h3>2UZUBOOK 학생과 기업을 이어주는 책</h3> </header>
                            <p>대덕소프트웨마이스터고등학교 34111)대전광역시 유성구 가정북로 76(장동 23-9) 교무실 ☎ : 042-866-8822</p>
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
        function password_check() {
            var password = $('#password').val();
            var passwordCheck = $('#password2').val();
            console.log(password);
            console.log(passwordCheck);
            if (password == passwordCheck) {
                document.getElementById("result").innerHTML = "Okay";
            }
            else {
                document.getElementById("result").innerHTML = "No";
            }
        }
    </script>
    <script>
        $("#id_confirm").click(function () {
            var url = "/2uzubook/ID_Confirm";
            var id = $('#id').val();
            var sendData = {
                "id": id
            };
            $.ajax({
                type: "POST"
                , url: url
                , data: sendData
                , dataType: 'json'
                , success: function (data) {
                    if (data.status != "사용가능한 아이디입니다.") {
                        $('#id').val('');
                    }
                    alert(data.status);
                }
             });
        });
        
        function email_confirm(){
        	console.log("이메일 컨펌 실행");
        	var temp=new Object();
        	var email=$('#email').val();
        	var tag='<div class="form-group" id="delete_div"><label class="control-label" for="email_con">E-Mail 인증번호</label><input id="email_con" name="email_con" type="text" class="form-control" required><div class="col-md-4" style="margin-top: 5px;"><input type="button" id="email_con_btn" onclick="code_confirm(); return false;" value="이메일 인증  검사" class="btn btn-primary"/></div></div>';
        	temp.email=email;
        	console.log(temp);
        	$.ajax({
				url : '/2uzubook/CreateAuthenticationCode',
				type : 'post',
				data : temp,
				success : function(data) {
					if(data.status>=0){
						alert("success")
						$('#loc').after(tag);
						//성공처리
					}else{
						alert("fail")
						//실패처리
						
					}
				},
				dataType : 'json'
			});
        }
        
        function code_confirm()
        {
        	console.log("코드 컨펌 실행");
        	var temp=new Object();
        	var email=$('#email').val();
        	var inputString=$('#email_con').val().trim();
        	temp.code=inputString;
        	temp.email=email;
        	$.ajax({
				url : '/2uzubook/CheckAuthenticationCode',
				type : 'post',
				data : temp,
				success : function(data) {
					if(data.status==1)
					{
						alert('인증되었습니다.');
						$("#email_confi").attr('type','hidden');
						$("#email").attr('disabled',true);

						$('#delete_div').remove();
					}
					else
					{
						alert('인증되지 못했습니다.');
					}
				},
				dataType : 'json'
			});
        }
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
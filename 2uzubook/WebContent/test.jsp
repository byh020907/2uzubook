<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%
request.setCharacterEncoding("UTF-8");

JSONArray jsonArray= (JSONArray) request.getAttribute("JSONArray");
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
                    <h1><a href="index.html" id="logo">DSM 2UZUBOOK</a></h1> </header>
            </div>
            <!-- Nav -->
            <nav id="nav">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="login.html">로그인 / 회원가입</a></li>
                    <li> <a href="#">For Student</a>
                        <ul>
                            <li><a href="myresume.jsp">내 레주메 보기</a></li>
                            <li><a href="#">레주메 내용 관리</a></li>
                        </ul>
                    </li>
                    <li> <a href="#">For Company</a>
                        <ul>
                            <li><a href="search.html">학생 찾기</a></li>
                            <li><a href="right-sidebar.html">시리얼 관리</a></li>
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
                                <h3>시험 성적 추가</h3> </header>
                        </section>
                        <hr /> </div>
                    <div class="9u 12u(mobile) important(mobile)" id="content">
                        <article id="main">
                            <header>
                                <h2>시험 성적을 추가해주세요 </h2>
                                <p>자신의 개발 활동을 기록해서 기업에게 보여주세요! 확실하고 솔직하게 자신을 나타낼 수 있도록 정성스럽게 적어주세요.</p>
                            </header>
                            <h3 class="text-center mb-3">추가된 시험 성적</h3>
                            <br>
                            <br>
                            <div id="test_loc" class="row">
                            	<% for(int i=0;i<jsonArray.size();i++)
								{	
									JSONObject award=(JSONObject)jsonArray.get(i);
								%>
                            		<div class="4u 12u(mobile)">
                            			<div class="row" id="modal_pop" style="cursor:pointer;">
                            				<div class="5u"><a class="image fit" onclick="test_delete(this);">
                            					<img src="images/student/etc.png" alt="" /></a>
                            				</div>
                            				<div class="7u">
                            					<h3 class="text-center" id="delete_name"><%=award.get("name")%></h3><%=award.get("score")%>
                            				</div>
                            			</div>
                            		</div>
    	
								<% 
								}
								%>  
                            </div>
                            <div class="row">
                                <div class="10u form1">
                                    <h3 class="text-center mb-3">시험 성적 추가</h3>
                                    <form action="" method="post">
                                        <input name="mode" type="hidden" value="1">
                                        <div class="form-group">
                                            <label class="control-label" for="test_name">시험 이름</label>
                                            <input id="name" name="award_name" placeholder="ex) TOPCIT " type="text" class="form-control" required> </div>
                                        <div class="form-group">
                                            <label class="control-label" for="test_score">시험 성적</label>
                                            <input id="score" name="test_score" placeholder="ex) 450" type="text" class="form-control" required> </div>
                                      <div class="form-group">
                                            <label class="control-label" for="test_keyword">키워드</label>
                                            <div class="col-md-4">
                                                <select id="keyword" name="test_keyword" class="form-control">
                                                    <option value="1">123</option>
                                                    <option value="2">123</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="Submit"></label>
                                            <div class="col-md-4">
                                                <button id="Submit" name="Submit" onclick="test_add();" class="btn btn-primary">저장하기</button>
                                            </div>
                                        </div>
                                    </form>
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
                                <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                                <li><a href="#" class="icon fa-github"><span class="label">Twitter</span></a></li>
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
        function test_add() {
        	var temp=new Object();
        	var name = $("#name").val();
            var score = $("#score").val();
            var	keyword=$("#keyword").val();
        	temp.part="8";
        	temp.name=name;
        	temp.score=score;
        	temp.keyword=keyword;
        	
        	var tag_div = '<div class="4u 12u(mobile)"><div class="row" id="modal_pop" style="cursor:pointer;"><div class="5u"><a class="image fit" onclick="test_delete(this);"><img src="images/student/etc.png" alt="" /></a></div><div class="7u"><h3 class="text-center" id="delete_name">'+name+'</h3>'+score+'</div></div></div></div>';
        	$("#test_loc").prepend(tag_div);
            $("#name").val('');
            $("#score").val('');
            $("#keyword").val('');
            
          	$.ajax({
				url : '/2uzubook/ResumeAdd',
				type : 'post',
				data : temp,
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						console.log(data[i].name);
					}
				},
				dataType : 'json'
			});
        }
        function test_delete(obj) {
            $(obj).parent().parent().parent().css('background-color', 'red');
            var flag = 0;
            var delete_name=$(obj).parent().next(".7u").children("#delete_name");
            var name=$(delete_name).text();
            console.log(name);
            if (confirm('삭제 하시겠습니까?')) {
                flag = 1;
                test_del(obj, flag,name);
                return;
            }
            else {
                test_del(obj, flag,name);
                return;
            }
        }

        function test_del(obj, flag,name) {
            if (flag == 1) {
                $(obj).parent().parent().parent().remove();
            	var temp=new Object();
            	temp.name=name;
            	temp.part="5";
                $.ajax({
    				url : '/2uzubook/ResumeRemove',
    				type : 'post',
    				data : temp,
    				success : function(data) {
    					console.log("delete_success");
    				},
    				dataType : 'json'
    			});
            }
            else {
                $(obj).parent().parent().parent().css('background-color', '');
            }
        }
    </script>
</body>

</html>
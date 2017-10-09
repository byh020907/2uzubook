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
                                <h3>자격증 추가</h3> </header>
                        </section>
                        <hr /> </div>
                    <div class="9u 12u(mobile) important(mobile)" id="content">
                        <article id="main">
                            <header>
                                <h2>자격증을 추가해주세요 </h2>
                                <p>자신의 개발 활동을 기록해서 기업에게 보여주세요! 확실하고 솔직하게 자신을 나타낼 수 있도록 정성스럽게 적어주세요.</p>
                            </header>
                            <h3 class="text-center mb-3">추가된 자격증</h3>
                            <br>
                            <script></script>
                            <div class="row" id="license_loc">
                            	<% for(int i=0;i<jsonArray.size();i++)
								{	
									JSONObject licen=(JSONObject)jsonArray.get(i);
								%>
                            		<div class="4u 12u(mobile)">
                            			<div class="row" id="modal_pop" style="cursor:pointer;">
                            				<div class="5u">
                            					<a class="image fit" id="color_con" onclick="licen_delete(this);">
                            					<img src="images/student/license2.png" alt="" /></a>
                            				</div>
                            				<div class="7u">
                            					<h3 class="text-center" id="delete_name"><%=(String)licen.get("name")%></h3><%=(String)licen.get("date")%>
                            				</div>
                            			</div>
                            		</div>
                                
								<% 
								}
								%>
                            </div>
                            
                                <div class="10u form1">
                                    <h3 class="text-center mb-3">자격증 추가</h3>
                                    <form action="" method="post">
                                        <input name="mode" type="hidden" value="1">
                                        <div class="form-group">
                                            <label class="control-label" for="License_name">자격증 이름</label>
                                            <input id="name" name="License_name" placeholder="ex) 정보처리기능사" type="text" class="form-control" required> </div>
                                        <div class="form-group">
                                            <label class="control-label" for="license_ins">인증기관</label>
                                            <div class="col-md-4">
                                                <select name="license_ins" id="ins" class="form-control">
                                                    <option value="대한상공회의소">대한상공회의소</option>
                                                    <option value="영화진흥위원회">영화진흥위원회</option>
                                                    <option value="한국광해관리공단">한국광해관리공단</option>
                                                    <option value="한국기술자격검정원">한국기술자격검정원</option>
                                                    <option value="한국방송통신전파진흥원">한국방송통신전파진흥원</option>
                                                    <option value="한국원자력안전기술원">한국원자력안전기술원</option>
                                                    <option value="한국인터넷진흥원">한국인터넷진흥원</option>
                                                    <option value="한국콘텐츠진흥원">한국콘텐츠진흥원</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label" for="date">자격증 취득 날짜</label>
                                            <input id="date" name="license_date" type="date" class="form-control" required> </div>
                                        <div class="form-group">
                                            <label class="control-label" for="License_keyword">키워드</label>
                                            	<div class="col-md-4">
														<select id="keyword" name="license_keyword" class="form-control">
															<option value="1">123</option>
															<option value="2">123</option>
														</select>
													</div> </div>                    
                                        <div class="form-group">
                                            <label class="col-md-4 control-label" for="Submit"></label>
                                            <div class="col-md-4">
                                                <button onclick="licen_add();" class="btn btn-primary">추가하기</button>
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
        function licen_add() {
        	var temp=new Object();
        	var name = $("#name").val();
            var ins = $("#ins").val();
            var date = $("#date").val();
            var	keyword=$("#keyword").val();
        	temp.part="1";
        	temp.name=name;
        	temp.ins=ins;
        	temp.date=date;
        	temp.keyword=keyword;
        	
        	var tag_div = '<div class="4u 12u(mobile)"><div class="row" id="modal_pop" style="cursor:pointer;"><div class="5u">' + '<a class="image fit" id="color_con" onclick="licen_delete(this);"><img src="images/student/license2.png" alt="" /></a></div><div class="7u">' + '<h3 class="text-center" id="delete_name">' + name+ '</h3>' + date + '</div></div></div>';
            
        	$("#license_loc").prepend(tag_div);
            $("#name").val('');
            $("#date").val('');
            
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
       
		
        function licen_delete(obj) {
            $(obj).parent().parent().parent().css('background-color', 'red');
            var flag = 0;
            var delete_name=$(obj).parent().next(".7u").children("#delete_name");
            console.log($(delete_name).text());
            var name=$(delete_name).text();
            if (confirm('삭제 하시겠습니까?')) {
                flag = 1;
                li_del(obj, flag,name);
                return;
            }
            else {
                li_del(obj, flag,name);
                return;
            }
        }

        function li_del(obj, flag,name) {
            if (flag == 1) {
                $(obj).parent().parent().parent().remove();
            	var temp=new Object();
            	temp.name=name;
            	temp.part="2";
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
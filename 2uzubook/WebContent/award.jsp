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
<%
request.setCharacterEncoding("UTF-8");
JSONArray jsonArray= (JSONArray) request.getAttribute("JSONArray");
JSONArray keywordArray= (JSONArray) request.getAttribute("KeywordArray");

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
                    <link rel="stylesheet" href="css/modalStyle.css" />
                </head>

                <body class="left-sidebar">
                    <div id="page-wrapper">
                        <!-- Header -->
                        <div id="header">
                            <!-- Inner -->
                            <div class="inner">
                                <header>
                                    <h1><a href="index.jsp" id="logo">DSM 2UZUBOOK</a></h1> </header>
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
                                                <h3>수상 경력 추가</h3> </header>
                                        </section>
                                        <hr/>
                                         <div class="row 20%">
                                <div class="4u">
                                    <a class="image fit" href="myresume_manage.jsp"><img src="images/previous.png" alt="" onclick="" style="cursor:pointer;" /></a>
                                </div>
                            </div>
                                    </div>
                                    <div class="9u 12u(mobile) important(mobile)" id="content">
                                        <article id="main">
                                            <header>
                                                <h2>수상경력을 추가해주세요 </h2>
                                                <p>자신의 개발 활동을 기록해서 기업에게 보여주세요! 확실하고 솔직하게 자신을 나타낼 수 있도록 정성스럽게 적어주세요.</p>
                                            </header>
                                            <h3 class="text-center mb-3">추가된 수상경력</h3>
                                            <br>
                                            <div id="award_loc" class="row">
                                                <% for(int i=0;i<jsonArray.size();i++){	
														JSONObject award=(JSONObject)jsonArray.get(i);
												%>
                                                  <div class="4u 12u(mobile)">
                                                      <div class="row" id="modal_pop" style="cursor:pointer;">
                                                          <div class="5u">
                                                              <a class="image fit modalLink" onclick="into_modal(this); return false;"> <img src="images/student/bulb.png" alt="" /></a>
                                                          </div>
                                                          <div class="7u">
                                                              <h3 class="text-center" id="delete_name"><%=award.get("name")%></h3>
                                                              <%=(Date)award.get("date")%>
                                                          </div>
                                                      </div>
                                                  </div>
                                                <% 
												}
												%>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="10u form1">
                                                    <h3 class="text-center mb-3">수상경력 추가</h3>
                                                    <form action="" method="post">
                                                        <input name="mode" type="hidden" value="1">
                                                        <div class="form-group">
                                                            <label class="control-label" for="award_name">수상한 대회 이름</label>
                                                            <input id="name" name="award_name" placeholder="ex) 제1회 넥슨 코딩 대회" type="text" class="form-control" required> </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="award_grade">수상한 상의 등급</label>
                                                            <input id="grade" name="award_grade" placeholder="ex) 금상" type="text" class="form-control" required> </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="award_ins">수상 기관</label>
                                                            <input id="ins" name="award_ins" placeholder="ex) 미래창조과학부" type="text" class="form-control" required> </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="award_date">수상 날짜</label>
                                                            <input id="date" name="award_date" type="date" class="form-control" required> </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="award_keyword">키워드</label>
                                                            <div class="col-md-4">
                                                                <select id="keyword" name="award_keyword" class="form-control">
                                                                    <%
                                                    for(int i=0;i<keywordArray.size();i++)
                                                    {
                    									JSONObject keyword=(JSONObject)keywordArray.get(i);
                    								%>
                                                                        <option value="<%=keyword.get("id")%>">
                                                                            <%=keyword.get("name")%>
                                                                        </option>
                                                                        <% 
                                                    }
                                                    %>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="Submit"></label>
                                                            <div class="col-md-4">
                                                                <button onclick="award_add(); return false;" class="btn btn-primary">추가하기</button>
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
                         <!-- modal -->
				        <div id="modalLayer">
						  <div class="modalContent">
						    <h4 style="margin-left:3%">License 수정 or 삭제</h4>
						    <hr>
						    <center>
						    <div style="margin-top:8%;">
						    <button style="margin-right:10%">수정</button>
						    <button onclick="award_delete(); return false;">삭제</button>
						    </div>
						    </center>
						    <br>
						    <hr>
						    <button type="button" id="delete_modal" style="float:right;">닫기</button>
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
                                                <li><a href="https://www.facebook.com/%EB%8C%80%EB%8D%95%EC%86%8C%ED%94%84%ED%8A%B8%EC%9B%A8%EC%96%B4%EB%A7%88%EC%9D%B4%EC%8A%A4%ED%84%B0%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90-463920667081098/" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                                                <li><a href="https://github.com/DSM-HS/StudentCouncil" class="icon fa-github"><span class="label">Twitter</span></a></li>
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
                    <script src="js/modal.js"></script>
                    <script src="js/jquery.dropotron.min.js"></script>
                    <script src="js/jquery.scrolly.min.js"></script>
                    <script src="js/jquery.onvisible.min.js"></script>
                    <script src="js/skel.min.js"></script>
                    <script src="js/util.js"></script>
                    <!--[if lte IE 8]><script src="js/ie/respond.min.js"></script><![endif]-->
                    <script src="js/main.js"></script>
                    <script>
                    var delete_obj;
	                	function into_modal(obj){
	                		console.log(obj);
	                		delete_obj=$(obj).parent();
	                	}
                        function award_add() {
                            var temp = new Object();
                            var name = $("#name").val();
                            var ins = $("#ins").val();
                            var grade = $("#grade").val();
                            var date = $("#date").val();
                            var keyword = $("#keyword").val();
                            temp.part = "2";
                            temp.name = name;
                            temp.ins = ins;
                            temp.grade = grade;
                            temp.date = date;
                            temp.keyword = keyword;
                            $.ajax({
                                url: '/2uzubook/ResumeAdd'
                                , type: 'post'
                                , data: temp
                                , dataType: 'json'
                                , success: function (data) {
                                    if (data.ret >= 0 && data.ret != null) {
                                        //성공처리
                                        var tag_div = '<div class="4u 12u(mobile)"><div class="row" id="modal_pop" style="cursor:pointer;"><div class="5u"><a class="image fit modalLink" onclick="into_modal(this); return false;"><img src="images/student/bulb.png" alt="" /></a></div><div class="7u"><h3 class="text-center" id="delete_name">' + name + '</h3>' + date + '</div></div></div>';
                                        $("#award_loc").prepend(tag_div);
                                        $("#name").val('');
                                        $("#date").val('');
                                        $("#ins").val('');
                                        $("#grade").val('');
                                        $("#keyword").val('');
                                        var modalLayer = $("#modalLayer");
                			            var modalLink = $(".modalLink");
                			            var modalCont = $(".modalContent");
                			            var marginLeft = modalCont.outerWidth()/2;
                			            var marginTop = modalCont.outerHeight()/2;
                			            modalLink.click(function(){
                			                modalLayer.fadeIn("slow");
                			                modalCont.css({"margin-top" : -marginTop, "margin-left" : -marginLeft});
                			                $(this).blur();
                			                return false;
                			              });
                                    }
                                    else {
                                        alert("add_fail");
                                    }
                                }
                                ,error:function(xhr,option,error){
                                	alert(xhr.status);
                                	alert(error);
                                }
                            });
                        }

                        function award_delete() {
                            console.log(delete_obj);
                            var delete_name=$(delete_obj).next(".7u").children("#delete_name");
                            var name=$(delete_name).text();
                            console.log(name);
                            award_del(delete_obj,name);
                        }

                        function award_del(obj,name) {
                           
                                $(obj).parent().parent().remove();
                                var temp = new Object();
                                temp.name = name;
                                temp.part = "1";
                                $.ajax({
                                    url: '/2uzubook/ResumeRemove'
                                    , type: 'post'
                                    , data: temp
                                    , success: function (data) {
                                    	if(data.status>=0){
                                    		$("#modalLayer").fadeOut("slow");
                        					$(".modalLink").focus();
                        				}else{
                        					alert("delete_fail");
                        				}
                                    }
                                    , dataType: 'json'
                                });
                            
                        }

                        function go() {
                            var frm = document.getElementById('frm1');
                            console.log('hel');
                            frm.submit();
                        }
                    </script>
                </body>

                </html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	JSONObject jsonObject= (JSONObject) request.getAttribute("JSONObject");
	
	JSONArray licenses=(JSONArray)jsonObject.get("licenses");
	JSONArray awards=(JSONArray)jsonObject.get("awards");
	JSONArray projects=(JSONArray)jsonObject.get("projects");
	JSONArray conferences=(JSONArray)jsonObject.get("conferences");
	JSONArray clubs=(JSONArray)jsonObject.get("clubs");
	JSONArray reads=(JSONArray)jsonObject.get("reads");
	JSONArray volunteers=(JSONArray)jsonObject.get("volunteers");
	JSONArray tests=(JSONArray)jsonObject.get("tests");
	
	System.out.println(jsonObject);//log
	String name=(String)jsonObject.get("name");
	String major=(String)jsonObject.get("major");
	int student_id=(Integer)jsonObject.get("student_id");
	String gender=(String)jsonObject.get("gender");
	String email=(String)jsonObject.get("email");
	
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
                    <li><a href="index.html">Home</a></li>
                    <li><a href="login.html">로그인 / 회원가입</a></li>
                    <li> <a href="#">For Student</a>
                        <ul>
                            <li><a href="myresume.html">내 레주메 보기</a></li>
                            <li><a href="myresume_manage.html">레주메 내용 관리</a></li>
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
                        <section>
                            <header>
                                <h3><a href="#">"세상과 소통하는 게임 개발자"</a></h3> </header>
                            <p> <strong>관심 분야</strong>
                                <br> 게임 개발, C++, 언리얼엔진 </p>
						<% for(int i=0;i<licenses.size();i++)
						{	
								JSONObject licen=(JSONObject)licenses.get(i);
						%>
                            <div class="row 50%">
                                <div class="4u">
                                    <a class="image fit"><img src="images/student/license.png" alt="" /></a>
                                </div>
                                <div class="8u">
                                    <h4><%=(String)licen.get("licenseName")%></h4>
                                    <p> <%=(String)licen.get("licenseDate")%></p>
                                </div>
                            </div>
						<% 
						}
						%>
                            <br>
                            <p> <strong><h3>Awards</h3></strong></p>
                       	<%for(int i=0;i<awards.size();i++){
                            JSONObject awd=(JSONObject)awards.get(i);
                            	%>
                            <div class="row 50%">
                                <div class="4u">
                                    <a class="image fit"><img src="images/student/trophy.png" alt="" /></a>
                                </div>
                                <div class="8u">
                                    <h4><%=(String)awd.get("awardName")%><br><strong><%=(String)awd.get("award") %></strong></h4>
                                    <p> <%=(String)awd.get("awardDate") %> </p>
                                </div>
                            </div>
						<%
						} 
						%>
                            <footer><form id="frm" action="/2uzubook/myresume" method="post"></form><a href="onesee.jsp" class="button">한눈에 보기</a> </footer>
                        </section>
                    </div>
                    <div class="9u 12u(mobile) important(mobile)" id="content">
                        <article id="main">
                            <header>
                                <h2><strong><%=name %></strong></h2>
                                <h3><%=major %> - <%=student_id %></h3>
                                <p> </p>
                            </header>
                            <a href="#" class="image featured"><img src="images/debate3.jpg" alt="" /></a>
                            <header> <h3>대외 참여(공모전/컨퍼런스)</h3> </header>
                             <p>
								<%for(int i=0;i<conferences.size();i++)
                            	{
                            		JSONObject conference=(JSONObject)conferences.get(i);
                            	%>
									<strong>⦁<%=conference.get("name") %> (<%=conference.get("date") %>)	</strong> <br>
								<%} %> 
								</article>
                    </div>
                </div>
                <hr />
                <div class="12u 12u(mobile) important(mobile)" id="content">
                    <article id="main">
                        <header>
                            <h2>Project</h2> </header>
                        <div class="row">
                        <%for(int i=0;i<projects.size();i++)
                        {
                        	JSONObject project=(JSONObject)projects.get(i);
                        %>
                            <div class="6u 12u(mobile)">
                                <div class="row">
                                    <div class="12u">
                                        <h3 class="text-center">"<%=(String)project.get("name")%>"</h3> <%=(String)project.get("startdate") %>~<%=(String)project.get("enddate")%>
                                        <br> ⦁ <%=(String)project.get("desc") %></div>
                                </div>
                            </div>
                         <%
                         }
                         %>   
                        </div>
                    </article>
                </div>
                <hr />
                <div class="12u 12u(mobile) important(mobile)" id="content">
                    <article id="main">
                        <header>
                            <h2>동아리 활동</h2> </header>
                        <div class="row">
                        <%
                        for(int i=0;i<clubs.size();i++)
                        {
                        	JSONObject club=(JSONObject)clubs.get(i);
                        %>
                            <div class="6u 12u(mobile)">
                                <div class="row">
                                    <div class="12u">
                                        <h3 class="text-center"><%=(String)club.get("name") %></h3> <%=(String)club.get("startdate") %>~<%=(String)club.get("enddate")%>
                                        <br> ⦁ <%=(String)club.get("desc") %> </div>
                                </div>
                            </div>
                       <%
                        }
                       %>
                        </div>
                    </article>
                </div>
                <hr />
                <div class="12u 12u(mobile) important(mobile)" id="content">
                    <article id="main">
                        <header>
                            <h2>기타사항</h2> </header>
                        <div class="row">
                            <div class="6u 12u(mobile)">
                                <div class="row">
                                    <div class="12u">
                                        <h3 class="text-center">독서</h3> 
                                        	<%for(int i=0;i<reads.size();i++)
                                        	{
                                        		JSONObject read=(JSONObject)reads.get(i);
                                        	%>
                                        			
                                        		<%=read.get("name") %> (<%=read.get("date") %>) <br>
                                        	<%
                                        	}
                                        	%>
                                    </div>
                                </div>
                            </div>
                            <div class="6u 12u(mobile)">
                                <div class="row">
                                    <div class="12u">
                                        <h3 class="text-center">봉사</h3> 
                                        	<%for(int i=0;i<volunteers.size();i++)
                                        	{
                                        		JSONObject volunteer=(JSONObject)volunteers.get(i);
                                        	%>
                                        	<%=volunteer.get("name") %> (<%=volunteer.get("starttime") %>~ <%=volunteer.get("endtime")%>)<br>
                                        	<%
                                        	}
                                        	%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </article>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <div id="footer">
            <div class="row">
                <div class="12u">
                    <!-- Contact -->
                    <section class="contact">
                        <header>
                            <h3>저와 함께 개발을 하고 싶거나 궁금한 사항이 있으면 연락주세요</h3> </header>
                        <p><%=email%></p>
                        <ul class="icons">
                            <li><a href="https://www.facebook.com" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                            <li><a href="https://github.com/yjh5424" class="icon fa-github"><span class="label">Github</span></a></li>
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
    function go(){
		var frm=$("#frm");
		console.log('hel');
		frm.submit();
	}
    </script>
</body>

</html>
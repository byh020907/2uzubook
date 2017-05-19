<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="bbs.BbsDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP 게시판 웹 사이트</title>
<style type="text/css">
	a, a:hover{
		color:#000000;
		text-decoration: none;
	}
</style>

</head>
<body>
	<%
		String userID=null;
		if(session.getAttribute("userID") !=null){
			userID=(String)session.getAttribute("userID");
		}
		
		int pageNumber=1;//기본페이지
		if(request.getParameter("pageNumber")!=null){
			pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp"> JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인 </a></li>
				<li class="active"><a href="boardlist.jsp">게시판 </a></li>
			</ul>

			<%
				if(userID==null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a> <!--#링크를 알려줌  -->
					<ul class="dropdown-menu">
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="join.jsp">회원가입</a></li>
					</ul></li>
			</ul>
			<%  /* 세션이없어서 즉 회원가입이 안된 사람은 회원가입 창이 뜨도록 하는것  */
				}else{
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a> <!--#링크를 알려줌  -->
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">로그아웃</a></li>
					</ul></li>
			</ul>
			<% 
				}
			%>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align:center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
					</tr>
				</thead>
				<tbody>
				<%
					BbsDAO bbsDAO= BbsDAO.getInstance();
					ArrayList<Bbs> list=bbsDAO.getList(pageNumber);
					for(int i=0; i<list.size();i++){
				%>
					<tr>
					 	<td><%= list.get(i).getBbsID() %></td>
					 	<td><a href="view.jsp?bbsID=<%=list.get(i).getBbsID() %>"> <%=list.get(i).getBbsTitle() %> </a></td>
					 	<td><%= list.get(i).getUserID() %></td>
					 	<td><%= list.get(i).getBbsData().substring(0,10)+" "+list.get(i).getBbsData().substring(11,13)+"시"+list.get(i).getBbsData().substring(14,16)+"분" %></td>
					</tr>
				<% 	
					}
				%>
				</tbody>
			</table>
			<%
				if(pageNumber!=1){
			%>
				<a href="boardlist.jsp?pageNumber=<%=pageNumber-1%>" class="btn btn-success">이전</a>
			<%	
				} if(bbsDAO.nextPage(pageNumber + 1)){ //다음페이지가 존재하는지 여부
					
			%>
				<a href="boardlist.jsp?pageNumber=<%=pageNumber+1%>" class="btn btn-success">다음</a>
				
			<%
				}
			%>
			<a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
		</div>
	</div>
	
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
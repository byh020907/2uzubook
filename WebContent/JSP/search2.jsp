<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	JSONArray jsonArray = (JSONArray) request.getAttribute("JSONArray");
	System.out.println(jsonArray);
	int[] index = new int[20];
	String[] name = new String[20];
	String[] major = new String[20];

	for (int i = 0; i < jsonArray.size(); i++) {
		JSONObject jobj = (JSONObject) jsonArray.get(i);
		index[i] = i;
		name[i] = (String) jobj.get("name");
		major[i] = (String) jobj.get("major");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
<link rel="stylesheet" type="text/css" href="/2uzubook/CSS/search2.css" />
<link rel="stylesheet" type="text/css" href="/2uzubook/CSS/input2.css"/>
</head>
<body>
<! Nav >
	<nav id="nav">
		<ul>
			<li class="one"><a href="index.jsp">Home</a></li>
			<li class="one"><a href="index.jsp">Resume</a>
				<ul>
					<li><a href="#">1학년 resume &hellip;</a>
						<ul>
							<li><a href="firstcommon.jsp">공통과</a></li>
						</ul></li>
					<li><a href="#">2학년 resume &hellip;</a>
						<ul>
							<li><a href="secondsoftware.jsp">소프트웨어 개발과</a></li>
							<li><a href="secondembeded.jsp">임베디드 개발과</a></li>
							<li><a href="secondsecurity.jsp">정보보안과</a></li>
						</ul></li>
					<li><a href="#">3학년 resume &hellip;</a>
						<ul>
							<li><a href="thirdsoftware.jsp">소프트웨어 개발과</a></li>
							<li><a href="thirdembeded.jsp">임베디드 개발과</a></li>
							<li><a href="thirdsecurity.jsp">정보보안과</a></li>
						</ul></li>

				</ul></li>

			<li class="one"><a href="login.jsp">Login</a></li>
		</ul>
	</nav>

	<div class="searchPart">
		<form>
			<input type="text" placeholder="search!!" name="2" /> 
			<input type="submit" value="검색" />
		</form>
		<br>
	</div>
	<div class="list0">
<%
	if(jsonArray!=null)
	{
		for(int j=0;j<jsonArray.size();j++)
		{
			if(j%2==0)
			{
			%>
			<div class="list1" style="float:left">
			<%=name[j]%>
			<br>
			<%=major[j] %>
			<hr color="#ffcccc">
			</div>
<%
			}
			else{
				%>
				<div class="list2" style="float:right">
					<%=name[j] %>
					<br>
					<%=major[j] %>
					<hr color="#ffcccc">
				</div>
				
<% 
			}
		}
	}
%>
	
	</div>
</body>
</html>
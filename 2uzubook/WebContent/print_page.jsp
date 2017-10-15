<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	JSONArray jsonArray= (JSONArray) request.getAttribute("JSONArray"); 
	
	for(int i=0;i<jsonArray.size();i++)
	{
		JSONObject jsonObject=(JSONObject)jsonArray.get(i);
		JSONArray licenses=(JSONArray)jsonObject.get("licenses");
		JSONArray awards=(JSONArray)jsonObject.get("awards");
		JSONArray projects=(JSONArray)jsonObject.get("projects");
		JSONArray conferences=(JSONArray)jsonObject.get("conferences");
		JSONArray clubs=(JSONArray)jsonObject.get("clubs");
		JSONArray reads=(JSONArray)jsonObject.get("readings");
		JSONArray volunteers=(JSONArray)jsonObject.get("volunteers");
		JSONArray tests=(JSONArray)jsonObject.get("tests");
		
		System.out.println(jsonObject);//log
		String name=(String)jsonObject.get("name");
		int major=(Integer)jsonObject.get("major");
		
		String majorName=(String)jsonObject.get("majorName");
		
		int student_id=(Integer)jsonObject.get("stu_id");
		String gender=(String)jsonObject.get("gender");
		String email=(String)jsonObject.get("email");
	
%>
	<div id="leftside">
		<table class="info">
			<thead>
				<tr>
					<th scope="cols">학생 정보</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row"><img src="/images/student/stu6.jpg"
						class="studentimg"></th>
					<td>
						<h2>
							<%=student_id %> <%=majorName %> <br> <%=name %>
						</h2> <strong><%=email %></strong> <br> 웹해킹 <br> 컴퓨터 보안
						<br> sw 개발
					</td>
				</tr>
			</tbody>
		</table>
		<table class="career">
			<thead>
				<tr>
					<th scope="cols">경력사항</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">자격증</th>
					<td><% for(int a=0;a<licenses.size();a++)
						{
						JSONObject licen=(JSONObject)licenses.get(a);
						%>
							<%=(String)licen.get("name")%> (<%=(Date)licen.get("date") %>)<br>
						<% 
						}
						%> </td>
				</tr>
				<tr>
					<th scope="row">수상</th>
					<td>
					<%for(int b=0;b<awards.size();b++){
                            JSONObject awd=(JSONObject)awards.get(b);
                    %>
						<%=(String)awd.get("name")%> <%=(String)awd.get("grade")%> (<%=(Date)awd.get("date") %>) <br> 
					<%
					}
					%>
					</td>
				</tr>
			
				<tr>
					<th scope="row">시험</th>
					<td>
					<%for(int c=0;c<tests.size();c++)
                      {
                           JSONObject test=(JSONObject)tests.get(c);
                    %>
						<%=test.get("name")%> <%=(Date)test.get("date") %>(<%=test.get("score")%>) <br>
					<%
					}
					%>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<table class="major">
		<thead>
			<tr>
				<th scope="cols">전공활동</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">프로젝트</th>
				<td>
					<%for(int d=0;d<projects.size();d++)
                    {
                        JSONObject project=(JSONObject)projects.get(d);
                    %>
						<h4>프로젝트<%=i%> : <%=(String)project.get("name")%></h4> - <%=(String)project.get("desc")%><br>
					<%
                    }
					%>
				</td>
			</tr>
			<tr>
				<th scope="row">전공 동아리</th>
				<td>
				<%
                    for(int e=0;e<clubs.size();e++)
                    {
                        JSONObject club=(JSONObject)clubs.get(e);
                %>
					<h4><%=(String)club.get("name") %> (<%=(Date)club.get("startdate") %>~<%=(Date)club.get("enddate")%>)</h4>
					-<%=(String)club.get("desc") %><br>
					<%
                    }
					%>
				</td>
			</tr>
			<tr>
				<th scope="row">대외 참여</th>
				<td>
					<%for(int f=0;f<conferences.size();f++)
                     {
                            JSONObject conference=(JSONObject)conferences.get(f);
                    %>
						<%=conference.get("name") %> (<%=(Date)conference.get("date") %>)
					<%
                     }
					%> 
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%
	}
	%>
	<script>
	$(document).ready(function() {
		 window.print();
	}); 
	</script>
</body>
</html>
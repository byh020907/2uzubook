<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	JSONObject jsonObject= (JSONObject) request.getAttribute("JSONObject");
	
	JSONArray licenses=(JSONArray)jsonObject.get("licenses");
	JSONArray awards=(JSONArray)jsonObject.get("awards");
	JSONArray contests=(JSONArray)jsonObject.get("contests");
	JSONArray projects=(JSONArray)jsonObject.get("projects");
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
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/table.css/">
</head>

<body>
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
							2학년 1반 소프트웨어개발과 <br> 윤정현
						</h2> <strong>jafj4a2@naver.com</strong> <br> 웹해킹 <br> 컴퓨터 보안
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
					<td><% for(int i=0;i<licenses.size();i++)
						{
						JSONObject licen=(JSONObject)licenses.get(i);
						%>
							<%=(String)licen.get(licenseName)%> <br>
						<% 
						} 
						%> </td>
				</tr>
				<tr>
					<th scope="row">수상</th>
					<td>
					<%for(int i=0;i<awards.size();i++){
                            JSONObject awd=(JSONObject)awards.get(i);
                    %>
						<%=(String)awd.get("awardName")%> <%=(String)awd.get("award")%> (<%=(String)awd.get("awardDate") %>) <br> 
					</td>
				</tr>
				<tr>
					<th scope="row">대회 공모전</th>
					<td>
					<%for(int i=0;i<contests.size();i++)
                      {
                           JSONObject contest=(JSONObject)contests.get(i);
                    %>
                    	<%=contest.get("contestName") %> (<%=contest.get("contestDate") %>) <br>
					</td>
				</tr>
				<tr>
					<th scope="row">어학</th>
					<td>
					<%for(int i=0;i<tests.size();i++)
                      {
                           JSONObject test=(JSONObject)tests.get(i);
                    %>
						<%=test.get("name")%> <%=test.get("testDate") %>(<%=test.get("score")%>) <br>
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
					<%for(int i=0;i<projects.size();i++)
                    {
                        JSONObject project=(JSONObject)projects.get(i);
                    %>
						<h4>프로젝트<%=i%> : <%=(String)project.get("name")%></h4> - <%=(String)project.get("desc")%>
					<%
                    }
					%>
				</td>
			</tr>
			<tr>
				<th scope="row">전공 동아리</th>
				<td>
				<%
                    for(int i=0;i<clubs.size();i++)
                    {
                        JSONObject club=(JSONObject)clubs.get(i);
                %>
					<h4><%=(String)club.get("name") %> (<%=(String)club.get("startdate") %>~<%=(String)club.get("enddate")%>)</h4>
					-<%=(String)club.get("desc") %>
					<%
                    }
					%>
				</td>
			</tr>
			<tr>
				<th scope="row">대외 참여</th>
				<td>
					<%for(int i=0;i<conferences.size();i++)
                     {
                            JSONObject conference=(JSONObject)conferences.get(i);
                    %>
						<%=conference.get("name") %> (<%=conference.get("date") %>)
					<%
                     }
					%> 
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="java.util.*"%>
<%
		request.setCharacterEncoding("UTF-8");
		
		JSONObject jsonObject= (JSONObject) request.getAttribute("JSONObject");
		
		JSONArray licenses=(JSONArray)jsonObject.get("licenses");
		JSONArray awards=(JSONArray)jsonObject.get("awards");
		JSONArray projects=(JSONArray)jsonObject.get("projects");
		JSONArray conferences=(JSONArray)jsonObject.get("conferences");
		JSONArray clubs=(JSONArray)jsonObject.get("clubs");
		JSONArray reads=(JSONArray)jsonObject.get("readings");
		JSONArray volunteers=(JSONArray)jsonObject.get("volunteers");
		JSONArray tests=(JSONArray)jsonObject.get("tests");
		JSONArray interests=(JSONArray)jsonObject.get("interests");
		
		System.out.println(jsonObject);//log
		String name=(String)jsonObject.get("name");
		int major=(Integer)jsonObject.get("major");
		
		String majorName=(String)jsonObject.get("majorName");
		
		int student_id=(Integer)jsonObject.get("stu_id");
		String gender=(String)jsonObject.get("gender");
		String email=(String)jsonObject.get("email");
	
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/table.css">
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
					<th scope="row"><img src="/2uzubook/ImageServlet?studentID=<%=student_id %>&gender=<%=gender%>" class="studentimg"> </th>
					<td>
						<h2>
							<%=student_id %> <%=majorName %> <br> <%=name %>
						</h2> <strong><%=email %></strong> 
						<%for(int i=0;i<interests.size();i++){ 
						JSONObject interest=(JSONObject)interests.get(i);
						%>
						<br><%=interest.get("name")%>
						<%}%>
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
							<%=(String)licen.get("name")%> (<%=(Date)licen.get("date") %>)<br>
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
						<%=(String)awd.get("name")%> <%=(String)awd.get("grade")%> (<%=(Date)awd.get("date") %>) <br> 
					<%
					}
					%>
					</td>
				</tr>
			
				<tr>
					<th scope="row">시험</th>
					<td>
					<%for(int i=0;i<tests.size();i++)
                      {
                           JSONObject test=(JSONObject)tests.get(i);
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
					<%for(int i=0;i<projects.size();i++)
                    {
                        JSONObject project=(JSONObject)projects.get(i);
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
                    for(int i=0;i<clubs.size();i++)
                    {
                        JSONObject club=(JSONObject)clubs.get(i);
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
					<%for(int i=0;i<conferences.size();i++)
                     {
                            JSONObject conference=(JSONObject)conferences.get(i);
                    %>
						<%=conference.get("name") %> (<%=(Date)conference.get("date") %>) <br>
					<%
                     }
					%> 
				</td>
			</tr>
		</tbody>
	</table>
     <table class="major">
        <thead>
            <tr>
                <th scope="cols">기타</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">봉사</th>
                <td> 중랑천 청소 (2016. 5. 20)
                    <br> 사이버안전훈련 청소 (2016 . 7. 21 ~ 7.22)
                    <br> 녹색 발명대회 (2016. 6.15)</td>
            </tr>
            <tr>
                <th scope="row">독서</th>
                <td>
                    신데렐라 (2016. 5. 20)
                    <br> 콩쥐팥쥐 (2016 . 7. 21 ~ 7.22)
                    <br> 앙기모띠 (2016. 6.15) </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
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
<link rel="stylesheet" href="../CSS/search2.css" />
</head>
<body>
	<div>
		<form>
			<input type="text" placeholder="search!!" name="2" /> <input
				type="submit" value="검색" />
		</form>
		<br>

	</div>
	<div class="list1">
<%
	if(jsonArray!=null)
	{
		for(int j=0;j<jsonArray.size();j++)
		{
			System.out.print(name[j]+" ");
			System.out.println(major[j]);
%>
			<hr color="#ffcccc">
<%
		}
	}
%>
	
	</div>
</body>
</html>
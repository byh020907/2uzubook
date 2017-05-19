<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="bbs.BbsDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP �Խ��� �� ����Ʈ</title>
</head>
<body>
	<%
		String userID=null;
		if(session.getAttribute("userID") !=null){
			userID=(String)session.getAttribute("userID");
		}
		int bbsID=0;
		if(request.getParameter("bbsID")!=null){
			bbsID=Integer.parseInt(request.getParameter("bbsID"));
		}
		if(bbsID==0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('��ȿ���� ���� ���Դϴ�..')");
			script.println("location.href = 'login.jsp'");
			script.println("</script>");
		}
		Bbs bbs=BbsDAO.getInstance().getBbs(bbsID);
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp"> JSP �Խ��� �� ����Ʈ</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">���� </a></li>
				<li class="active"><a href="boardlist.jsp">�Խ��� </a></li>
			</ul>

			<%
				if(userID==null){
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">�����ϱ�<span class="caret"></span></a> <!--#��ũ�� �˷���  -->
					<ul class="dropdown-menu">
						<li><a href="login.jsp">�α���</a></li>
						<li><a href="join.jsp">ȸ������</a></li>
					</ul></li>
			</ul>
			<%  /* �����̾�� �� ȸ�������� �ȵ� ����� ȸ������ â�� �ߵ��� �ϴ°�  */
				}else{
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">ȸ������<span class="caret"></span></a> <!--#��ũ�� �˷���  -->
					<ul class="dropdown-menu">
						<li><a href="logoutAction.jsp">�α׾ƿ�</a></li>
					</ul></li>
			</ul>
			<%
				}
			%>
		</div>
	</nav>
	<div class="container">
		<div class="row">

			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"
							style="background-color: #eeeeee; text-align: center;">�Խ��� ��
							����</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">������</td>
						<td colspan="2"><%= bbs.getBbsTitle().replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>")  %></td>
					</tr>

					<tr>
						<td>�ۼ���</td>
						<td colspan="2"><%= bbs.getBbsID() %></td>
					</tr>

					<tr>
						<td>�ۼ�����</td>
						<td colspan="2"><%= bbs.getBbsData().substring(11,13)+"��"+bbs.getBbsData().substring(14,16)+"��"  %></td>
					</tr>

					<tr>
						<td>����</td>
						<td colspan="2" style="min-height: 200px; text-align: left;'"><%= bbs.getBbsContent().replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">","&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
				</tbody>
			</table>
			<a href="boardlist.jsp" class="btn btn-primary">���</a>
			<%
					if(userID !=null && userID.equals(bbs.getUserID())){
			%>
					<a href="update.jsp?bbsID=<%=bbsID%>" class="btn btn-primary">����</a>
					<a onClick="return confirm('������ �����Ͻðڽ��ϱ�?')" href="deleteAction.jsp?bbsID=<%=bbsID%>" class="btn btn-primary">����</a>
					
			<% 
				}
			%>
			<input type="submit" class="btn btn-primary pull-right" value="�۾���">

		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="user.UserDAO"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"></jsp:useBean> <!--scope �������������� �۵�  -->
<jsp:setProperty property="userID" name="user" />   <!--���� �Ķ���Ϳ� userŬ������ setter�żҵ��� ��Ī  -->
<jsp:setProperty property="userPassword" name="user"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP �Խ��� �� ����Ʈ</title>
</head>
<body>
	<%	
		//String checkbox=request.getParameter("checkbox"); üũ�ڽ��� ���� ��� ���� ���� ����  ���̾ƴϸ� ��������
		String userID= null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID"); //setAttribute ��ü�ι�ȯ�ϱ⿡ String ĳ����
		}
		/* if(checkbox!=null){ */
		if(userID!=null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�̹� �α����� �Ǿ��ֽ��ϴ�.')");
			script.println("location.href = 'main.jsp'");
			script.println("</script>");
			}
		/* } */
		UserDAO userDao = UserDAO.getInstance();
		int result = userDao.login(user.getUserID(), user.getUserPassword());
		if (result == 1) {
		/* 	if(checkbox!=null){ */
			session.setAttribute("userID", user.getUserID());
			/* } */
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'main.jsp'"); //�α��� ������ ���������� �̵�
			script.println("</script>");
		} else if (result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('��й�ȣ�� Ʋ���ϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		} else if (result == -1) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�������� �ʴ� ���̵��Դϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		} else if (result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�����ͺ��̽� ������ �߻��߽��ϴ�.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
</body>
</html>
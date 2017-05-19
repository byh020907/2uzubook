<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="user.UserDAO"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="user.User" scope="page"></jsp:useBean> <!--scope 이페이지에서만 작동  -->
<jsp:setProperty property="userID" name="user" />   <!--폼의 파라미터와 user클래스의 setter매소도를 매칭  -->
<jsp:setProperty property="userPassword" name="user"/>
<jsp:setProperty property="userName" name="user"/>
<jsp:setProperty property="userGender" name="user"/>
<jsp:setProperty property="userEmail" name="user"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
		/* String checkbox = request.getParameter("checkbox"); //체크박스가 널일경우 세션 저장 ㄴㄴ  널이아니면 세션저장 */
		String userID = null;
		if (session.getAttribute("userID") != null) {
			userID = (String) session.getAttribute("userID"); //setAttribute 객체로반환하기에 String 캐스팅
		}
		/* if (checkbox != null) { */
			if (userID != null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('이미 로그인이 되어있습니다.')");
				script.println("location.href = 'main.jsp'");
				script.println("</script>");
			}
		/* } */
		if (user.getUserID() == null || user.getUserPassword() == null || user.getUserName() == null
				|| user.getUserGender() == null || user.getUserEmail() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입렫이 안된 사항이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			UserDAO userDao = UserDAO.getInstance();
			int result = userDao.join(user);
			if (result == -1) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('존재하는 아이디입니다.')");
				script.println("history.back()");
				script.println("</script>");
			} else {
				/* if (checkbox != null) { */
					session.setAttribute("userID", user.getUserID());
				/* } */
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("location.href= 'main.jsp'");
				script.println("</script>");
			}
		}
	%>
</body>
</html>
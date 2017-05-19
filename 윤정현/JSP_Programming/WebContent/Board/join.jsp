<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" 
				data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">  JSP �Խ��� �� ����Ʈ</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">���� </a></li>
				<li><a href="bbs.jsp">�Խ��� </a></li>	
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">�����ϱ�<span class="caret"></span></a> <!--#��ũ�� �˷���  -->
					<ul class="dropdown-menu">
						<li class="active"><a href="login.jsp">�α���</a></li>
						<li><a href="join.jsp">ȸ������</a></li>
					</ul>
				</li>
			</ul>
			
		</div>
	</nav>  
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px">
				<form action="joinAction.jsp" method="post"> <!--������ ó���� joinAction Page  -->
					<h3 style="text-align: center;">ȸ������</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="���̵�"
							name="userID" maxlength="20">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" placeholder="�����ȣ"
							name="userPassword" maxlength="20">
					</div>

					<div class="form-group">
						<input type="text" class="form-control" placeholder="�̸�"
							name="userName" maxlength="20">
					</div>

					

					<div class="form-group" style="text-align: center;">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <input
								type="radio" name="userGender" autocomplete="off" value="����"
								checked>����
							</label>
							<!--active ���� Ȱ��ȭ�Ȱ�  -->

							<label class="btn btn-primary"> <input type="radio"
								name="userGender" autocomplete="off" value="����" checked>����
							</label>
						</div>
					</div>
					
					<div class="form-group">
						<input type="email" class="form-control" placeholder="Email"
							name="userEmail" maxlength="30">
					</div>


					<!-- <div class="checkbox">
					<label>
						<input type="checkbox" name="checkbox" value="0">Remember me 
					</label>
					</div> -->

					<input type="submit" class="btn btn-primary form-control"
						value="ȸ������">
				</form>

			</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

</body>
</html>
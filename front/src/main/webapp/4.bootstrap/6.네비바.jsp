<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="1.��ġ.jsp" %>
	
		<div class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container">
		    <button class="navbar-toggler" type="button" 
		    	data-bs-toggle="collapse" data-bs-target="#navmenu" >
		      <span class="navbar-toggler-icon"></span>
		    </button>
			<div class="collapse navbar-collapse" id="navmenu"> <!-- 760px ���Ϸ� �Ǹ� �޴� �����   -->
				
				<a href="#" class="navbar-brand">�ΰ�</a>
				
				<ul class="navbar-nav"> <!-- �׺���̼� ��� -->
					<li class="nav-item"> <a href="#" class="nav-link">�޴�1</a> </li> <!-- �׺���̼� ��� �� -->
					<li class="nav-item"> <a href="#" class="nav-link">�޴�2</a> </li>
					<li class="nav-item"> <a href="#" class="nav-link">�޴�3</a> </li>
					
					<li class="nav-item dropdown"> <!-- ����ٿ�  -->
						<!-- �ϴ� �ؽ�Ʈ�� Ŭ�������� �޴� ��ġ�� -->
						<a href="#" class="nav-link" data-bs-toggle="dropdown">
						����ٿ�
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#"> ����ٿ� �޴�1 </a>
							<a class="dropdown-item" href="#"> ����ٿ� �޴�2 </a>
							<a class="dropdown-item" href="#"> ����ٿ� �޴�3 </a>
						</div>
					</li>
				</ul> <!-- �׺���̼� ��� �� -->
				<form action="">
					<div class="row">
						<div class="col-md-5">
							<input type="text" class="form-control" placeholder="�˻���">
						</div>
						<div class="col-md-5">
							<button class="form-control" type="submit">�˻�</button>
						</div>
					</div>
				</form>
			</div>
			
		</div>
	</div>
	
	
</body>
</html>





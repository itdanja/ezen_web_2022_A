<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<!-- ���� ��ġ(����)�� �ٸ� ���� �����ϱ� -->
	<%@include file = "header.jsp" %>
	<br><br><br><br><br><br>
	<!--  ĳ���� : �̹��� �����̵�  -->
	<div id="cs" class="carousel slide" data-bs-ride="carousel" data-bs-interval="1000">
								<!-- �����̵�ð� : �и���(1000/1��)  -->
		<!-- �����̵� ��ġ ǥ�� : �ε������� -->
		<div class="carousel-indicators">
			<button data-bs-target="#cs" data-bs-slide-to="0" class="active"></button>
			<button data-bs-target="#cs" data-bs-slide-to="1"></button>
			<button data-bs-target="#cs" data-bs-slide-to="2"></button>
			<button data-bs-target="#cs" data-bs-slide-to="3"></button>
		</div>
		 <!-- ĳ���� ���빰 -->
		<div class="carousel-inner">
			<div class="carousel-item active"> <img alt="" src="img/mainimage1.jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/mainimage2.jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/mainimage3.jpg"> </div>
			<div class="carousel-item "> <img alt="" src="img/mainimage4.jpg"> </div>
		</div>
		<!-- �̹��� �̵� ��ư -->
		<button class="carousel-control-prev" data-bs-target="#cs" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
		</button>
		<button class="carousel-control-next" data-bs-target="#cs" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
		</button>
		
	</div> <!-- ĳ���� end  -->
	<br><br>
	
	<div class="container text-center">
		<hr> <!-- �Ǽ� �±� -->
			<h3> New ARRIVAL </h3>
			<p> �Ż�ǰ </p>
	</div>
	
	<div class="container">
		<div class="row">
			<% for( int i = 0 ; i<8 ; i++ ){ %>
				<div class="col-md-3 col-sm-6">	<!-- col-md-3 : col-md: 760px; �̻��ϰ��   col-sm : 570px �̻��ϰ�� --> 
					<div class="card"> <!-- ī������ -->
						<img class="card-img-top" alt="" src="img/item1.gif"> <!-- �̹��� -->
						<div class="card-body">
							<p class="item">
								<span class="title"></span>
								<br>
								<span class="content">
								[1+1] ������� ������ ������
								(��S/M/L/XL/2XL/3XL)
								700�� �ı� ����! ���� �Ǹ� 1��!
								</span>
								<br>
								<span class="price1"> 79,900�� </span>  
								<span class="price2"> 75,900�� </span>
								<br>
								<span class="badge bg-warning text-dark my-3"> �ֹ� ���� </span>
								<span class="badge bg-danger text-dark my-3" > ǰ�� �Թ� </span>
							</p>
						</div>
					</div>
				</div>
			<% } %>
				
		</div>
	</div>
	
	
	
	
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>





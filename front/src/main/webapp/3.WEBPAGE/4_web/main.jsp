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
		
	</div>
	
	
	
	<%@include file = "footer.jsp" %>
	
</body>
</html>





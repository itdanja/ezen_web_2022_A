<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file = "header.jsp" %>
	<div class="container">
		<div id="mainslide" class="carousel slide" data-bs-ride="carousel" data-bs-interval="1000"> <!-- 캐러셀  -->
																<!-- 슬라이드 지연시간 ( 밀리초 ) -->
			<!-- 슬라이드 하단 위치 버튼  -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="1" ></button>
				<button type="button" data-bs-target="#mainslide" data-bs-slide-to="2" ></button>
			</div>	
			<!-- 이미지 목록  -->														
			<div class="carousel-inner"> 
				<div class="carousel-item active"> <!-- 이미지 -->
					<img alt="" src="img/mainpageimg1.jpg">
				</div>
				<div class="carousel-item"> <!-- 이미지 -->
					<img alt="" src="img/mainpageimg2.jpg">
				</div>
				<div class="carousel-item"> <!-- 이미지 -->
					<img alt="" src="img/mainpageimg3.jpg">
				</div>
			</div>
			<!-- 왼쪽 이동 버튼  -->
			<button class="carousel-control-prev" type="button" data-bs-target="#mainslide" data-bs-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</button>
			<!-- 오른쪽 이동 버튼  -->
			<button class="carousel-control-next" type="button" data-bs-target="#mainslide" data-bs-slide="next">
				<span class="carousel-control-next-icon"></span>
			</button>
		</div>
		<div class="row adbox"> <!-- 광고 / 이벤트 -->
			<div class="col-md-6">
				<img alt="" src="img/mainad1.gif">
			</div>
			<div class="col-md-6">
				<img alt="" src="img/mainad2.jpg">
			</div>
		</div>
		<div class="main_box">	<!--베스트-->
			<h6 class="main_title"> BEST </h6>
			<div class="row">
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
			</div>
		</div>
		<div class="main_box"> <!--  신상품 -->
			<h6 class="main_title"> NEW ARRIVAL </h6>
			<div class="row">
				<div class="col-md-4 best_box">
					<img alt="" src="img/img1.webp">
					<div class="p_item">
						<div class="p_title">페어리 머슬핏 라운드 반팔 니트</div>
						<div class="p_size"> FREE , M , L </div>
						<div class="row">
							<div class="p_discount"> 62,000원 </div>
							<div class="p_price"> 29,000원</div>
							<div class="p_review"> 리뷰 : 412</div>
						</div>
					</div>
				</div>
				<div class="col-md-4 best_box">
					<img alt="" src="img/img1.webp">
				</div>
				<div class="col-md-4 best_box">
					<img alt="" src="img/img1.webp">
				</div>
			</div>
		</div>
		<div>	<!-- 실시간 구매후기 -->
			
		</div>
	</div>
	<%@include file = "footer.jsp" %>

</body>
</html>




<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<!-- 부트스트랩 css 포함 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자 정의한 css 포함 -->
	<link href="css/main.css" rel="stylesheet">
	
</head>
<body>
	<div class="container"> <!-- 박스권 형성 -->
		<div class="py-3"> <!-- 상단 메뉴 -->
				<!-- p : 안쪽 여백	py-* : 위아래 안쪽 여백   
					m : 바깥 여백 	my-* : 위아래 바깥 여백
				-->
			<div class="row"> <!-- 가로 배치 -->
				<div class="col-md-4 offset-4 text-center"> <!-- 그리드[12조각중 4조각] -->
						<!-- text-center : 박스권내 내용물 가운데 정렬 -->
						<!-- offset-4 : 여백 그리드 -->
					<a href="main.jsp" class="header_logo"> 안산 남자 쇼핑몰 </a> <!-- 링크 -->
				</div>
				<div class="col-md-4 d-flex justify-content-end"> <!-- 상단 메뉴  -->
					<ul class="nav"> <!-- nav : 가로배치 -->
						<li> <a href="#">로그인</a> | </li>
						<li> <a href="#">회원가입</a> | </li>
						<li> <a href="#">장바구니</a> | </li>
					</ul>
				</div>
				
			</div>
		</div>
	</div>

	<!-- 부트스트랩 js 포함 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>








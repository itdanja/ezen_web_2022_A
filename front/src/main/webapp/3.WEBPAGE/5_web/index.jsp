<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<!-- 부트스트랩 css cdn -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자정의 css -->
	<link href="index.css" rel="stylesheet" >
	<!-- 폰트어썸[ 아이콘 ]  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">

</head>
<body>
	<!-- 부트스트랩 js cdn  -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<!-- https://huns.co.kr/      : 훈스 -->
	<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5"> <!-- 상단고정 --> 
		<div class="col-md-7 offset-5 d-flex justify-content-end"> <!-- 헤더 메뉴( 오른쪽 배치 )  -->
			<ul class="nav"> <!-- 해당 리스트[ ul , ol ] 가로 배치[ inline ] -->
				<li class="tophead"> <a href="login.jsp">LOGIN</a></li>
				<li class="tophead"> <a href="#">JOIN</a> </li>
				<li class="tophead"> <a href="#">CART</a> </li>
				<li class="tophead"> <a href="#">MY PAGE</a> </li>
				<li class="tophead"> <a href="#">SNS</a> </li>
				<li class="tophead"> <a href="#">BOOKMARK</a> </li>
			</ul>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-2 sidemenu"> <!-- 사이드바 메뉴 -->
			<h3> HUNS </h3>
			<ul>
				<li> BEST </li>
				<li> NEW </li>
				<li> 당일배송 </li>
				<li> 1+1 / 코디세트 </li>
			</ul>
			<ul>
				<li> 아우터 </li>
				<li> 상의 </li>
				<li> 셔츠 </li>
				<li> 니트/가디건 </li>
				<li> 팬츠 </li>
				<li> 트레이닝 </li>
				<li> 신발 </li>
				<li> 악세사리 </li>
				<li> 세일 </li>
			</ul>
			<ul>
				<li> NOTICE </li>
				<li> Q & A </li>
				<li> REVIEW </li>
				<li> EVENT </li>
			</ul>
			<div>
				<input type="text"> <i class="fas fa-search"></i>
			</div>
			<div>
				고객센터　xxx-xxxx-xxxx <br>
				카카오채널 @이젠 <br>
				MON - FRI AM9 - PM4 <br>
				(LUNCH TIME PM12:30 - PM13:30) <br>
				SAT, SUN, HOLIDAY CLOSE <br>
				업무시간외 문의는<br>
				Q＆A 게시판을 이용부탁드립니다.  <br>
				우리은행 xxxx-xxx-xxxxxxxx <br>
				예금주 : (주)이젠컴퍼니
			</div>
		</div>
		<div class="col-md-10 offset-2 content"> <!-- 본문 -->
			<div> <!-- 캐러셀 -->
				캐러셀
			</div>
			
			<div> <!-- 제품 --> 
				제품 3개씩
			</div>
			
			<div> <!-- 푸터 -->
				푸터 3구역 
			</div>
		</div>
		
	</div>
</body>
</html>





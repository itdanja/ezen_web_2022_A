<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ezen 쇼핑몰</title>
	<!-- 부트스트랩 css cdn -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 사용자정의 css -->
	<link href="/jspweb/css/main.css" rel="stylesheet">
	<!-- 폰트어썸[ 아이콘 ]  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<!--   헤더페이지[ 모든 페이지 사용되기 때문에 = 최상위에서 절대경로 ] -->
	<%
		String loginid 
		= (String)session.getAttribute("login"); // 세션 호출 ( 기본타입 = Odject )
	%>
	<div class="container"> <!-- container : 박스권 -->
	
		<div class="py-4"> <!-- py : 위아래 패딩(안쪽여백) -->
			<div class="row"> <!-- row : 가로배치 -->
				<div class="col-md-4"> <!-- 그리드[12조각중 4 ] -->
					<a href="/jspweb/main.jsp" class="header_logo">EZEN SHOP</a>
				</div>
				<div class="col-md-4 offset-4 d-flex justify-content-end header_topmenu"> <!-- offset 공백그리드 -->
				
					<ul class="nav"> <!-- nav : li 가로배치  -->
					<% if( loginid == null ){ %> <!--  로그인이 안된 상태 = 만약에 세션이 없으면  -->
						<li> <a href="/jspweb/member/login.jsp" class="header_topmenu">로그인</a> · </li>
						<li> <a href="/jspweb/member/signup.jsp"  class="header_topmenu">회원가입</a> · </li> 
					<%} %>
					<% if( loginid != null ){ %> <!--  만약에 로그인된 상태 = 만약에 세션이 있으면 -->
						<li> <span  class="header_topmenu"> <%=loginid %>님 </span> · </li>
						<li> <a href="/jspweb/logout"  class="header_topmenu">로그아웃</a> · </li>
						<li> <a href="/jspweb/member/myshopping.jsp"  class="header_topmenu">나의쇼핑</a> · </li>
						
						<!-- 로그인 id가 admin이면  -->
						<%  if( loginid.equals("admin") ){ %>
							<li> <a href="/jspweb/admin/dashboard.jsp"  class="header_topmenu">관리자모드</a> </li>
						<%} %>
						
					<%} %>
						<li> <a href="/jspweb/board/boardlist.jsp?key=&keyword="  class="header_topmenu">자유게시판</a> </li>
					</ul>
				</div>
			</div>
		</div>  <!--  상단 메뉴 끝  -->
		
		<div class="navbar navbar-expand-md navbar-light bg-white">  <!--  본메뉴  -->
			<ul class="navbar-nav col-md-12 justify-content-between"> 
				<li class="nav-item"> <a href="#"> BIG SIZE </a> </li>
				<li class="nav-item"> <a href="#" style="color: #00D8FF;"> MUSCLE-FIT </a> </li>
				<li class="nav-item"> <a href="#" style="color: #0100FF;"> 1+1 이벤트 </a> </li>
				
				<li class="nav-item dropdown"> <!-- dropdown : 드랍다운 -->
					 <a href="#"> 아우터 </a> <!--  data-bs-toggle="dropdown" : 해당 태그를 클릭했을때 드랍다운 열기  -->
					<!-- 드롭다운 -->
					<div class="dropdown-menu">	<!--  dropdown-menu : 드랍다운 내용물  -->
						<a class="dropdown-item" href="#"> 드랍다운 메뉴 </a>
						<a class="dropdown-item" href="#"> 드랍다운 메뉴 </a>
						<a class="dropdown-item" href="#"> 드랍다운 메뉴 </a>
						<a class="dropdown-item" href="#"> 드랍다운 메뉴 </a>
						<a class="dropdown-item" href="#"> 드랍다운 메뉴 </a>
					</div>
				 </li>
				 
				<li class="nav-item"> <a href="#"> 상의 </a> </li>
				<li class="nav-item"> <a href="#"> 바지 </a> </li>
				<li class="nav-item"> <a href="#"> 슈즈 </a> </li>
				<li class="nav-item"> <a href="#"> 악세사리 </a> </li>
				<li class="nav-item"> <a href="#"> BEST </a> </li>
				<li class="nav-item"> <a href="/jspweb/teamchatting.jsp"> 트레이닝 </a> </li>
				<li class="nav-item"> <a href="/jspweb/teammarble.jsp" style="color: #FFBB00;"> 모델처러입자 </a> </li>
				<li class="nav-item"> <a href="#" style="color: #FF0000;"> 50% 할인 </a> </li>
				<li class="nav-item"> 
					<input type="text" class="header_input" size="13"> 
					<a href="#"><i class="fas fa-search"></i></a>
				</li>
				<li class="nav-item"> <a href="/jspweb/product/productcart.jsp">장바구니<span class="shoppingbox">3</span></a></li>
			</ul>
		</div> <!-- 본 메뉴 끝 -->
		
	</div> <!--  메뉴 끝  -->
		
	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- 사용자정의 js -->
	<script src="/jspweb/js/main.js" type="text/javascript"></script>
	<!-- jquery 최신 cdn -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>






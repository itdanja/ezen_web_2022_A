<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="1.설치.jsp" %>
	
		<div class="navbar navbar-expand-lg navbar-light bg-light">
		  <div class="container">
		    <button class="navbar-toggler" type="button" 
		    	data-bs-toggle="collapse" data-bs-target="#navmenu" >
		      <span class="navbar-toggler-icon"></span>
		    </button>
			<div class="collapse navbar-collapse" id="navmenu"> <!-- 760px 이하로 되면 메뉴 사라짐   -->
				
				<a href="#" class="navbar-brand">로고</a>
				
				<ul class="navbar-nav"> <!-- 네비게이션 목록 -->
					<li class="nav-item"> <a href="#" class="nav-link">메뉴1</a> </li> <!-- 네비게이션 목록 값 -->
					<li class="nav-item"> <a href="#" class="nav-link">메뉴2</a> </li>
					<li class="nav-item"> <a href="#" class="nav-link">메뉴3</a> </li>
					
					<li class="nav-item dropdown"> <!-- 드랍다운  -->
						<!-- 하단 텍스트를 클릭했을때 메뉴 펼치기 -->
						<a href="#" class="nav-link" data-bs-toggle="dropdown">
						드랍다운
						</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#"> 드랍다운 메뉴1 </a>
							<a class="dropdown-item" href="#"> 드랍다운 메뉴2 </a>
							<a class="dropdown-item" href="#"> 드랍다운 메뉴3 </a>
						</div>
					</li>
				</ul> <!-- 네비게이션 목록 끝 -->
				<form action="">
					<div class="row">
						<div class="col-md-5">
							<input type="text" class="form-control" placeholder="검색어">
						</div>
						<div class="col-md-5">
							<button class="form-control" type="submit">검색</button>
						</div>
					</div>
				</form>
			</div>
			
		</div>
	</div>
	
	
</body>
</html>





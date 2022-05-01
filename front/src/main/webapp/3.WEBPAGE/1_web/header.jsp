<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		/* <a href> 링크 사용시 기본값 제거 */
		a{ text-decoration: none; color: black; }
		a:hover {  color: orange; }
		/* 기본값으로 여백이 들어가는 경우 기본 여백 제거 */
		*{ padding: 0px; margin: 0px;  }
		#header{
			width: 1150px; 	/*가로길이 */
			height: 100px;	/* 세로길이 */
			margin: 0 auto;	/* 박스권 가운데정렬 */
		}
		
		#logo{ float: left; margin: 20px 0 0 20px; }
		#menus{ float: right;}
		#top_menu{
			text-align: right;
			margin-top: 20px;
		}
		#main_menu{
			margin-top: 20px; font-family: "궁서";
			font-size: 20px;
		}
		#main_menu li{ 
			display: inline; 	/* 메뉴 가로 배치 */
			margin-left: 80px; /* 메뉴 간 간격 */ 
		}
	</style>

</head>
<body>
	
	<div id="header">
		<div id="logo"><!-- 로고 -->
			<a href="index.jsp"> <img alt="" src="img/logo.png"> </a>
		</div> 
		<div id="menus">	<!-- 메뉴 -->
			<div id="top_menu"> <!-- 상단 메뉴  -->
				<a href="login.jsp">로그인</a> | 
				<a href="signup.jsp">회원가입</a> | 
				<a href="board.jsp">공지사항</a>
			</div>
			<ul id="main_menu"> <!--  메인 메뉴  -->
				<li> <a href="#">사진이론</a> </li>
				<li> <a href="#">사진구도</a> </li>
				<li> <a href="#">사진작가</a> </li>
				<li> <a href="#">갤러리1</a> </li>
				<li> <a href="#">갤러리2</a> </li>
			</ul>
		</div>
	</div>
	

</body>
</html>














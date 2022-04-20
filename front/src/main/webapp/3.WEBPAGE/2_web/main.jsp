<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		#sidebar{ width: 250px; float: left; }
		#main{ width: 840px; float: right; }
		#sidebar .title1{
			background-color: #0ca9a3;
			color: white; padding: 15px;
			font-size: 18px;
		}
		#sidebar .comment{ padding: 15px; line-height: 150%; }
		#sidebar #search input{ width: 150px; height: 28px; }
		#sidebar #search button { margin-left: 5px; padding: 6px 10px;}
		#sidebar .title2{
			border-top: solid 2px black;
			border-bottom: solid 1px #eeeeee;
			padding: 15px; margin-top: 30px;
			font-size: 15px;
		}
		#sidebar .list{ margin: 20px 0px; }
		#sidebar .list li{ margin: 10px; }
		
		#left_main{ width: 400px; float: left;}
		#right_main{ width: 400px; float: right;}
		
		#left_main .title1{
			border-bottom: solid 2px black; padding-bottom: 8px;
		}	
		#left_main .boardul{ margin-top: 20px; margin-bottom: 50px;} 
		#left_main .items{ height: 30px;}
		#left_main .items .subject{  float: left;  }
		#left_main .items .date{ float: right; }
		
		#right_main .items{
			float: right; width: 190px;
			margin-top: 30px; 
		}
		#right_main .subject{
			margin-top: 10px; font-size: 15px; font-weight: bold;
		}
		#right_main .date{ margin-top: 5px;}
		
	</style>


















</head>
<body>
	<div id="box">
		<div id="sidebar" > <!-- 사이드바 -->
			<h3 class="title1"> The 베이킹 </h3>
			<p class="comment"> 안녕하세요. 쿠키와 빵 만들기 정보를 공유하고 소통하는 공간입니다. </p>
			<div id="search">
				<input type="text"><button>검색</button>
			</div>
			<h3 class="title2"> 베이킹/요리 </h3>
			<ul class="list">
				<li> 쿠키 만들기 </li>
				<li> 빵 만들기 </li>
				<li> 마카롱 만들기 </li>
			</ul>
			<h3 class="title2"> 최근 댓글 </h3>
			<ul class="list">
				<li> 쿠키 만들기 </li>
				<li> 빵 만들기 </li>
				<li> 마카롱 만들기 </li>
			</ul>
		</div>
		
		<div> <!-- 메인메뉴 -->
		</div>
		<div id="main">
			<div id="left_main"> <!--  게시판 구역  -->
				<h3 class="title1"> 알림 </h3>
				<ul class="boardul">
					<li class="items">  
						<div class="subject">쿠키 클래스 연기합니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">쿠키 클래스 연기합니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">쿠키 클래스 연기합니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">쿠키 클래스 연기합니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">쿠키 클래스 연기합니다.</div> 
						<div class="date">09.30</div> 
					</li>
				</ul>
				
				<h3 class="title1"> 게시판 </h3>
				<ul class="boardul">
					<li class="items">  
						<div class="subject">안녕하세요 반값습니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">안녕하세요 반값습니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">안녕하세요 반값습니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">안녕하세요 반값습니다.</div> 
						<div class="date">09.30</div> 
					</li>
					<li class="items">  
						<div class="subject">안녕하세요 반값습니다.</div> 
						<div class="date">09.30</div> 
					</li>
				</ul>
				
			</div>
			
			<div id="right_main"> <!--  제품 구역  -->
				 <h3 class="title1"> 제방 클래스 </h3>
				 <ul class="items">
				 	<li> <img alt="" src="img/bread1.png"> </li>
				 	<li class="subject"> 도너츠 만들기[3] </li>
				 	<li class="date"> 21.09.30 </li>
				 </ul>
				 <ul class="items">
				 	<li> <img alt="" src="img/bread2.png"> </li>
				 	<li class="subject"> 도너츠 만들기[3] </li>
				 	<li class="date"> 21.09.30 </li>
				 </ul>
				 <ul class="items">
				 	<li> <img alt="" src="img/bread3.png"> </li>
				 	<li class="subject"> 도너츠 만들기[3] </li>
				 	<li class="date"> 21.09.30 </li>
				 </ul>
				 <ul class="items">
				 	<li> <img alt="" src="img/bread4.png"> </li>
				 	<li class="subject"> 도너츠 만들기[3] </li>
				 	<li class="date"> 21.09.30 </li>
				 </ul>
			</div>
		</div>
		
	</div>
</body>
</html>

















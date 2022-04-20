<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		
		#footer{ 
			clear: both; 
			background-color:#05354e; 
			color: white;  
			height: 250px;
		}
		#footer_menu{
			padding: 20px;	font-weight: bold;
		}
		#footer_menu li{
			display: inline;	/*가로배치 */
			margin-right: 30px;	/* 간격 */
		}
		#footer .items{
			float: left;
			margin: 20px 100px 20px 20px;
		}
		#footer h3{ color:#088a69;  }
		#footer .items ul{ margin-top: 10px; }
		#footer .items li{ margin-top: 5px; }
		#footer .items #phone{ font-size: 25px; font-weight: bold;}
		
	</style>
























</head>
<body>

	<div id="footer">
		<div id="box">
			<ul id="footer_menu"> 
				<li> The 베이킹 소개 </li>
				<li> 개인정보처리방침 </li>
				<li> 저작권 정보 </li>
				<li> 이용 안내 </li>
			</ul>
			<div class="items">
				<h3> 문의전화 </h3>
				<ul>
					<li id="phone"> 123-1234 </li>
					<li> 10:00 ~ 18:00 ( Lunch 12:00 ~ 13:00 ) </li>
				</ul>
			 </div>
			<div class="items"> 
				<h3> The 베이킹 </h3>
				<ul>
					<li> 주소 : 경기도 용인시 기흥구 동백대로 123 </li>
					<li> 전화 : 031-123-1234 </li>
					<li> 팩스 : 031-123-1234 </li>
					<li> 이메일 : 031-123-1234 </li>
				</ul>
			</div>
			<div class="items"> 
				<h3> 입금 정보 </h3>
				<ul>
					<li> 농협 123-123-123456 </li>
					<li> The 베이킹 </li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>
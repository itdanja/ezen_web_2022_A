<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		#footer{
			width: 100%;
			height: 150px;
			clear: both;	/* 앞 태그의 float 제거 */
			background-color: #2c2a29;
		}
		#footer_box{
			width: 1150px;
			height: 150px;
			margin: 0 auto;
		}
		#footer_logo{
			float: left;
			margin: 50px 0 0 30px;
		}
		#address{
			float: right;
			margin: 50px 30px 0px 0px;
			color: white;
		}
	</style>
	
</head>
<body>

	<div id="footer">
		<div id="footer_box">
		
			<div id="footer_logo"> <!-- logo --> 
				<img alt="" src="img/footer_logo.png">
			</div>
			
			<ul id="address"> <!-- 주소 -->
				<li>서울시 강남구 삼성동 1234 우:123-1234</li>
				<li>TEL:031-123-1234 Email : email@domain.com</li>
				<li>COPYRIGHT (C) 루바토 ALL RIGHTS RESERVED</li>
			</ul>
			
		</div>
	</div>

</body>
</html>



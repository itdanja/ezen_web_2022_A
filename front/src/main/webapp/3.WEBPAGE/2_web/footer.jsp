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
			display: inline;	/*���ι�ġ */
			margin-right: 30px;	/* ���� */
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
				<li> The ����ŷ �Ұ� </li>
				<li> ��������ó����ħ </li>
				<li> ���۱� ���� </li>
				<li> �̿� �ȳ� </li>
			</ul>
			<div class="items">
				<h3> ������ȭ </h3>
				<ul>
					<li id="phone"> 123-1234 </li>
					<li> 10:00 ~ 18:00 ( Lunch 12:00 ~ 13:00 ) </li>
				</ul>
			 </div>
			<div class="items"> 
				<h3> The ����ŷ </h3>
				<ul>
					<li> �ּ� : ��⵵ ���ν� ���ﱸ ������ 123 </li>
					<li> ��ȭ : 031-123-1234 </li>
					<li> �ѽ� : 031-123-1234 </li>
					<li> �̸��� : 031-123-1234 </li>
				</ul>
			</div>
			<div class="items"> 
				<h3> �Ա� ���� </h3>
				<ul>
					<li> ���� 123-123-123456 </li>
					<li> The ����ŷ </li>
				</ul>
			</div>
		</div>
	</div>

</body>
</html>
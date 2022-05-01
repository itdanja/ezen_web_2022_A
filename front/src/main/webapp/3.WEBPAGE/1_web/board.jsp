<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#contents{ width: 1150px; margin: 0 auto;}
		
		*{text-align: center;}
		
		#search{ background-color: #eeeeee; width: 1150px; padding : 10px; margin: 0 auto; }
		
		button {background-color : black; color:white; width: 50px; height: 30px;}
		input {width: 400px; height: 30px;}
	
		#title{height:30px; font-size: 18px; font-style: bold;}
		
		#table{ border-top : solid 1px gray; border-bottom : solid 1px gray;
			width: 1150px; margin: 0 auto; text-align: center; font-size: 18px; 
			border-collapse: collapse;}
	
		#table tr{border-bottom: solid 1px gray;}
		#table td{ padding: 25px 10px;}
		
	</style>
</head>
<body>
	<%@include file="header.jsp"%><!-- ��� -->
	<%@include file="mainimage.jsp"%><!-- ����̹��� -->
	<div id="contents">
	<!-- ���� -->
		<h3>�߰�����1 �Դϴ�.</h3>
		<p> �Ʒ��� �̹������� �Դϴ�.. �̹��������� ���� �����ϰ� �ۼ��Ͻÿ� </p>
		<img alt="" src="�߰�����1.png" border="3" style="padding: 10px">
		
			<h2>��������</h2>


		<form id="search">
			<input type="text" placeholder="�˻�� �Է����ּ���.">
			<button>�˻�</button>
		</form>
		
		<table id="table">
	
			<tr id="title">
				<td> ��ȣ </td> <td> ���� </td> <td> ����� </td>
			</tr>
			
			<tr>
				<td>3</td> <td>[��������] �������� ó����ħ ����ȳ�ó����ħ</td> <td>2017.07.13</td>
			</tr>
	
			<tr>
				<td>2</td> <td>�������� �ȳ��Դϴ�. �̿����ּż� �����մϴ�.</td> <td>2017.06.15</td>
			</tr>
	
			<tr>
				<td>1</td> <td>�������� �ȳ��Դϴ�. �̿����ּż� �����մϴ�.</td> <td>2017.06.15</td>
			</tr>
	 	
 		</table>
		
		
	</div>
	<%@include file="footer.jsp" %><!-- Ǫ�� -->
</body>
</html>
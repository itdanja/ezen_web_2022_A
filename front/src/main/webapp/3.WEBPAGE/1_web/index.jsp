<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	<style type="text/css">
		/* <a href> ��ũ ���� �⺻�� ���� */
		a{ text-decoration: none; color: black; }
		a:hover {  color: orange; }
		/* �⺻������ ������ ���� ��� �⺻ ���� ���� */
		*{ padding: 0px; margin: 0px;  }
		
		/* ���̾ƿ� �ۼ��� : ��ġȮ�� ( ���̾ƿ� �� ���� ���� ) */
		/* *{ border: solid 1px red; background-color: #eeeeee; } */
		
		#header{
			width: 1150px; 	/*���α��� */
			height: 100px;	/* ���α��� */
			margin: 0 auto;	/* �ڽ��� ������� */
		}
		#main_img{
			width: 100%;	/* ������*/
			height: 250px;
		}
		#contents{
			width: 1150px;
			margin: 0 auto;
		}
		#footer{
			width: 100%;
			height: 150px;
			clear: both;	/* �� �±��� float ���� */
			background-color: #2c2a29;
		}
		
	</style>

</head>
<body>
	 <!-- jsp���� :  �Ӽ� �±� [ �ڹ� ��밡�� ]  -->
	<%@include file="header.jsp"%>
	
	<%@include file="mainimage.jsp"%>
	
	<%@include file="main.jsp" %>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>













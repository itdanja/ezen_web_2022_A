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
		*{ border: solid 1px red; background-color: #eeeeee; }
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
			height: 600px;
		}
		#footer{
			width: 100%;
			height: 150px;
		}
		
		
		
	</style>

</head>
<body>
	 <!-- jsp���� :  �Ӽ� �±� [ �ڹ� ��밡�� ]  -->
	<%@include file="header.jsp"%>
	<div id="main_img"> �����̹��� </div>
	<div id="contents"> ����		</div>
	<div id="footer"> 	Ǫ�� 		</div>
	
</body>
</html>













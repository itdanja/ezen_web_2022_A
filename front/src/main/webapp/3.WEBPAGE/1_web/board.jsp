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
	<%@include file="header.jsp"%><!-- 헤더 -->
	<%@include file="mainimage.jsp"%><!-- 헤더이미지 -->
	<div id="contents">
	<!-- 본문 -->
		<h3>중간과제1 입니다.</h3>
		<p> 아래는 이미지파일 입니다.. 이미지파일을 보고 동일하게 작성하시오 </p>
		<img alt="" src="중간과제1.png" border="3" style="padding: 10px">
		
			<h2>공지사항</h2>


		<form id="search">
			<input type="text" placeholder="검색어를 입력해주세요.">
			<button>검색</button>
		</form>
		
		<table id="table">
	
			<tr id="title">
				<td> 번호 </td> <td> 제목 </td> <td> 등록일 </td>
			</tr>
			
			<tr>
				<td>3</td> <td>[공지사항] 개인정보 처리방침 변경안내처리방침</td> <td>2017.07.13</td>
			</tr>
	
			<tr>
				<td>2</td> <td>공지사항 안내입니다. 이용해주셔서 감사합니다.</td> <td>2017.06.15</td>
			</tr>
	
			<tr>
				<td>1</td> <td>공지사항 안내입니다. 이용해주셔서 감사합니다.</td> <td>2017.06.15</td>
			</tr>
	 	
 		</table>
		
		
	</div>
	<%@include file="footer.jsp" %><!-- 푸터 -->
</body>
</html>
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
		
		/* 레이아웃 작성시 : 위치확인 ( 레이아웃 후 삭제 예정 ) */
		/* *{ border: solid 1px red; background-color: #eeeeee; } */
		
		#header{
			width: 1150px; 	/*가로길이 */
			height: 100px;	/* 세로길이 */
			margin: 0 auto;	/* 박스권 가운데정렬 */
		}
		#main_img{
			width: 100%;	/* 반응형*/
			height: 250px;
		}
		#contents{
			width: 1150px;
			margin: 0 auto;
		}
		#footer{
			width: 100%;
			height: 150px;
			clear: both;	/* 앞 태그의 float 제거 */
			background-color: #2c2a29;
		}
		
	</style>

</head>
<body>
	 <!-- jsp문법 :  속성 태그 [ 자바 사용가능 ]  -->
	<%@include file="header.jsp"%>
	
	<%@include file="mainimage.jsp"%>
	
	<%@include file="main.jsp" %>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>













<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 제품 재고 </h3>
	카테고리 목록 
	<select id="categorybox"> <!-- 카테고리가 출력되는 부분 -->
	</select>
	제품 목록
	<select id="productbox"> <!-- 제품명이 출력되는 부분  -->
	</select>
	<form id="stockaddform" style="display: none;">
		색상 <input type="text" id="scolor">
		사이즈 <input type="text" id="ssize">
		수량 <input type="text" id="samount">
		<button type="button" onclick="stockadd()"> 재고 추가 </button>
	</form>
	
	재고 목록 
	<table class="table" id="stocklistbox"> 
	
	</table>
	
	<!-- 스크립트 추가 -->
	<script src="/jspweb/js/productstock.js" type="text/javascript"></script>

</body>
</html>








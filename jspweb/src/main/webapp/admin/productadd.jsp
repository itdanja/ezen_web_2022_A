<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 제품 등록 페이지 </h3>
	<form>
		제품명 <input type="text" id="pno" name="pno" placeholder="제품명"> <br>
		가격  <input type="text" id="pprice" name="pprice" placeholder="가격"> <br>
		할인율 <input type="text" id="pdiscount" name="pdiscount" placeholder="할인율"> <br>
		
		카테고리
			<button onclick="categorybtn()" type="button" >
				카테고리추가
			</button> 
		<br>
		
		<div id="categotyinput">
			
		</div>
		
		<div id="categorybox">
			* DB에 저장된 카테고리 만큼 버튼 표시 [ DB -> JAVA(서블릿) -> JS -> HTML ]
		</div>
		대표이미지 <input type="file" id="pimg" name="pimg"> <br>
		<button> 등록 </button>
	</form>
	
	<!-- 사용자정의 js 호출 --> <script src="/jspweb/js/productadd.js" type="text/javascript"></script>
	
</body>
</html>









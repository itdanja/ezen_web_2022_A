<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "header.jsp" %>
	<div class="container my-5">
		<h3> 비회원제 실시간 채팅 페이지[ 소켓X 게시판형식O] </h3>
		<div class="col-md-4 offset-4">
		
			<!-- overflow-y:scroll    div에 스크롤 만들기  -->
			<div id="contents" style="border: 2px dotted red; height: 500px; overflow-y:scroll">
				* 채팅 내용이 표시되는 구역
			</div>
			
			<div class="row g-0"> <!-- g-0 : div div 사이간 여백 제거  -->
				<div class="col-md-3">
					<input type="text" class="form-control" placeholder="닉네임" size="10">
				</div>
				<div class="col-md-7">
					<input type="text" class="form-control" placeholder="내용" size="20">
				</div>
				<div class="col-md-2">
					<button type="submit" class="form-control">입력</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file = "footer.jsp" %>





</body>
</html>














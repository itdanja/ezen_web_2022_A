<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%@include file="header.jsp" %>
	<br><br><br><br><br><br><br><br><br><br>
	
	<div class="container">
		<h3 class="text-center titleline"> 문의 글 </h3>
		<!-- 버튼 -->
		<div class="my-3">
			<a href="boardlist.jsp"><button class="btn btn-outline-info">목록</button></a>
			<a href="boardlist.jsp"><button class="btn btn-outline-info">수정</button></a> <!-- 작성자만 가능 [ 유효성검사 ] -->
			<a href="boardlist.jsp"><button class="btn btn-outline-info">삭제</button></a> <!-- 작성자만 가능 [ 유효성검사 ] -->
			<a href="boardlist.jsp"><button class="btn btn-outline-info">답변</button></a> <!-- 관리자만 가능 [ 유효성검사 ] -->
		</div>
		<!-- 작성자 입력한 내용 -->
		<div> <!-- div박스권 : display : block   /  span박스권 : display : inline -->
			<div> <span>작성자 </span> <span> 유재석 </span></div>
			<div> <span>문의날짜 </span> <span> 2022-04-24 10:10 </span></div>
		</div>
		<div>
			<input type="text" value="환불해주세요~~~" class="form-control" readonly >
		</div>
		<div>
			<textarea rows="20" cols="" class="form-control" readonly style="resize: none;" > 하하하하하하ㅏ하하하</textarea>
																	<!-- textarea 크기고정 -->
		</div>
		
		<div class="row my-4"> <!-- 첨부된 사진들  -->
			<h4> 첨부 사진 </h4>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
			<div class="col-md-3"> 
				<img alt="" src="img/item1.gif" width="100%">
			</div>
		</div>
		
		<!-- 관라자가 답변한 내용 -->
		<h4> 답변 </h4> 
		<p> 답변일 : 2022-04-23 12:10 </p>
		<div>
			<textarea rows="" cols="" class="form-control inputbackcolor" readonly style="resize: none;"  > 호호호호호호호호호호호 </textarea>
		</div>
		
	</div>
	<br><br><br><br><br><br><br><br><br><br>
	<%@include file="footer.jsp" %>
</body>
</html>














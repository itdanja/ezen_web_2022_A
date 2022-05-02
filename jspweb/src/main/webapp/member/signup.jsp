<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<%@include file = "../header.jsp" %>
<div class="container">
	<h3> 회원 페이지 </h3>
	<form>
		아이디 : <input type="text" id="mid" placeholder="user id">
		<span id="idchack"></span> 
		<br>
		비밀번호 : <input type="password" id="mpassword" placeholder="user password"> 
		비밀번호 확인 : <input type="password" id="mpasswordcheck" placeholder="password chack">
		<span id="passwordchack"></span>
		<br>
		이름 <input type="text" id="mname" placeholder="user name">
		<br>
		전화번호 : <input type="text" id="mphone" placeholder="user phone">
		<br>
		이메일 : <input type="text" id="memail" placeholder="user email">
		<br>
		주소 : <input type="text" id="maddress" placeholder="user address">
		<br>
		<button onclick="signup()" type="button">가입하기</button>
	</form>
</div>

<script src="../js/signup.js" type="text/javascript"></script>
<%@include file = "../footer.jsp" %>

</body>
</html>
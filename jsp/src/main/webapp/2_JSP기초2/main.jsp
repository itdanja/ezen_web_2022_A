<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 회원제 게시판 </h3>
	<a href="signup.jsp"><button>회원가입</button></a>
	<a href="write.jsp"><button>글쓰기</button></a>
	
	<form>
		<input type="text" name="id">
		<input type="password" name="passowrd">
		<input type="submit" value="로그인"> 
	</form>
	
	<table>
		<tr>
			<th> 번호 </th>  <th> 작성일 </th> 
			<th>작성자</th> 	<th> 제목 </th> <th> 내용 </th>
		</tr>
		<!-- 반복문 -->
		<tr>
		
		</tr>
	</table>
	
</body>
</html>












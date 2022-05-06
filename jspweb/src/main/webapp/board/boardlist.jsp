<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	
	<%@include file ="../header.jsp" %>

	<div class="container">
		<h3> 자유게시판 </h3>
		
		<%
			String mid = (String)session.getAttribute("login");
			if( mid != null ){
		%>
			<a href="boardwrite.jsp"> 글쓰기 </a>
		<%} %>
		
		<table class="table"> <!-- 테이블 -->
			<tr>
				<th> 번호 </th> <th> 제목 </th> <th> 작성자 </th> 
				<th> 조회수  </th> <th> 작성일 </th> 
			</tr>
			<!-- for 문 -->
			<%
				// 1. 모든 게시물  호출 
				ArrayList<Board> boardlist = 
					BoardDao.getBoardDao().getboardlist();
					System.out.println( boardlist);
				for( Board board : boardlist ){
					System.out.println( board.toString() );
			%>
				<tr>
					<td> <%=board.getBno() %> </td>
					<td> <%=board.getBtitle() %> </td>
					<td> <%=board.getMid() %> </td>
					<td> <%=board.getBview() %> </td>
					<td> <%=board.getBdate() %> </td>
				</tr>
			<%
				}
			%>
			
			
		</table>
	</div>
	<%@include file ="../footer.jsp" %>

</body>
</html>
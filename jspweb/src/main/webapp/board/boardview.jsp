<%@page import="dao.MemberDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file ="../header.jsp" %>
	<div class="container">
		<h3> 게시물 상세 </h3>
		<% 
			int bno = Integer.parseInt( request.getParameter("bno") );	
			Board board =  BoardDao.getBoardDao().getboard(bno);
			
			String mid = (String)session.getAttribute("login"); 	// 세션 
			if( board.getMno() == MemberDao.getmemberDao().getmno(mid) ){
		%>
		<a href="delete"> <button>삭제</button> </a>
		<a href="update.jsp"> <button>수정</button> </a>
		<%} %>
		<a href="boardlist.jsp"> <button>목록</button> </a>
		<table>
			<tr> <td>번호</td> <td><%=board.getBno() %></td> <td>작성자</td> <td><%=board.getMid() %></td> <td>작성일</td> <td><%=board.getBdate() %></td> </tr>
			<tr> <td>제목</td> <td><%=board.getBtitle() %></td> </tr>
			<tr> <td>내용</td> <td><%=board.getBcontent() %></td> </tr>
			<% if( board.getBfile() == null ){ // 첨부파일이 없을경우 %> 
				<tr> <td>첨부파일<td> <td> - </td> </tr> <!-- 첨부파일 다운로드 -->
			<%	}else{ // 첨부파일이 있을경우 %>
				<tr> <td>첨부파일<td> <td> <a href="filedown?bfile=<%=board.getBfile()%>">
					<%=board.getBfile() %></a> </td> </tr> <!-- 첨부파일 다운로드 -->
			<% } %>
			
		</table>
	</div>
	<%@include file ="../footer.jsp" %>

</body>
</html>














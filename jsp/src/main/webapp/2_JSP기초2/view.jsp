<%@page import="Dto.Board"%>
<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// view.jsp?bno=게시물번호
		int bno 
			= Integer.parseInt(request.getParameter("bno"));
		// 링크에서 선택한 게시물 가져오기 
		Dao dao = new Dao();
		Board board = dao.get(bno);
		
		// 만약 로그인된 정보와 작성자가 동일할경우 삭제/수정 표시
		String loginid = (String)session.getAttribute("loginid");
		if( loginid != null && loginid.equals( board.getBwriter() )){
						// null  값은 equals 불가능 
	%>
		<a href="bupdate.jsp"> <button>수정</button>  </a>
		<a href="bdeletecontroller.jsp?bno=<%=bno%>"> <button>삭제</button>  </a>
	<%
		}
	%>
	<a href="main.jsp"> <button>목록보기</button> </a>
	
	<div> 제목 : <%=board.getBtitle() %> </div>
	<div> 작성자 : <%=board.getBwriter() %> </div>
	<div> 작성일 : <%=board.getBno() %> </div>
	<div> 내용 : <%=board.getBcontent() %> </div>

</body>
</html>












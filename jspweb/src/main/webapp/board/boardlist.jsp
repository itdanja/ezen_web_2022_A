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
		<h4 class="boardlist_title"> 자유게시판 </h4>
<!-------------------------------- 페이징 계산 처리 ------------------------------------>
<%
	// 1. 게시물 전체 개수
	int totalrow = BoardDao.getBoardDao().gettotalrow();
	// 2. 현재 페이지번호 
	int currentpage = 1;
		// *요청받은 페이지번호 
		String pagenum = request.getParameter("pagenum");
		if( pagenum == null ){ // 만약에 페이지번호 요청이 없으면
			currentpage = 1; // 1페이지
		}else{
			currentpage = Integer.parseInt( pagenum ); // 요청된 페이지번호 -> 정수형변환 -> 현재페이지 설정 
		}
	// 3. 페이지당 게시물을 표시할 개수 
	int listsize = 5;	// 추후에 사용자에게 입력 받기 
	// 4. 페이지당 게시물의 시작번호 
	int startrow = (currentpage-1)*listsize; // 1페이지 -> 0  // 2페이지 -> 5  // 3페이지 -> 10 ~~~ 
	// 5. 마지막페이지 번호 
	int lastpage = 0;
	if( totalrow % listsize == 0 ){ 
		// 전체게시물 와 화면표시게시물수 나누기 했을때 나머지가 0이면
		lastpage = totalrow / listsize; 
	}else{
		lastpage = totalrow / listsize +1; 
		// 나머지가 있으면 나머지 게시물을 표시할 페이지 +1
	}
	// 5. 모든 게시물  호출 
	ArrayList<Board> boardlist = BoardDao.getBoardDao().getboardlist( startrow , listsize );
	
%>
<!------------------------- 전체글 / 인기글  버튼 구역 -------------------------- -->
		<div class="row boardlist_topbtn">
			<div class="col-md-1 offset-10">
				<button class="form-control">전체글</button>
			</div>
			<div class="col-md-1">
				<button class="form-control">인기글</button>
			</div>
		</div>
<!-- ---------------------- 테이블 구역 -------------------------- -->
		<table class="table table-hover text-center"> <!-- 테이블 -->
			<tr>
				<th width="10%"> 번호 </th> 
				<th width="50%"> 제목 </th> 
				<th width="15%"> 작성자 </th> 
				<th width="15%"> 작성일 </th> 
				<th width="10%"> 조회수  </th> 
			</tr>
			<!-- for 문 -->
			<% for( Board board : boardlist ){ %>
				<tr>
					<td> <%=board.getBno() %> </td>
					<td  style="text-align: left;"> 
							<a href="boardview.jsp?bno=<%=board.getBno()%>">
								<%=board.getBtitle() %>
							</a> 
					</td>
					<td> <%=board.getMid() %> </td>
					<td> <%=board.getBdate() %> </td>
					<td> <%=board.getBview() %> </td>
				</tr>
			<%
				}
			%>
		</table>
<!-- ---------------------- 글쓰기 버튼 구역 -------------------------- -->
		<div class="col-md-2 offset-10">
		<% String mid = (String)session.getAttribute("login");
			if( mid != null ){  
		%>
			<a href="boardwrite.jsp"> <button class="form-control">글쓰기</button> </a>
		<%}else{ %>
			<span>*로그인후 글쓰기 가능합니다.</span>
		<%} %>
		</div>

<!-------------------------- 페이징 입력 구역  -------------------------- -->		
		<div class="col-md-4 offset-4 d-flex justify-content-center">	<!--  d-flex justify-content-center : 박스권 내에서 가운데 배치 -->
			 <ul class="pagination">
			 	<li class="page-item">  <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage-1%> ">이전</a></li>
			 	<% for( int i = 1 ; i<=lastpage ; i++ ){ %>
			 		<li class="page-item"> 
				 		<a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=i%>"> 
				 			<%=i %> 
				 		</a> 
			 		</li>
				<%} %>
			 	<li class="page-item"> <a class="page-link pagenum" href="boardlist.jsp?pagenum=<%=currentpage+1%> ">다음</a></li>
			 </ul>
		</div>
<!-- ---------------------- 검색 입력 구역  -------------------------- -->		
		<form action="#" class="col-md-4 offset-4 d-flex justify-content-center">
			<div class="col-md-3">  <!-- 키워드 선택  -->
				<select class="form-select">
					<option> 제목 </option>
					<option> 내용 </option>
					<option> 작성자 </option>
				</select>
			</div>
			<div class="col-md-7"> <!-- 검색 입력창  -->
				<input type="text" class="form-control">
			</div>
			<div class="col-md-2">  <!-- 검색 버튼  -->
				<input type="submit" class="form-control" value="검색">
			</div>
		</form>
<!-- ------------------------------------------------------------ -->	
	</div>
	<%@include file ="../footer.jsp" %>

</body>
</html>



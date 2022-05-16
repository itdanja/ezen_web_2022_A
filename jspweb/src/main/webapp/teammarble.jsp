<%@page import="teamchatting.도시"%>
<%@page import="dao.BoardDao"%>
<%@page import="java.util.ArrayList"%>
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
	
		<button onclick="게임접속('<%=(String)session.getAttribute("login") %>')" class="btn">게임 접속하기</button>
		
		<div>
			<h3> 현재 접속된 유저들 </h3>
			<div id="접속명단">
				
			</div>
		</div>
	
		<table class="table my-5" id="게임상자">
		<%
			ArrayList<도시> list = BoardDao.getBoardDao().get도시();
			int 위치 = 1;
			for(int r = 1 ; r<=5 ; r++ ){
			%>
				<tr>
			<%
				for( int c = 1 ; c<=5 ; c++ ){

					if( ( r == 2 || r==3 || r== 4 ) && (c == 2 || c==3 || c== 4) ){ 
						
						if( r == 2 && c == 2){
			%>
						<td width="20%" style="background-color: #eeeeee"><h3>순서</h3><h5 id="턴표시" style="color: red;">플레이어1</h5></td>
			<%		
						}else if( r == 2 && c == 3){
			%>
						<td width="20%" style="background-color: #eeeeee">주사위 결과 <br> <h1 id="주사위표시"></h1></td>
			<%
						}else if( r == 3 && c == 3){
			%>
						<td width="20%" style="background-color: #eeeeee"> <button onclick="주사위돌리기()"> 주사위 버튼 </button></td>
			<%
						}else{
			%>
						<td width="20%" style="background-color: #eeeeee"> </td>
			<%			
						}
					}
					else{ 
			%>
						<td onClick="도시클릭(<%=list.get(위치-1).도시번호 %>)" width="20%" id=<%=위치 %> > 
							<h1> <%=list.get(위치-1).도시명 %> </h1>
							<div id="말위치"> 말1 , 말2 , 말3 </div>
						</td>
			<%			
						위치++;}
			%>
			<%
				}
			%>			
				</tr>
			<%
			}
		%>
		</table>
		
		<br>
		<div>
			<h3> 현재 잔액  : </h3>
			<h3> 현재 구매한 땅  : </h3>
		</div>
		
	</div>	
	<script src="/jspweb/teammarble.js" type="text/javascript"></script>
	<%@include file = "footer.jsp" %>
	

</body>
</html>
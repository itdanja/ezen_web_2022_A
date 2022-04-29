<%@page import="java.util.Random"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%! // 선언문 : [ (필드) 멤버 변수 ]
		String[] 게임판 = {" "," "," "," "," "," "," "," "," " }; // 게임판 
	%>
	
	<%	// 스크립트문  메소드 [ javaService 메소드 내에서 실행 ]
		out.print( Arrays.toString( 게임판) ); 	// 확인 [ Arrays.toString : 배열 내용물 출력 ]
	%>
	<%
		// 사용자 선택 
		for( int i = 0 ; i<게임판.length ;i++ ){
			if( request.getParameter( i+"" ) !=null && request.getParameter(i+"").equals(i+"") && 게임판[i].equals(" ") ){
				out.print(i+"번 선택 !!! ");
				게임판[i] = "O";
				// 컴퓨터 난수 생성
				while(true){
					Random random = new Random();
					int com = random.nextInt(9);
					if( 게임판[com].equals(" ") ){ 게임판[com] = "X"; break; }
				}
			}
		}
	
	String winner = ""; // 승리 알을 담을 변수 
				for( int i = 0 ; i<=6 ; i+=3 ) {
					if( 게임판[i].equals(게임판[i+1] ) && 게임판[i+1].equals(게임판[i+2])  ) {
						if( !게임판[i].equals("[ ]") ) {
							// ! : 부정 [ true => false ]
							winner = 게임판[i];
						}
					}
				}
					// 2. 0 3 6  // 1 4 7 // 2 5 8   [세로로 이기는수] 모양이 같을경우 해당 모양 승리
				for( int i = 0 ; i<=2 ; i++  ) {
					if( 게임판[i].equals(게임판[i+3]) && 게임판[i+3].equals(게임판[i+6])) {
						if( !게임판[i].equals("[ ]") ) {
							// ! : 부정 [ true => false ]
							winner = 게임판[i];
						}
					}
				}
					// 3. 0 4 8  // 2 4 6			 [대각선로 이기는수]모양이 같을경우 해당 모양 승리
				if( 게임판[0].equals(게임판[4]) && 게임판[4].equals(게임판[8]) ) {
					if( !게임판[0].equals("[ ]") ) {
						// ! : 부정 [ true => false ]
						winner = 게임판[0];
					}
				}
				if( 게임판[2].equals(게임판[4]) && 게임판[4].equals(게임판[6])) {
					if( !게임판[2].equals("[ ]") ) {
						// ! : 부정 [ true => false ]
						winner = 게임판[2];
					}
				}
	%>

	<form action="5_틱택토.jsp" method="get">
		<% for( int i = 0 ; i<게임판.length; i++){ %>	<!-- 0부터 9까지 1씩증가 -->
		
			<button type="submit" value="<%=i %>" name="<%=i %>" > <%=i %>버튼 </button>
				<!-- type=전송  value="i번째 인덱스"	name="i번째 인덱스" -->	
			
			<!-- 3줄마다 줄바꿈 -->
			<% if( i % 3 == 2 ){ out.print("<br>"); }  %>
			
		<%} %>
	</form>
	
	<div> <%=winner %></div>

</body>
</html>
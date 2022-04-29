<%@page import="java.util.Calendar"%>
<%@page import="java.time.Year"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% // 자바언어 작성되는 공간
			// 폼이 전송하기전에는 요청 할수가 없다. [ null ]
		
		// 1. 현재 달력 가져오기 
		Calendar calendar = Calendar.getInstance(); 
		int year = calendar.get( Calendar.YEAR); 		// 1-2. 현재 연도
		int month = calendar.get( Calendar.MONDAY)+1; 	// 1-3. 현재 월

		boolean ch = false; // 출력가능 달력이면 false
		
		// 2. 요청변수가 있을경우 [ 요청변수가 null 아니면 ]
		if(  request.getParameter("year") != null &&
				request.getParameter("month") != null ){
			year =  Integer.parseInt( request.getParameter("year") ); // 2-2. form에서 입력받은 값 요청 
			month = Integer.parseInt( request.getParameter("month") );// 2-3. form에서 입력받은 값 요청 
			// 만약에 월이 1 미만 이면 연도 1감소 월12 설정
			if( month < 1 ){
				month = 12; year--;
			}
			// 만약에 월이 12 초과 이면 연도 1증가 월1 설정
			if( month > 12 ){
				month = 1 ; year++;
			}
			// 지원 불가 달력이면  1900년 이하
			if( year < 1900 || year > 2300 || month < 0 || month > 12 ){
				ch = true; // 출력 불가능 달력이면 true;
			}
		}
		// 3. 입력받은 값으로 달력 설정
		calendar.set( year , month-1 , 1 ); // month-1 차감하는이유 : 0:1월  ~  11:12월
		int sweek = calendar.get( Calendar.DAY_OF_WEEK ); // 해당 월의 시작 요일 구하기 
		int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH ); // 해당 월의 마지막 일 구하기 
		
	%>
	<!-- html 작성 공간 -->
	<%if( ch == true ){ %>
		<div> 표현 할수 없는 달력입니다. </div>
	<%}%>
	<form action="4_달력.jsp" method="get">
		<!-- action="폼이 전송될 위치(파일명)" -->
		<input type="text" name="year" placeholder="연도">
		<input type="text" name="month" placeholder="월">
		<input type="submit" value="검색">
	</form>
	<p> 입력한 연도 : <%=year %> </p>
	<p> 입력한 월 : <%=month %> </p>
	
	<form action="4_달력.jsp" method="get">
		<input type="text" name="year" value="<%=year %>">
		<input type="text" name="month" value="<%=month-1 %>">
		<input type="submit" value="이전">	<!-- 현재 월 -1 -->
	</form>
	
	<form action="4_달력.jsp" method="get">
		<input type="text" name="year" value="<%=year %>">
		<input type="text" name="month" value="<%=month+1 %>">
		<input type="submit" value="다음">    <!-- 현재 월 +1  -->
	</form>


	<table>
		<tr>
			<th> 일요일 </th> 	<th> 월요일 </th> <th> 화요일 </th> <th> 수요일 </th> 
			<th> 목요일 </th>		<th> 금요일 </th>	 <th> 토요일 </th>
		</tr>
		<tr>
			<!-- 시작 요일( 2022/4 기준 => 6 ) 미만 공백으로 채움 -->
			<% for(int i = 1 ; i<sweek ; i++ ) { %>
				<td> </td>	<!-- 해당 셀 공백 -->
			<%} %>
			<!-- 1일부터 마지막일까지 1씩 증가 하면서 출력 -->
			<% for( int i = 1 ; i<=eday ; i++ ){ %>
				<td> <%=i %> </td>	<!-- 일수 출력 -->
				<!-- 요일이 7배수 마다 줄바꿈 [ 토요일 마다 ] -->
				<% if( sweek % 7 == 0 ){ %>
					</tr> <tr>	<!-- 테이블 행 바꿈 -->
				<%} %>
				<% sweek++;   %> <!-- 일 증가 할때마다 요일 도 증가 --> 
			<%} %>
		</tr>
	</table>
	
</body>
</html>










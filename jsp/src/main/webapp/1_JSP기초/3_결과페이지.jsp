<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <!-- 
    	전 페이지로부터 request(요청)
    	request : 서블릿에서 제공해주는 내장객체(미리 만들어진 객체)
    	request.getParameter("요청할 변수의 name값 ")
    		단점 : (String)문자만 가능 
    		형변환 :
    			문자 -> 정수열 : Integer.parseInt
     -->
   	<%
   		// 스크립트문 = 자바 언어를 작성하고 실행하는 있는 공간
   		String 이름 = request.getParameter("name");
   		String 색상 = request.getParameter("color");
   		// 제어문
   		boolean admin = true;
   		if( !이름.equals("관리자") ){  admin = false; }
   		int 반복횟수 = Integer.parseInt(request.getParameter("number"));
   		
   	%>
   	
   	
<html>
	<body style=" background-color: <%=색상%>">
		작성한 이름 : <%=이름 %> <br>
		선택한 색상 : <%=색상 %>
		<!-- 제어문 -->
		<%	// 자바 시작 
			if( admin == true ){
			// 자바 끝 
		%>
			<div> 관리자 이군요. </div>
		<%
			// 자바 시작
			}
			// 자바 끝
		%>
		<!-- 반복문 -->
		<br>
		<%
			for( int i = 0 ; i<반복횟수 ;i++ ){
		%>		
				<span> ☆ </span> <!-- 별찍기 -->
		<%	
			}
		%>
		<br>
		<%
			for( int i = 0 ; i<반복횟수 ;i++ ){
				for( int s = 0 ; s<=i ; s++){
			%>		
				<span> ☆ </span> <!-- 별찍기 -->
			<% 
				}
		%>		
				<br> <!-- 줄바꿈처리  -->
		<%	
			}
		%>
		
	</body>
</html>







    
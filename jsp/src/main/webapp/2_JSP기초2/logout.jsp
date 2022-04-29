<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		// session.invalidate();// 모든 세션 초기화
		
		session.setAttribute("loginid", null ); // 특정 세션명 null로 설정하기 
		// 페이지 전환
		response.sendRedirect("main.jsp");
	%>
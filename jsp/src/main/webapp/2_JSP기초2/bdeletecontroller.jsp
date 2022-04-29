<%@page import="Dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	// 1. 전페이지로 부터 게시물번호 요청 
    	int bno = Integer.parseInt( 
    			request.getParameter("bno")
    			);
    	// 2. dao 게시물삭제 메소드 호출
    	Dao dao = new Dao();
    	boolean result =  dao.ddelete(bno);
    	// 3. 삭제가 성공했으면 
    	if( result ){
    		response.sendRedirect("main.jsp");
    	}
    
    %>

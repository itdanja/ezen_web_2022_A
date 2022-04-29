<%@page import="Dao.MemberDao"%>
<%@page import="Dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
  		// 컨트롤 페이지로 사용 
  	
  		// request : 요청 [ 서버가 ---> 클라이언트 ]
  		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
  
		// 변수3개 ->  객체화(dto)
		Member member = new Member( 0 , id , password , name );
		
		// 객체(dto) -> dao ( DB )
		MemberDao memberDao = new MemberDao();
  	
    %>
    
    
    
    
    
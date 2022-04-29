<%@page import="Dao.MemberDao"%>
<%@page import="Dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
  		// 컨트롤 페이지로 사용 
  	
  		// request : 요청 [ 서버가 ---> 클라이언트 ]
  			// 요청시 사용되는 한글 인코딩 변환[설정]
  		request.setCharacterEncoding("UTF-8");
    
  		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
  
		// 변수3개 ->  객체화(dto)
		Member member = new Member( 0 , id , password , name );
		
		// 객체(dto) -> dao ( DB )
		MemberDao memberDao = new MemberDao();
		
		// dao 가입메소드 실행
		boolean result =  memberDao.signup(member);
		
		if( result ){
			response.sendRedirect("main.jsp");
			// response.sendRedirect("이동할페이지")
		}
    %>
    
    
    
    
    
package controller.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

/**
 * Servlet implementation class delete2
 */
@WebServlet("/board/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno =  Integer.parseInt( request.getParameter("bno") ) ;
		boolean result =  BoardDao.getBoardDao().delete(bno);
		// * java에서 html 작성하기(js 명령어) 사용하기
		response.setCharacterEncoding("UTF-8");	// 응답 인코딩 타입 = 한글 
		response.setContentType("text/html; charset=UTF-8"); // 응답 파일타입 = HTML 
		PrintWriter out = response.getWriter();	// HTML 내보내기 메소드 사용
		if( result ) {
			// 1. HTML 내보내기 
//			out.println( "<html>");
//			out.println( "<body>");
//			out.println( "</body>");
//			out.println( "</html>");
			// 2. JS 내보내기 
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 되었습니다.');");
			out.println("location.href='boardlist.jsp';");	// js [ location.href = "경로" ]
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 실패[관리자에게 문의] .');");
			out.println("history.back();");	// js [ history.back() : 이전 페이지로 가기 메소드 ] 
			out.println("</script>");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

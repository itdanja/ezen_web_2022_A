package controller.board;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Board;

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
		
		// * DB 삭제 전에 파일명 가져오기
		Board board = BoardDao.getBoardDao().getboard(bno);
		String bfile = board.getBfile();
		
		boolean result =  BoardDao.getBoardDao().delete(bno); // DB 삭제처리 
		
		// * java에서 html 작성하기(js 명령어) 사용하기
		response.setCharacterEncoding("UTF-8");	// 응답 인코딩 타입 = 한글 
		response.setContentType("text/html; charset=UTF-8"); // 응답 파일타입 = HTML 
		PrintWriter out = response.getWriter();	// HTML 내보내기 메소드 사용
		if( result ) {
			// * DB삭제 성공시 해당 파일도 서버에서 지우기 
			String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/"+bfile ); // 파일 경로 찾기 
			File file = new File(uploadpath); // 해당 파일 객체화 
			file.delete(); // 파일 삭제하기 ( file클래스내 제공되는 delete() 메소드 = 파일삭제시 사용 )
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

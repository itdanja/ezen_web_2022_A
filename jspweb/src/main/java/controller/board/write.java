package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;

@WebServlet("/board/write") // URL 정의 = 현재 클래스와 통신할 경로 설정
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 데이터 요청 
		request.setCharacterEncoding("UTF-8");
		String btitle = request.getParameter("btitle");
		String bcotent = request.getParameter("bcotent");
		String bfile = request.getParameter("bfile");
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
		int mno = MemberDao.getmemberDao().getmno(mid);
		// 객체화 
		Board board = new Board( 0 , btitle, bcotent, mno, bfile, 0 , null, null);
		
		// DB 처리
		boolean result = BoardDao.getBoardDao().write(board);
		// 결과 
		if( result ) { response.sendRedirect("/jspweb/board/boardlist.jsp"); }
		else { response.sendRedirect("/jspweb/board/boardwrite.jsp"); }
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

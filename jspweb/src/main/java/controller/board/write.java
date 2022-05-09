package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 저장 경로 [    \ : 제어문자  ->  경로 사용시 \\ , / ]
			// 1. 개발중인 프로젝트 경로
		// String uploadpath = "C:/Users/505-t/git/ezen_web_2022_A/jspweb/src/main/webapp/board/upload";
			// 2. 서버 폴더 경로 
				// 서버 경로 찾기 : request.getSession().getServletContext().getRealPath( 경로 ) ;
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload") ;

		// 첨부파일 업로드 [ MultipartRequest : cos 라이브러리 제공 클래스 ] 
		MultipartRequest multi = new MultipartRequest(
				request ,		// 1. 요청방식 
				uploadpath , 	// 2. 파일 저장 경로 
				1024*1024*10 ,	// 3. 파일 최대 용량 허용 범위 [ 10MB ] 
				"UTF-8" ,		// 4. 인코딩타입 
				new DefaultFileRenamePolicy() 	// 5. 보안방식 : 동일한 파일명이 있을경우 자동 이름 변환 
				);	
		
		// 데이터 요청 
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile"); // 첨부파일 : getFilesystemName
		
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
			
		int mno = MemberDao.getmemberDao().getmno(mid);
		// 객체화 
		Board board = new Board( 0 , btitle, bcontent, mno, bfile, 0 , null, null);
		
		// DB 처리
		boolean result = BoardDao.getBoardDao().write(board);
		// 결과 
		if( result ) { response.sendRedirect("/jspweb/board/boardlist.jsp"); }
		else { response.sendRedirect("/jspweb/board/boardwrite.jsp"); }
		
	}

}

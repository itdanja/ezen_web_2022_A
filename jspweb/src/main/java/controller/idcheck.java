package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class idcheck
 */
@WebServlet("/idcheck")
public class idcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public idcheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("js와 통신"); // 통신 테스트
		
		request.getParameter("UTF-8"); 	// 요청시 사용되는 인코딩타입 [ 한글 ] 
		String mid = request.getParameter("mid"); // 데이터 요청 
		
			System.out.println( mid ); // JS에서 데이터 가져오기 확인
		
		// 1. dao를 통해 동일한 아이디가 있는지 체크 
		// 2. 만약에 동일한 아이디가 있으면 1 없으면 2 
		response.getWriter().print( 1 );
		//response.getWriter().print( 2 );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

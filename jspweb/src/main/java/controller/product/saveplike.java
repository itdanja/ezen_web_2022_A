package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ProductDao;

/**
 * Servlet implementation class saveplike
 */
@WebServlet("/product/saveplike")
public class saveplike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveplike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt( request.getParameter("pno") ) ;	// 제품번호 요청 
		String mid = request.getParameter("mid"); // 회원아이디 요청 
		// DB처리 
		int result = ProductDao.getProductDao().saveplike( pno , MemberDao.getmemberDao().getmno(mid) );
		// DB결과 JS 전달 
		if( result == 1 ) { response.getWriter().print( result ) ; }
		else if( result == 2 ) { response.getWriter().print( result ) ; }
		else if( result == 3 ) { response.getWriter().print( result ) ; }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

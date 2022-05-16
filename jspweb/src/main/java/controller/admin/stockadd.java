package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class stockadd
 */
@WebServlet("/admin/stockadd")
public class stockadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stockadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int pno = Integer.parseInt( request.getParameter("pno") );
		String scolor = request.getParameter("scolor");
		String ssize = request.getParameter("ssize") ;
		int samount = Integer.parseInt(request.getParameter("samount") );
		
		Stock stock = new Stock(0, scolor, ssize, samount, null, null, pno);
		
		boolean result = ProductDao.getProductDao().ssvae( stock );
		if( result ) { response.getWriter().print(1); }
		else { response.getWriter().print(2); }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class getstock
 */
@WebServlet("/admin/getstock")
public class getstock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getstock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pno 
			= Integer.parseInt(request.getParameter("pno"));
		ArrayList<Stock> list 
			=  ProductDao.getProductDao().getStock(pno);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String html = "";
		for( Stock temp : list ) {
			html += 
				"<tr>" +
					"<td> "+temp.getScolor()+" <td>" +
					"<td> "+temp.getSsize()+" <td>" +
					"<td> "+temp.getSamount()+" <td>" +
					"<td> 비고 <td>" +
				"</tr>";
		}
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

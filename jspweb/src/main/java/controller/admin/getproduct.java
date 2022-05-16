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
import dto.Product;

/**
 * Servlet implementation class getproduct
 */
@WebServlet("/admin/getproduct")
public class getproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 변수 요청 
		String type = request.getParameter("type");
		int cno = Integer.parseInt( request.getParameter("cno") );
		// 응답 객체 설정
		response.setCharacterEncoding("UTF-8"); // 응답시 인코딩 타입 
		PrintWriter out = response.getWriter();
		// DB처리 
		ArrayList<Product> list = ProductDao.getProductDao().getproductlist();
		String html =""; // 반환될 html의 변수 선언 
		// 반환 타입 
		if( type != null && type.equals("option") ) {
			for( Product temp : list ) {
				if( temp.getCno() == cno ) {
					html +=
						"<option value=\""+temp.getPno()+"\">"+temp.getPname()+"</option>";	
				}
			}
		}else { }
		
		// 반환
		out.print( html );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

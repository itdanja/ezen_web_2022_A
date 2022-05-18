package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class getamount
 */
@WebServlet("/product/getamount")
public class getamount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getamount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	// 한글 인코딩 타입 
		int pno = Integer.parseInt( request.getParameter("pno") ); // 제품번호 요청 
		String color = request.getParameter("color"); // 색상 요청 
		String size = request.getParameter("size");// 사이즈 요청 
		ArrayList<Stock> stocks =  ProductDao.getProductDao().getStock(pno); // 해당제품의 재고목록 
		for( Stock s : stocks) { // 만약에 재고내 색상과 사이즈가 동일하면 
			if( s.getScolor().equals(color) && s.getSsize().equals( size.trim() ) ) { // 공백문제 => 문자열.trim() 공백제거
				response.getWriter().print( s.getSamount() ); // 해당 수량 응답->js
			}
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

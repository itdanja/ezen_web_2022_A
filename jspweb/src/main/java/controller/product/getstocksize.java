package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Stock;

/**
 * Servlet implementation class getstocksize
 */
@WebServlet("/product/getstocksize")
public class getstocksize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getstocksize() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int pno = Integer.parseInt( request.getParameter("pno") );
		String scolor = request.getParameter("color");
		
		ArrayList<Stock> list = ProductDao.getProductDao().getStock(pno);
		// 제품별 사이즈와 재고 [ 1.문자열 , 2.컬렉션 , 3.json 등 ] 
			// LIST 컬렉션 : 중복O [ 인덱스 ] 
			// SET 컬렉션 : 중복X  [ 인덱스X ] 
			// MAP 컬렉션 : key(set=중복) : value => entry엔트리 
		Map< String , String> map = new TreeMap<>();
		for( Stock s : list  ) {
			if( s.getScolor().equals(scolor) ) {
				if( s.getSamount() == 0 ) {
					map.put( s.getSsize() ,  "품절" );
				}else {
					map.put( s.getSsize() ,  s.getSamount()+"개" );
				}
			}
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print( map );
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

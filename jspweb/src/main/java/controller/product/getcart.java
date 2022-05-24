package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.json.JSONArray;

import com.mysql.cj.xdevapi.JsonArray;

import dao.MemberDao;
import dao.ProductDao;

/**
 * Servlet implementation class getcart
 */
@WebServlet("/product/getcart")
public class getcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcart() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.getmemberDao().getmno(mid);
		// DB처리 
		JSONArray jsonArray = ProductDao.getProductDao().getcart(mno);
		// request , response -> 전송 인코딩 타입 -> 문자열 
			// 1. 응답객체내 한글 인코딩 타입설정 
			response.setCharacterEncoding("UTF-8");
			// *** 2. 응답객체의 자료형 [ 문자열 -> json 형식 ] 
			response.setContentType("application/json");
			// 3. 응답전송 
			response.getWriter().print( jsonArray );
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}







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
import dto.Category;

/**
 * Servlet implementation class getcategory
 */
@WebServlet("/admin/getcategory")
public class getcategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 반환타입 변수 호출
		String type =  request.getParameter("type");
		// DB에서 카테고리 리스트 호출 
		ArrayList<Category> arrayList = ProductDao.getProductDao().getcategorylist();
		// 자바에서 js(AJAX)에게 HTML 전송
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =  response.getWriter(); // HTML 에게 전송 객체생성
		String html = ""; // 응답할 문자열 ~~
		
		if( type !=null && type.equals("option") ) { // option 반환
			
			for( Category temp : arrayList ) {
				html +=
					"<option value=\""+temp.getCno()+"\">"+temp.getCname()+"</option>";
			}
			
		}else { // input 반환
			int i = 1;
			for( Category temp  : arrayList  ) {
				html += 
				"<input type=\"radio\" name=\"cno\" value=\""+
				temp.getCno()+"\">"+temp.getCname();
				if( i % 6 == 0 ) html += "<br>"; // 만약에 카테고리가 개수 6배수마다 줄바꿈처리 
				
				i++;
			}
		}
		
		
		//  java에서 " " : 문자열 인식용 	//  		\"  : " 표시(출력)
		out.print( html ); // 해당 문자열 응답~~ 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

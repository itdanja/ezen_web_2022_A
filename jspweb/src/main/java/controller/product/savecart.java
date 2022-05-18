package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class savecart
 */
@WebServlet("/product/savecart")
public class savecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// json형식 문자열 통신 호출 
		String data = request.getParameter("json");
		System.out.println( data );
		// json형식 문자열 -> json형식 객체로 변환
		try {
			// 1. 통신한 데이터를 JSONArray형으로 형변환
			JSONArray jsonArray = new JSONArray( data );
			// 2. 반복문 이용한 jsonarray에서 jsonobject 호출 
			for( int i = 0 ; i<jsonArray.length(); i++ ) {
				// 3. jsonarray 배열내 i번째 객체 호출 
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				// 4. 해당 객체에 키 를 이용한 값 호출 
				System.out.println( jsonObject.get("pname") );
				System.out.println( jsonObject.get("color") );
				System.out.println( jsonObject.get("size") );
				System.out.println( jsonObject.get("amount") );
				System.out.println( jsonObject.get("pprice") );
				System.out.println( jsonObject.get("totalprice") );
				System.out.println( jsonObject.get("point") );
			}
		}catch (Exception e) {}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

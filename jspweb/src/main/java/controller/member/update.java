package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.Member;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 요청시 사용되는 인코딩타입 [ 한글 포함 ] 
		
		int mno = Integer.parseInt( request.getParameter("mno") ); // 수정 식별 대상 
		String mname =request.getParameter("mname");	
		String mphone =request.getParameter("mphone");
		String memail =request.getParameter("memail");
		String memailaddress =request.getParameter("memailaddress");
			String email = memail +"@"+memailaddress;
		String address1 =request.getParameter("address1");
		String address2 =request.getParameter("address2");
		String address3 =request.getParameter("address3");
		String address4 =request.getParameter("address4");
			String address = address1+"_"+address2+"_"+address3+"_"+address4;
		// 객체화
		Member member = new Member(mno, null, null, mname, mphone, email , address, 0 , null);
		// 테스트 // System.out.println( member.toString() );
		// DB처리 
		boolean result = MemberDao.getmemberDao().update(member);
		if( result ) { response.sendRedirect("/jspweb/member/update.jsp?result=1"); }
		else { response.sendRedirect("/jspweb/member/update.jsp?result=2"); }
		
		
		
		
		
		
		
		
		
	}

}








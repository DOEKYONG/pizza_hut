package controller.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String memailaddress = request.getParameter("memailaddress");
			String email = memail+"@"+memailaddress;
		String mphone = request.getParameter("mphone");
		

		Member member  = null;
		
		if( oldpassword.equals("") || newpassword.equals("")  ) { // 패스워드 변경이 없을때.
			member = new  Member(mnum, null, null, mname, email, mphone , null , null);
			System.out.println("1"+member.toString()); // 객체화가 안되는거 같음...
		}else { // 패스워드 변경이 있을때.
			// 기존 패스워드 체크
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
			
			boolean reulst=  MemberDao.getmemberDao().passwordcheck( mid  , oldpassword);
			
			if( reulst ) { // 기존 패스워드가 동일하면 
				member = new Member(mnum, null, newpassword, mname, email, mphone , null , null);
				System.out.println(member.toString());
			}else { // 동일하지 않으면
				//response.sendRedirect("/pizza1/info/update.jsp?result=3"); 
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('기존 비밀번호를 잘못 입력하셨습니다.'); location.href='"+"/pizza1/info/update.jsp"+"';</script>"); 
				writer.close();
				return;
			}
		}
		// DB처리 
		boolean result = MemberDao.getmemberDao().update(member);
		
		if( result ) { //System.out.println("2"+member.toString()); response.sendRedirect("/pizza1/info/update.jsp?result=1");
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter writer = response.getWriter(); 
			writer.println("<script>alert('회원정보수정 완료.'); location.href='"+"/pizza1/info/update.jsp"+"';</script>"); 
			writer.close();
		
		}
		else { response.sendRedirect("/pizza1/info/update.jsp?result=2"); }
		
	}

}
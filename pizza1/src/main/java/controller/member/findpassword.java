package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class findpassword
 */
@WebServlet("/findpassword")
public class findpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findpassword() {
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
		// TODO Auto-generated method stub
		String mid = request.getParameter("fid");
		String mphone = request.getParameter("fphone");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String result =  MemberDao.getmemberDao().findpassword( mid , mphone );
		
		if( result != null  ) { 
			
			out.println("<script>alert('회원님의 비밀번호는 "+result +" 입니다.'); location.href='/pizza1/member/login.jsp';</script>");
			out.flush();
		}
		else  { 
			
			out.println("<script>alert('해당 아이디 혹은 전화번호가 존재하지않습니다.'); location.href='/pizza1/member/findpassword.jsp';</script>");
			out.flush();
			
		}
		
		doGet(request, response);
	}

}

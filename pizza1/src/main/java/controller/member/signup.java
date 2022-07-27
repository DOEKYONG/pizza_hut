package controller.member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dto.Member;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
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
		request.setCharacterEncoding("UTF-8");
		String id=	request.getParameter("mid");
		String password = request.getParameter("mpassword");
		String name = request.getParameter("mname");
		String memail =  request.getParameter("memail");
		String memailaddress = request.getParameter("memailaddress");
		String email = memail+"@"+memailaddress;
		String phone =  request.getParameter("mphone");
		String birth =  request.getParameter("yy")+"-"
				+ request.getParameter("mm")+"-"
				+ request.getParameter("dd");
		Date date = new Date();
		SimpleDateFormat dfomat = new SimpleDateFormat("yyyy-MM-dd");
		String 가입일 = dfomat.format(date);
		
		Member member = new Member(0,id,password,name,email,phone,birth,가입일);
		
		boolean result =MemberDao.getmemberDao().signup(member);
		
		if(result){
			response.sendRedirect("/pizza1/home.jsp");
		}else{
			response.sendRedirect("/pizza1/member/signup.jsp");
		}
		doGet(request, response);
	}

}

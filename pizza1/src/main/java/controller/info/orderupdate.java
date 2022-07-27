package controller.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FranchiseeDao;
import dao.MemberDao;
import dto.Franchisee;
import dto.Member;

/**
 * Servlet implementation class orderupdate
 */
@WebServlet("/orderupdate")
public class orderupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderupdate() {
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

	
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		String fname = request.getParameter("frname");
		String address1 = request.getParameter("faddress1");
		String address2 = request.getParameter("faddress2");
		String address3 = request.getParameter("faddress3");
		String address4 = request.getParameter("faddress4");
		String faddress = address1+"_"+address2+"_"+address3+"_"+address4;
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String memailaddress = request.getParameter("memailaddress");
			String email = memail+"@"+memailaddress;
		String mphone = request.getParameter("mphone");
		
	
		
		
		Member member  = null;
		Franchisee franchisee = null;
		
		if( oldpassword.equals("") || newpassword.equals("")  ) { // 패스워드 변경이 없을때.
			franchisee = new Franchisee(fnum, mnum, faddress, fname, mname);
			member = new  Member(mnum, null, null, mname, email, mphone , null , null);
			System.out.println("1"+member.toString()); 
		}else { // 패스워드 변경이 있을때.
			// 기존 패스워드 체크
			boolean reulst=  MemberDao.getmemberDao().passwordcheck( mid  , oldpassword);
			
			if( reulst ) { // 기존 패스워드가 동일하면 
				franchisee = new Franchisee(fnum, mnum, faddress, fname, mname);
				member = new Member(mnum, null, newpassword, mname, email, mphone , null , null);
				System.out.println(member.toString());
			}else { // 동일하지 않으면
				//response.sendRedirect("/pizza1/admin/franchiseeview.jsp?fnum="+fnum+"&ordernum="+mnum+""); return;
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter writer = response.getWriter(); 
				writer.println("<script>alert('기존 비밀번호를 잘못 입력하셨습니다.'); location.href='"+"/pizza1/admin/franchiseeview.jsp"+"';</script>"); 
				writer.close();
				return;
			}
		}
		// DB처리 
		boolean result = FranchiseeDao.getfranchiseeDao().update(member, franchisee);
		
		if( result ) { System.out.println("2"+member.toString()); response.sendRedirect("/pizza1/admin/franchiseelist.jsp?result=1");}
		else { response.sendRedirect("/pizza1/admin/franchiseeview.jsp?result=2"); }
		
		
	}
}

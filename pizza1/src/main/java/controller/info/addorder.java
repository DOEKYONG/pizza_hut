package controller.info;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FranchiseeDao;
import dao.MemberDao;
import dto.Franchisee;
import dto.Member;

/**
 * Servlet implementation class addorder
 */
@WebServlet("/addorder")
public class addorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addorder() {
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
		String fname =  request.getParameter("frname");
		String address1 = request.getParameter("faddress1");
		String address2 = request.getParameter("faddress2");
		String address3 = request.getParameter("faddress3");
		String address4 = request.getParameter("faddress4");
			String faddress = address1+"_"+address2+"_"+address3+"_"+address4;
		
		Member member = new Member(0,id,password,name,email,phone,birth,가입일);
		
		boolean result =MemberDao.getmemberDao().signup(member);
		
		if(result){
			
			int ordernum = FranchiseeDao.getfranchiseeDao().ordernum(id);
			
			if(ordernum!= 0) {
				
				Franchisee franchisee = new Franchisee(0, ordernum, faddress, fname,null);
				
				boolean result1 = FranchiseeDao.getfranchiseeDao().ordersignup(franchisee);
				int getfnum =  FranchiseeDao.getfranchiseeDao().getfnum(ordernum);
				boolean result2 = FranchiseeDao.getfranchiseeDao().ordersignup2(getfnum);
				if(result1) {
					response.sendRedirect("/pizza1/admin/franchiseelist.jsp");
				}
				else {
					response.sendRedirect("/pizza1/admin/addorder.jsp");
				}
			}
			else {response.sendRedirect("/pizza1/admin/addorder.jsp");}
			
		}else{
			response.sendRedirect("/pizza1/admin/addorder.jsp");
		}
		
	}
	

}

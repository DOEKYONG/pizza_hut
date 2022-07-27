package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

/**
 * Servlet implementation class findid
 */
@WebServlet("/findid")
public class findid extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findid() {
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
      String mname = request.getParameter("fname");
      response.setContentType("text/html; charset=UTF-8");
      
      String memail = request.getParameter("femail");
      PrintWriter out = response.getWriter();
      
      String result =  MemberDao.getmemberDao().findid( mname , memail );
      
      if( result != null  ) { 
         
         out.println("<script>alert('회원님의 아이디는 "+result +" 입니다.'); location.href='/pizza1/member/login.jsp';</script>");
         out.flush();
      }
      else  { 
         
         out.println("<script>alert('해당 아이디가 존재하지않습니다.'); location.href='/pizza1/member/findid.jsp';</script>");
         out.flush();
         
      }
      doGet(request, response);
   }

}
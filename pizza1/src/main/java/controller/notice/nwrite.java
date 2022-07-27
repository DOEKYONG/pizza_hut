package controller.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FranchiseeDao;
import dao.MemberDao;
import dao.NoticeDao;


/**
 * Servlet implementation class nwrite
 */
@WebServlet("/nwrite")
public class nwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nwrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("통신");
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		ncontent = ncontent.replace("\r\n", "<br>");
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("login");
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		int fnum = FranchiseeDao.getfranchiseeDao().getfnum(mnum);
		
		
		if(ntitle != null) {
			boolean result = NoticeDao.getNoticeDao().nwrite(ntitle,ncontent,fnum);
			
			if(result) {
				response.sendRedirect("/pizza1/notice/noticelist.jsp");
			}
			else {
				response.sendRedirect("/pizza1/notice/noticewirte.jsp");
			}
			
		} else {
			
		}
		
		
	}

}

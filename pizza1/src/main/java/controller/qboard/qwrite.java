package controller.qboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.MemberDao;

import dao.QboardDao;

/**
 * Servlet implementation class qwrite
 */
@WebServlet("/qwrite")
public class qwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qwrite() {
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
		System.out.println("통신");
		String qtitle = request.getParameter("qtitle");
		String qcontent = request.getParameter("qcontent");
		qcontent = qcontent.replace("\r\n", "<br>");
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("login");
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		
		
		
		if(qtitle != null) {
			boolean result = QboardDao.getQboardDao().qwrite(qtitle,qcontent,mnum);
			
			if(result) {
				response.sendRedirect("/pizza1/qboard/qlist.jsp");
			}
			else {
				response.sendRedirect("/pizza1/qboard/qwrite.jsp");
			}
			
		} else {
			
		}
		
		
	}
	

}

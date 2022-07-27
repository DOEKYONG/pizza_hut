package controller.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import dto.Notice;

/**
 * Servlet implementation class noticeupdate
 */
@WebServlet("/notice/noticeupdate")
public class noticeupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeupdate() {
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
		int nnum = Integer.parseInt(request.getParameter("nnum"));
		String ntitle = request.getParameter("ntitle");
		String ncontent = request.getParameter("ncontent");
		ncontent = ncontent.replace("\r\n", "<br>");
		
		Notice notice = new Notice(nnum,ntitle,ncontent,0,0,null,null);
		boolean result = NoticeDao.getNoticeDao().noticeupdate(notice);
		if(result) {
			response.sendRedirect("/pizza1/notice/noticeview.jsp?nnum="+nnum);
		}else {
		response.sendRedirect("/pizza1/notice/noticelist.jsp");
		}
	}

}

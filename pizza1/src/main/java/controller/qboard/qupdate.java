package controller.qboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;
import dao.QboardDao;
import dto.Notice;
import dto.Qboard;

/**
 * Servlet implementation class qupdate
 */
@WebServlet("/qboard/qupdate")
public class qupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qupdate() {
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
		int qnum = Integer.parseInt(request.getParameter("qnum"));
		String qtitle = request.getParameter("qtitle");
		String qcontent = request.getParameter("qcontent");
		qcontent = qcontent.replace("\r\n", "<br>");
		
		Qboard qboard = new Qboard(qnum,qtitle,qcontent,0,null,null,null);
		boolean result = QboardDao.getQboardDao().qboardupdate(qboard);
		if(result) {
			response.sendRedirect("/pizza1/qboard/qview.jsp?qnum="+qnum);
		}else {
		response.sendRedirect("/pizza1/qboard/qlist.jsp");
		}
	}

}

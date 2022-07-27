package controller.notice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticeDao;

/**
 * Servlet implementation class noticedelete
 */
@WebServlet("/notice/noticedelete")
public class noticedelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticedelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("연결");
		response.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");
int nnum = Integer.parseInt(request.getParameter("nnum"));
		
		boolean result = NoticeDao.getNoticeDao().noticedelete(nnum);
		PrintWriter out = response.getWriter();	// HTML 내보내기 메소드 사용
		if(result) {
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 되었습니다.');");
			out.println("location.href='noticelist.jsp';");	// js [ location.href = "경로" ]
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('해당 게시물이 삭제 실패[관리자에게 문의] .');");
			out.println("history.back();");	// js [ history.back() : 이전 페이지로 가기 메소드 ] 
			out.println("</script>");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package controller.event;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.EventDao;
import dto.Event;


/**
 * Servlet implementation class addevent
 */
@WebServlet("/event/addevent")
public class addevent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addevent() {
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
		
		
		System.out.println("ssss");
		MultipartRequest multi = new MultipartRequest(
				request ,		//
				request.getSession().getServletContext().getRealPath("/event/upload") , 	 
				1024*1024*1024 ,	
				"UTF-8" ,	
				new DefaultFileRenamePolicy() 	
				);	
		
		// 데이터 요청 
		String etitle = multi.getParameter("etitle");
		String ecoupon = multi.getParameter("ecoupon");
		int ediscount = Integer.parseInt(multi.getParameter("ediscount"));
		String datepicker1 = multi.getParameter("datepicker1");
		String [] 날짜1=  datepicker1.split("-");
		String 날짜재정의 = 날짜1[0]+"."+날짜1[1]+"."+날짜1[2];
		String datepicker2 = multi.getParameter("datepicker2");
		String [] 날짜2=  datepicker2.split("-");
		String 날짜재정의2 = 날짜2[0]+"."+날짜2[1]+"."+날짜2[2];
		String bannerimg = multi.getFilesystemName("bannerimg"); // 첨부파일 : getFilesystemName
		String eventimg = multi.getFilesystemName("eventimg");
		
		//객체화
		Event event = new Event(0, etitle, ecoupon, ediscount, 날짜재정의, 날짜재정의2, bannerimg, eventimg);
		
		boolean result = EventDao.geteventDao().addevent(event);
		if(result) {
			response.sendRedirect("/pizza1/admin/eventlist.jsp");
		}else {
			response.sendRedirect("/pizza1/admin/addevent.jsp");
		}
		
		
			
	}

}

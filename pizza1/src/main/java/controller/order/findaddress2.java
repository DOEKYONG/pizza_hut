package controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.OrderDao;

/**
 * Servlet implementation class findaddress
 */
@WebServlet("/order/findaddress2")
public class findaddress2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findaddress2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("findaddress");
		
		// DB처리 
				JSONArray jsonArray = OrderDao.getorderDao().findstore2(address);
				// request , response -> 전송 인코딩 타입 -> 문자열 
					// 1. 응답객체내 한글 인코딩 타입설정 
					response.setCharacterEncoding("UTF-8");
					// *** 2. 응답객체의 자료형 [ 문자열 -> json 형식 ] 
					response.setContentType("application/json");
					// 3. 응답전송 
					response.getWriter().print( jsonArray );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

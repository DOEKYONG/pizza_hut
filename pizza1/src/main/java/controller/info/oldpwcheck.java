package controller.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class oldpwcheck
 */
@WebServlet("/oldpwcheck")
public class oldpwcheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public oldpwcheck() {
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
		// 1. 통신된 페이지에게 변수의 데이터를 요청한다. 
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("oldpassword");
		System.out.println( mid + mpassword );
		
		// 2. 객체화 [ 변수가 많을경우 ]  = 생략 
		// 3. DB처리 
		boolean result = 
				MemberDao.getmemberDao().passwordcheck( mid , mpassword );
		// 4. 결과 
		if( result ) {
			// 5. 통신된 페이지로 데이터 응답하기
			response.getWriter().print(1);
			System.out.println("aaa");
		} else{ response.getWriter().print(2); System.out.println("bbb"); }
	}

}

package controller.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;

/**
 * Servlet implementation class sizeadd
 */
@WebServlet("/sizeadd")
public class sizeadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sizeadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String size = request.getParameter("size");
		int sizeprice = Integer.parseInt(request.getParameter("sizeprice"));
		int menunum = Integer.parseInt(request.getParameter("menunum"));
		System.out.println(size+sizeprice+menunum);
		boolean result 
		= MenuDao.getmemberDao().pizzasize(size,sizeprice,menunum);
		if( result ) { response.getWriter().print(1);}
		else { response.getWriter().print(2); }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

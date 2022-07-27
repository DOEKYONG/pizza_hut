package controller.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;

/**
 * Servlet implementation class sizeupdate
 */
@WebServlet("/menu/sizeupdate")
public class sizeupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sizeupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subnum = Integer.parseInt(request.getParameter("subnum"));
		String sizeup = request.getParameter("sizeup");
		int sizepriceup = Integer.parseInt(request.getParameter("sizepriceup"));
		
		boolean result = MenuDao.getmemberDao().sizeupdate(subnum,sizeup,sizepriceup);
		if(result) {response.getWriter().print(result);}
		else {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

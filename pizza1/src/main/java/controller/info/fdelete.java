package controller.info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FranchiseeDao;

/**
 * Servlet implementation class fdelete
 */
@WebServlet("/fdelete")
public class fdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fdelete() {
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
		System.out.println("ff");
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		int mnum = Integer.parseInt(request.getParameter("mnum"));
		
		boolean result = FranchiseeDao.getfranchiseeDao().delete(fnum, mnum);
		if(result) {
			response.getWriter().print(1); 
		}
		else {
			response.getWriter().print(2); 
		}
	}

}

package controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.OrderDao;
import dto.Cart;

/**
 * Servlet implementation class cart
 */
@WebServlet("/order/subcart")
public class subcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public subcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int menunum=Integer.parseInt(request.getParameter("menunum"));
		int count=Integer.parseInt(request.getParameter("count"));
		int totalprice=Integer.parseInt(request.getParameter("totalprice"));
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("login");
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		
		boolean result = OrderDao.getorderDao().subaddcart(menunum,count,totalprice,mnum);
		if(result) {response.getWriter().print(result);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

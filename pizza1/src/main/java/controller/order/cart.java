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
@WebServlet("/order/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int menunum=Integer.parseInt(request.getParameter("menunum"));
		int size=Integer.parseInt(request.getParameter("size"));
		int edge=Integer.parseInt(request.getParameter("edge"));
		int count=Integer.parseInt(request.getParameter("count"));
		int topping1=Integer.parseInt(request.getParameter("topping1"));
		int topping2=Integer.parseInt(request.getParameter("topping2"));
		int totalprice=Integer.parseInt(request.getParameter("totalprice"));
		System.out.println("ss"+topping1);
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("login");
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		System.out.println(totalprice);
		
		Cart cart = new Cart(0, count, totalprice, menunum, size, edge, topping1, topping2, mnum);
		
		boolean result = OrderDao.getorderDao().addcart(cart);
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

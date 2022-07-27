package controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.AlertDao;
import dao.MemberDao;
import dao.OrderDao;
import dto.Order;

/**
 * Servlet implementation class saveorder
 */
@WebServlet("/order/saveorder")
public class saveorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid =  (String)request.getSession().getAttribute("login");
		int mno = MemberDao.getmemberDao().getmnum(mid);
		String json = request.getParameter("orderjson"); 
		String date = request.getParameter("date");
		try {
			JSONObject jo = new JSONObject(json); 
			int orderfnum = jo.getInt("orderfnum");
			String orderphone = jo.get("orderphone").toString();
			String orderaddress = jo.get("orderaddress").toString();
			int ordertotalpay = jo.getInt("ordertotalpay") ;
			String orderrequest = jo.get("orderrequest").toString();
			String odelivery = jo.get("odelivery").toString();
			int  couponnum = jo.getInt("couponnum");
			
			Order order = new Order( 0, date, orderphone ,
					orderaddress, ordertotalpay, odelivery, 
					mno , orderfnum, "주문처리중" , orderrequest);
			System.out.println(order);
			if(couponnum!=0) {
				OrderDao.getorderDao().changecoupon( couponnum,mno );
			}
			System.out.println(date);
			OrderDao.getorderDao().saveorder( order );
			int onum2 = AlertDao.getalertDao().getonum(date);
			response.getWriter().print(onum2);
			
		
		}catch (Exception e) { System.out.println( e );}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

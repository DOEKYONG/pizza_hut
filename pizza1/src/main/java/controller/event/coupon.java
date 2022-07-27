package controller.event;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventDao;
import dao.MemberDao;
import dto.Couponlist;

/**
 * Servlet implementation class coupon
 */
@WebServlet("/event/coupon")
public class coupon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coupon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int eventnum = Integer.parseInt( request.getParameter("coupon"));
		String mid = request.getParameter("mid");
		
		String couponactive = "사용전";
		
		int mnum = MemberDao.getmemberDao().getmnum(mid);
		
		Couponlist couponlist = new Couponlist(mnum, eventnum , couponactive);
		
		int result = EventDao.geteventDao().addcoupon(couponlist);
		if(result==1) {
			response.getWriter().print( result ) ;
		}
		else if(result==2){response.getWriter().print( result ) ;}
		else if(result==3){response.getWriter().print( result ) ;}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

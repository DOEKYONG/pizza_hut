package controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MenuDao;
import dto.Subpizza;

/**
 * Servlet implementation class getsize
 */
@WebServlet("/admin/getsize")
public class getsize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getsize() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int menunum
		= Integer.parseInt(request.getParameter("menunum"));
	
	
	ArrayList<Subpizza> list =  MenuDao.getmemberDao().getsubpizza(menunum);
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	String html = "";
		for( Subpizza temp : list ) {
			if(temp.getSubsize()!=null) {
			html += 
				"<tr>" +
					"<td> "+temp.getSubsize()+" </td>" +
					"<td> "+temp.getSubprice()+" </td>" +
					"<td>"
					+ "<button type=\"button\" onclick=\"sizeupdate("+temp.getSubnum()+",'"+temp.getSubsize()+"',"+temp.getSubprice()+")\" >수정</button>"
					+ "<button onclick=\"sizedelete("+temp.getSubnum()+")\">삭제</button>"
					+ "</td>" +
				"</tr>";
			}
		}
		out.print(html);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

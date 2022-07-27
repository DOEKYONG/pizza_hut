package controller.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MenuDao;

/**
 * Servlet implementation class edgeadd
 */
@WebServlet("/edgeadd")
public class edgeadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edgeadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		MultipartRequest multi = new MultipartRequest(
				request,			
				request.getSession().getServletContext().getRealPath("/admin/menuimg") , /* 저장 폴더위치 */
				1024*1024*1024, 	
				"UTF-8" ,			
				new DefaultFileRenamePolicy()
			
				);
		String edge = multi.getParameter("edgeadd");
		int edgeprice = Integer.parseInt( multi.getParameter("edgeprice") );
		String edgeimg = multi.getFilesystemName("edgeimg"); 
		System.out.println(edge);
		
		int menunum = Integer.parseInt( multi.getParameter("menunum") );
		System.out.println(menunum);
		boolean result =  MenuDao.getmemberDao().pizzaedge(edge,edgeprice,edgeimg,menunum);
		
		if( result ) { response.getWriter().print(1);}
		else { response.getWriter().print(2);}
	}

}

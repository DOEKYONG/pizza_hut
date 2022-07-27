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
 * Servlet implementation class edgeupdate
 */
@WebServlet("/menu/edgeupdate")
public class edgeupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edgeupdate() {
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
		System.out.println("sdas");
		MultipartRequest multi = new MultipartRequest(
				request,			
				request.getSession().getServletContext().getRealPath("/admin/menuimg") , /* 저장 폴더위치 */
				1024*1024*1024, 	
				"UTF-8" ,			
				new DefaultFileRenamePolicy()
				);
		String edgeup = multi.getParameter("edgeup");
		int edgeupprice = Integer.parseInt( multi.getParameter("edgeupprice") );
		String edgeupimg = multi.getFilesystemName("edgeupimg"); 
		int subnum = Integer.parseInt( multi.getParameter("subnum") );
		
		boolean result =  MenuDao.getmemberDao().edgeupdate(edgeup,edgeupprice,edgeupimg,subnum);
			
			if( result ) { response.getWriter().print(1);}
			else { response.getWriter().print(2);}
		
	}

}

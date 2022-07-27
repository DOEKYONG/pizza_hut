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
import dto.Menu;

/**
 * Servlet implementation class menuadd
 */
@WebServlet("/menuadd")
public class menuadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public menuadd() {
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
		
				MultipartRequest multi = new MultipartRequest(
						request,			
						request.getSession().getServletContext().getRealPath("/admin/menuimg") ,
						1024*1024*1024, 	
						"UTF-8" ,			
						new DefaultFileRenamePolicy()
					
						);
				String menuname = multi.getParameter("menuname");
				String menucontent = multi.getParameter("menucontent");
				int menuprice = Integer.parseInt( multi.getParameter("menuprice") );
				int cnum = Integer.parseInt( multi.getParameter("cnum") );
				String menuimg = multi.getFilesystemName("menuimg"); // 첨부파일 파일명은 요청시 .getFilesystemName() 메소드 이용 
				Menu menu = new Menu( 0 , menuname, menucontent, menuprice, menuimg,cnum);
				
				boolean result =  MenuDao.getmemberDao().menuadd(menu);
				
				if( result ) { response.getWriter().print(1);}
				else { response.getWriter().print(2);}
	}

}

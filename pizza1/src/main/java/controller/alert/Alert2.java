package controller.alert;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.AlertDao;
import dto.AlertDto;

/**
 * Servlet implementation class Alert2
 */
@WebServlet("/alert/Alert2")
public class Alert2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alert2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("리스트json통신");
		try {
			int onum =  Integer.parseInt( request.getParameter("onum"));
			System.out.println(onum);
			ArrayList<AlertDto> alertlist =AlertDao.getalertDao().getalertlist(onum);
			//JSONObject object = new JSONObject();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			JSONArray ajsonArray = new JSONArray();
			for(AlertDto temp : alertlist ) {
JSONObject object = new JSONObject();
				
				object.put("onum", temp.getOnum());
				object.put("odate", temp.getOdate());
				object.put("ophone",temp.getOphone());
				if(temp.getOaddress()==null) {
					object.put("oaddress","");
				}else {
					object.put("oaddress",temp.getOaddress());
				}
				object.put("ototalprice",temp.getOtotalprice());
				object.put("odelivery", temp.getOdelivery());
				object.put("mnum", temp.getMnum());
				object.put("fnum",temp.getFnum());
				object.put("ostate", temp.getOstate());
				object.put("orequest", temp.getOrequest());
				object.put("odetailnum", temp.getOdetailnum());
				object.put("omenunum",AlertDao.getalertDao().getmenuname(temp.getOmenunum()));
				object.put("oamount", temp.getOamount());
				if(AlertDao.getalertDao().getsize(temp.getOnum()) == null) {
					object.put("osize"," ");
				} else {
					object.put("osize",AlertDao.getalertDao().getsize(temp.getOsize()));
				}
				object.put("oedge",AlertDao.getalertDao().getedgename(temp.getOedge()));
				object.put("otopping1",AlertDao.getalertDao().getmenuname(temp.getOtopping1()));
				if(AlertDao.getalertDao().getmenuname(temp.getOtopping2())==null) {
					object.put("otopping2"," ");
				}else {
					object.put("otopping2",AlertDao.getalertDao().getmenuname(temp.getOtopping2()));
				}
				ajsonArray.put(object);
				
			}
		
			
			
			
			response.getWriter().print(ajsonArray);
			
		} catch (Exception e) {System.out.println("fdff" +e);		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

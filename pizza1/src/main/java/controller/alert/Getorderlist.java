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
 * Servlet implementation class Getorderlist
 */
@WebServlet("/alert/Getorderlist")
public class Getorderlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getorderlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("주문목록json통신");
		try {
			int fnum =  Integer.parseInt( request.getParameter("fnum"));
			System.out.println(fnum);
			ArrayList<AlertDto> alertlist =AlertDao.getalertDao().getorderlist(fnum);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			int ordernum = -1;
			JSONArray ajsonArray = new JSONArray();
			JSONArray child = new JSONArray();
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
				if(AlertDao.getalertDao().getsize(temp.getOsize()) == null) {
					object.put("osize"," ");
				} else {
					object.put("osize",AlertDao.getalertDao().getsize(temp.getOsize()));
				}
				object.put("oedge",AlertDao.getalertDao().getedgename(temp.getOedge()));
				if(AlertDao.getalertDao().getmenuname(temp.getOtopping1()) == null) {
					object.put("otopping1"," ");
				}else {
					object.put("otopping1",AlertDao.getalertDao().getmenuname(temp.getOtopping1()));
				}
				object.put("img",AlertDao.getalertDao().getimg(temp.getOmenunum()));
				if(AlertDao.getalertDao().getmenuname(temp.getOtopping2())==null) {
					object.put("otopping2"," ");
				}else {
					object.put("otopping2",AlertDao.getalertDao().getmenuname(temp.getOtopping2()));
				}
				System.out.println(temp.getOnum());
				
				if(ordernum == temp.getOnum()) {
					child.put(object);
				}else {
					child = new JSONArray();
					child.put(object);
					ajsonArray.put(child);
				}
				ordernum = temp.getOnum();
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

package controller.info;

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
import dao.MemberDao;
import dto.AlertDto;

/**
 * Servlet implementation class morderlist
 */
@WebServlet("/info/morderlist")
public class morderlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public morderlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ddfdsafjdsalkfjlk");
		try {
			int mnum =  Integer.parseInt( request.getParameter("mnum"));
			ArrayList<AlertDto> alertlist =MemberDao.getmemberDao().getorderlist(mnum);
			//JSONObject object = new JSONObject();
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
				//ajsonArray.put(object);
				
			}
		
			
			System.out.println("제이슨어레이" + ajsonArray);
			
			response.getWriter().print(ajsonArray);
			
		} catch (Exception e) {System.out.println("faadsds" +e);		}
	
			
//			for(AlertDto temp : alertlist ) {
//				JSONObject object = new JSONObject();
//				object.put("onum", temp.getOnum());
//				object.put("odate", temp.getOdate());
//				object.put("ophone",temp.getOphone());
//				object.put("oaddress",temp.getOaddress());
//				object.put("ototalprice",temp.getOtotalprice());
//				object.put("odelivery", temp.getOdelivery());
//				object.put("mnum", temp.getMnum());
//				object.put("fnum",temp.getFnum());
//				object.put("ostate", temp.getOstate());
//				object.put("orequest", temp.getOrequest());
//				object.put("odetailnum", temp.getOdetailnum());
//				object.put("omenunum",AlertDao.getalertDao().getmenuname(temp.getOmenunum()));
//				object.put("oamount", temp.getOamount());
//				object.put("osize",AlertDao.getalertDao().getsize(temp.getOsize()));
//				object.put("oedge",AlertDao.getalertDao().getedgename(temp.getOedge()));
//				object.put("otopping1",AlertDao.getalertDao().getmenuname(temp.getOtopping1()));
//				if(AlertDao.getalertDao().getmenuname(temp.getOtopping2())==null) {
//					object.put("otopping2"," ");
//				}else {
//					object.put("otopping2",AlertDao.getalertDao().getmenuname(temp.getOtopping2()));
//				}
//			
//				
//				ajsonArray.put(object);
//				
//			}
//			for(int i = 0 ;  i<alertlist.size(); i++) {
//				JSONObject object = new JSONObject();
//				object.put("onum", alertlist.get(i).getOnum());
//				object.put("odate", alertlist.get(i).getOdate());
//				object.put("ophone", alertlist.get(i).getOphone());
//				object.put("oaddress", alertlist.get(i).getOaddress());
//				object.put("ototalprice", alertlist.get(i).getOtotalprice());
//				object.put("odelivery", alertlist.get(i).getOdelivery());
//				object.put("mnum", alertlist.get(i).getMnum());
//				object.put("fnum", alertlist.get(i).getFnum());
//				object.put("ostate", alertlist.get(i).getOstate());
//				object.put("orequest", alertlist.get(i).getOrequest());
//				object.put("odetailnum", alertlist.get(i).getOdetailnum());
//				object.put("omenunum", AlertDao.getalertDao().getmenuname(alertlist.get(i).getOmenunum()));
//				
//				object.put("oamount", alertlist.get(i).getOamount());
//				object.put("osize", AlertDao.getalertDao().getsize(alertlist.get(i).getOsize()));
//				object.put("oedge", AlertDao.getalertDao().getedgename(alertlist.get(i).getOedge()));
//				object.put("otopping1", AlertDao.getalertDao().getmenuname(alertlist.get(i).getOtopping1()));
//				object.put("oedge", AlertDao.getalertDao().getedgename(alertlist.get(i).getOedge()));
//				if(AlertDao.getalertDao().getmenuname(alertlist.get(i).getOtopping2()) == null) {
//					object.put("otopping2", "");
//				}else {
//					object.put("otopping2", AlertDao.getalertDao().getmenuname(alertlist.get(i).getOtopping2()));
//				}
//				ajsonArray.put(object);
//		
//			}
//			
//			response.getWriter().print(ajsonArray);
//			
//		} catch (Exception e) {System.out.println("멤버주문리스트" +e);		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

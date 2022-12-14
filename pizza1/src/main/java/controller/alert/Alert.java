package controller.alert;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;


import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONObject;



// @WebServlet : URL 매핑
// @WebServlet(" HTTP 클래스내로 들어오는 경로 정의");
// @ServerEndpoint("서버소켓 클래스로 들어오는 경로 정의")
@ServerEndpoint("/alert/{mnum}/{fnum}") // {변수명} : URL 변수 받을수 있다. 
public class Alert {	// 서버소켓 사용할 클래스 
	
	public static Map< Session , Integer > clients = new Hashtable<>(); // 동기화 [ 한명씩 처리 ] 
	// 1. 소켓 오픈
	@OnOpen
	public void OnOpen( Session session , @PathParam("mnum") Integer mnum, @PathParam("fnum") Integer fnum  ) { 
							// @PathParam  : URL 경로상의 변수의 인수로 가져오기 
		clients.put( session , mnum); // 해당 세션(키)과 접속된회원번호(값) 저장 
	}
	// 2. 소켓 닫기 
	@OnClose
	public void OnClose( Session session ) {
		clients.remove( session );	// 해당 세션 제거 				
	}
	// 3. 소켓 메시지
	@OnMessage
	public void OnMessage( String msg , Session session, @PathParam("fnum") Integer fnum) throws IOException {
			if(fnum==0) {
			for( Session s : clients.keySet() ) { // 리스트에 존재하는 세션들에게 메시지 보내기
					// map객체.keyset() : 모든 키 를 호출 
					s.getBasicRemote().sendText(msg);
}
		} 
	}
}

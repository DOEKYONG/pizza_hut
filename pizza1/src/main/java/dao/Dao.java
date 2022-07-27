package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;




public class Dao {
	
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	//jdbc
		//1.프로젝트내 build path에 mysqljdbc.jar
	
	public Dao() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizza?serverTimezone=UTC",
                "root","1234");
		System.out.println("연동성공");
		}
		catch(Exception e) {System.out.println("연동실패: " +e);}
		
	}

	
}

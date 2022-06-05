package javaexp.z01_homework;

import java.beans.Statement;
import java.sql.*;
public class A01_Connection {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public void setConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@106.10.23.227:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 에러 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 처리 에러 : " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		A01_Connection con = new A01_Connection();
		con.setConn();
	}

}

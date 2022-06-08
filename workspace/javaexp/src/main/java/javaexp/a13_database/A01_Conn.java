package javaexp.a13_database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
// DAO(database access object)
public class A01_Conn {
	// 1. 공통 필드 선언하기
	private Connection con; // 연결객체
	private Statement stmt; // 대화객체
	private ResultSet rs; // data를 받는 결과 객체 select sql의 처리 결과로 활용

	// 2. 공통 연결 메서드
	public void setConn() {
		// 1. jdbc 드라이버의 클래스를 객체화하여 메모리에 로딩 : 연결 - 필수예외처리(컴파일시 필요)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 특정 서버에 접속정보로 접속 - localhost
			// 		ip, port, sid, 계정, 비번
			String info = "jdbc:oracle:thin:@106.10.23.227:1521:xe";
			// jdbc:oracle:thin - 위에 선언한 jdbc드라이버를 통해서
			// @localhost - 특정 서버에 접속(ip-외부 접속시는 127.242.21.243 활용, 현재 com에 있는 서버일 경우 localjost/127.0.0.1)
			// 1521 - 여러가지 서비스 중에 하나의 port에 접속함 ex) 하나의 com에 여러개의 service를 제공하는 서버를 만들수 있고
			// 			이것을 구분하여 외부에서 접속할 때 port를 활용한다.
			// xe - 데이터베이스의 식별자, 오라클서버 안에서 여러개의 DB를 만들 수 있다.
			con = DriverManager.getConnection(info, "scott", "tiger");
			// scott : 계정, tiger : 비밀번호
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("클래스 에러 : " + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("DB 처리 에러 : " + e.getMessage());
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A01_Conn dao = new A01_Conn();
		dao.setConn();
	}

}

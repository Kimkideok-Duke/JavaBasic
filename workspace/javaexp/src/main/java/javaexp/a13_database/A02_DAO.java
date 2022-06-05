package javaexp.a13_database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
// DAO(database access object)
public class A02_DAO {
	// 1. 공통 필드 선언하기
	private Connection con; // 연결객체
	private java.sql.Statement stmt; // 대화객체
	private ResultSet rs; // data를 받는 결과 객체 select sql의 처리 결과로 활용

	// 2. 공통 연결 메서드
	public void setConn() throws SQLException {
		// 1. jdbc 드라이버의 클래스를 객체화하여 메모리에 로딩 : 연결 - 필수예외처리(컴파일시 필요)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 특정 서버에 접속정보로 접속 - localhost
			// 		ip, port, sid, 계정, 비번
			String info = "jdbc:oracle:thin:@106.10.23.227:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("클래스 에러 : " + e.getMessage());
		}
	}
	// 3. 각 기능별 메서드
	// 	1) emp를 출력하는 기능메서드
	public void showEmp() {
		// 선언한 공통 연결 메서드 호출
		try{
			// 1. 필드에 선언된 private Connection con; 에 객체가 생성이 된다.
			setConn();
			// 2. 대화객체선언
			// 		1) sql문 작성
			String sql = "select * from emp"; 
			// sql문 안에 (;)를 붙이지 않는다.
			// 		2) 대화객체 생성
			stmt = con.createStatement();
			// 		3) 대화객체를 통해 결과객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = stmt.executeQuery(sql);
			// 		4) 전체 데이터 가져오기
			// 			저장된 갯수만큼 next()를 호출
			int cnt = 1;
			while(rs.next()) {
				System.out.print(cnt + "행" + rs.getInt("empno"));
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
				cnt++;
			}
			// 자원해제(열린순서 반대 방향)
			rs.close();;
			stmt.close();
			con.close();
			// 예외 처리
			// 기본 예외 : DB - SQLException
			// 일반 예외 : Exception
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("DB 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		}finally {
			// 예외 상관없이 처리할 내용
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	// 단일 row sql 처리
	public int getEmpCnt() {
		int cnt = 0;
		// [핵심코드]
		String sql = "select count(*) cnt from emp";
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 하나의 데이터 결과 처리이기에 바로 처리
			// [핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			// 
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}



	// 단일 row sql 처리
	public int getEmpCnt(int deptno) {
		int cnt = 0;
		// [핵심코드]
		String sql = "select count(*) cnt from emp where deptno = 10";
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 하나의 데이터 결과 처리이기에 바로 처리
			// [핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			// 
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	// 단일 row sql 처리
	public int getEmpCnt(String job) {
		int cnt = 0;
		// [핵심코드]
		String sql = "select count(*) cnt from emp where job = '" + job + "' ";
		System.out.println(sql);
		// 연결
		try {
			setConn();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			// 하나의 데이터 결과 처리이기에 바로 처리
			// [핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			// 
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A02_DAO dao = new A02_DAO();
		// dao.showEmp();
		System.out.println("사원 정보의 갯수 : " + dao.getEmpCnt());
		System.out.println("사원 정보의 갯수(부서) : " + dao.getEmpCnt(10));
		System.out.println("사원 정보의 갯수(직책) : " + dao.getEmpCnt("SALESMAN"));
		
	}

}

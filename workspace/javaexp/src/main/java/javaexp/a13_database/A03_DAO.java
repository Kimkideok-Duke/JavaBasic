package javaexp.a13_database;

import java.sql.*;
// DAO(database access object)
public class A03_DAO {
	// 1. 공통 필드 선언하기
	private Connection con; // 연결객체
	private Statement stmt; // 대화객체
	private ResultSet rs; // data를 받는 결과 객체 select sql의 처리 결과로 활용

	// 2. 공통 연결 메서드
	public void setConn() throws SQLException {
		// 1) 드라이버 선언
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("드라이버 : " + e.getMessage());
		}
		// 2) 서버 연결 처리 (Connection 객체 생성)
		String info = "jdbc:oracle:thin:@106.10.23.227:1521:xe";
		con = DriverManager.getConnection(info, "scott", "tiger");
		System.out.println("접속 성공");
	}
	// 3. 각 기능별 메서드
	// 	1) emp를 출력하는 기능메서드
	public void empList() {
		// 1) 연결메서드 호출
		try{
			setConn();
		// 2) 대화객체 만들기
			stmt = con.createStatement();
		// 3) 결과객체 할당하기
			// 		1) sql문 작성
			String sql = "select * from emp"; 
			rs = stmt.executeQuery(sql);
			System.out.println("기능 sql 처리 완료");
		} catch (SQLException e) {
			System.out.println("DB처리 : " + e.getMessage());
		}
	}
	public void deptList() {
		try {
			setConn();
			stmt = con.createStatement();
			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);
			int cnt = 1;
			while(rs.next()) {
				System.out.print(cnt + "행 " + rs.getInt("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\n");
				cnt++;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("DB처리 : " + e.getMessage());
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
		
	}


// 부서번호별 최고 연봉
	public double getMaxSal(int deptno) {
		double maxSal = 0.0;
		try {
			setConn();
			stmt = con.createStatement();
			String sql = "SELECT max(sal) msal\n"
					+ "FROM emp\n"
					+ "where DEPTNO = "+deptno;
			rs = stmt.executeQuery(sql);
			rs.next();
			maxSal = rs.getDouble("msal");
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("DB처리 : " + e.getMessage());
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
		return maxSal;
	}
	public void getMaxSalEmp() {
		try {
			setConn();
			String sql = "SELECT to_char(hiredate,'Q') qua, e.*\n"
					+ "FROM emp e\n"
					+ "WHERE ( to_char(hiredate,'Q'), sal) IN (\n"
					+ "    SELECT to_char(hiredate, 'Q') qua, max(sal) msal\n"
					+ "    FROM emp\n"
					+ "    GROUP BY to_char(hiredate,'Q')\n"
					+ ")\n"
					+ "ORDER BY qua";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getString("qua") + "\t");
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.print(rs.getInt("deptno") + "\n");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("DB처리 : " + e.getMessage());
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
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A03_DAO dao = new A03_DAO();
		// dao.empList();
		// dao.deptList();
		System.out.println("10부서의 최고연봉 : " + dao.getMaxSal(10));
		System.out.println("20부서의 최고연봉 : " + dao.getMaxSal(20));
		System.out.println("30부서의 최고연봉 : " + dao.getMaxSal(30));
		System.out.println("40부서의 최고연봉 : " + dao.getMaxSal(40));
		dao.getMaxSalEmp();
	}

}

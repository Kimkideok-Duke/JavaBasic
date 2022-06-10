package javaexp.a13_database;
// javaexp.a13_database.A05_preDAO

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javaexp.z03_vo.Dept;
import javaexp.z03_vo.Emp;
// DAO(database access object)
// 전화기와 동일 : 연결/대화/결과를 통해 받은 데이터/종료 - 자원해제, 예외처리
public class A05_PreDAO {
	// 1. 공통 필드 선언하기
	private Connection con; // 연결객체
	private PreparedStatement pstmt; // 대화객체
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
			String sql = "select * from emp011"; 
			// sql문 안에 (;)를 붙이지 않는다.
			// 		2) 대화객체 생성
			pstmt = con.prepareStatement(sql);
			// 		3) 대화객체를 통해 결과객체 생성, 매개변수로 sql문을 할당 처리한다.
			rs = pstmt.executeQuery();
			// 		4) 전체 데이터 가져오기
			// 			저장된 갯수만큼 next()를 호출
			int cnt = 1;
			while(rs.next()) {
				System.out.print(cnt + "행" + rs.getInt("empno") + "\t");
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
			pstmt.close();
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
			if(pstmt!=null) {
				try {
					pstmt.close();
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

	public ArrayList<Dept> getDeptList(String dname, String loc) {
		ArrayList<Dept> deptList = new ArrayList<Dept>();
		try {
			setConn();
			String sql = "select * \n"
						+ "from dept \n"
						+ "where dname like '%'|| ? ||'%' \n"
						+ "and loc like '%'|| ? ||'%'";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			rs = pstmt.executeQuery();
			rs.next();
			while(rs.next()) {
				deptList.add(new Dept(
								rs.getInt("deptno"),
								rs.getString("dname"),
								rs.getString("loc") )
								);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return deptList;
	}
	// 단일 row sql 처리
	public int getEmpCnt() {
		int cnt = 0;
		// [핵심코드]
		String sql = "select count(*) cnt from emp";
		// 연결
		try {
			setConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 하나의 데이터 결과 처리이기에 바로 처리
			// [핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			// 
			rs.close();
			pstmt.close();
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
			if(pstmt!=null) {
				try {
					pstmt.close();
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
/*
-- String sql = "select count(*) cnt from emp where deptno="+deptno;
select count(*) cnt from emp where deptno = 10;
SELECT * FROM emp WHERE deptno = 10;
-- String sql = "select count(*) cnt from emp where job= '"+job+"' ";
-- job = '"+job+"' " : 변동되는 문자열 job에 다른 sql 결과를 얻기 위해서 이런형식이 필요하다.
select count(*) cnt from emp where job = 'CLERK';
select * from emp where job = 'CLERK';
*/
	// 단일 row sql 처리
	public int getEmpCnt(int deptno) {
		int cnt = 0;
		// [핵심코드]
		String sql = "select count(*) cnt from emp where deptno = ?";
		// 연결
		try {
			setConn();
			pstmt = con.prepareStatement(sql);
			// ? 에 mapping될 데이터를 타입에 맞게 처리한다.

			pstmt.setInt(1, deptno);
			// deptno로 연동할 데이터가 정수형이고, 첫번째 ?에 연동할 데이터
			// ?는 1부터 시작해서 증가시켜준다.
			rs = pstmt.executeQuery();

			// 하나의 데이터 결과 처리이기에 바로 처리
			// [핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			// 
			rs.close();
			pstmt.close();
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
			if(pstmt!=null) {
				try {
					pstmt.close();
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
		String sql = "select count(*) cnt from emp where job = ? ";
		// '?'형식으로 넣지말자
		System.out.println(sql);
		// 연결
		try {
			setConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, job);
			rs = pstmt.executeQuery();
			// 하나의 데이터 결과 처리이기에 바로 처리
			// [핵심코드]
			rs.next();
			cnt = rs.getInt("cnt");
			// 
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}
	// 단일 row sql 처리
	public ArrayList<Emp> getEmpList(Map<String, String> map) {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		try {
			setConn();
			String sql = "SELECT *\n" +
				"FROM emp\n" +
				"WHERE ename LIKE '%'|| ? ||'%' ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, map.get("ename"));
			rs = pstmt.executeQuery();
			// 하나의 데이터 결과 처리이기에 바로 처리
			// [핵심코드]
			rs.next();
			while(rs.next()) {
				empList.add(new Emp(
							rs.getInt("empno"),
							rs.getString("ename"),
							rs.getString("job"),
							rs.getInt("mgr"),
							rs.getDate("hiredate"),
							rs.getDouble("sal"),
							rs.getDouble("comm"),
							rs.getInt("deptno") )
				);
			}
			// 자원해제
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return empList;
	}
	// 단일 row sql 처리
	public void insertEmp(Emp ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "INSERT INTO EMP011 values(?,?,?,?,\n"
					+ "    to_date(?,'YYYY-MM-DD'),?,?,?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getEmpno());
			pstmt.setString(2, ins.getEname());
			pstmt.setString(3, ins.getJob());
			pstmt.setInt(4, ins.getMgr());
			pstmt.setString(5, ins.getHiredate_s());
			pstmt.setDouble(6, ins.getSal());
			pstmt.setDouble(7, ins.getComm());
			pstmt.setInt(8, ins.getDeptno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러 : " + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	// 단일 row sql 처리
	public void updateEmp(Emp ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "UPDATE EMP011\n"
					+ "    SET ename = ?,\n"
					+ "        job = ?,\n"
					+ "        mgr = ?,\n"
					+ "        hiredate = to_date(?, 'YYYY-MM-DD'),\n"
					+ "        sal = ?,\n"
					+ "        comm = ?,\n"
					+ "        deptno = ?\n"
					+ "WHERE empno = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, ins.getEmpno());
			pstmt.setString(2, ins.getEname());
			pstmt.setString(3, ins.getJob());
			pstmt.setInt(4, ins.getMgr());
			pstmt.setString(5, ins.getHiredate_s());
			pstmt.setDouble(6, ins.getSal());
			pstmt.setDouble(7, ins.getComm());
			pstmt.setInt(8, ins.getDeptno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러 : " + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	// 단일 row sql 처리
	public void deleteEmp(int empno) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "DELETE FROM EMP011\n"
					+ "WHERE empno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러 : " + e.getMessage());
			// commit 전에 예외가 발생하면 rollback 처리
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A05_PreDAO dao = new A05_PreDAO();
		/*
		public Emp()
		*/
		// dao.getDeptList("", "");
//		dao.insertEmp(new Emp(1003, "이영철", "과장", 7780, "2022-06-01", 3500, 100, 10));
//		dao.showEmp();
//		dao.updateEmp(new Emp(1003, "오영철", "과장", 7780, "2022-07-01", 4500, 50, 30));
//		dao.deleteEmp(7499);
//		dao.showEmp();
		// System.out.println("사원 정보의 갯수 : " + dao.getEmpCnt());
		// System.out.println("사원 정보의 갯수(부서) : " + dao.getEmpCnt(10));
		// System.out.println("사원 정보의 갯수(직책) : " + dao.getEmpCnt("SALESMAN"));
		Map<String, String> sch = new HashMap<String, String>();
		sch.put("ename", "A");
		sch.put("job", "");
		ArrayList<Emp> empList = dao.getEmpList(sch);
		for(Emp e:empList) {
			System.out.print(e.getEmpno()+"\t"); System.out.print(e.getEname()+"\t");
			System.out.print(e.getJob() + "\t"); System.out.print(e.getMgr()+"\t");
			System.out.print(e.getHiredate()+"\t"); System.out.print(e.getComm()+"\t");
			System.out.print(e.getDeptno()+"\n");
		}
		/*
		ArrayList<Emp> empList = dao.getEmpList("B");
		for(Emp e:empList) {
			System.out.print(e.getEmpno() + "\t");
			System.out.print(e.getEname() + "\t");
			System.out.print(e.getJob() + "\t");
			System.out.print(e.getMgr() + "\t");
			System.out.print(e.getHiredate() + "\t");
			System.out.print(e.getSal() + "\t");
			System.out.print(e.getComm() + "\t");
			System.out.print(e.getDeptno() + "\n");
		}
		*/
	}

}

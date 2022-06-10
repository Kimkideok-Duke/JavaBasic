package javaexp.z01_homework;

import java.sql.*;
import java.util.ArrayList;

import javaexp.z03_vo.Dept;
import javaexp.z03_vo.Emp;

public class A0608 {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void setConn() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String info = "jdbc:oracle:thin:@106.10.23.227:1521:xe";
			con = DriverManager.getConnection(info, "scott", "tiger");
			System.out.println("접속성공!!");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 에러 : " + e.getMessage());
		}
	}
	public void showDept() {
		try{
			setConn();
			String sql = "select * from dept011"; 
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int cnt = 1;
			while(rs.next()) {
				System.out.print(cnt + "행" + rs.getInt("deptno") + "\t");
				System.out.print(rs.getString("dname") + "\t");
				System.out.print(rs.getString("loc") + "\n");
				cnt++;
			}
			rs.close();;
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("DB 에러 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외 : " + e.getMessage());
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
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
	// 2022-06-08
	// [1단계:개념] 1. 등록/수정/삭제시, 추가 삭제 필요한 코드를 예제로 기술하세요.
	// 등록
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
	// 수정
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
			
			
			pstmt.setString(1, ins.getEname());
			pstmt.setString(2, ins.getJob());
			pstmt.setInt(3, ins.getMgr());
			pstmt.setString(4, ins.getHiredate_s());
			pstmt.setDouble(5, ins.getSal());
			pstmt.setDouble(6, ins.getComm());
			pstmt.setInt(7, ins.getDeptno());
			pstmt.setInt(8, ins.getEmpno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러 : " + e.getMessage());
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
	// 삭제
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
	// [1단계:확인] 2. 복사테이블로 Dept01 을 만들고, 입력처리하는 메서드를 만드세요.
	public void insertDept(Dept ins) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "INSERT INTO dept011 values(?, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ins.getDeptno());
			pstmt.setString(2, ins.getDname());
			pstmt.setString(3, ins.getLoc());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러 : " + e.getMessage());
			try{
				con.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
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
	// [1단계:확인] 3. Dept01부서정보를 전체 컬럼을 수정하세요.
	public void updateDept(Dept upt) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "UPDATE dept011\n"
					+ "    SET dname = ?,\n"
					+ "        loc = ?\n"
					+ "WHERE deptno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getDname());
			pstmt.setString(2, upt.getLoc());
			pstmt.setInt(3, upt.getDeptno());
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러 : " + e.getMessage());
			try{
				con.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
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
	// [1단계:확인] 4. Dept01부서정보를 deptno기준으로 삭제하세요
	public void deleteDept(int deptno) {
		try {
			setConn();
			con.setAutoCommit(false);
			String sql = "DELETE FROM dept011\n"
					+ "WHERE deptno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.executeUpdate();
			con.commit();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 에러 : " + e.getMessage());
			try{
				con.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
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
	// [1단계:개념] 5. jsp페이지를 웹서버(WAS)에서 실행할 때, 기본예
	// <%@ page language="java" contentType="text/html; charset=UTF-8"
	// 	pageEncoding="UTF-8"%>
	// <!DOCTYPE html>
	// <html>
	// 	<head>
	// 	<meta charset="UTF-8">
	// 	<title>Insert title here</title>
	// </head>
	// <body>
	// 	<h2>jsp입니다.</h2>
	// </body>
	// </html>
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A0608 dao = new A0608();
		dao.insertDept(new Dept(50, "인사부", "서울"));
		dao.showDept();
		dao.updateDept(new Dept(50, "영업", "부산"));
		dao.showDept();
		dao.deleteDept(50);
		dao.showDept();
	}

}

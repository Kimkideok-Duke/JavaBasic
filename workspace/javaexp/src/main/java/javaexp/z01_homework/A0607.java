package javaexp.z01_homework;

import java.sql.*;
import java.util.ArrayList;

import javaexp.z03_vo.Dept;
import javaexp.z03_vo.Emp;
import javaexp.z03_vo.EmpDeptJoin;

public class A0607 {
	private Connection con;
	private Statement stmt;
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
		// 2022-06-07
		// [1단계:개념] 1. PreparedStament를 사용하는 이유를 기술하세요
					// Statement 객체에서 사용한 createStatement()라는 메소드를 사용할 경우 사용자의 입력 값을 미리 만들어 놓은 sql문에 적용한 후 
					// 컴파일을 하기 때문에 사용자의 입력 값에 따라 쿼리문의 형태가 바뀔 수 있어 보안에 취약하다.
					// 따라서 해결책으로 Statement 객체의 preparedStatement(query) 메소드를 사용한다. 
					// 이것은 미리 개발자가 작성한 쿼리문을 컴파일 하고 ?로 처리한 부분에 사용자의 입력 값을 넣기 때문에 쿼리문의 형태가 바뀌지 않아 보안성을 높일 수 있다.

		// [1단계:개념] 2. PreparedStament 를 활용하여 기존에 Statement와 비교하여 변경되는 code를 예제를 통해 기술하세요.
		
		/********************* 기존 Statement *************************/
		public int getEmpCntS(int deptno) {
			int cnt = 0;
			String sql = "select count(*) cnt from emp where deptno = 10";
			try {
				setConn();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
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
		/*************************************************************/
		/********************* PreparedStatement *********************/
		public int getEmpCntP(int deptno) {
			int cnt = 0;
			String sql = "select count(*) cnt from emp where deptno = ?";
			try {
				setConn();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, deptno);
				rs = pstmt.executeQuery();
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
		/*************************************************************/

		// [1단계:확인] 3. 연봉이 범위(@@~@@) 사이이고, 부서별로 검색하는 사원 정보를 PreparedStament 로 처리하여 결과를 출력하세요
		public void showEmpInfo(int sal_start, int sal_finish, int deptno) {
			String sql = "SELECT *\n"
					+ "FROM emp\n"
					+ "WHERE sal>= ? AND sal<= ? \n"
					+ "AND deptno = ?";
			try {
				setConn();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, sal_start);
				pstmt.setInt(2, sal_finish);
				pstmt.setInt(3, deptno);
				rs = pstmt.executeQuery();
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
		}

		// [1단계:확인] 4. 사원명과 부서명을 키워드검색(like,%활용)하여, 부서명, 사원명, 사원번호, 급여를 출력 하게 하세요.(PreparedStament)
		public ArrayList<EmpDeptJoin> getEmpDeptList(String ename, String dname) {
			ArrayList<EmpDeptJoin> empdeptList = new ArrayList<EmpDeptJoin>();
			try {
				setConn();
				String sql = "SELECT e.*, dname, loc\n"
							+ "FROM emp e, dept d\n"
							+ "WHERE e.deptno = d.deptno\n"
							+ "AND dname LIKE '%' || ? || '%'\n"
							+ "AND ename LIKE '%' || ? || '%'";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dname);
				pstmt.setString(2, ename);
				rs = pstmt.executeQuery();
				rs.next();
				while(rs.next()) {
					empdeptList.add(new EmpDeptJoin(
									rs.getInt("empno"),
									rs.getString("ename"),
									rs.getString("job"),
									rs.getInt("mgr"),
									rs.getDate("hiredate"),
									rs.getDouble("sal"),
									rs.getDouble("comm"),
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
			return empdeptList;
		}

		// [1단계:확인] 5. select * from dept where dname like '%'||''||'%' and loc like '%'||''||'%' 를 이용해서
		//               리턴 ArrayList<Dept>로 처리해서 main()에서 확인하세요.
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

		// [1단계:확인] 6. 오늘 webprj2로 프로젝트 만들고, 톰캣연동하는 부분을 ppt 자료를 만들어서 캡쳐해서, 제출하세요.
	public static void main(String[] args) {
		A0607 dao = new A0607();
		System.out.println("Statement : " + dao.getEmpCntS(10));
		System.out.println("PreparedStatement : " + dao.getEmpCntP(10));
		dao.showEmpInfo(1000, 3000, 10);
		ArrayList<EmpDeptJoin> edjList = dao.getEmpDeptList("A", "A");
		for(EmpDeptJoin edj:edjList) {
			System.out.print(edj.getDname() + "\t");
			System.out.print(edj.getEmpno() + "\t");
			System.out.print(edj.getEname() + "\t");
			System.out.print(edj.getSal() + "\n");
		}
		ArrayList<Dept> deptList = dao.getDeptList("A", "N");
		for(Dept d:deptList) {
			System.out.print(d.getDeptno() + "\t");
			System.out.print(d.getDname() + "\t");
			System.out.print(d.getLoc() + "\n");
		}
	}

}

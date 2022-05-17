package javaexp.a10_exception;

public class A03_throws {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# throws
		1. 메소드 단위로 예외를 해당 메소드별로 코드로 처리하는 것이 아니라 
			메소드를 호출하는 곳에서 한꺼번에 예외를 처리할 때, 활용된다.
		2. 기본 형식
			리턴타입 메소드명() throws 예외클래스1, 예외클래스2{

			}
		 */
		// 컴파일 예외 처리(필수 예외)
		try {
			// 메모리를 패키지 로딩하여 처리할 때 사용되는 코드 (필수 예외 처리)
			Class clz = Class.forName("java.lang.String2");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		DBConn con = new DBConn();
		try{
			// 위임할 예외를 한번에 처리함
			con.conn01();
			con.conn02();
			con.conn03();
		}catch(ClassNotFoundException e) {
			System.out.println("# 에러 경로 처리 #");
			e.printStackTrace();
			System.out.println("# 에러 경로 처리 끝 #");
		}
		try{
			con.callString1();
			con.callString2();
			con.callString3();
		}catch(NullPointerException npe) {
			System.out.println("예외 발생 : " + npe.getMessage());
		}
	}

}
class DBConn{
	// throws 위임할 예외 클래스
	public void conn01() throws ClassNotFoundException {
		Class clz = Class.forName("db.com.oracle");
	}
	public void conn02() throws ClassNotFoundException {
		Class clz = Class.forName("db.com.mysql");
	}
	public void conn03() throws ClassNotFoundException {
		Class clz = Class.forName("db.com.mssql");
	}
	public void callString1() throws NullPointerException {
		String name = null; System.out.println(name.toString());
	}
	public void callString2() throws NullPointerException {
		String name = null; System.out.println(name.toString());
	}
	public void callString3() throws NullPointerException {
		String name = null; System.out.println(name.toString());
	}
}
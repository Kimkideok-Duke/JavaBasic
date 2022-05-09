package javaexp.a06_class;

public class A12_ObjectCalcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m = new Member();
		System.out.println("현재로그인 : " + m.curLoginId());
		m.login("himan", "7778");
		System.out.println("현재로그인 : " + m.curLoginId());
		System.out.println(m.loginResult());
		// ex)
		m.setPoint(15000);
		System.out.println(m.isSuperUser());
		m.setPoint(5000);
		System.out.println(m.isSuperUser());
	}

}
class Member{
	String id;
	String pass;
	void login(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	String loginResult() {
		String result = "로그인실패";
		if(id.equals("himan") && pass.equals("7777")) {
			result = "로그인 성공";
		}
		return result;
	}
	String curLoginId() {
		return id;
	}
	int point;
	void setPoint(int point) {
		this.point = point;
	}
	String isSuperUser() {
		String result = "일반고객입니다.";
		if(point >= 10000) result = "MVP입니다.";
		return result;
	}
}
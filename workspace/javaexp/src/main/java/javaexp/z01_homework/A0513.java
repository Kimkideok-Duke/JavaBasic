package javaexp.z01_homework;

import java.util.Scanner;

public class A0513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2022-05-13
		// [1단계:개념] 1. 예외 처리의 기본 형식과 처리 순서를 기본 예제에 의해 기술하세요.
					// 기본 형식
					// 		try{
					// 			예외가 일어날 가망성이 있는 코드
					// 		}catch(Exception e) {
					// 			예외가 일어날 떄, 처리할 블럭
					// 		}finally {
					// 			예외가 있든지 없든지 수행할 블럭
					// 		}
					System.out.println("프로세스1");
					try{
						System.out.println("프로세스2");
						System.out.println(1/0);
						System.out.println("프로세스3");
						System.out.println("프로세스4");
					}catch(Exception e) {
						System.out.println("에러 처리");
						System.out.println(e.getMessage());
						System.out.println("프로세스5");
						System.out.println("프로세스6");
					}finally {
						System.out.println("프로세스7");
					}
					
		// [1단계:확인] 2. args를 통해서 나올 수 있는 예외를 아래에 하나씩 처리하세요
			// 	1) args값을 입력하지 않았을 때.
					try{
						System.out.println(args[1]);
					}catch(NullPointerException ne) {
						System.out.println("에러 처리");
						System.out.println(ne.getMessage());
					}finally {
						System.out.println("args값을 입력하지 않았을 때");
					}
			// 	2) args값의 배열의 범위를 넘어설 때.
					try{
						System.out.println(args[6]);
					}catch(ArrayIndexOutOfBoundsException ae) {
						System.out.println("에러 처리");
						System.out.println(ae.getMessage());
					}finally {
						System.out.println("args값의 배열의 범위를 넘어설 때");
					}
			// 	3) args의 값 중에 숫자형 문자를 입력하여야 하는데 문자 자체를 입력했을 때.
					try{
						System.out.println(Integer.parseInt(args[0]));
					} catch(NumberFormatException nfe) {
						System.out.println("예외 발생");
						System.out.println(nfe.getMessage());
					}finally {
						System.out.println("args의 값 중에 숫자형 문자를 입력하여야 하는데 문자 자체를 입력했을 때");
					}
		// [1단계:개념] 3. 예외 처리의 계층별 처리란 무엇인지 기술하세요.
					// 다중의 예외를 처리할 때는 상속관계로 가장 하단에 있는 예외부터 처리하고, 점점 상위에 있는 예외를 처리한다.
					// try{

					// }catch(최하위에 있는 예외) {
					
					// }catch(차상위에 있는 예외) {

					// }catch(최상위에 있는 예외) {

					// }

		// [1단계:개념] 4. 예외의 위임처리하는 내용을 예제를 통해서 기술하세요.
					Homework0513 hw = new Homework0513();
					try {
						hw.homework01();
						hw.homework02();
						hw.homework03();
					} catch(NullPointerException npe) {
						System.out.println("예외 경로 처리");
						npe.printStackTrace();
					}

		// [1단계:확인] 5. DBException이라는 사용자 정의 예외를 선언하고, Scanner를 통해서
		// 	입력되는 값이  null이거나 공백문자일 때, 처리되게 하세요.
					Scanner sc = new Scanner(System.in);
					System.out.print("입력 : ");
					String str = sc.nextLine();
					try{
						if(str.isEmpty() == true) {
							throw new DBException("입력된 문자가 null");
						}
					}catch(DBException de) {
						System.out.println(de.getMessage());
						de.showMsg();
					}
	}

}
class Homework0513{
	public void homework01() throws NullPointerException {
		String name = null; System.out.println(name.toString());
	}
	public void homework02() throws NullPointerException {
		String name = null; System.out.println(name.toString());
	}
	public void homework03() throws NullPointerException {
		String name = null; System.out.println(name.toString());
	}
}
class DBException extends Exception{
	public DBException(){}
	public DBException(String message) {
		super(message);
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	public void showMsg() {
        System.out.println("사용자 정의 예외 추가 기능메서드");
    }
}
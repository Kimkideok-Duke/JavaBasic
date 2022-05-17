package javaexp.z01_homework;

import java.util.ArrayList;
import java.util.List;

public class A0517 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2022-05-17
		// [1단계:개념] 1. 특정 DB서버에 접속에 필요한 정보는 무엇이 있는가를 기술해 보세요.
					// ip,port, DB명, 계정, 비밀번호

		// [1단계:개념] 2. select 구문의 컴럼 선택과 별칭사용에 대하여 예제를 통하여 설명하세요.
					// SELECT empno,
					// 		empno AS NO, -- as 키워드를 이용해서 별칭 사용
					// 		ename AS name,
					// 		hiredate hire, -- " " 공백을 삽입하여 별칭으로 처리
					// 		deptno dno
					// FROM emp;

		// [1단계:확인] 3. emp 테이블의 컬럼명을 한글로 표현해보세요. ex) 사원번호, 사원명, 직책, 관리자, 입사일, 급여, 보너스, 부서번호
					// SELECT empno 사원번호,
					// 		ename 사원명,
					// 		job 직책,
					// 		mgr 관리자,
					// 		hiredate 입사일,
					// 		sal 급여,
					// 		comm 보너스,
					// 		deptno 부서번호
					// FROM emp;

		// [1단계:확인] 4. sal를 부서번호로 부너번호%로 보너스처리하여 급여를 정하기로 했다.  
		// 				sal==> 기본급여, deptno ==> 보너스, 총급여(기본급여+보너스)로 처리하여 출력하되 alias명도 함께 처리하세요.
					// SELECT sal 기본급여,
					// 		deptno 보너스,
					// 		sal+deptno 총급여
					// FROM emp;

		// [1단계:확인] 5. 아래의 형식으로 컬럼간의 연산과 연결처리를 하여 alias로 출력하세요.
		// 			1) @@님의 사원번호는 @@이고, 올해 연말보너스는 연봉의 20%인 @@원입니다.  @@님(ename)
					// SELECT ename || '님의  사원번호는 ' || empno || '이고, 올해 연말 보너스는 연봉의 20%인 ' || (sal*0.2) || '입니다.' show
					// FROM emp;

		// 			2) @@님의 입사일은 @@이고, 현재 연봉의 1/13인 월급여는 @@만원.   입사일 @@(hiredate)
					// SELECT ename || '님의 입사일은 ' || hiredate || '이고, 현재 연봉의 1/13인 월급여는 ' || (sal/13) || '만원.' show
					// FROM emp;

		// 			3) @@님의 이번달 보너스는 연봉(sal)의 deptno%기준으로  @@@만원 지급합니다.
					// SELECT ename || '님의 이번달 보너스는 연봉(' || sal ||')의 ' || deptno || '%기준으로 ' || sal*(deptno/100) || '만원 지급합니다.' show
					// FROM emp;	

		// [1단계:개념] 6. distinct로 데이터를 처리해야 하는 경우를 기본예제를 통해서 설명하세요.
					// 1. 특정한 데이터를 출력하는 것은 연관관계 없이 컬럼으로 출력이 된다.
					// 2. 특정 컬럼의 데이터 중에 중복된 것을 제외 시키고 출력할 때는 distinct 컬럼명 형식으로 처리한다.
					// 3. 2개 이상의 컬럼에서도 중복된 데이터를 제외 시킬 수 있다.
					// 	해당 컬럼을 체크해도 동일할 때는 제외를 한다.
					//
					// SELECT * FROM emp;
					// SELECT deptno FROM emp;
					// SELECT DISTINCT deptno FROM emp;

		// [1단계:개념] 7. 기본 유형을 Wrapper 클래스로 만드는 이유를 설명하세요.
					// 기본 타입의 값은 외부에서 변경 불가능하기 때문에 객체로 변환하여, 객체에게 지원하는 메서드를 통해 처리할 때 사용한다.

		// [1단계:확인] 8. 아래의 기본유형의 문자열을 Wrapper클래스의 valueOf 메서드를 이용해서 Wrapper클래스로 만들어 보세요.
		// 				(Integer,Character,Boolean)
					Integer i = Integer.valueOf("1000");
					Character c = Character.valueOf('C');
					Boolean b = Boolean.valueOf("true");
					System.out.println(i);
					System.out.println(c);
					System.out.println(b);

		// [1단계:개념] 9. boxing, unboxing, auto boxing/auto unboxing 개념에 대하여 기본예제로 기술하세요.
					// 박싱 : 기본 타입의 값을 포장객체로 만드는 과정
					Short ob02 = new Short("20"); // 생성자 사용
        			Integer ob03 = Integer.valueOf(1000); // valueOf() 메서드 사용
					// 언박싱 : 포장 객체에서 기본 타입의 값을 얻어내는 과정 
					short num02 = ob02.shortValue();
					int num03 = ob03.intValue();
					// 자동박싱/자동언박싱 : 객체 데이터를 생성자, 객체 생성을 위한 기능 메서드를 통해서 객체를 생성하지만,
        			// Wrapper는 기본 데이터 유형을 효과적으로 활용하기 위해 조금 더 간편하게 객체를 생성할 수 있게 자동박싱/자동언박싱 개념을 도입해서 생성한다.
					// 자동 박싱 : 포장 클래스 타입에 기본값이 대입될 경우 발생한다.
					Integer obj = 100;
					System.out.println(obj);
					// 자동 언박싱 - 기본타입에 포장객체가 대입될 경우 발생
					int value = obj;
					System.out.println(value);

		// [1단계:개념] 10. 컬렉션 프레임 웍의 최상위 인터페이스 3가지와 그 특징을 기술하세요.
					// List : 순서를 유지하고 저장, 중복 저장가능
					// Set : 순서를 유지하지 않고 저장, 중복저장 안됨.
					// Map : 키와 값의 쌍으로 저장, 키는 중복저장 안됨.

		// [1단계:확인] 11. List기능 메서드를 예제를 통하여 설명하세요
					List<String> list = new ArrayList<String>();
					
					list.add("축구"); // add() : 주어진 객체를 맨 끝에 추가.
					list.add("야구");
					list.add("농구");
					System.out.println("초기 데이터");
					for(int idx = 0; idx<list.size(); idx++) {
						System.out.println(idx + ":" +list.get(idx)); // get(index) : 주어진 인덱스에 저장된 객체를 리턴
					}
					
					System.out.println("삽입 데이터");
					list.add(1, "배구"); // add(index, 객체) : 주어진 객체를 특정한 인덱스 위치에 삽입
					for(int idx = 0; idx<list.size(); idx++) {
						System.out.println(idx + ":" + list.get(idx));
					}
					
					System.out.println("변경 데이터");
					list.set(0, "탁구"); // set(index, 객체) : 주어진 인덱스에 저장된 객체를 주어진 객체로 바꿈.
					for(int idx = 0; idx<list.size(); idx++) {
						System.out.println(idx + ":" + list.get(idx));
					}

					System.out.println(list.contains("야구")); // contain(객체) : 해당 객체가 포함되어 있는지 여부
					System.out.println(list.contains("축구"));

					System.out.println(list.isEmpty()); // isEmpty() : 컬렉션이 비어있는지 조사

					System.out.println(list.size()); // size() : 저장되어있는 전체 객체수 리턴

					System.out.println("삭제 데이터");
					list.remove(2); // remove(index) : 특정 위치에 있는 객체 삭제
					for(int idx = 0; idx<list.size(); idx++) {
						System.out.println(idx + ":" + list.get(idx));
					}

					System.out.println("모든데이터 삭제");
					list.clear(); // clear() : 모든 객체 삭제
					for(int idx = 0; idx<list.size(); idx++) {
						System.out.println(idx + ":" + list.get(idx));
					}
	}

}

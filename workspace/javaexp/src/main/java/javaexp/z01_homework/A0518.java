package javaexp.z01_homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A0518 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2022-05-18
		// [1단계:개념] 1. Set컬렉션의 특징을 기본 예제를 통해서 기술하세요.
					// 수학의 집합에 비유
					// 저장 순서가 유지되지 않음
					// 객체를 중복저장 불가
					// 하나의 null만 저장 가능
					Set<Integer> dice = new HashSet<Integer>();
					dice.add(1);
					dice.add(6);
					dice.add(3);
					dice.add(2);
					dice.add(3);
					dice.add(4);
					dice.add(4);
					dice.add(5);
					dice.add(6);
					System.out.println("주사위의 숫자");
					for(int num:dice) {
						System.out.println(num);
					}

		// [1단계:개념] 2. map컬렉션의 특징을 기본 예제를 통해서 기술하세요.
					// 키와 값으로 구성된 Map.Entry 객체를 저장하는 구조
					// 키와 값은 모두 객체
					// 키는 중복될 수 없지만 값은 중복 저장 가능

		// [1단계:개념] 3. Map<Integer, Player> 형태로 번호와 선수정보를 mapping하는
		// 	  Map 객체를 생성하여 선수의 팀명 이름 성적으로 3명 선수번호와 함께 출력하세요.
					Map<Integer, Player1> plist = new HashMap<Integer, Player1>();
					plist.put(50, new Player1("김현수", "LG", 102));
					plist.put(10, new Player1("양의지", "NC", 70));
					plist.put(30, new Player1("허경민", "두산", 50));
					Set<Integer> pnum = plist.keySet();
					System.out.println("번호\t선수명\t팀명\t성적");
					for(int no:pnum) {
						System.out.print(no + "\t");
						plist.get(no).showInfo();
					}

		// [1단계:개념] 4. select 컬럼과 where 조건의 차이점를 예제로 기술하세요.
					// SELECT *
					// FROM emp
					// WHERE sal<=2000;
					// select : 열단위 컬럼을 선택
    				// where 조건 : 행단위 filtering을 처리

		// [1단계:활용] 5. 사원정보에서 급여가 2000~5000인 사원번호, 사원명, 급여를 출력하세요.
					// SELECT empno 사원번호,
					// ename 사원명,
					// sal 급여
					// FROM emp
					// WHERE sal BETWEEN 2000 AND 5000;

		// [1단계:활용] 6. 직책이 CLERK와 MANAGER를 검색하여 이에 해당 하는 사원 정보를 출력하세요.
					// SELECT *
					// FROM emp
					// WHERE job = 'CLERK'
					// OR job = 'MANAGER';

		// [1단계:활용] 7. [SUBQUERY in] 사원번호 7566, 7782가 소속된 부서번호에 해당하는 
		// 	  사원정보를 출력하세요.
					// SELECT *
					// FROM emp
					// WHERE deptno in(
					// 		SELECT deptno
					// 		FROM emp
					// 		WHERE empno = 7566 OR empno = 7782
					// );
					
		// [1단계:개념] 8. 키워드 검색의 종류를 예제와 함께 나열해보세요.
					// '데이터%' : 해당 데이터로 시작
					// SELECT *
					// FROM emp
					// WHERE job LIKE 'S%';

					// '%데이터' : 해당 데이터로 끝
					// SELECT *
					// FROM emp
					// WHERE job LIKE '%T';

					// '%데이터%' : 해당 데이터 포함
					// SELECT *
					// FROM emp
					// WHERE job LIKE '%ER%';

					// '_데이터' : 첫자이후에 특정데이터 포함 - 자릿수 keyword 검색
					// SELECT *
					// FROM emp
					// WHERE job LIKE '_A%';

					// '데이터_' : 데이터가 마지막 한자 데이터 포함
					// SELECT *
					// FROM emp
					// WHERE job LIKE '%S_';

		// [1단계:활용] 9. 1981에 입사한 사원들의 직책을 기준으로 사원정보를 출력하세요..
					// SELECT *
					// FROM emp
					// WHERE hiredate LIKE '%81%'
					// ORDER BY job;

		// [1단계:활용] 10. like 키워드로 1/4분에 입사한 사원들의 부서정보와 동일한 사원들을 출력하세요.
					// SELECT *
					// FROM emp
					// WHERE deptno in(
					// 		SELECT deptno
					// 		FROM emp
					// 		WHERE to_char(hiredate) LIKE '%01%'
					// 		OR to_char(hiredate) LIKE '%02%'
					// 		OR to_char(hiredate) LIKE '%03%'
					// 		OR to_char(hiredate) LIKE '%04%'
					// );

		// [1단계:개념] 11. 집합연산자의 종류를 예제를 통해서 기술하세요.
					// union : 두 집합에 대해 중복되는 행을 제외한 합집합
					// union all : 두 집합에 대해 중복되는 행을 포함한 합집합
					// minus : 두 집합간의 차집합
					// intersect : 두 집합간의 교집합
					
					// CREATE TABLE emp_cp100
					// AS SELECT * FROM emp
					// WHERE deptno = 10;
					// SELECT * FROM emp_cp100;
					// INSERT INTO emp_cp100 values(7999, '홍길동', '사원', 7839, sysdate, 3000, NULL, 40)
					// -- 중복데이터를 제거한 데이터 : union
					// SELECT empno, ename FROM emp
					// UNION
					// SELECT empno, ename FROM emp_cp100;
					// -- 중복데이터를 제거한 데이터 : union all
					// SELECT empno, ename FROM emp
					// UNION ALL
					// SELECT empno, ename FROM emp_cp100;
					// -- 차집합 처리 : minus
					// SELECT empno, ename FROM emp
					// MINUS
					// SELECT empno, ename FROM emp_cp100;
					// -- 교집합 처리 : intersect
					// SELECT empno, ename FROM emp
					// intersect
					// SELECT empno, ename FROM emp_cp100;
	}

}
class Player1{
	private String name;
	private String tname;
	private int score;

	public Player1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player1(String name, String tname, int score) {
		super();
		this.name = name;
		this.tname = tname;
		this.score = score;
	}

	public void showInfo() {
		System.out.println(tname + "\t" + name + "\t" + score);
	}
	
}
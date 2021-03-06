package javaexp.z01_homework;

public class A0519 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2022-05-19
		// [1단계:개념] 1. 데이터베이스의 정렬의 기본 형식을 기본 예제를 통해서 설명하세요.
					// select *
					// from 테이블
					// where..
					// order by 컬럼 [asc/desc]
					// asc : default 로 오름차순 정렬
					// desc : 내림차순 정렬

					// SELECT *
					// FROM emp
					// ORDER BY deptno, sal desc;

		// [1단계:개념] 2. 함수의 크게 단일행/복수행 함수로 나누어진다. 이것의 구별기준을 예제로 설명하세요.
					// 단일행 함수 : 테이블에 저장되어 있는 개별 행을 대상으로 하는 함수를 말하고, 적용을 하며 하나의 행당
					// 			하나의 결과를 반환하는 함수를 말한다.
					// 복수행 함수 : 조건에 따라 여러 행을 그룹화하여 그룹별로 결과를 하나씩 반환하는 함수
					// 			여러 행의 데이터를 함수가 적용되었을 때, 단일 또는 줄어든 행의 결과값을 리턴하는 함수를 말한다.

		// [1단계:확인] 3. 아래의 형식으로 함수를 적용해서 출력하되 ename이 대소문자 구분없이 a/A인 데이터로 두번째 포함되어 검색 되게 처리하세요.
		//                 The salary of Ward is @@@ won!!!
					// SELECT 'The salary of ' || initcap(ename) || ' is ' || sal || 'won!!!'
					// FROM emp
					// WHERE ename LIKE '_A%'
					// OR ename LIKE '_a%';

		// [1단계:개념] 4. substr() 함수의 기본 매개변수와 기능을 기본예제를 통해서 설명하세요.
					// substr(문자열데이터, 시작위치, 시작위치에서 갯수)
					// 문자열 데이터를 시작위치와 마지막위치를 기준으로 절삭처리하여 사용하는 것을 말한다.
					
					// SELECT substr('951212-2701521', 0, 2) || '년 ' 
					// 	|| substr('951212-2701521', 2, 2) || '월 '
					// 	|| substr('951212-2701521', 4, 2) || '일'
					// FROM dual;

		// [1단계:확인] 5. ename의 첫번째에서 3번째 데이터 추출, job과 혼합하여 화면에 출력하되, substr(), concat()함수를 활용하세요
					// SELECT concat(substr(ename, 3, 1), job)
					// FROM emp;

		// [1단계:확인] 6. ||, substr을 활용하여 1980에 입사한 사람의 입사일정보를 @@@는 @@@@년 @@월 @@일에 입사했습니다.로 출력하세요(ename, hiredate활용)
					// SELECT ename || '는 ' 
					// 		|| '19' || substr(hiredate, 0, 2) || '년 ' 
					// 		|| substr(hiredate, 4, 2) || '월 '
					// 		|| substr(hiredate, 7, 2) || '일에 입사했습니다' show
					// FROM emp;
					
		// [1단계:개념] 7. instr의 기본 매개변수 옵션을 예제를 통해서 기술하세요.
					// instr(데이터, '검색할 문자') : 해당 위치를 return
					// instr(데이터, '검색할 문자', 검색할 시작위치, 매칭대상이 나올 횟수) : 
					// 	1부터 시작해서 검색할 시작위치와 검색되어 나온 데이터의 @@번째 횟수를 지정해서 index를 나오게 할 수 있다.

		// [1단계:확인] 8. 사원번호, 사원명, 직책 급여을 출력하되, 사원명, 직책은 최고 크기를 확인하고, 
		//                 사원명과 직책은 각각 최고 크기의 기준으로 왼쪽과 오른쪽에 #을 삽입하여 출력하세요.
					// SELECT empno, length(ename), length(job),lpad(ename, 6, '#'), rpad(job, 9, '#')
					// FROM emp;

		// [1단계:개념] 9. 숫자형 함수 중에 자리수 처리에 대한 처리를 함수별로 비교를 기술하세요.
					// round : 지정한 소숫점 자리로 반올림 처리를 해주는 함수
					// trunc : 지정한 소숫점 자리까지 남기고 절삭처리

		// [1단계:확인] 10. 근무일수를 2분위로 나누어서(중앙값을 기준)서 보너스를 급여의 150%,200% 차등 지급하기로 했다. 사원명, 입사일, 분류, 보너스금액
					// SELECT ename, hiredate,
					// 		floor(sysdate - hiredate) workdate2,
					// 		floor((sysdate - hiredate)/14955) 구분자,
					// 		sal,
					// 		(floor(((sysdate-hiredate)/14955)+3)*0.5)*100 || '%' "보너스 비율",
					// 		sal*(floor((sysdate - hiredate)/14955)+3)*0.5 "보너스 급여"
					// FROM emp; 
					
		// [1단계:확인] 11. 오늘을 1일을 기준으로 1000일 기념일의 날짜와  걸린 기간을 @@년 @@개월 @@일 형식으로 표기하세요. hint)mod함수 활용
					// SELECT sysdate+1000 "날짜", trunc(1000/365) || '년 ' 
					// 				|| trunc(mod(1000, 365)/31) || '개월' 
					// 				|| mod(mod(1000, 365), 31) || '일' "걸린기간"
					// FROM dual;		
	}

}

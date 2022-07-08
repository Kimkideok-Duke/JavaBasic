package springweb.Homework;

public class Hw0708 {
//	2022-07-08
//	[1단계:개념] 1. mybatis framework를 통해 데이터 베이스를 처리할려고 한다. 기본 환경 설정 구성을 예제를 통해서 기술하세요.
			//	1. sql 작성
			//		select ename, job, empno
			//		from emp
			//	2. vo 만들기
			//		class Emp2{
			//			private String ename;
			//			private String job;
			//			private int empno;
			//			// 생성자/set/get메서드.
			//		}
			//	3. dao interface 선언
			//		interface ExpDao{
			//			public List<Emp2> emplist();
			//		}
			//	
			//	4. 공통 설정 파일 mybatis.Spring.xml
			//		1) vo를 alias로 등록
			//		2) mapper 등록
			//	
			//	5. mapper 안에 sql 처리
			//		<select id="emplist" resultType="emp2"
			//			select ename, job, empno
			//			from emp
	
//	[1단계:개념] 2. dao와 mapper의 연관관계를 설정하는 이유와 연관관계 설정 규칙을 기술하세요.
			//	1. 인터페이스 명과 namespace의 명을 동일하게.. XXXMapper.xml === XXXDao
			//	public class EmpDao {
			//	   public List<Emp> getEmpList(Emp sch); (추상메서드)
			//	   // 3. 리턴할 데이터 유형 List<Emp> == resultType
			//	   // 4. 매개변수의 데이터 유형(Emp sch) == parameterType
			//	2. 기능메서드와 sql을 가지고 있는 mapper의 id명과 연결
			//	   public void insertEmp(Emp ins);
			//	}
			//	인터페이스의 구성요소를 실제 객체를 만들기 위해 연결 규칙을 선언해주면 실제 객체를 만들어준다.
			//	EmpDao dao = new RealEmpDaoObj();
//	[1단계:확인] 3. 아래의 sql을 통해 처리되는 dao인터페이스 mapper.xml에 처리될 코드를 기술하세요.
//	      1) 가장 최근에 입사한 사람의 입사일
//	      2) 30번 부서 최고 급여자 사원정보
//	      3) 급여가 1000~3000사이의 사원명
//	      4) 1/4분기에 입사한 사람의 사원번호, 사원명, 분기명, 입사일
//	      5) 직책별 평균 급여 정보(직책, 급여)
			// dao 인터페이스
			@Repository
			public interface DaoHw0708 {
			//	1
				public Date getLatestHired();
			//	2
				public Emp HighestSalinDept();
			//	3
				public String getEnameSalRange();
			//	4
				public Emp getEmpListHiredFirstQuater();
			//	5
				public Emp AvgSalbyDept();
			}
			// mapper.xml
			/*
			<mapper namespace="springweb.a02_mvc.a03_dao.DaoHw0708">
				<select id="getLatestHired" resultType="Date">
					SELECT max(hiredate)
				FROM emp
				</select>
				<select id="HighestSalinDept" resultType="Emp">
					SELECT *
				FROM EMP
				WHERE SAL IN(
				SELECT max(sal)
				FROM emp
				WHERE DEPTNO=30
				)
				</select>
				<select id="getEnameSalRange" resultType="String">
					SELECT ename
				FROM emp
				WHERE sal>=1000 AND sal<=3000
				</select>
				<select id="getEmpListHiredFirstQuater" resultType="Emp">
					SELECT empno, ename, TO_CHAR(hiredate,'Q'), hiredate
				FROM emp
				WHERE TO_CHAR(HIREDATE, 'Q')='1'
				</select>
				<select id="AvgSalbyDept" resultType="Emp">
					SELECT job, ROUND(AVG(sal)) 
				FROM EMP
				GROUP BY JOB
				</select>
			</mapper>
			*/
}

package springweb.Homework;

import springweb.z01_vo.Emp;

public class Hw0711 {

//	2022-07-11
//	[1단계:개념] 1. mybatis와 단일 매개변수와 다중매개변수를 처리하는 방식을 기술하세요.
//	[1단계:개념] 2. map으로 매개변수 처리할 때, Map의 기본 기능과 mybatis에서 처리하는 방식을 기술하세요.
//	[1단계:개념] 3. mybatis에서 조건절 처리에 대한 기본 형식을 기술하세요.
//	[1단계:확인] 4. 아래의 sql을 mybatis를 활용하여 처리하세요.
	
	
//	      1) 직책을 입력하여 직책의 평균급여를 직책과 함께 데이터 가져옮
	/*
	SELECT job, round(avg(sal) sal
	FROM emp
	WHERE job = #{job}
	GROUP BY job 
	*/
/*
vo : emp
dao
	public Emp getAvgSalJob(String job);
mapper
	<select id="getAvgSalJob" resultType="emp" parameterType="string">
		SELECT job, round(avg(sal) sal
		FROM emp
		WHERE job = #{job}
		GROUP BY job
	</select>
service
	Emp jobEmp = dao2.getAvgSalJob("CLERK");
	if(jobEmp!=null) System.out.println(jobEmp.getEmpno()+":"+
			jobEmp.getEname());
*/
	
	
//	      2) 급여의 범위(시작/마지막)을 지정하여 사원 정보를 가져오기
	/*
	SELECT *
	FROM emp
	WHERE sal BETWEEN #{start} AND #{end}
	*/
//map? vo? : vo를 쓰는 경우, 이후에 재활용을 하고, 테이블과 mapping되는 property인 경우
//	map을 쓰는 경우, 테이블에 있는 property가 아니고, 사용도 이 경우에만 활용된 경우
/*
dao
	public List<Emp> getSalSch(Map map);
mapper
	<select id="getSalSch" resultType="emp" parameterType="hashMap">
		SELECT *
		FROM emp
		WHERE sal BETWEEN #{start} AND #{end}
	</select>
service
	Map<String, Double> salmap = new HashMap<String, Double>();
	salmap.put("start",1000);
	salmap.put("end",3000);
	System.out.println("검색된 사원의 건수(1000~3000):"
							+dao2.getSalSch(salmap).size());
*/
	
	
	
//	      3) salgrade테이블의 정보를 입력 처리
	/*
	INSERT INTO salgrade011 values(#{grade},#{losal},#{hisal})
	*/
/*
vo
	class Salgrade{
		private int grade;
		private double losal;
		private double hisal;
	}
dao
	public void insertSalgrade(Salgrade ins);
공통 mybatis
	salgrade :
mapper
	<insert id="insertSalgrade" parameterType="salgrade">
		INSERT INTO salgrade011 values(#{grade},#{losal},#{hisal})
	</insert>
service
	dao2.insertSalgrade(new Salgrade(7, 5001,6000));
*/
	
	
	
}

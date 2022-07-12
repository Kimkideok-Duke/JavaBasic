package springweb.Homework;

public class Hw0712 {
//	2022-07-12
//	[1단계:개념] 1. 스프링 초기화면 요청값 처리하는 방식과 모델 처리방식을 기술하세요
                // # 요청값과 모델 데이터 처리
                // 1. 요청값은 controller의 메서드의 매개변수로 처리할 수 있다.
                //     1) url : /call01.do?name=홍길동
                //     2) @RequestMapping("call01.do")
                //         public String call01(@RequestMapping("name") String name,
                //                             @RequestMapping("age") int age){
                //             // 요청값을 처리하되, 요청값의 이름을 @RequestParam("name")형태로
                //             // 선언해서 처리한다.
                //             System.out.print("이름 : "+name)
                //             System.out.print("나이 : "+age)
                //         }
                //     # 주의 !!
                //     - 요청값을 받지 못하게 처리되는 경우 : 404에러
                //         get방식으로 요청값 없이 위 메서드 호출하면 에러 발생
                //         /call01.do
                //         ==> 요청값이 있으면 요청값을 받아서 처리하고, 없으면 일단 default로 처리하는 방법
                //         public String call01(@RequestMapping(("name"), defaultValue ="") String name,
                //                             @RequestMapping(("age"), defaultValue="0") int age,
                //     - 단, default값을 설정하더라도 숫자형 데이터는 숫자형으로 형변환 될 문자열을 query string 으로
                //         선언하지 않으면 404에러 발생
                //         /call01.do?name=홍길동&age=이십오(X)
                    
                // 2. 요청값을 객체로 매개변수 받아서 처리
                //     1) url : empList.do?ename=홍길동&job=사원
                //     2) 위의 요청값을 받기 위해서 매개변수로 설정된 클래스안에 다음과 같은 메서드가 property로
                //         선언되어 있으면 된다.
                //         public void setEname(String ename){
                //             // setEname ==> Ename ==> ename (set property)
                //             // getEname ==> Ename ==> ename (get property) ${emp.ename}

                //     3) 요청값의 key=value 에 key가 set property와 동일하고, 데이터 유형이 매개변수로
                //         할당이 가능할 때, 자동으로 객체에 할당이 된다.
                //         핵심) 객체 이름 중요한것이 아니고, 객체가 가지고 있는 메서드 setXXXX()가 어떻게 아래의 규칙으로 선언이
                //             되어 있는가가 문제이다.
                //         ex) job=사원
                //         public void setJob(String job) (O)
                //         public void setJob1(String job) (X)
                //         public void setJob(int job) (X)
                //         public void setJob(double job) (X)
                //         ex) sal=3000
                //         public void setSal(String sal) (O)
                //         public void setSal1(String sal) (X)
                //         public void setSal(double sal) (O)
                //         public void setSal(int sal) (O)


//	[1단계:개념] 2. 스프링에서 화면과 함께 하는 MVC의 전체적인 흐름을 핵심 코드 위주로 설명하세요.
                // # 화면단 처리와 모델 데이터
                //     1. 화면 출력 내용(view)
                //         1) 화면에 구성 처리(css, html, js)
                //             front 화면의 구성을 만들기
                //         2) 요청값에 대한 처리
                //             query string : 요청key=요청value : 서버(controller)에 보낼 데이터
                //             <form action="서버url" method="get/post">
                //                 <input name="요청key" value="요청value"
                //                 <input type="submit"

                //         3) 모델데이터를 화면에 출력
                //     2. 위 화면 출력(view)에서 controller에 영향을 미치고, 영향받는 내용
                //         특정한 controller단의 연동하는 메서드를 호출하는 방식
                //         0) url mapping : /boardList.do
                //             @RequestMapping("boardList.do")
                //             public String boardList(Model d) {
                //         1) 요청값 처리 : ? 요청key=요청value
                //             ex) ?subject=첫번째글&writer=홍길동
                //             public String boardList(@RequestParam("요청key") String name)
                //             public String boardList(
                //                 @RequestParam("subject") String subject,
                //                 @RequestParam("writer") String writer
                //             ){
                //                 subject, writer : 클라이언트에서 전달할 요청값을 변수로 사용가능
                //             }
                //             public String boardList(Board sch){

                //             }

                //         2) 모델데이터 처리

                //     3. controller ==> service --> dao
                //         BoardController BoardService BoardDao (mybatis) mapper
                //         요청 subject, writer							 parameterType="board"
                //             Board ==> Board ==> Board					#{subject} getSubject()

                //         mybatis에서 dao 	==> 	service 	===> 	controller		==>		view 모델 데이터 처리
                //         dao상속받은				   서비스에서 받은    	   서비스에 온 데이터를
                //         데이터있는 객체			   알고리즘, DB외에도   	view단에 전달할 내용 있으면
                //         List<Board>	  		 모델처리를 위한 연동처리	 	 Model을 통해서
                //         인터페이스							  			모델 key, 모델 데이터
                //         BoardDao dao 
                //         = 마이바티즈.boardList(sch);
                //         마이바티즈에서 만들어준 실제 객체

                //     4. controller에서 모델 데이터를 화면에 보내기

                //     5. 화면에서 받아온 모델 데이터 처리하기

//	[1단계:확인] 3. 현재 만들어진 dao(DaoExp01)를 기준으로 화면을 만들어 요청값과 모델 데이터를 처리하세요
//	         1) 사원번호로 상세 사원정보 검색
dao
    public List<Emp> getEmpEmpno(int empno);
mapper
    <select id="getEmpEmpno" resultType="emp" parameterType="int">
        SELECT empno, ename, job, sal, deptno
        FROM emp
        WHERE 1=1
        AND empno LIKE '%'||#{empno}||'%'
    </select>
service
    public List<Emp> getEmpEmpno(int empno){
        return dao2.getEmpEmpno(empno);
    }
controller
    @RequestMapping("getEmpEmpno.do")
    public String getEmpEmpno(
            @RequestParam(value="empno", defaultValue="7") int empno,
            Model d) {
        d.addAttribute("elist", service.getEmpEmpno(empno));
        return "WEB-INF/views/a02_mvc/Hw0712_empnoList.jsp";
    }

//	         2) 직책으로 평균 급여 검색
dao
    public List<Emp> getAvgSal(String job);
mapper
    <select id="getAvgSal" resultType="emp" parameterType="string">
        SELECT job, round(avg(sal)) sal
        FROM emp
        WHERE job = #{job}
        GROUP BY job
    </select>
service
    public List<Emp> getAvgSal(String job) {
        return dao2.getAvgSal(job);
    }
controller
    @RequestMapping("getAvgSal.do")
    public String getAvgSal(
            @RequestParam(value="job", defaultValue="") String job,
            Model d) {
        d.addAttribute("elist", service.getAvgSal(job));
        return "WEB-INF/views/a02_mvc/Hw0712_getAvgSalJob.jsp";
    }
//	         3) 부서번호를 기준으로 부서번호와 최고 급여 출력
dao
    public List<Emp> getMaxDeptno(int deptno);
mapper
    <select id="getMaxDeptno" resultType="emp" parameterType="int">
        SELECT deptno, max(sal) sal
        FROM emp
        WHERE deptno = #{deptno}
        GROUP BY deptno
    </select>
service
    public List<Emp> getMaxDeptno(int deptno) {
        return dao2.getMaxDeptno(deptno);
    }
controller
    @RequestMapping("getMaxDeptno.do")
    public String getMaxDeptno(
            @RequestParam(value="deptno", defaultValue="0") int deptno,
            Model d) {
        d.addAttribute("elist", service.getMaxDeptno(deptno));
        return "WEB-INF/views/a02_mvc/Hw0712_getMaxDeptno.jsp";
    }
}

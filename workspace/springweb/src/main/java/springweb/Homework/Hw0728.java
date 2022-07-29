package springweb.Homework;

public class Hw0728 {
	// [1단계:개념] 1. jquery lib를 활용하는 순서를 기술하세요
                // 1) jquery lib 다운로드
                //     webapp 설정 main index.html 확인
                // 2) controller/view단 확인
                // 3) 공통 lib(css, js) webapp/a01_com 위치
                // 4) 초기 로딩 화면 controller를 통해 호출
                // 5) ajax 처리 및 호출 controller 메서드 선언

	// [1단계:개념] 2. fullcalendar의 수정 처리 프로세스의 종류와 처리방법을 기술하세요.
                // 1) 상세화면/등록 화면의 기본 태이블과 버튼 처리(show()/hide()처리)
                // 2) 수정 처리
                //     상세 화면에서 수정 처리
                //     일정 드랍 다운, 일정 시간 resize로 수정 처리
                // 3) 공통 form 데이터 처리 기능 메서드 선언 및
                //     기능메서드의 매개변수로 해당 기능 할당 처리
                // 4) $("form").attr("action", ...)
                //    $("form").submit()

	// [1단계:개념] 3. 스프링의 이용한 session 처리 방법을 기술하세요.
                // 1) jsp Servlet 활용
                //     메서드의 매개변수로 HttpServletRequest request를 선언하여
                //         getSession() 메서드로 선언할 수 있다.
                // 2) spring 자체 키워드
                //     ModelAttribute("세션명")를 선언하고, Controller상단에
                //     SessionAttribute("세션명")을 선언함으로 세션 처리를 할 수 있다.

	// [1단계:확인] 4. 기존의 member테이블을 이용하여 ajax로 회원등록여부와 로그인 session 처리를 하세요.
    // 1) sql
    //     SELECT count(*)
    //     FROM Member011
    //     WHERE id=#{id}

    //     SELECT *
    //     FROM member011
    //     WHERE id=#{id}
    //     AND pass=#{pass}
    
    // 2) vo member 공통 mybatis등록

    // 3) dao/mapper/service
    //     public int checkMember(int id);
    //     public Member getMember(Member m);
        
    //     mapper
    //     springweb.a02_mvc.a03_dao.MemberDao
    //     <select id="checkMember" parameterType="int" resultType="int">
    //         SELECT count(*)
    //         FROM Member011
    //         WHERE id=#{id}
    //     </select>
    //     <select id="getMember" parameterType="member" resultType="member">
    //         SELECT *
    //         FROM member011
    //         WHERE id=#{id}
    //         AND pass=#{pass}
    //     </select>

//        service
//
//
//    4) controller
//        회원가입화면
//        로그인처리화면
//        ajax처리
//    5) controller단 session처리
//    6) view(jsp)
//        jquery ajax를 통해 회원가입여부 처리
//        로그인 화면에서 로그인처리
    
}

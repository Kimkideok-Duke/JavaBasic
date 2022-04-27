package javaexp.a04_process;

public class A02_if_else {

    public static void main(String[] args){

        /*
        # java에서 문자열의 비교 처리
        1. 문자열1==문자열2(X) 로 비교하면 예외가 발생한다.
        2. 문자열1.equals(문자열2)
        */
        String name01 = "홍길동";
        String name02 = "홍길동";
        String name03 = "신길동";
        System.out.println("문자열 비교 : " + name01.equals(name02));
        System.out.println("문자열 비교 : " + name01.equals(name03));

        String inputId = "himan";
        String inputPwd = "9998";
        if(inputId.equals("himan") && inputPwd.equals("9999")){
            System.out.println(inputId + "님 로그인 성공입니다!");
        } else {
            System.out.println("로그인 실패입니다!");
        }
        // ex) age를 임의의 숫자로 할당하고, 10~20까지일 때는 청소년 요금제입니다.
        //      그외는 청소년 요금제가 아닙니다.
        int age = 22;
        if(age <= 20 && age >= 10) {
            System.out.println("청소년 요금제 입니다.");
        } else System.out.println("일반 요금제 입니다.");

        // ex) 타율 : 안타수/타석 입력받아서
        //      0.350 이상은 최고타자
        //      0.3 ~ 0.35 미만 우수타자
        //      0.25 ~ 0.3 미만 일반타자
        //      0.25 미만 2군 준비 타자

        int hit = 102, chance = 330;
        float BA;
        BA = (float)hit/chance;
        System.out.println("타율은 " + BA);
        if(BA>=0.35) System.out.println("최고 타자");
        else if(BA >= 0.3) System.out.println("우수 타자");
        else if(BA >= 0.25) System.out.println("일반 타자");
        else System.out.println("2군 준비 타자");
    }

}

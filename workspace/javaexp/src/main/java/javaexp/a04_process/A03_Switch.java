package javaexp.a04_process;

public class A03_Switch {

    public static void main(String[] args) {
        /*
        # switch문
        1. 변수나 연산식의 값에 따라 실행문 선택할 때, 사용한다.
        2. 기본 형식
            switch(변수){
                case 값1:
                    처리할 내용
                    break;
                case 값2:
                    처리할 내용
                    break;
                default:
                    상단에 선언한 값이 아닌 경우.
            }
        */
        int btnNum = 1;
        switch(btnNum) {
            case 1:
                System.out.println("A 구역에 불이 켜졌습니다.");
                break;
            case 2:
                System.out.println("B 구역에 불이 켜졌습니다.");
                  break;
            case 3:
                System.out.println("C 구역에 불이 켜졌습니다.");
                break;
            default:
                System.out.println("해당 버튼은 지정된 버튼이 아닙니다.");
        }
        /**
         ex) 주사위 번호를 변수로 선언해서 1,3은 빙고라고 출력, 2,4번은 행운의 번호, 5,6번은 gogo!라고 출력, 그 외는 주사위 번호가 아닙니다.
         */
        int dice_Num = 5;
        switch(dice_Num) {
            case 1:
            case 3:
                System.out.println("빙고");
                break;
            case 2:
            case 4:
                System.out.println("행운의 번호");
                break;
            case 5:
            case 6:
                System.out.println("gogo!");
                break;
            default:
                System.out.println("주사위 번호가 아닙니다.");
        }
    }
}

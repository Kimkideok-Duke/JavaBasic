package javaexp.a03_calcu;

public class A05_Calcu_equal {

    public static void main(String[] args){
        /*
        # 비교연산자
        1. 두개의 피연산자의 값을 비교하여 동일한지(==), 같지 않는지(!=), 큰지 (>), 작은지(<)을 boolean값은 true/false 값으로 결과를 처리하는 연산자를 말한다.
        2. 종류
            ==, !=, >, <, >=, <=
        3. 활용
            boolean에 할당하거나, 조건식if(비교연산자), while(비교연산자)를 통하여 활용한다.
        */
        int num01 = 25;
        int num02 = 5;
        System.out.println("#비교 연산 결과");
        System.out.println(num01 + " == " + num02 + " = " + (num01==num02));
        System.out.println(num01 + " != " + num02 + " = " + (num01!=num02));
        System.out.println(num01 + " > " + num02 + " = " + (num01>num02));
        System.out.println(num01 + " < " + num02 + " = " + (num01<num02));
        System.out.println(num01 + " >= " + num02 + " = " + (num01>=num02));
        System.out.println(num01 + " <= " + num02 + " = " + (num01<=num02));

        boolean isEqual = num01 == num02;
        System.out.println("같은지 여부 : " + isEqual);
        if( isEqual ) {
            System.out.println("동일합니다(조건식1)");
        }else{
            System.out.println("동일합니다(조건식2)");
        }
        while(num01!=num02){
            num02++;
            System.out.println(num01 + ":" + num02);
        }
        // ex1) 획득 점수를 변수로 선언하고, 합격기준 점수도 변수를 선언하여, 합격 여부를 boolean값으로 아래 형식으로 출력하세요
        //      획득 점수 : 000, 합격 기준 점수 : 00, 합격 여부 : true/false
        int get_point = 88, pass_point = 70;
        System.out.println("획득 점수 : " + get_point + ", 합격 기준 점수 : " + pass_point + ", 합격 여부 : " + (get_point>=pass_point));
        // ex2) 4지 선다에서 check한 변호 선언, 정답 변호 선언
        //      정답 여부를 출력
        int check_num = 3, answer_num = 1;
        System.out.println("체크 번호 : " + check_num + ", 정답 번호 : " + answer_num + ", 정답 여부 : " + (check_num==answer_num));
    }
}

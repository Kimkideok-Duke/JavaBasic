package javaexp.a03_calcu;

public class A02_Calcu02 {

    public static void main(String[] args) {

        /*
        # 연산자의 종류
        1. 산술 연산자
        2. 부호 연산
            피연산자에 부호 기호(+,-)를 붙여 양수와 음수를 처리하는 것을 말한다.
        */
        
        int num01 = 25;
        int num02 = 5;
        int num03 = -num02;
        int num04 = -num03;
        // num02에 부호기호 -를 붙여 처리하였다.
        System.out.println(num01+num02);
        System.out.println(num01+num03);
        System.out.println("부호기호 - (음수)에 다시 -(음수)를 붙인 경우 : "+num04);

        /*
        3. 문자열의 + 연산자
            +는 숫자형 데이터의 경우 합산을 처리하지만, 문자열의 데이터인 경우 문자열과 문자열을 이어주는 역할을 한다.
            1) 문자열1 + 문자열2 ==> 문자열1문자열2
            2) 숫자1 + 숫자2 + 문자열 ==> 숫자합산문자열
            3) 문자열 + 숫자1 + 숫자2 ==> 문자열숫자1숫자2
        */
        String str1 = "안녕하세요";
        String str2 = "반갑습니다.";
        System.out.println(str1+str2+"문자열을 이어줌");
        int num05 = 4;
        int num06 = 7;
        System.out.println(num05+num06+str1+str2);
        System.out.println(str1+str2+num05+num06);
    }
}

package javaexp.z01_homework;

public class A0426 {

    public static void main(String[] args){
        
        //  2022-04-26
        
        // [1단계:개념] 1. 변수의 초기화에 대하여, 예제를 통하여 기술하세요
        int val1; // 변수의 선언
        val1 = 0; // 변수의 초기화
        int val2 = 0; // 변수의 선언과 동시에 초기화

        // [1단계:개념] 2. 기본데이터유형이 할당되는 jvm 메모리와 해당 유형 종류를 크기에 따라 기술하세요.
        /*****정수형*****/
        // byte = 1byte
        // short = 2byte
        // int = 4byte
        // long = 8byte
        /*****실수형*****/
        // float = 4byte
        // double = 8byte
        /*****문자형*****/
        // char = 2byte
        /*****bool형*****/
        // boolean = true or false
        /////////////Stack, heap

        // [1단계:코드] 3. 21억, 15억 데이터를 int에 할당하고, 합산결과를 변수를 선언하여 할당 출력하세요
        int bil2_1 = 2100000000;
        int bil1_5 = 1500000000;
        long bil_sum = (long)bil2_1 + (long)bil1_5;
        System.out.println("21억+15억 = " + bil_sum);
        
        // [1단계:개념] 4. 150라는 데이터를 기본데이터유형 중에 어디에 할당이 가능한가를 기술하고 그 이유에 대하여 설명하세요
        // byte num150 = 150; // 1byte 초과
        short num150 = 150; // 2byte 미만, short, int, long에 할당 가능하다.

        // [2단계:코드] 5. 알파벳의 코드값 범위와 문자 0부터 9까지 범위의 코드값 범위를 확인하고 출력하세요.
        char a = 'a', z = 'z', A = 'A', Z = 'Z', num0 = '0', num9 = '9';
        System.out.println("알파벳 소문자 a~z까지의 범위는 " + (int)a + "~" + (int)z);
        System.out.println("알파벳 대문자 A~Z까지의 범위는 " + (int)A + "~" + (int)Z);
        System.out.println("문자 0~9까지의 범위는 " + (int)num0 + "~" + (int)num9);

        // [1단계:개념] 6. 형변환 두가지 유형을 예제를 통해서 기술하고 설명하세요..
        // 1) 자동(묵시적) 형변환 : 작은데이터유형에서 큰 데이터 유형으로 변환할 때는 추가 코드없이 자동으로 할당이 된다.
        byte num01 = 25;
		int num02 = 25+num01;
		int num03 = 30;
		double num04 = num03;
		System.out.println(" # 묵시적 형변환 결과 #");
		System.out.println(num01);
		System.out.println(num02);
		System.out.println(num03);
		System.out.println(num04);
        // 2) 강제(명시적) 형변환 : ()을 활용하여 특정한 데이터유형으로 변경이 명시적으로 필요할 때 사용한다.
        double dblNum = 25.27;
		int num05 = (int)dblNum;
		System.out.println("casting한 결과 : " + num05);
		int num06 = 10;
		int num07 = 3;
		// 정수형/정수형 ==> 정수형 : 소숫점 이하의 값이 나오지 않는다.
		// 정수형/실수형 ==> 실수형 : 소숫점 이하의 값이 처리가 된다.
		double result = num06/num07;
		System.out.println("연산결과값 : "+result);
		double result2 = num06/(double)num07;
		System.out.println("연산결과값 : "+result2);

        // [1단계:코드] 7. 500cc의 오렌지쥬스를 3잔에 나누어 할당할려고 한다. 소숫점 이하가 처리된 경우와
        //     소숫점 이하가 처리되지 않는 경우를 나누어 코딩하세요
        int juice_cc = 500, cup = 3, one_cup_int = juice_cc/cup;
        float one_cup_float = (float)juice_cc/(float)cup;
        System.out.println("500cc를 3잔에 나누어 할당할때 한잔의 양(소숫점 이하 처리x) : " + one_cup_int);
        System.out.println("500cc를 3잔에 나누어 할당할때 한잔의 양(소숫점 이하 처리O) : " + one_cup_float);
        
        // [1단계:개념] 8. 연산자, 피연산자, 연산식의 개념을 기본예제를 통해서 구분하여, 설명하세요.
        int x = 5, y = 7, sum;
        sum = x + y; // 연산자 : 연산에 사용되는 표시나 기호 (+, =)
                     // 피연산자 : 연산 대상이 되는 데이터 (x, y, sum)
                     // 연산식 : 연산자와 피연산자를 혼합하여 식을 만들어 가는 것 (sum = x + y)

        // [1단계:코드] 9. 일일 가계부 입력에 필요한 연산식을 만들고 아래 형식으로 출력하세요
        //     날짜   지출구분   내용  입금액    출금액  잔액
        //     4/1   입금     용돈   30000         30000
        //     4/1   출금     점심           6000  24000
        int money_in = 0, money_out = 0, money_remain = 0;
        String note, day, inout;
        System.out.println("날짜     지출구분     내용     입금액     출금액     잔액     ");
        day = "4/1";
        inout = "입금";
        money_in = 30000;
        money_out = 0;
        money_remain = money_remain + money_in - money_out;
        note = "용돈";
        System.out.println(day + "        " + inout + "       " + note + "     " + money_in + "        " + money_out + "       " + money_remain);
        day = "4/1";
        inout = "출금";
        money_in = 0;
        money_out = 6000;
        money_remain = money_remain + money_in - money_out;
        note = "점심";
        System.out.println(day + "        " + inout + "       " + note + "       " + money_in + "         " + money_out + "     " + money_remain);
        
        // [1단계:코드] 10. 변수 선언하고 이를 이용하여 타율(안타/타석)을 계산하여 출력하세요.
        int hit = 129, chance = 391, BA;
        BA = (hit*1000) / chance;
        System.out.println("안타수 : " + hit);
        System.out.println("타석수 : " + chance);
        System.out.println("타율 : " + BA/100 + "할" + (BA - (BA/100)*100)/10 + "푼" + BA%10 + "리");

        // [1단계:코드] 11. 삼각형의 면적을 구하는 공식을 이용하여 밑면과 높이로 출력하세요.
        float underside, height, area;
        underside = 4; height = 6;
        area = underside * height / 2;
        System.out.println("밑면과 높이가 각각 " + underside + ", " + height + "인 삼각형의 넓이는 " + area);
        
        // [1단계:코드] 12. 대입연산자와 연산자의 진행방향의 차이점을 기본 예제를 통해 설명하세요.
        // 대입연산자
        // 1. = : 데이터를 오른쪽에서 왼쪽으로 대입하여 할당이 된다.
            int num1 = 5;
            num1 = num1+1;
            System.out.println("num1 = " + num1);
        // 2. +=,-=,*=,/=,%=
        //     기존 변수에서 누적하여 다시 데이터를 할당할 때, 활용된다.
        //     2이상의 증가하거나 감소등의 연산식을 처리할 때, 활용된다.
            int num2 = 5;
            num2 += 2;
            System.out.println("num2 = " + num2);
        // # 다 하신 후에 어렵거나 자세한 풀이가 필요한 문제는 제출시 표기해주세요
    }

}

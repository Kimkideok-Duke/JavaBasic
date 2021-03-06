package javaexp.a03_calcu;

public class A07_Calcu_Triple {

    public static void main(String[] args) {
        
        /*
        # 삼항연산자
        1. 세 개의 피연산자를 필요로 하는 연산자
        2. 앞의 조건식 결과에 따라 콜론 앞 뒤의 피연산자 선택 ==> 조건 연산기
        3. 형식
            (비교연산자, 조건연산자) ? true일때 : false일때

            cf) 다중의 조건을 처리할 때, 위의 false일때에 다시 3항연산식을 사용한다.
            if else if else if ...
            조건1?결과1:(조건2?결과2:그외결과)
        */

        int point = 80;
        String result = (point>=70)?"합격":"불합격";
        System.out.println("점수 : " + point);
        System.out.println("결과 : " + result);
        // ex1) 쇼핑몰에서 구매한 물건의 가격과 갯수를 변수로 설정하여 총 비용이 30000이상이면 할인대상고객 그렇지 않으면 일반고객으로 표시하세요.
        int price_total, price = 5000, num = 7;
        price_total = price*num;
        String buyer = (price_total>=30000)?"할인대상고객":"할인미대상고객";
        System.out.println("구매한 물건의 가격 : " + price + ", 구매한 물건 갯수 : " + num + ", 전체 가격 : " + price_total + ", " + buyer);
        // ex2) 위 문제에서 나이를 check하여 나이가 20미만이면 20% 할인하여 금액을 산정하고 그렇지 않으면 전테금액을 처리할 때, 최종 금액을 출력하세요.
        int buyer_age = 18;
        price_total = (buyer_age < 20)?(price_total-(price_total*20/100)):price_total;
        System.out.println("구매자의 나이 : " + buyer_age + ", 최종 금액 : " + price_total);
    }
}

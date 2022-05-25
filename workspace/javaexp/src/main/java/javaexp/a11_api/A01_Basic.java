package javaexp.a11_api;

public class A01_Basic {

    public static void main(String[] args) {
        /**
        # 자바 api 도큐먼트
        1. 자바에서 기본적으로 제공하는 라이브러리
        2. 프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음
        3. 쉽게 api찾아 이용할 수 있도록 문서화 한것
        4. html 페이지로 작성되어 있어 웹 브라우저로 바로 볼 수 있음.
        # java.lang 패키지
        1. 자바 프로그램의 기본적인 클래스를 담은 패키지
        2. 포함된 클래스와 인터페이스는 import 없이 사용
        3. 주요 클래스
            1) Object : 자바클래스의 최상위 클래스로 사용
            2) System : 표준 입력/출력 장치 처리 필요
            3) Class : 클래스를 메모리로 로딩할 때, 사용
            4) String : 문자열을 저장하고 여러가지 정보를 얻을 때 사용
            5) StringBuffer, StringBuilder : 문자열을 저장 혹 내부 문자열을 조작할 때 사용
            6) Math : 수학 함수를 이용할 때 사용
            7) Wrapper(Byte, Short, Character, Integer, Float, Double, Boolean)
                기본 타입의 데이터를 갖는 객체를 만들 때 사용
                문자열을 기본타입으로 변환할 때 사용
                입력값 검사에 사용
         */

        /**
        # String 클래스 메소드
        1. 문자열의 추출, 비교, 찾기, 분리, 변환등과 같은 다양한 메소드를 가진다.
        2. 사용 빈도 높은 메소드
            1) charAt(int idx) : 특정위치에 문자 리턴
         */
        String str01 = "EMP1061521";
        System.out.println("첫번째 문자 : " + str01.charAt(0));
        System.out.println("마지막에 있는 문자 : " + str01.charAt(9));
        // ex)
        String civilNum = "901212-1702618";
        for(int i = 0; i<6; i++){
            System.out.print(civilNum.charAt(i));
        }
        System.out.println();
        // indexOf(String str) : 문자열 내에 주어진 문자열의 위치를 리턴
        String data01 = "안녕하세요!! 홍길동입니다.";
        System.out.println(data01.indexOf("홍길동"));
        // ex)
        System.out.println(data01.indexOf("하세요"));
        System.out.println(data01.indexOf("입니다"));
        // 3) length() : 총 문자수를 리턴
        //      주의) 배열의 갯수는 length로 사용되나, 문자열의 문자갯수는 length()
        System.out.println("문자열의 크기" + data01.length());
        // ex)
        System.out.println(data01.indexOf("홍길동"));
        System.out.println((data01.indexOf("홍길동") + ("홍길동".length()) - 1));
        // 4) replace() : 특정부분의 문자를 대체하여 변경처리할 때 사용된다.
        String target = "Hello!! Good day";
        String newText = target.replace('o', 'i');
        System.out.println(newText);
        // ex)
        String names = "김길동, 신길동, 오길동, 마길동";
        System.out.println(names.replace("김", "신"));
        // 5) substring(시작index) : 특정한 문자열을 시작index부터 추출한다.
        //    substring(시작index, 마지막index) : 특정한 문자열을 시작index로 부터 마지막 index를 추춣해준다,
        //    주의) 시작index는 0부터하고, 마지막 index는 1부터 시작한다.
        String data2 = "사과 바나나 딸기 오렌지";
        System.out.println(data2.substring(3));
        System.out.println(data2.substring(7, 9));
        // ex)
        System.out.println(civilNum.substring(0, 6));
        // 6) toLowerCase()/toUpperCase()
        //    소문자로 변경 / 대문자로 변경
        //    cf) 특정데이터를 대소문자 구분없이 검색처리할 때, 주로 활용된다.
        String data3 = "Hello! Good day";
        System.out.println(data3.toLowerCase());
        System.out.println(data3.toUpperCase());
        // 7) trim() : 문자열 앞뒤에 공백을 제거할 때, 사용된다.
        //    [안녕 ] 검색시나 입력시 공백이 들어간 경우, 육안으로 확인이 안된다.
        //           이때 , 아러한 키입력상의 예외를 방지하기 위하여 trim()써서 검색하는 경우가 많다.
        String data4 = "Hello ";
        System.out.println("문자열의 크기 : " + data4.length());
        String data5 = data4.trim();
        System.out.println("trim()후 문자열 : " + data5);
        System.out.println("trim()후 문자열의 크기 : " + data5.length());
        // 8) split("구분할 문자") : 특정데이터를 구분할 문자열로 분리하여 배열을 만들 때, 사용된다.
        String data6 = "사과&바나나&딸기&오렌지";
        String fnames[] = data6.split("&");
        for(String fruit:fnames) {
            System.out.println(fruit);
        }
        // ex)
        String menu = "라면@카레@국밥@떡볶이@치킨";
        String mnames[] = menu.split("@");
        for(String lunch:mnames) {
            System.out.println(lunch);
        }
    }
}
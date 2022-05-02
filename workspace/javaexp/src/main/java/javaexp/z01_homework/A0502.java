package javaexp.z01_homework;

public class A0502 {

    public static void main(String[] args) {

    //     2022-05-02
    // [1단계:개념] 1. 배열의 속성들을 기술하고, 선언과 할당 방식을 기술하세요
                // 같은 타입의 데이터를 연속된 공간에 저장하는 자료구조
                // 각 데이터 저장 위치는 인덱스 부여해 접근한다.
                // # 배열의 선언
                // 1. 배열을 사용하기 위해서 우선 배열 변수 선언
                //     데이터유형[] 배열변수;
                //     데이터유형 배열변수[];
                // 2. 배열은 초기화를 통해 선언을 완료한다.
                //     배열변수 = null;
                // 3. 배열의 heap영역에 메모리를 할당하여야 사용할 수 있다.
                //     1) new 데이터 유형[배열의 크기]; 초기값(0)으로 모든 배열의 구성요소를 할당.
                //     2) {데이터1, 데이터2, 데이터3} : 선언과 직접적인 데이터 할당 한번
                //     3) new 데이터유형[]{데이터1, 데이터2, 데이터3}; : 선언/할당 분리할때
                //     4) 각 배열의 index값을 할당

    // [1단계:개념] 2. 배열과 반복문의 관계를 기술하고, 학생 30명을 임의의 점수(0~100)로 배열에 할당/출력하세요.
                // 반복문을 통해서 효과적으로 활용할 수 있다.
                // for(인덱스의 초기값; 인덱스의 범위; 증감연산자)
                int[] score_arr = new int[30];
                for(int i = 0; i < 30; i++) {
                    score_arr[i] = (int)(Math.random()*101);
                    System.out.println(i+1 + "번째 학생의 점수 : " + score_arr[i]);
                }

    // [1단계:응용] 3. 무지개 색상을 배열로 선언하고, 이 중에서 임의의 색상 3개를 출력하세요
                String[] rainbow_str = {"빨", "주", "노", "초", "파", "남", "보"};
                int[] memory = new int[3];
                for(int i = 0; i < 3; i++) {
                    int rand_num = (int)(Math.random()*7+1);
                    if(rand_num == memory[0] || rand_num == memory[1] || rand_num == memory[2]) i--;
                    else {
                        memory[i] = rand_num;
                        System.out.println(rainbow_str[rand_num-1]);
                    }
                }

    // [1단계:응용] 4. 1차원 배열로 회원의 이름 5명을 선언하고 할당 출력하세요
                String[] name = {"김영삼", "김대중", "노무현", "이명박", "박근혜"};
                for(int i = 0; i<5; i++) {
                    System.out.println(name[i]);
                }
    //         2차원 배열로 위 회원이름에 추가하여 나이와 사는 곳을 만들어 할당하고 출력하세요
                String[][] members = new String[5][3];
                members[0] = new String[] {name[0], "45", "서울"};
                members[1] = new String[] {name[1], "60", "광주"};
                members[2] = new String[] {name[2], "25", "수원"};
                members[3] = new String[] {name[3], "33", "부산"};
                members[4] = new String[] {name[4], "12", "춘천"};
                for(int i = 0; i<members.length; i++) {
                        System.out.println("이름 : " + members[i][0] + ", 나이 : " + members[i][1] + ", 사는곳 : " + members[i][2]);
                }

    // [1단계:개념] 5. main(String args[])에서 args가 사용하는 방법과 내용을 기술하세요
                // args문자열을 배열로 사용하겠다는 의미
                // main() 실행시 사용되는 메서드.
                // String[] args : 실행시 외부에서 받은 데이터를 배열로 받아서 처리할 때 활용된다.
                // java A04_Args 사과 바나나 딸기
                // 		위 경우에 String[] args = {"사과", "바나나", "딸기"};
                // 		args[0] : "사과"
                // 		args[1] : "바나나"
                // 		args[2] : "딸기"

    // [1단계:개념] 6. args[]로 구매할 물건명 가격 갯수를 입력받아서 물건명과 총비용을 출력하세요.
                int sum = Integer.parseInt(args[1]) * Integer.parseInt(args[2]);
                System.out.println("물건명 : " + args[0] + ", 가격 : " + args[1] + ", 갯수 : " + args[2] + ", 총비용 : " + sum);

    }

}

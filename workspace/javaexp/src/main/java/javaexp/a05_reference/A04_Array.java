package javaexp.a05_reference;

public class A04_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 # 배열 타입
		 1. 같은 타입의 데이터를 연속된 공간에 저장하는 자료구조
		 2. 각 데이터 저장 위치는 인덱스 부여해 접근한다.
		 */

		int[] array = {1000, 2000, 3000, 4000};
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		/**
		# 배열의 장점
		1. 중복된 변수선언을 줄이기 위해 사용합니다.
			int num01;
			int num02;
			int num03;
			int num04;
			==> 
			int[] numArray;
		2. 반복문을 통해서 효과적으로 활용할 수 있다.
			for(인덱스의 초기값; 인덱스의 범위; 증감연산자)
		 */
		// 배열명.length : 배열의 딜이
		// 배열의 index의 최고값 : 배열의 길이 - 1
		// 배열의 범위를 설정할 때 , index값이 길이보다 작기 때문
		// 	비교연산자를  < cf)주의  <= (X)
		System.out.println("반복문을 통한 배열의 처리");
		for(int idx = 0; idx < array.length;idx++) {
			System.out.print("index 번호 : " + idx+"\t");
			System.out.print(array[idx] + "\n");
		}

		/**
		# 배열의 선언
		1. 배열을 사용하기 위해서 우선 배열 변수 선언
			데이터유형[] 배열변수;
			데이터유형 배열변수[];
		2. 배열은 초기화를 통해 선언을 완료한다.
			배열변수 = null;
		3. 배열의 heap영역에 메모리를 할당하여야 사용할 수 있다.
			1) new 데이터 유형[배열의 크기]; 초기값(0)으로 모든 배열의 구성요소를 할당.
			2) {데이터1, 데이터2, 데이터3} : 선언과 직접적인 데이터 할당 한번
			3) new 데이터유형[]{데이터1, 데이터2, 데이터3}; : 선언/할당 분리할때
			4) 각 배열의 index값을 할당
		 */
		int[] array01; // 배열의 선언1
		int array02[]; // 배열의 선언2
		array01 = null; // 배열의 stack영역 초기화 : heap영역에 할당되지 않음, 사용불가능
		float [] array03 = null;
		System.out.println(array01);
	//  System.out.println(array02); stack영역 초기화 되지않아 호출조차 불가능
		System.out.println(array03);
		// heap영역에 할당하지 않는 상황에서 index로 사용하면 에러 발생
	//  System.out.println(array01[0]); 에러 발생
		// heap 메모리 할당 - 데이터 초기화
		// 객체는 stack/heap영역 같이 사용하고, new 키워드를 통해서 heap영역에 객체를 생성한다.
		int [] array04 = new int[5]; // int형으로 5개가 포함된 배열 선언
		array04[2] = 30;
		System.out.println(array04[0]);
		System.out.println(array04[1]);
		System.out.println(array04[2]);
		System.out.println(array04[3]);
		System.out.println(array04[4]);
		int [] array05 = {10, 20, 30, 40, 50};
		// 	배열 객체를 생성, 초기 데이터 할당
		System.out.println(array05[0]);
		System.out.println(array05[1]);
		System.out.println(array05[2]);
		System.out.println(array05[3]);
		System.out.println(array05[4]);
		int [] array06;
		array06 = new int[] {10, 40, 20};
		// 선언 후, 초기데이터 할당시에는 반드시 new 데이터유형[]{} 선언하여야 한다.
		System.out.println(array06[0]);
		System.out.println(array06[1]);
		System.out.println(array06[2]);
		char [] array07 = {'A', 'C', 'E'};
		double[] array08 = {30.5, 40.2, 50.7};
		String[] array09 = {"사과", "바나나", "딸기"};
		for(int idx = 0; idx<array07.length;idx++) {
			System.out.println(array07[idx] + ":" + array08[idx] + ":" + array09[idx]);
		}

		// ex1) 정수형으로 5개 초기값 0으로 배열을 선언하고 2번째와 4번째 데이터를 할당하고 전체데이터를 출력하세요
		int[] arr_int = new int[5];
		arr_int[1] = 2; arr_int[3] = 4;
		for(int i = 0; i < 5; i++) {
			System.out.println(arr_int[i]);
		}
		// ex2) 몸무게(실수) 배열 3개를 선언과 동시에 할당하고 출력하세요.
		double[] weight = {75.5, 49.7, 119.9};
		for(int i = 0; i < 3; i++) {
			System.out.println(weight[i]);
		}
	}

}

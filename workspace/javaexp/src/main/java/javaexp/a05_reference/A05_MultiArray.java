package javaexp.a05_reference;

public class A05_MultiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 다차원 배열
		1. 2차원 배열 이상의 배열
		2. 자바는 1차원 배열을 이용하여 2차원 이상의 배열을 구현할 수 있다.
			int[][] 배열명 = new int[크기1][크기2];
		 */
		int[][] multiArray = new int[3][2];
		System.out.println("상위 차원의 크기 : " + multiArray.length);
		System.out.println("하위 차원의 크기 : " + multiArray[0].length);
		multiArray[0][0] = 25;
		multiArray[0][1] = 55;
		multiArray[1][0] = 35;
		multiArray[1][1] = 45;
		multiArray[2][0] = 65;
		multiArray[2][1] = 75;
		for(int idx = 0; idx<multiArray.length; idx++) {
			for(int jdx = 0; jdx<multiArray[idx].length;jdx++) {
				System.out.println("행열[" + idx + "][" + jdx + "]:" + multiArray[idx][jdx]);
			}
		}

		// ex) 2차원 배열로 번호별로 국어/영어/수학점수를 할당했을 때 3명의 국어/영어/수학 출력하세요.
		int[][] score_arr= { { 77, 89, 65 },
							 { 97, 74, 99 },
							 { 43, 23, 55 } };
		for(int i = 0; i<score_arr.length; i++) {
			System.out.print(i+1 + "번째 학생의 성적(국어, 영어, 수학) = ");
			for(int j = 0; j<score_arr[i].length; j++) {
				System.out.print(score_arr[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}

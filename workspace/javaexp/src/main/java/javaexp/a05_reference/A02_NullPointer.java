package javaexp.a05_reference;

public class A02_NullPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# null
		1. 변수가 참조하는 객체가 없는 경우 초기값으로 사용가능
			(stack)	[			]
					[	heap	]
					[			]
			heap 영역에는 할당하지 않고 stack영역에서 선언만 한 상태에서 객체를 초기화 시키는 것을 말한다.
			Person p = null;
			cf) 기본데이터 유형을 일반적으로 해당 유형에 맞게 초기화 시킨다.
				int num01 = 0; double num02 = 0.0;
		2. 참조 타입의 변수에만 저장가능하다.
		3. null로 초기화된 참조 변수는 스택 영역 생성
		4. 객체가 heap영역에 생성되지 않는 가운데서 해당 구성요소를 메모리상 호출
		 */

		Friend f = null;
		Friend f1 = new Friend();
		System.out.println(f1);
		System.out.println(f1.name);
		System.out.println(f);
		System.out.println(f.name);
	}

}

class Friend{
	String name = "친구1";
}

package javaexp.z01_homework;

import java.util.ArrayList;

public class A0509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2022-05-09
		// [1단계:개념] 1. 하나의 클래스를 통해 여러개의 객체을 생성하는 기본 예제를 작성하고 설명하세요.
			Homework0509 hw01 = new Homework0509();
			Homework0509 hw02 = new Homework0509();
			Homework0509 hw03 = new Homework0509();
			hw01.sout();
			hw02.sout();
			hw03.sout();
			System.out.println();
			// 각각 다른 객체이지만 하나의 클래스를 통해 만들어졌기에 동일한 결과가 나온다.

		// [1단계:개념] 2. 배열과 반복문 처리의 형식 2개(일반 for문, forEach 문)를 예제를 통하여 기술하세요
			Homework0509 []arr1 = new Homework0509[3];
			arr1[0] = new Homework0509();
			arr1[1] = new Homework0509();
			arr1[2] = new Homework0509();
			for(int i = 0; i<3; i++) {
				arr1[i].sout();
			}
			System.out.println();
			for(Homework0509 hw04:arr1) {
				hw04.sout();
			}
		
			
		// [1단계:확인] 3. 삼각형 3개 배열을 생성하되, 삼각형의 밑면과 높이 색상을 필드로 선언하고, 생성자를 통해를 이를 할당하고
		// 	출력메서드를 통해서 해당 정보를 출력하되, 면적을 리턴하는 메서드를 선언하세요.
			Triangle []arr2 = new Triangle[3];
			arr2[0] = new Triangle(3, 3, "Red");
			arr2[1] = new Triangle(7, 5, "Blue");
			arr2[2] = new Triangle(4, 5, "Green");
			for(Triangle tri1:arr2) {
				System.out.println("넓이 : " + tri1.area());
			}
			System.out.println();

		// [1단계:개념] 4. 일반 배열과 동적배열(ArrayList)의 차이점을 예제를 통해서 기술하세요.
			ArrayList<Triangle> tlist = new ArrayList<Triangle>();
			tlist.add(new Triangle(3, 4, "Black"));
			tlist.add(new Triangle(4, 5, "Yellow"));
			tlist.add(new Triangle(5, 6, "Purple"));
			for(Triangle tri2:tlist) {
				System.out.println("넓이 : " + tri2.area());
			}
			// 동적배열은 배열의 크기를 필요한 만큼 늘릴 수 있다.
			System.out.println();

		// [1단계:개념] 5. 동적배열 ArrayList의 활용 방법과 주요 기능 메서드를 기본 예제를 통하여 기술하세요.
			// 참조값.add(new 생성자()); // 객체를 생성함과 동시에 하나의 객체에 할당
			// 참조감.get(0); // index번호를 통해 특정한 위치에 있는 객체를 가지고 온다.
			// 참조값.size(); // 동적배열의 크기를 가져온다.
			// 참조값.remove(index번호); // 특정한 위치에 있는 객체를 삭제
			tlist.remove(2);
			for(int idx=0; idx<tlist.size(); idx++) {
				tlist.get(idx).area();
			}
			System.out.println();

		// [2단계:확인] 6. ArrayList<Product>를 활용하여 구매할 물건 정보 3개를 추가하여 출력처리하세요.
		// 	int tot()메서드로 내용 출력과 물건가격*물건단가를 리턴하게 하여, 물건 3개의 총비용을 누적 처리되게 하세요.
		ArrayList<Product> plist = new ArrayList<Product>();
		plist.add(new Product("휴대폰", 10000, 50));
		plist.add(new Product("연필", 30000, 10));
		plist.add(new Product("빵", 200000, 3));
		int sum = 0;
		for(Product p : plist) {
			sum += p.tot();
		}
		System.out.println("누적비용 : " + sum);
			
		// [1단계:개념] 7. static 멤버와 instance 멤버의 차이점을 예제를 통해 기술하세요.
		Homework0509 hw05 = new Homework0509();
		System.out.println(hw05.num_i);
		hw05.setNum(500);
		System.out.println(hw05.num_i);

		System.out.println(Homework0509.num_s);
		Homework0509.num_s = 100;
		System.out.println(Homework0509.num_s);
		// 객체 내부에 존재하지 않고, 메소드 영역에 존재
		// 정적 멤버는 객체를 생성하지 않고 클래스로 바로 접근해 사용

	}

}
class Homework0509{
	static int num_s = 1000;
	int num_i = 5000;
	void Homework0504(){}
	void sout() {
		System.out.println("Homework class");
	}
	void setNum(int num_i){
		this.num_i = num_i;
	}
}
class Triangle{
	int under, height;
	String color;
	Triangle(int under, int height, String color) {
		this.under = under;
		this.height = height;
		this.color = color;
	}
	double area() {
		System.out.println(under + "\t" + height + "\t" + color);
		return under*height*0.5;
	}
}
class Product{
	String name;
	int price, cnt;

	Product(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	int tot() {
		System.out.println(name + "\t" + price + "\t" + cnt);
		return price*cnt;
	}
}
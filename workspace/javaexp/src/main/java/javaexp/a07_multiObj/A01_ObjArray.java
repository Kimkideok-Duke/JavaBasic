package javaexp.a07_multiObj;

public class A01_ObjArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 객체형 배열 처리
		1. 하나의 클래스에서 만들어진 객체는 여러개의 배열로 사용할 수 있다.
		2. 객체 배열..
			단위객체명[] 배열명 = new 단위객체명[갯수];
			단위객체명[] 배열명 = {new 객체명(), new 객체명()...};
			배열명[index번호]; 호출
			배열명[index번호] = new 객체명(); 할당		 
		*/
		Student []arr1 = new Student[3];
		arr1[0] = new Student(1, "홍길동"); arr1[0].setPoint(80);
		arr1[1] = new Student(2, "김길동"); arr1[1].setPoint(90);
		arr1[2] = new Student(3, "최길동"); arr1[2].setPoint(100);
		arr1[0].showInfo();
		arr1[1].showInfo();
		arr1[2].showInfo();
		// ex) Fruit 필드 : 과일종류, 가격
		// 			 생성자 : 필드값 초기
		//			 메서드 show() : 종류와 가격 출력.
		// 	배열로 3개를 선언 및 할당, show() 호출
		Fruit []arr3 = {new Fruit("오렌지", 1200), new Fruit("키위", 1500), new Fruit("수박", 15000)};
		// for each 구문을 통한 처리
		// for(단위객체:배열) : 배열에 있는 갯수만큼 반복해서 단위 객체에 할당.
		for(Fruit fru : arr3) {
			fru.show();
		}
		// ex2) Computer 클래스 선언 : cpu, ram, hdd 속성을 선언하고, 객체선언과 할당을 동시처리
		// 			생성자 : 필드 초기화
		// 			메서드 : comInfo()를 통해 속성 출력 처리
		Computer []arr4 = {new Computer("i9", 4, 512), new Computer("5600x", 32, 2048), 
							new Computer("5950x", 64, 4096)};
		for(Computer com : arr4) {
			com.comInfo();
		}
	}
	
}
class Student{
	int no;
	String name;
	int kor;
	Student(int no, String name) {
		this.no = no;
		this.name = name;
	}
	void setPoint(int kor) {
		this.kor = kor;
	}
	void showInfo() {
		System.out.println(no + "\t" + name + "\t" + kor);
	}
}
class Fruit{
	String kind;
	int price;
	Fruit(String kind, int price) {
		this.kind = kind;
		this.price = price;
	}
	void show() {
		System.out.println(kind + "\t" + price);
	}
}
class Computer{
	String cpu;
	int ram, hdd;
	Computer(String cpu, int ram, int hdd) {
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	void comInfo() {
		System.out.println(cpu + "\t" + ram + "\t" + hdd);
	}
}
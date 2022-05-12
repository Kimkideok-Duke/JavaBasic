package javaexp.a07_multiObj;

import java.util.ArrayList;

import javaexp.z03_vo.BTeam;
import javaexp.z03_vo.Bplayer;
import javaexp.z03_vo.Mart;
import javaexp.z03_vo.Product;

public class A10_OneVsMulti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		# 1:다관계 객체 처리
		1. 프로그래밍에서 1:다관계의 내용을 자주 발생하는 프로그래밍 형태이다.
		2. 하나의 클래스 안에 여러개의 다중의 선언된 클래스를 호출하여 선언하고 할당하는 경우를 말한다.
			1) 다른 종류의 여러가지 객체가 할당되는 경우
				ex) 컴퓨터안에 cpu, ram, hdd등 여러가지 다른 종류의 내용들이 할당하여 사용되는 경우
			2) 같은 종류의 여러가지 객체가 할당되는 경우
				ex) 마트안에 판매하는 여러개의 물품을 구매하는 경우
					배열이나 동적 배열 ArrayList을 통해 처리
		3. 위 내용은 하나씩 객체를 할당하는 메서드를 사용하는 경우와 한꺼번에 할당하는 경우가 있다.
			1) 마트에서 물건을 하나씩 담는 경우
				ex)
				class Mart{
					private ArrayList<Product> plist;
					public void buyOne(Product p){
						plist.add(p);
			2) 마트에서 세트로 물건을 바로 담는 경우
				class Mart{
					private ArrayList<product> plist;
					public void buyAll(ArrayList<Product> plist){
						this.plist = plist;
					}
		4. 담은 다중의 물건을 확인할 때, 반복문을 활용한다. 단 이때도 조건 처리로 해당 내용의 메모리를 확인하거나, 
			담은 갯수가 1이상인 경우로 처리하는 경우가 많다.
			public void calcuProd(){
				System.out.println(name+"마트에서 구매한 물건 계산");
				if(plist!=null && plist.size()>0){
					for(Product p:plist){
						p.showInfo();
		5. 구현 순서
			1) 다중으로 처리한 종속된 단위 객체를 위한 클래스 선언.
			2) 해당 다중 객체를 포함할 클래스 선언
				- 필드
				- 초기 생성자 설정
				- 다중의 데이터 처리할 입력 메서드 선언
				- 1:다관계로 출력하거나 리턴할 객체 선언
		 */
		Product p = new Product();
		System.out.println(p);
		Mart m = new Mart("행복");
		m.calcu();
		m.addCart(new Product("사과", 3000, 2));
		m.addCart(new Product("바나나", 4000, 3));
		m.addCart(new Product("딸기", 12000, 3));
		m.calcu();

		// ex)
		BTeam bt = new BTeam("두산베어스");
		bt.showTeamList();
		// 외부에서 등록할 멤버를 한번에 List형태로 만들어서 바로 할당 처리하는 경우
		ArrayList<Bplayer> blist = new ArrayList<Bplayer>();
		blist.add(new Bplayer(50, "김현수", "891225"));
		blist.add(new Bplayer(30, "이종욱", "800202"));
		blist.add(new Bplayer(60, "김동주", "700715"));
		bt.setBlist(blist);

		bt.addPlayer(new Bplayer(50, "김현수", "891225"));
		bt.addPlayer(new Bplayer(30, "이종욱", "800202"));
		bt.addPlayer(new Bplayer(60, "김동주", "700715"));
		bt.showTeamList();
	}

}

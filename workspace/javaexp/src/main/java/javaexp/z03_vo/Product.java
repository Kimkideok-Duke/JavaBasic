package javaexp.z03_vo;

public class Product {
    
	// 필드 선언
    private String name;
    private int price;
    private int cnt;
    // 생성자 선언
    // 매개변수가 없는 생성자 선언
    public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
    // 필드값을 초기화하는 생성자
	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
    public int show() {
        System.out.println(name+"\t");
        System.out.println(price+"\t");
        System.out.println(cnt+"\t");
        return price*cnt;
    }
    // product p = new Product();
    // System.out.println(p); // 패키지명.클래스명@16진수
    // System.out.println(p); // toString()선언을 아래와 같이 하면, toString()에서 선언한 내용이 출력된다.
    @Override
    public String toString() {
        return "Product [name = " + name + ", price = " + price + ", cnt = " + cnt + "]";
    }

    // 기능메서드 선언 : 할당 및 호출 메서드
    // 각 필드값을 쓰기 메서드와 읽기 메서드를 구분하여 처리
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
    
}

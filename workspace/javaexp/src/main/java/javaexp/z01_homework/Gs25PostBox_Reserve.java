package javaexp.z01_homework;

public class Gs25PostBox_Reserve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
class Reservation_ProdInfo {
	private String selProd;
	private int priceProd;
	private String properties;
	public Reservation_ProdInfo() {
	}

	public Reservation_ProdInfo(String selProd, int priceProd, String properties) {
		this.selProd = selProd;
		this.priceProd = priceProd;
		this.properties = properties;
	}
	public void showRV_PdInfo() {
		System.out.println("물품선택 : " + selProd);
		System.out.println("물품가액 : " + priceProd + "만원");
		System.out.println("등록정보 : " + properties);
		System.out.println();
	}
}
class Reservation_Sender {
	private String sname;
	private String sphoneNum;
	private String saddr;
	public Reservation_Sender() {
	}

	public Reservation_Sender(String sname, String sphoneNum, String saddr, String passwd) {
		this.sname = sname;
		this.sphoneNum = sphoneNum;
		this.saddr = saddr;
	}
	public void showRV_Sender() {
		System.out.println("이름 : " + sname);
		System.out.println("휴대폰 번호 : " + sphoneNum);
		System.out.println("주소 : " + saddr);
		System.out.println();
	}
}
class Reservation_Recipient {
	private String rname;
	private String rphoneNum;
	private String raddr;
	private String request;
	private String payment;
	public Reservation_Recipient() {
	}

	public Reservation_Recipient(String rname, String rphoneNum, String raddr, String request, String payment) {
		this.rname = rname;
		this.rphoneNum = rphoneNum;
		this.raddr = raddr;
		this.request = request;
		this.payment = payment;
	}
	public void showRV_Recipient() {
		System.out.println("이름 : " + rname);
		System.out.println("휴대폰 번호 : " + rphoneNum);
		System.out.println("주소 : " + raddr);
		System.out.println("배송요청사항 : " + request);
		System.out.println("지불방법 : " + payment);
	}
}

class Domestic_ProdInfo extends Reservation_ProdInfo {
	public Domestic_ProdInfo() {}
	public Domestic_ProdInfo(String selProd, int priceProd, String properties){
		super(selProd, priceProd, properties);
	}
	@Override
	public void showRV_PdInfo() {
		// TODO Auto-generated method stub
		System.out.println("============= 물품정보 ==============");
		super.showRV_PdInfo();
	}
	
}
class Domestic_Sender extends Reservation_Sender{
	public Domestic_Sender() {}
	public Domestic_Sender(String sname, String sphoneNum, String saddr, String passwd){
		super(sname, sphoneNum, saddr, passwd);
	}
	@Override
	public void showRV_Sender() {
		// TODO Auto-generated method stub
		System.out.println("============= 보내는 분 주소 ==============");
		super.showRV_Sender();
	}
}
class Domestic_Recipient extends Reservation_Recipient {
	public Domestic_Recipient() {}
	public Domestic_Recipient(String rname, String rphoneNum, String raddr, String request, String payment) {
		super(rname, rphoneNum, raddr, request, payment);
	}
	@Override
	public void showRV_Recipient() {
		// TODO Auto-generated method stub
		System.out.println("============= 받는 분 주소 ==============");
		super.showRV_Recipient();
	}
}

class Half_ProdInfo extends Reservation_ProdInfo {
	public Half_ProdInfo() {}
	public Half_ProdInfo(String selProd, int priceProd, String properties){
		super(selProd, priceProd, properties);
	}
	@Override
	public void showRV_PdInfo() {
		// TODO Auto-generated method stub
		System.out.println("============= 물품정보 ==============");
		super.showRV_PdInfo();
	}
}
class Half_Sender extends Reservation_Sender {
	public Half_Sender() {}
	public Half_Sender(String sname, String sphoneNum, String saddr, String passwd){
		super(sname, sphoneNum, saddr, passwd);
	}
	@Override
	public void showRV_Sender() {
		// TODO Auto-generated method stub
		System.out.println("============= 반송처 입력(보내는 분 주소) ==============");
		super.showRV_Sender();
	}
}
class Half_Recipient extends Reservation_Recipient {
	public Half_Recipient() {}
	public Half_Recipient(String rname, String rphoneNum, String raddr, String request, String payment) {
		super(rname, rphoneNum, raddr, request, payment);
	}
	@Override
	public void showRV_Recipient() {
		// TODO Auto-generated method stub
		System.out.println("============= 도착 편의점(받는 분이 찾아가실 편의점) ==============");
		super.showRV_Recipient();
	}
}

class International_ProdInfo extends Reservation_ProdInfo {
	public International_ProdInfo() {}
	public International_ProdInfo(String selProd, int priceProd, String properties){
		super(selProd, priceProd, properties);
	}
	@Override
	public void showRV_PdInfo() {
		// TODO Auto-generated method stub
		super.showRV_PdInfo();
	}
}
class International_Sender extends Reservation_Sender {
	public International_Sender() {}
	public International_Sender(String sname, String sphoneNum, String saddr, String passwd){
		super(sname, sphoneNum, saddr, passwd);
	}
	@Override
	public void showRV_Sender() {
		// TODO Auto-generated method stub
		super.showRV_Sender();
	}
}
class International_Recipient extends Reservation_Recipient {
	public International_Recipient() {}
	public International_Recipient(String rname, String rphoneNum, String raddr, String request, String payment) {
		super(rname, rphoneNum, raddr, request, payment);
	}
	@Override
	public void showRV_Recipient() {
		// TODO Auto-generated method stub
		super.showRV_Recipient();
	}
}
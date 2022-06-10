package javaexp.z01_homework;

import java.util.*;
public class Gs25PostBox_Reserve {

	public static void main(String[] args) {
		// 국내택배
		String type1 = "국내 택배 예약";
		ArrayList<Domestic_ProdInfo> dplist = new ArrayList<Domestic_ProdInfo>();
		ArrayList<Domestic_Sender> dslist = new ArrayList<Domestic_Sender>();
		ArrayList<Domestic_Recipient> drlist = new ArrayList<Domestic_Recipient>();

		// 반값택배
		String type2 = "반값 택배 예약";
		ArrayList<Half_ProdInfo> hplist = new ArrayList<Half_ProdInfo>();
		ArrayList<Half_Sender> hslist = new ArrayList<Half_Sender>();
		ArrayList<Half_Recipient> hrlist = new ArrayList<Half_Recipient>();

		// 국제택배
		String type3 = "국제 택배 예약";
		ArrayList<International_ProdInfo> iplist = new ArrayList<International_ProdInfo>();
		ArrayList<International_Sender> islist = new ArrayList<International_Sender>();
		ArrayList<International_Recipient> irlist = new ArrayList<International_Recipient>();
		ArrayList<Customs_Declaration> cdlist = new ArrayList<Customs_Declaration>();

		String type4 = "예약 조회";
		String []typelist = {type1, type2, type3, type4};

		Reservation_ProdInfo rp = new Reservation_ProdInfo();
		Reservation_Recipient rr = new Reservation_Recipient();

		International_ProdInfo ip = new International_ProdInfo();

		Scanner sc = new Scanner(System.in);
		String choice_s;
		int choice;

		while(true) {
			System.out.println("=============== 택배예약 ================");
			for(int i = 0; i < typelist.length; i++) {
				System.out.println(i+1 + ":" + typelist[i]);
			}
			System.out.println("원하는 작업을 선택하세요.(0번은 종료)");
			String num = sc.nextLine();
			int num_int = Integer.parseInt(num);
			System.out.println();
			if(num_int == 0) break;
			else if(num_int > 0 && num_int<=typelist.length) {
				System.out.println(typelist[num_int-1]);
				switch(num_int) {
					case 1:
						System.out.println("=========== 국내택배 ==========");
						System.out.println("=========== 국내택배 유의사항 ==========");
						System.out.println("예약 전 유의사항");
						System.out.println("~~~~~~~~~~~");
						System.out.println("1.이전\t2.인지하였습니다.");
						System.out.print("선택 : ");
						choice_s = sc.nextLine();
						choice = Integer.parseInt(choice_s);
						if(choice == 1) break;
						else if(choice == 2) {
							System.out.println("=========== 국내택배 ==========");
							System.out.println("=========== 물품정보 ==========");
							System.out.print("물품선택(");
							for(int i = 0; i<rp.prodlist.length;i++){
								if(i!=0) System.out.print(", ");
								System.out.print(i+1 + "." + rp.prodlist[i]);
								if(i==rp.prodlist.length-1) System.out.println(")");
							}
							System.out.print("선택 : ");
							String pchoice_s = sc.nextLine();
							int pchoice = Integer.parseInt(pchoice_s)-1;
							System.out.print("물품가액(만원) : ");
							String prodprice = sc.nextLine();
							int priceProd = Integer.parseInt(prodprice);
							System.out.print("등록정보( 예)친구선물 ) : ");
							String properties = sc.nextLine();

							System.out.println("=========== 보내는분 ==========");
							System.out.print("이름 : ");
							String sname = sc.nextLine();
							System.out.print("연락처 : ");
							String sphoneNum = sc.nextLine();
							System.out.print("주소 : ");
							String saddr = sc.nextLine();

							System.out.println("=========== 받는분 ==========");
							System.out.print("이름 : ");
							String rname = sc.nextLine();
							System.out.print("연락처 : ");
							String rphoneNum = sc.nextLine();
							System.out.print("주소 : ");
							String raddr = sc.nextLine();
							System.out.print("배송요청사항 : ");
							String request = sc.nextLine();
							System.out.print("지불방법(");
							for(int i = 0; i<rr.paymentlist.length;i++){
								if(i!=0) System.out.print(", ");
								System.out.print(i+1 + "." + rr.paymentlist[i]);
								if(i==rr.paymentlist.length-1) System.out.println(")");
							}
							System.out.print("선택 : ");
							String payment_s = sc.nextLine();
							int payment = Integer.parseInt(payment_s)-1;

							System.out.println("1.이전\t2.예약하기.");
							System.out.print("선택 : ");
							String choice_s2 = sc.nextLine();
							int choice2 = Integer.parseInt(choice_s2);
							if(choice2 == 1) break;
							else if(choice2 == 2) {
								dplist.add(new Domestic_ProdInfo(rp.prodlist[pchoice], priceProd, properties));
								dslist.add(new Domestic_Sender(sname, sphoneNum, saddr));
								drlist.add(new Domestic_Recipient(rname, rphoneNum, raddr, request, rr.paymentlist[payment]));
								System.out.println("예약이 완료되었습니다.");
							}
						}
						break;
					case 2:
						System.out.println("=========== 반값택배 ==========");
						System.out.println("=========== 반값택배 유의사항 ==========");
						System.out.println("예약 전 유의사항");
						System.out.println("~~~~~~~~~~~");
						System.out.println("1.이전\t2.인지하였습니다.");
						System.out.print("선택 : ");
						choice_s = sc.nextLine();
						choice = Integer.parseInt(choice_s);
						if(choice == 1) break;
						else if(choice == 2) {
							System.out.println("=========== 반값택배 ==========");
							System.out.println("=========== 물품정보 ==========");
							System.out.print("물품선택(");
							for(int i = 0; i<rp.prodlist.length;i++){
								if(i!=0) System.out.print(", ");
								System.out.print(i+1 + "." + rp.prodlist[i]);
								if(i==rp.prodlist.length-1) System.out.println(")");
							}
							System.out.print("선택 : ");
							String pchoice_s = sc.nextLine();
							int pchoice = Integer.parseInt(pchoice_s)-1;
							System.out.print("물품가액(만원) : ");
							String prodprice = sc.nextLine();
							int priceProd = Integer.parseInt(prodprice);
							System.out.print("등록정보( 예)친구선물 ) : ");
							String properties = sc.nextLine();

							System.out.println("=========== 반송처 입력 (보내는 분 주소) ==========");
							System.out.print("이름 : ");
							String sname = sc.nextLine();
							System.out.print("연락처 : ");
							String sphoneNum = sc.nextLine();
							System.out.print("주소 : ");
							String saddr = sc.nextLine();

							System.out.println("=========== 도착 편의점(받는 분이 찾아가실 편의점) ==========");
							System.out.print("이름 : ");
							String rname = sc.nextLine();
							System.out.print("연락처 : ");
							String rphoneNum = sc.nextLine();
							System.out.print("도착 편의점 : ");
							String raddr = sc.nextLine();
							System.out.print("배송요청사항 : ");
							String request = sc.nextLine();
							System.out.print("지불방법(");
							for(int i = 0; i<rr.paymentlist.length;i++){
								if(i!=0) System.out.print(", ");
								System.out.print(i+1 + "." + rr.paymentlist[i]);
								if(i==rr.paymentlist.length-1) System.out.println(")");
							}
							System.out.print("선택 : ");
							String payment_s = sc.nextLine();
							int payment = Integer.parseInt(payment_s)-1;

							System.out.println("1.이전\t2.예약하기.");
							System.out.print("선택 : ");
							String choice_s2 = sc.nextLine();
							int choice2 = Integer.parseInt(choice_s2);
							if(choice2 == 1) break;
							else if(choice2 == 2) {
								hplist.add(new Half_ProdInfo(rp.prodlist[pchoice], priceProd, properties));
								hslist.add(new Half_Sender(sname, sphoneNum, saddr));
								hrlist.add(new Half_Recipient(rname, rphoneNum, raddr, request, rr.paymentlist[payment]));
								System.out.println("예약이 완료되었습니다.");
							}
						}
						break;
					case 3:
						System.out.println("=========== 국제택배 ==========");
						System.out.println("=========== 국제택배 유의사항 ==========");
						System.out.println("예약 전 유의사항");
						System.out.println("~~~~~~~~~~~");
						System.out.println("1.이전\t2.인지하였습니다.");
						System.out.print("선택 : ");
						choice_s = sc.nextLine();
						choice = Integer.parseInt(choice_s);
						if(choice == 1) break;
						else if(choice == 2) {
							System.out.println("=========== 국제택배 ==========");
							System.out.println("=========== 물품정보 ==========");
							System.out.print("등록정보( 예)친구선물 ) : ");
							String properties = sc.nextLine();
							System.out.print("구분(");
							for(int i = 0; i<ip.divisionlist.length;i++){
								if(i!=0) System.out.print(", ");
								System.out.print(i+1 + ". " + ip.divisionlist[i]);
								if(i==ip.divisionlist.length-1) System.out.println(")");
							}
							System.out.print("선택 : ");
							String dchoice_s = sc.nextLine();
							int dchoice = Integer.parseInt(dchoice_s)-1;
							System.out.print("특송사 선택(");
							for(int i = 0; i<ip.selCourierlist.length;i++){
								if(i!=0) System.out.print(", ");
								System.out.print(i+1 + ". " + ip.selCourierlist[i]);
								if(i==ip.selCourierlist.length-1) System.out.println(")");
							}
							System.out.print("선택 : ");
							String cchoice_s = sc.nextLine();
							int cchoice = Integer.parseInt(cchoice_s)-1;
							

							System.out.println("=========== 보내는 분 ==========");
							System.out.print("이름 : ");
							String sname = sc.nextLine();
							System.out.print("연락처 : ");
							String sphoneNum = sc.nextLine();
							System.out.print("주소 : ");
							String saddr = sc.nextLine();

							System.out.println("=========== 받는 분 ==========");
							System.out.print("이름 : ");
							String rname = sc.nextLine();
							System.out.print("연락처 : ");
							String phoneNum = sc.nextLine();
							System.out.print("국가 : ");
							String country = sc.nextLine();
							System.out.print("ZIP CODE : ");
							String zipcode = sc.nextLine();
							System.out.print("ADDRESS1 : ");
							String address1 = sc.nextLine();
							System.out.print("ADDRESS2 : ");
							String address2 = sc.nextLine();

							System.out.println("=========== 세관신고 ==========");
							System.out.print("내용품명 : ");
							String prodname = sc.nextLine();
							System.out.print("내품총수량 : ");
							String prodQuantity_s = sc.nextLine();
							int prodQuantity = Integer.parseInt(prodQuantity_s);
							System.out.print("HS CODE : ");
							String hscode = sc.nextLine();
							System.out.print("생산지 : ");
							String prodPlace = sc.nextLine();
							System.out.print("물품가액 : ");
							String price_s = sc.nextLine();
							int price = Integer.parseInt(price_s);

							System.out.println("1.이전\t2.예약하기.");
							System.out.print("선택 : ");
							String choice_s2 = sc.nextLine();
							int choice2 = Integer.parseInt(choice_s2);
							if(choice2 == 1) break;
							else if(choice2 == 2) {
								iplist.add(new International_ProdInfo(properties, ip.divisionlist[dchoice], ip.selCourierlist[cchoice]));
								islist.add(new International_Sender(sname, sphoneNum, saddr));
								irlist.add(new International_Recipient(rname, phoneNum, country, zipcode, address1, address2));
								cdlist.add(new Customs_Declaration(ip.divisionlist[dchoice], prodname, prodQuantity, hscode, prodPlace, price));
								System.out.println("예약이 완료되었습니다.");
							}
						}
						break;
					case 4:
						System.out.println("=========== 예약조회 ==========");
						System.out.println("=========== 국내택배 ==========");
						for(int i = 0; i<dplist.size();i++){
							dplist.get(i).showRV_PdInfo();
							dslist.get(i).showRV_Sender();
							drlist.get(i).showRV_Recipient();
						}
						System.out.println("=========== 반값택배 ==========");
						for(int i = 0; i<hplist.size();i++){
							hplist.get(i).showRV_PdInfo();
							hslist.get(i).showRV_Sender();
							hrlist.get(i).showRV_Recipient();
						}
						System.out.println("=========== 국제택배 ==========");
						for(int i = 0; i<iplist.size();i++){
							iplist.get(i).showRV_ProdInfo();
							islist.get(i).showRV_Sender();
							irlist.get(i).showRV_Recipient();
							cdlist.get(i).showCusDec();
						}
						
						
				}
			}
		}
	}

}
class Reservation_ProdInfo {
	public String []prodlist = {"의류", "서신/서류", "가전제품류", "과일류", "곡물류", "한약류", "식품류", "한약류", "식품류", "잡화/서적"};
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

	public Reservation_Sender(String sname, String sphoneNum, String saddr) {
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
	public String []paymentlist = {"선불", "착불"};
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
	public Domestic_Sender(String sname, String sphoneNum, String saddr){
		super(sname, sphoneNum, saddr);
	}
	@Override
	public void showRV_Sender() {
		// TODO Auto-generated method stub
		System.out.println("============= 보내는 분 ==============");
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
		System.out.println("============= 받는 분 ==============");
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
	public Half_Sender(String sname, String sphoneNum, String saddr){
		super(sname, sphoneNum, saddr);
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

class International_ProdInfo {
	private String properties;
	private String division;
	public String []divisionlist = {"비서류", "서류"};
	private String selCourier;
	public String []selCourierlist = {"SF EXPRESS", "EMS", "DHL"};

	public International_ProdInfo() {
	}

	public International_ProdInfo(String properties, String division, String selCourier) {
		this.properties = properties;
		this.division = division;
		this.selCourier = selCourier;
	}

	public void showRV_ProdInfo() {
		System.out.println("============= 물품정보 ==============");
		System.out.println("등록정보 : " + properties);
		System.out.println("구분 : " + division);
		System.out.println("특송사선택 : " + selCourier);
		System.out.println();
	}
}
class International_Sender extends Reservation_Sender {
	public International_Sender() {}
	public International_Sender(String sname, String sphoneNum, String saddr){
		super(sname, sphoneNum, saddr);
	}
	@Override
	public void showRV_Sender() {
		// TODO Auto-generated method stub
		System.out.println("============= 보내는 분 ==============");
		super.showRV_Sender();
	}
}
class International_Recipient {
	private String rname;
	private String phoneNum;
	private String country;
	private String zipcode;
	private String address1;
	private String address2;
	public International_Recipient() {}

	public International_Recipient(String rname, String phoneNum, String country, String zipcode, String address1, String address2) {
		this.rname = rname;
		this.phoneNum = phoneNum;
		this.country = country;
		this.zipcode = zipcode;
		this.address1 = address1;
		this.address2 = address2;
	}

	public void showRV_Recipient() {
		System.out.println("============= 받는 분 주소 ==============");
		System.out.println("이름 : " + rname);
		System.out.println("연락처 : " + phoneNum);
		System.out.println("국가 : " + country);
		System.out.println("ZIP CODE : " + zipcode);
		System.out.println("ADDRESS1 : " + address1);
		System.out.println("ADDRESS2 : " + address2);
		System.out.println();
	}
}
class Customs_Declaration {
	private String division;
	private String prodname;
	private int prodQuantity;
	private String hscode;
	private String prodPlace;
	private int price;

	public Customs_Declaration() {
	}

	public Customs_Declaration(String division, String prodname, int prodQuantity, String hscode, String prodPlace, int price) {
		this.division = division;
		this.prodname = prodname;
		this.prodQuantity = prodQuantity;
		this.hscode = hscode;
		this.prodPlace = prodPlace;
		this.price = price;
	}

	public void showCusDec() {
		System.out.println("============= 세관신고 ==============");
		System.out.println("구분 : " + division);
		System.out.println("내용품명 : " + prodname);
		System.out.println("내품총수량 : " + prodQuantity);
		System.out.println("HS CODE : " + hscode);
		System.out.println("생산지 : " + prodPlace);
		System.out.println("물품가액 : " + price + "US$");
	}
}
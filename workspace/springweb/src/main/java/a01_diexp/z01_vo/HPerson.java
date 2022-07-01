package a01_diexp.z01_vo;

public class HPerson {
	private String name;
	private HandPhone handphone;
	public HPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HPerson(String name) {
		super();
		this.name = name;
	}
	public void myHandphone() {
		System.out.println("이름:"+name);
		if(handphone!=null){
			System.out.println("##소유 핸드폰##");
			System.out.println(handphone.getHnumber());
			System.out.println(handphone.getCompany());
		}else{
			System.out.println("핸드폰 없음");
		}
	}
	
	public HPerson(String name, HandPhone handphone) {
		super();
		this.name = name;
		this.handphone = handphone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HandPhone getHandphone() {
		return handphone;
	}
	public void setHandphone(HandPhone handphone) {
		this.handphone = handphone;
	}
	
	
}

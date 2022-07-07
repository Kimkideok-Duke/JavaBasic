package a01_diexp.z05_vo;

public class Mart {
	private String mname;
	private Product pd;

	public Mart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mart(String mname, Product pd) {
		super();
		this.mname = mname;
		this.pd = pd;
	}

	public Mart(String mname) {
		super();
		this.mname = mname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Product getPd() {
		return pd;
	}

	public void setPd03(Product pd) {
		this.pd = pd;
	}
	public void shoppingInfo(){
		System.out.println(mname+"에서 구매한 물건:"+pd.getPname()+", 가격:"+pd.getPrice()+", 갯수:"+pd.getCnt());
	}
}

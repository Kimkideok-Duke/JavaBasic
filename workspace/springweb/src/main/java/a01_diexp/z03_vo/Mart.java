package a01_diexp.z03_vo;

import org.springframework.stereotype.Component;

@Component("mart01")
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

	public void setPd(Product pd) {
		this.pd = pd;
	}
	public void shoppingInfo(){
		if(pd != null)
			System.out.println(mname+"에서 구매한 물건:"+pd.getPname()+", 가격:"+pd.getPrice()+", 갯수:"+pd.getCnt());
	}
}

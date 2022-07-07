package a01_diexp.z04_vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mart01")
public class Mart {
	private String mname;
	// source상에 객체가 할당될 수 있게 선언
	// container에 해당 객체가 로딩되어 있을 때, 자동으로
	@Autowired
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

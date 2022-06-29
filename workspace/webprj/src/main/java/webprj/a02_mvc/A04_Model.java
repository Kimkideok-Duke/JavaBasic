package webprj.a02_mvc;

public class A04_Model {
	public String getProduct(String pname, String price, String cnt) {
		return "물건명:"+pname+", 가격:" + price+",갯수:"+cnt;
	}
}

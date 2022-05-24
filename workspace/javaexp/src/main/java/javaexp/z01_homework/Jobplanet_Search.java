package javaexp.z01_homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Jobplanet_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String NUM1 = "SEARCH COMPANY";
		String NUM2 = "CURRENT SEARCH";
		String []NUM_STR = {NUM1,NUM2};
		List<Memory> mlist = new ArrayList<Memory>();
		while(true) {
			System.out.println("ENTER NUMBER(0:END PROCESS)");
			System.out.println("1:"+NUM1);
			System.out.println("2."+NUM2);
			Scanner sc = new Scanner(System.in);
			String num = sc.nextLine();
			int num_int = Integer.parseInt(num);
			if(num_int == 0) break;
			else if(num_int > 0 && num_int<3) {
				System.out.println(NUM_STR[num_int-1]);
				switch(num_int) {
					case 1:
						System.out.println("존버하고 이직한다를 검색해보세요");
						String comp_name = sc.nextLine();
						mlist.add(new Memory(comp_name));
						break;
					case 2:
						for(Memory m:mlist) {
							m.showList();
						}
						break;
				}
			} else System.out.println("1부터 2까지의 숫자를 입력하세요.");

		}
	}

}
class Memory {
	private String comp_name;
	public Memory() {
		super();
	}
	public Memory(String comp_name) {
		this.comp_name = comp_name;
	}
	public void showList() {
		System.out.println(comp_name);
	}
}
class Comp_Info {
	private String name;
	private String Homepage;
	private int sal_avg;
	private double score;
	private void kakaoInfo() {
		name = "(주)카카오";
		Homepage = "www.kakaocorp.com";
		sal_avg = 5850;
		score = 3.8;
	}
	public void compInfo() {
		name = "(주)카카오";
		Homepage = "www.kakaocorp.com";
		sal_avg = 5850;
		score = 3.8;
	}
	Map<String, String> info = new HashMap<String, String>();
	info.put("kakao","kakaoInfo");
}
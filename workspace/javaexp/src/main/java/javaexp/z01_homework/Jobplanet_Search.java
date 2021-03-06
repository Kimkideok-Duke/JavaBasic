package javaexp.z01_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Jobplanet_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Company2 c = new Company2();

		Map<String,Company2> clist = new HashMap<String, Company2>();		// Map에 저장된 기업 배치
		clist.put("NA", new NA());
		clist.put("카카오", new Kakao());
		clist.put("네이버", new Naver());
		clist.put("쿠팡", new Coupang());
		clist.put("우아한형제들", new Woowahan());
		clist.put("라인", new Lineplus());

		String NUM1 = "기업검색";
		String NUM2 = "최근 검색어";
		String NUM3 = "실시간 급상승 검색기업";
		String NUM4 = "내 관심기업";
		String NUM5 = "잡플래닛 추천 검색어";
		String []NUM_STR = {NUM1,NUM2,NUM3,NUM4,NUM5};

		List<Memory> mlist = new ArrayList<Memory>();
		List<Memory> flist = new ArrayList<Memory>();

		while(true) {
			System.out.println("ENTER NUMBER(1~4)");
			System.out.println("(0:END PROCESS)");
			for(int i = 0; i < NUM_STR.length; i++) {
				System.out.println(i+1 + ":" + NUM_STR[i]);
			}
			Scanner sc = new Scanner(System.in);
			String num = sc.nextLine();
			int num_int = Integer.parseInt(num);
			if(num_int == 0) break;
			else if(num_int > 0 && num_int<=NUM_STR.length) {
				System.out.println(NUM_STR[num_int-1]);
				switch(num_int) {
					case 1:		// 기업검색 파트
						System.out.println("존버하고 이직한다를 검색해보세요");
						String comp_name = c.checkName(sc.nextLine());
						clist.get(comp_name).showInfo(); // 기업 정보 열람
						if(comp_name.equals("NA") == false) {
							if(mlist.contains(comp_name) == false)
								mlist.add(new Memory(comp_name)); // 최근 검색어 저장
							if(flist.contains(comp_name) == false) {	
								System.out.println("관심기업으로 추가하겠습니까? (y/n)");
								String fchoice = sc.nextLine();
								if(fchoice.equals("y")==true) {
									System.out.println(comp_name + "이(가) 관심기업으로 추가되었습니다.");
									flist.add(new Memory(comp_name));
								}
							}/*else if(flist.contains(comp_name) == true) {
								System.out.println("관심기업입니다. 관심기업에서 제거하시겠습니까?(y/n)");
								String fchoice = sc.nextLine();
								if(fchoice.equals("y")==true) {
									System.out.println(comp_name + "이 관심기업에서 제거되었습니다.");
									for(int i = 0; i < flist.size(); i++) {
										if(flist.get(i).equals(comp_name) == true) flist.remove(i);
									}
								}
							}*/
						}
						break;
					case 2:		// 최근 검색어 파트
						if(mlist.isEmpty() == false) {
							for(Memory m:mlist) {
								m.showList();
							}
							System.out.println("삭제하시겠습니까?(y/n)");
							String dchoice = sc.nextLine();
							if(dchoice.equals("y")==true) {
								System.out.println("삭제를 원하는 위치의 순번을 입력하세요");
								dchoice = sc.nextLine();
								if(Integer.parseInt(dchoice) <= mlist.size() && Integer.parseInt(dchoice) > 0)
									mlist.remove(Integer.parseInt(dchoice)-1);
							}
						}else {
							System.out.println("최근 검색어 내역이 없습니다.");
							System.out.println("궁금한 기업을 검색해 보세요.");
						}
						break;
					case 3:		// 실시간 급상승 검색기업 파트
						c.ranking();
						break;
					case 4:		// 내 관심기업 파트
						if(flist.isEmpty() == false) {
							for(Memory f:flist) {
								f.showList();
							}
							System.out.println("삭제하시겠습니까?(y/n)");
							String fchoice = sc.nextLine();
							if(fchoice.equals("y")==true) {
								System.out.println("삭제를 원하는 위치의 순번을 입력하세요");
								fchoice = sc.nextLine();
								if(Integer.parseInt(fchoice) <= flist.size() && Integer.parseInt(fchoice) > 0)
									flist.remove(Integer.parseInt(fchoice)-1);
							}
						}else {
							System.out.println("팔로우한 관심기업이 없습니다.");
							System.out.println("팔로우하고 관심 기업의 새소식을 가장 먼저 확인하세요.");
						}
						break;
					case 5:		// 추천검색어 파트
						System.out.print("#신의직장'몰두센'");
						System.out.print("\t");
						System.out.print("#적극 채용중인 회사");
						System.out.print("\t");
						System.out.print("#주4.5일근무");
						System.out.print("\t");
						System.out.print("#재택근무하는회사");
						System.out.print("\t");
						System.out.print("#중소기업연봉Top3");
						System.out.print("\t");
						System.out.print("#IT중소연봉TOP");
						System.out.println();
						break;
				}
			}else {
				System.out.println("WRONG NUMBER");
			}
		}
	}

}
class Memory {						// 최근 검색어를 저장하는 클래스
	private String comp_name;
	public Memory() {
		super();
	}
	public Memory(String comp_name) {
		this.comp_name = comp_name;
	}
	public void showList() {		// 저장된 기업명을 보여주는 함수
		System.out.println(comp_name);
	}
	@Override
	public String toString() {		// 회사명 반환 함수
		// TODO Auto-generated method stub
		return comp_name;
	}
}
class Company2 {					// 기업의 정보를 저장하는 클래스
	private String name;
	private String Homepage;
	private int sal_avg;
	private double score;

	public Company2() {}	
	public Company2(String name, String Homepage, int sal_avg, double score) {
		this.name = name;			// 기업명
		this.Homepage = Homepage;	// 기업 홈페이지
		this.sal_avg = sal_avg;		// 평균연봉
		this.score = score;			// 기업평점
	}
	public void showInfo() {		// 기업의 정보를 보여주는 함수
		System.out.println("회사명 : " + name);
		System.out.println("홈페이지 : " + Homepage);
		System.out.println("평균 연봉 : " + sal_avg);
		System.out.println("평점 : " + score);
	}
	public String checkName(String cname) {		// 입력받은 기업명을 map의 key에 맞는 문자열로 반환
		if(cname.equals("카카오") == true 
			|| cname.equals("KAKAO") == true 
			|| cname.equals("kakao") == true) { Kakao.cnt--; return "카카오"; }
		else if(cname.equals("네이버") == true 
			|| cname.equals("NAVER") == true 
			|| cname.equals("naver") == true) { Naver.cnt--; return "네이버"; }
		else if(cname.equals("쿠팡") == true 
			|| cname.equals("COUPANG") == true 
			|| cname.equals("coupang") == true) { Coupang.cnt--; return "쿠팡";}
		else if(cname.equals("우아한형제들") == true 
			|| cname.equals("WOOWAHAN") == true 
			|| cname.equals("woowahan") == true) { Woowahan.cnt--; return "우아한형제들"; }
		else if(cname.equals("라인") == true 
			|| cname.equals("LINE") == true 
			|| cname.equals("line") == true) { Lineplus.cnt--; return "라인"; }
		else return "NA";
	}
	public void ranking() {
		int num[] = {Kakao.cnt, Naver.cnt, Coupang.cnt, Woowahan.cnt, Lineplus.cnt};
		Arrays.sort(num);
		Map<Integer, String> ranking = new HashMap<Integer, String>();
		ranking.put(Kakao.cnt, "카카오");
		ranking.put(Naver.cnt, "네이버");
		ranking.put(Coupang.cnt, "쿠팡");
		ranking.put(Woowahan.cnt, "우아한 형제들");
		ranking.put(Lineplus.cnt, "라인");
		for(int i = 0; i < num.length; i++) {
			if(num[i] != 0) System.out.println((i+1) +"."+ranking.get(num[i]));
		}
	}
}
class NA extends Company2 {				// 검색되지 않는 기업
	public NA() {}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("검색결과가 없습니다.");
	}
}
class Kakao extends Company2 {			// 카카오에 대한 기업정보
	static int cnt;
	public Kakao() {
		super("(주)카카오", " https://www.kakaocorp.com/", 5850, 3.8);
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
	}
}
class Naver extends Company2 {			// 네이버에 대한 기업정보
	static int cnt;
	public Naver() {
		super("네이버(주)", "https://www.navercorp.com/", 6351, 3.9);
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
	}
}
class Coupang extends Company2 {		// 쿠팡에 대한 기업정보
	static int cnt;
	public Coupang() {
		super("쿠팡(주)", "http://www.coupang.com/", 5226, 3.1);
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
	}
}
class Woowahan extends Company2 {		// 우아한 형제들에 대한 기업정보
	static int cnt;
	public Woowahan() {
		super("(주)우아한형제들", "http://www.woowahan.com/", 5174, 3.6);
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
	}
}
class Lineplus extends Company2 {		// 라인플러스에 대한 기업정보
	static int cnt;
	public Lineplus() {
		super("라인플러스(주)", "http://linepluscorp.com/", 6083, 3.7);
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
	}
}

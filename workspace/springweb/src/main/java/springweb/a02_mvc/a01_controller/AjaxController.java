package springweb.a02_mvc.a01_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a02_mvc.a04_vo.Calcu;
import springweb.a02_mvc.a04_vo.Member011;
import springweb.a02_mvc.a04_vo.Music;
import springweb.a02_mvc.a04_vo.Person;
import springweb.a02_mvc.a04_vo.Person01;
import springweb.a02_mvc.a04_vo.Product;
import springweb.a02_mvc.a04_vo.ScPlayer;

@Controller
public class AjaxController {
	
	// http://localhost:5080/springweb/ajax01.do
	@RequestMapping("ajax01.do")
	public String ajax01(Model d) {
		d.addAttribute("data01", "안녕하세요");
		
		return "pageJsonReport";
	}
	
	// http://localhost:5080/springweb/ajax02.do
	@RequestMapping("ajax02.do")
	public String ajax02(Model d) {
		d.addAttribute("msg", "반가워요");
		
		return "pageJsonReport";
	}
	
	// http://localhost:5080/springweb/ajax03.do
	@RequestMapping("ajax03.do")
	public String ajax03(Model d) {
		d.addAttribute("person", new Person("홍길동", 25, "서울신림"));
		
		return "pageJsonReport";
	}

	// http://localhost:5080/springweb/ajax04.do
	@RequestMapping("ajax04.do")
	public String ajax04(Model d) {
		d.addAttribute("product", new Product("연필", 1200, 12));
		
		return "pageJsonReport";
	}
	
	// http://localhost:5080/springweb/ajax05.do
	@RequestMapping("ajax05.do")
	public String ajax05(Person p, Model d) {
		d.addAttribute("person", p);
		return "pageJsonReport";
	}
	
	// http://localhost:5080/springweb/ajax06.do?mtitle=밤편지&singer=아이유
	@RequestMapping("ajax06.do")
	public String ajax06(Music m, Model d) {
		d.addAttribute("music", m);
		return "pageJsonReport";
	}
	
	// http://localhost:5080/springweb/ajax07.do?name=손흥민&record=10
	@RequestMapping("ajax07.do")
	public String ajax07(ScPlayer scp, Model d) {
		d.addAttribute("scplayer", scp);
		return "pageJsonReport";
	}
	
	// http://localhost:5080/springweb/ajax08.do?id=himan&pass=7777
	@RequestMapping("ajax08.do")
	public String ajax08(Member011 m, Model d) {
		d.addAttribute("valid", m.getId().equals("himan")&&m.getPass().equals("7777"));
		return "pageJsonReport";
	}
	// ex) 회원등록 여부 확인 등록된 회원이면 hasMember:true
	// http://localhost:5080/springweb/ajax09.do?id=himan
	@RequestMapping("ajax09.do")
	public String ajax09(@RequestParam(value="id",
							defaultValue="") String id, Model d) {
		d.addAttribute("hasMember", id.equals("himan"));
		return "pageJsonReport";
	}
	// ex1) http://localhost:5080/springweb/ajax10.do?num01=100&num02=2000
	/*
	1) url패턴
	2) query string : 1개 또는 객체 결정? vo 확인
	3) vo 선언 Calcu
		private int num01;
		private int num02;
		private int sum;
	4) 메서드를 선언
	5) 모델데이터
		cal.setSum(cal.getNum01()+cal.getNum01());
		d.addAttribute("calResult",cal);
	 * */
	@RequestMapping("ajax10.do")
	public String ajax10(Calcu cal, Model d) {
		cal.setSum(cal.getNum01()+cal.getNum02());
		d.addAttribute("calResult", cal);
		return "pageJsonReport";
	}
	

	// Hw0718
	// 1) http://localhost:5080/springweb/ajax11.do?name=홍길동&height=175.5&weight=68.5
	// 화면출력 {"p01",{"name":"홍길동","height":175.5,"weight":68.5}}
	@RequestMapping("ajax11.do")
	public String ajax11(Person01 p01, Model d) {
		d.addAttribute("p01", p01);
		return "pageJsonReport";
	}

}

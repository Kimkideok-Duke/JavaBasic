package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.y01_dao.A05_PreDAO;
import springweb.z01_vo.Emp;
import springweb.z01_vo.Player;
import springweb.z01_vo.Product;

@Controller
public class A02_SecondController {
	// http://localhost:5080/springweb/second.do
	@RequestMapping("/second.do")
	public String start() {


		return "WEB-INF/views/a02_view.jsp";
	}
	// http://localhost:5080/springweb/call02.do
	// http://localhost:5080/springweb/call02.do?pname=사과&price=12000&cnt=2
	@RequestMapping("call02.do")
    public String call02(
                @RequestParam(value="pname", defaultValue="") String pname,
                @RequestParam(value="price", defaultValue="0") int price,
                @RequestParam(value="cnt", defaultValue="0") int cnt,
                Model d
    		){
        System.out.println("물품명:"+pname);
        System.out.println("가격:"+price);
        System.out.println("갯수:"+cnt);
        
        // 모델 설정
        d.addAttribute("buyInfo", new Product(pname,price,cnt));
        // view단 - ${buyInfo.pname} ${buyInfo.price} ${buyInfo.cnt}
        
        return "WEB-INF/views/a01_basic/a01_product.jsp";
    }
	//
	// http://localhost:5080/springweb/call03.do
	// 화면은 입력 좋아하는 운동선수 : [	], 성적 : [	] [데이터 입력]
	// 입력버튼 클릭시, 하단에 입력된 정보 출력.
	// a02_player.jsp
	@RequestMapping("call03.do")
    public String call03(
                @RequestParam(value="pname", defaultValue="") String pname,
                @RequestParam(value="score", defaultValue="0") String score,
                Model d
    		){
        System.out.println("운동선수:"+pname);
        System.out.println("성적:"+score);
        
        // 모델 설정
        d.addAttribute("playerInfo", new Player(pname,score));
        // view단 - ${buyInfo.pname} ${buyInfo.price} ${buyInfo.cnt}
        
        return "WEB-INF/views/a01_basic/a02_player.jsp";
	}
	// 
	// 객체로 요청값 처리 : usebean의 property 개념으로 처리가 가능
	// http://localhost:5080/springweb/empList.do
	@RequestMapping("/empList.do")
	public String empList(Emp sch, Model d) {
		System.out.println("사원명:"+sch.getEname());
		System.out.println("직책명:"+sch.getJob());
		// model데이터 설
		d.addAttribute("emplist", new A05_PreDAO().getEmpList2(sch));
		return "WEB-INF/views/a01_basic/a06_empList.jsp";
	}
}

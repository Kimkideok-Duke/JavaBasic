package springweb.a01_start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class A01_StartController {
	// http://localhost:5080/springweb/start.do
	@RequestMapping("/start.do")
	public String start() {
		
		
		return "WEB-INF/views/a01_startView.jsp";
	}
    // http://localhost:5080/springweb/call01.do?name=홍길동&age=25
    // 요청값 처리
    @RequestMapping("call01.do")
    public String call01(
                @RequestParam("name") String name,
                @RequestParam("age") int age){
        System.out.println("이름:"+name);
        System.out.println("나이:"+age);
        return "";
    }
}

package springweb.a02_mvc.a01_controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springweb.a02_mvc.a04_vo.Dept;

@RestController
public class RestCtrl {
	@RequestMapping("callRest.do")
	public Dept callDept() {
		return new Dept(10,"인사","서울");
	}
}

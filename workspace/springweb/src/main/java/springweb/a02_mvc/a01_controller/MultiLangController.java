package springweb.a02_mvc.a01_controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class MultiLangController {
	// 컨테이너에 언어에 따라서 view 화면의 language가 변경 되게 설정하는 객체 호출..
	@Autowired(required=false)
	private LocaleResolver localResolver;
	
	
	// http://localhost:5080/springweb/multi.do
	@RequestMapping("multi.do")
	public String multi(
			@RequestParam(value="lang", defaultValue = "") String lang,
			HttpServletRequest request, HttpServletResponse response
			) {
		System.out.println("선택한 언어:"+lang);
		Locale locale = new Locale(lang);
		localResolver.setLocale(request, response, locale);
		
		return "WEB-INF/views/a02_mvc/a23_multilanguage.jsp";
	}
}
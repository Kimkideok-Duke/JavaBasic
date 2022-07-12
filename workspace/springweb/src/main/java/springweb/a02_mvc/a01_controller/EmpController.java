package springweb.a02_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a02_mvc.a02_service.EmpService;
import springweb.a02_mvc.a04_vo.Emp;

@Controller
public class EmpController {
	@Autowired(required = false)
	private EmpService service;
	// http://localhost:5080/springweb/empList01.do
	@RequestMapping("empList01.do")
	public String empList(Emp sch, Model d) {
		d.addAttribute("empList", service.getEmpList(sch));
		return "WEB-INF/views/a02_mvc/a01_empList.jsp";
	}
	// http://localhost:5080/springweb/schJob.do
	@RequestMapping("schJob.do")
	public String jobSearch(
			@RequestParam(value="job", defaultValue="") String job,
			Model d) {
		d.addAttribute("elist", service.getEmpJob(job));
		return "WEB-INF/views/a02_mvc/a02_jobSearch.jsp";
	}
	
//	Hw0712
	// http://localhost:5080/springweb/getEmpEmpno.do
	@RequestMapping("getEmpEmpno.do")
	public String getEmpEmpno(
			@RequestParam(value="empno", defaultValue="7") int empno,
			Model d) {
		d.addAttribute("elist", service.getEmpEmpno(empno));
		return "WEB-INF/views/a02_mvc/Hw0712_empnoList.jsp";
	}
	// http://localhost:5080/springweb/getAvgSal.do
	@RequestMapping("getAvgSal.do")
	public String getAvgSal(
			@RequestParam(value="job", defaultValue="") String job,
			Model d) {
		d.addAttribute("elist", service.getAvgSal(job));
		return "WEB-INF/views/a02_mvc/Hw0712_getAvgSalJob.jsp";
	}
	// http://localhost:5080/springweb/getMaxDeptno.do
	@RequestMapping("getMaxDeptno.do")
	public String getMaxDeptno(
			@RequestParam(value="deptno", defaultValue="0") int deptno,
			Model d) {
		d.addAttribute("elist", service.getMaxDeptno(deptno));
		return "WEB-INF/views/a02_mvc/Hw0712_getMaxDeptno.jsp";
	}
}

package springweb.a02_mvc.a01_controller;

import java.util.HashMap;
import java.util.Map;

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
	
	// Hw0713
	// http://localhost:5080/springweb/getEmp01List.do
	@RequestMapping("getEmp01List.do")
	public String getEmp01List(Model d) {
		d.addAttribute("elist", service.getEmp01List());
		return "WEB-INF/views/a02_mvc/Hw0713_emp01List.jsp";
	}
	@RequestMapping("getDetail.do")
	public String getDetail(@RequestParam("empno") int empno, Model d) {
		d.addAttribute("emp", service.getDetail(empno));
		return "WEB-INF/views/a02_mvc/Hw0713_empDetail.jsp";
	}
	@RequestMapping("updateEmp01.do")
	public String updateEmp01(Emp upt, Model d) {
		d.addAttribute("emp", service.updateEmp01(upt));
		d.addAttribute("proc", "upt");
		return "WEB-INF/views/a02_mvc/Hw0713_empDetail.jsp";
	}
	@RequestMapping("deleteEmp.do")
	public String deleteEmp(@RequestParam("empno") int empno, Model d) {
		service.deleteEmp(empno);
		d.addAttribute("proc", "del");
		return "WEB-INF/views/a02_mvc/Hw0713_empDetail.jsp";
	}


	@RequestMapping("emplist02.do")
	public String ajaxExp() {
		return "WEB-INF/views/a02_mvc/a07_empAjax.jsp";
	}
	// http://localhost:5080/springweb/ajaxEmp.do
	@RequestMapping("ajaxEmp.do")
	public String ajaxEmp(Model d) {
		d.addAttribute("empList", service.getEmpList(new Emp("","")));
		return "pageJsonReport";
	}


	@RequestMapping("deptList10.do")
	public String deptList10() {
		return "WEB-INF/views/a02_mvc/a08_deptAjax.jsp";
	}
	// http://localhost:5080/springweb/ajaxDept.do
	@RequestMapping("ajaxDept.do")
	public String ajaxDept(Model d) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dname", "");
		map.put("loc", "");
		d.addAttribute("dlist", service.getDeptList(map));
		return "pageJsonReport";
	}
	
	// http://localhost:5080/springweb/ajaxDept.do?empno=7839
	@RequestMapping("ajaxEmpDetail.do")
	public String ajaxEmpDetail(@RequestParam("empno") int empno, Model d) {
		d.addAttribute("emp", service.getDetail(empno));
		return "pageJsonReport";
	}
}

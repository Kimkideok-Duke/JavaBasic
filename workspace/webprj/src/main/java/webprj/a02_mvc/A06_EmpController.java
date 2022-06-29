package webprj.a02_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webprj.z01_vo.Emp;

/**
 * Servlet implementation class A06_EmpController
 */
@WebServlet(name = "emplist.do", urlPatterns = { "/emplist.do" })
public class A06_EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private A06_EmpService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public A06_EmpController() {
        super();
        // TODO Auto-generated constructor stub
        service = new A06_EmpService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ename = request.getParameter("ename");
	    String job = request.getParameter("job");
	    
	    request.setAttribute("emplist", service.getEmpList(new Emp(ename, job)));
	    
	    String page = "a04_jsp\\a06_mvc\\a06_empList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}

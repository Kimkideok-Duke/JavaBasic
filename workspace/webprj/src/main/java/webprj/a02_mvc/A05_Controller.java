package webprj.a02_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A05_Controller
 */
@WebServlet(name = "mvc05.do", urlPatterns = { "/mvc05.do" })
public class A05_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 요청값
		String pname = request.getParameter("pname");
		String record = request.getParameter("record");
		A05_Model m05 = new A05_Model();
		// 2. 모델 데이터
		request.setAttribute("model05", m05.getModelData(pname, record));
		// 3. 뷰단 호출
		String page = "a04_jsp/a06_mvc/a05_view.jsp";
		// forward 형식 : 모델 데이터 함께 전송
		RequestDispatcher rd = request.getRequestDispatcher(page);
		// redirect 형식 : 모델 데이터 전송하지 않음
		rd.forward(request, response);
	}

}

package webprj.a02_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class A03_Ctroller
 */
@WebServlet(name = "mvc03.do", urlPatterns = { "/mvc03.do" })
public class A03_Ctroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 요청값 처리
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("받은 요청값1:"+name);
		// ?name=홍길동&age=25;
		System.out.println("받은 요청값:2"+age);
		// 2. 모델 객체 생성 및 데이터 처리
		A03_Model m = new A03_Model();
		request.setAttribute("model01", m.getModelData(name));
		//		모델명을 
		request.setAttribute("model02", "나이:"+age);
		
		// 3. view단 호출
		String viewPage = "a04_jsp\\a06_mvc\\a03_view.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}

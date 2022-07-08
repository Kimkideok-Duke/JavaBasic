package springweb.a02_mvc.a02_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springweb.a02_mvc.a03_dao.DaoExp01;
import springweb.a02_mvc.a03_dao.EmpDao;
import springweb.a02_mvc.a04_vo.DeptEmp01;
import springweb.a02_mvc.a04_vo.Emp;

@Service
public class EmpService {
	@Autowired(required = false)
	private EmpDao dao;
	
	@Autowired(required = false)
	private DaoExp01 dao2;
	
	public List<Emp> getEmpList(Emp sch){
		
		System.out.println("사원번호가 있는지?"
				+dao2.hasemp());
		// mybatis
		// dao2 = new DaoExp01Impl();
		DeptEmp01 de = dao2.getDeptEmp();
		System.out.println("객체 생성 여부:"+de);
		System.out.println("사원명:"+de.getEname());
		System.out.println("부서번호:"+de.getDname());
		
		return dao.getEmpList(sch);
	}
}

package springweb.a02_mvc.a03_dao;
// springweb.a02_mvc.a03_dao.DaoExp01

import org.springframework.stereotype.Repository;

import springweb.a02_mvc.a04_vo.DeptEmp01;

@Repository
public interface DaoExp01 {
	public int getEmpCount();
	public double getSal();
	public double getSalSum();
	public String getJob();
	public boolean hasemp();
	public DeptEmp01 getDeptEmp();
}

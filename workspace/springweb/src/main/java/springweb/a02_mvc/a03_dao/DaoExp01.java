package springweb.a02_mvc.a03_dao;
// springweb.a02_mvc.a03_dao.DaoExp01

import java.util.List;

import org.springframework.stereotype.Repository;

import springweb.a02_mvc.a04_vo.DeptEmp01;
import springweb.a02_mvc.a04_vo.Emp;

@Repository
public interface DaoExp01 {
	public int getEmpCount();
	public double getSal();
	public double getSalSum();
	public String getJob();
	public boolean hasemp();
	public DeptEmp01 getDeptEmp();

	public List<String> getEnames();
	public List<Integer> getEmpnos();
	public List<Double> getSalaries();
	
	public List<String> getJobs();
	
	public List<Emp> getEmpList30();

}

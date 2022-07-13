package springweb.a02_mvc.a03_dao;
// springweb.a02_mvc.a03_dao.DaoExp01

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import springweb.a02_mvc.a04_vo.DeptEmp01;
import springweb.a02_mvc.a04_vo.Emp;
import springweb.a02_mvc.a04_vo.Salgrade;

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
	
	public Emp getAvgSalJob(String job);
	public List<Emp> getSalSch(Map map);
	public void insertSalgrade(Salgrade ins);
	
	public List<Emp> getEmpJob(String job);
	
//	Hw0712
	public List<Emp> getEmpEmpno(int empno);
	public List<Emp> getAvgSal(String job);
	public List<Emp> getMaxDeptno(int deptno);

// 	Hw0713
	public List<Emp> getEmp01();
	public Emp getDetail(int empno);
	public void updateEmp01(Emp upt);
    public void deleteEmp(int empno);
}

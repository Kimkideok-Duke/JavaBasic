package springweb.a02_mvc.a03_dao;
// springweb.a02_mvc.a03_dao.DaoHw0708

import java.util.Date;

import org.springframework.stereotype.Repository;

import springweb.a02_mvc.a04_vo.Emp;
@Repository
public interface DaoHw0708 {
//	1
	public Date getLatestHired();
//	2
	public Emp HighestSalinDept();
//	3
	public String getEnameSalRange();
//	4
	public Emp getEmpListHiredFirstQuater();
//	5
	public Emp AvgSalbyDept();
}

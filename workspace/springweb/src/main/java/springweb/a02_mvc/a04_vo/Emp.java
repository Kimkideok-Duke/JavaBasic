package springweb.a02_mvc.a04_vo;

import java.util.Date;

public class Emp {
    // sql결과에 맞게 데이터 유형과 속성을 지정한다.
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private String hiredate_s;
    private double sal;
    private double comm;
	private int deptno;
	private boolean pass;
	private char hiredate_q;
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	// where 조건문에 검색하기 위한 생성
	public Emp(String ename, String job) {
		this.ename = ename;
		this.job = job;
	}
	// insert 구문에 데이터를 입력하는 객체 생성
	public Emp(int empno, String ename, String job, int mgr, String hiredate_s, double sal, double comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate_s = hiredate_s;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	// select의 데이터를 가져오기 위한 생성
	public Emp(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public Emp(int empno, String ename, String job, int mgr, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	public Emp(int empno, String ename, Date hiredate, char hiredate_q) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.hiredate_q = hiredate_q;
	}
	public Emp(String ename, String job, double sal) {
		super();
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}
	
	public Emp(double sal, int deptno) {
		super();
		this.sal = sal;
		this.deptno = deptno;
	}
	public Emp(String job, double sal) {
		super();
		this.job = job;
		this.sal = sal;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getHiredate_s() {
		return hiredate_s;
	}
	public void setHiredate_s(String hiredate_s) {
		this.hiredate_s = hiredate_s;
	}
	public boolean isPass(){
		return pass;
	}
	public void setPass(boolean pass){
		this.pass = pass;
	}
	public char getHiredate_q() {
		return hiredate_q;
	}
	public void setHiredate_q(char hiredate_q) {
		this.hiredate_q = hiredate_q;
	}
}

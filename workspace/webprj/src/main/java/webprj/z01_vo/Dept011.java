package webprj.z01_vo;

public class Dept011 {
    private int deptno;
    private String dname;
    private String loc;

    public Dept011() {
    }

    public Dept011(int deptno, String dname) {
        super();
        this.deptno = deptno;
        this.dname = dname;
    }

    public Dept011(int deptno, String dname, String loc) {
        super();
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public int getDeptno() {
        return this.deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return this.dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
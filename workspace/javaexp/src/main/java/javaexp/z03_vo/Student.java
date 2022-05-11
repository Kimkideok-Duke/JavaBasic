package javaexp.z03_vo;

public class Student {
    private int grade;
    private String major;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Student(int grade, String major) {
        this.grade = grade;
        this.major = major;
    }

    public void show() {
        System.out.println(major + grade + "학년");
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}

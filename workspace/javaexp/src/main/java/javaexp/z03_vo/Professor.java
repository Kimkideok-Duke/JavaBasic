package javaexp.z03_vo;

import java.util.ArrayList;

public class Professor {
	private String name;
    private ArrayList<Student> slist;

    public Professor() {
        slist = new ArrayList<Student>();
    }
    public Professor(String name) {
        this.name = name;
        slist = new ArrayList<Student>();
    }

    public void addStudent(Student s) {
        System.out.println("학생이 수강등록했습니다.");
        slist.add(s);
    }
    public void showStudentList() {
        System.out.println(name + "교수 강의 수강 학생 목록");
        if(slist.size()>0) {
            for(Student s:slist) {
                s.show();
            }
            System.out.println("총 " + slist.size() + "명");
        }else {
            System.out.println("수강 신청한 학생이 없습니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getSlist() {
        return this.slist;
    }

    public void setSlist(ArrayList<Student> slist) {
        this.slist = slist;
    }

    
}

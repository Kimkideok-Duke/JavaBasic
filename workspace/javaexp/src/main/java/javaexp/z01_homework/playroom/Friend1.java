package javaexp.z01_homework.playroom;

import javaexp.z01_homework.studyroom.Student1;

public class Friend1 {
    private String secret = "비밀";
    String name = "홍길동";
    public int birth = 1212;

    public void callStudentInfo(){
		Student1 s1 = new Student1();
		// System.out.println(s1.name);
		System.out.println(s1.score);
	}
}

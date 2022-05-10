package javaexp.z01_homework.studyroom;

import javaexp.z01_homework.playroom.Friend1;

public class Student1 {
    private int age = 22;
    String name = "김길동";
    public int score = 100;

    public void callFriendinfo() {
        Friend1 f1 = new Friend1();
        // System.out.println(f1.name);
        System.out.println(f1.birth);
    }
}

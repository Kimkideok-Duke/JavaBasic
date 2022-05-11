package javaexp.z03_vo;

public class Busrider {
    private String gender;
    private int age;

    public Busrider() {
        super();
    }

    public Busrider(String gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public void show() {
        System.out.println(gender + age + "살");
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

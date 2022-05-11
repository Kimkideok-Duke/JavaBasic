package javaexp.z03_vo;

public class Bplayer {
    private int num;
    private String name;
    private String birth;

    public Bplayer() {
        super();
    }

    public Bplayer(int num, String name, String birth) {
        this.num = num;
        this.name = name;
        this.birth = birth;
    }

    public void show() {
        System.out.print(num + "\t");
        System.out.print(name + "\t");
        System.out.println(birth);
    }


    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

}

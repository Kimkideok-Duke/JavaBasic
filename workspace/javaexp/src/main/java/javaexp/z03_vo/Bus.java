package javaexp.z03_vo;

import java.util.ArrayList;

public class Bus {
    private int num;
    private ArrayList<Busrider> blist;

    public Bus() {
        blist = new ArrayList<Busrider>();
    }    
    public Bus(int num) {
        this.num = num;
        blist = new ArrayList<Busrider>();
    }

    public void addRider(Busrider r) {
        System.out.println(r.getGender() + "이 " + num +"번 버스에 탑승했습니다.");
        blist.add(r);
    }

    public void showRiderList() {
        System.out.println(num + "번 버스 승객 정보");
        if(blist.size()>0) {
            System.out.println(blist.size() + "명 탑승");
            for(Busrider r:blist) {
                r.show();
            }
        }else {
            System.out.println("승객이 없습니다.");
        }
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ArrayList<Busrider> getBlist() {
        return this.blist;
    }

    public void setBlist(ArrayList<Busrider> blist) {
        this.blist = blist;
    }
    
}

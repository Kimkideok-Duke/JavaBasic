package javaexp.z03_vo;

import java.util.ArrayList;

public class Train {
    private String dest;
    private ArrayList<Seat> slist;

    public Train() {
        slist = new ArrayList<Seat>();
    }
    public Train(String dest) {
        this.dest = dest;
        slist = new ArrayList<Seat>();
    }
    public void addSeat(Seat s) {
        System.out.println(s.getNum() + "좌석이 예약되었습니다.");
        slist.add(s);
    }
    public void showSeatList() {
        System.out.println("예약 좌석 목록");
        if(slist.size()>0) {
            for(Seat s:slist) {
                s.show();
            }
        }else {
            System.out.println("예약된 좌석이 없습니다.");
        }
    }

    public String getDest() {
        return this.dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public ArrayList<Seat> getSlist() {
        return this.slist;
    }

    public void setSlist(ArrayList<Seat> slist) {
        this.slist = slist;
    }

}

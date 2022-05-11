package javaexp.z03_vo;

import java.util.ArrayList;

public class BTeam {
    private String tname;
    private ArrayList<Bplayer> blist;
    public BTeam() {
        blist = new ArrayList<Bplayer>();
    }
    public BTeam(String tname) {
        this.tname = tname;
        blist = new ArrayList<Bplayer>();
    }
    public void addPlayer(Bplayer bp) {
        System.out.println(bp.getName() + "선수가 " + tname +"팀에 합류했습니다.");
        blist.add(bp);
    }
    public void showTeamList() {
        System.out.println(tname + "팀의 소속 선수 정보");
        if(blist.size()>0) {
            for(Bplayer bp:blist) {
                bp.show();
            }
        }else {
            System.out.println(tname + "팀의 소속 선수가 없습니다.");
        }
    }

    public String getTname() {
        return this.tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public ArrayList<Bplayer> getBlist() {
        return this.blist;
    }

    public void setBlist(ArrayList<Bplayer> blist) {
        this.blist = blist;
    }

}

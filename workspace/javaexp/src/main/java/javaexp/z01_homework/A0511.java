package javaexp.z01_homework;

import javaexp.z03_vo.Bus;
import javaexp.z03_vo.Busrider;
import javaexp.z03_vo.Professor;
import javaexp.z03_vo.Seat;
import javaexp.z03_vo.Student;
import javaexp.z03_vo.Train;

public class A0511 {

    public static void main(String[] args) {
        // [1단계:개념] 1. 1:1관계 클래스와 1:다관계 클래스를 구현할 때, 구조상/코드상 차이점을 기술하세요. 
            // 1:1관계 클래스는 하나의 클래스안에 하나의 객체만 할당 되지만
            // 1:다관계 클래스는 하나의 클래스안에 여러개의 다중의 선언된 클래스를 호출하여 선언하고 할당한다.

        // [1단계:개념] 2. 1:다관계 클래스 구현할 때, 간단한 예제와 함께 구현 순서를 기술하세요.
            // 구현 순서
			// 1) 다중으로 처리한 종속된 단위 객체를 위한 클래스 선언.
			// 2) 해당 다중 객체를 포함할 클래스 선언
			// 	- 필드
			// 	- 초기 생성자 설정
			// 	- 다중의 데이터 처리할 입력 메서드 선언
			// 	- 1:다관계로 출력하거나 리턴할 객체 선언

        // [1단계:확인] 3. 아래의 여러가지 1:다 관계 클래스를 선언하고 출력하세요.
        //         1) 버스, 버스에 탄 승객
                    // public class Bus {
                    //     private int num;
                    //     private ArrayList<Busrider> blist;
                    
                    //     public Bus() {
                    //         blist = new ArrayList<Busrider>();
                    //     }    
                    //     public Bus(int num) {
                    //         this.num = num;
                    //         blist = new ArrayList<Busrider>();
                    //     }
                    
                    //     public void addRider(Busrider r) {
                    //         System.out.println(r.getGender() + "이 " + num +"번 버스에 탑승했습니다.");
                    //         blist.add(r);
                    //     }
                    
                    //     public void showRiderList() {
                    //         System.out.println(num + "번 버스 승객 정보");
                    //         if(blist.size()>0) {
                    //             System.out.println(blist.size() + "명 탑승");
                    //             for(Busrider r:blist) {
                    //                 r.show();
                    //             }
                    //         }else {
                    //             System.out.println("승객이 없습니다.");
                    //         }
                    //     }
                    
                    //     public int getNum() {
                    //         return this.num;
                    //     }
                    
                    //     public void setNum(int num) {
                    //         this.num = num;
                    //     }
                    
                    //     public ArrayList<Busrider> getBlist() {
                    //         return this.blist;
                    //     }
                    
                    //     public void setBlist(ArrayList<Busrider> blist) {
                    //         this.blist = blist;
                    //     }
                        
                    // }

                    // public class Busrider {
                    //     private String gender;
                    //     private int age;
                    
                    //     public Busrider() {
                    //         super();
                    //     }
                    
                    //     public Busrider(String gender, int age) {
                    //         this.gender = gender;
                    //         this.age = age;
                    //     }
                    
                    //     public void show() {
                    //         System.out.println(gender + age + "살");
                    //     }
                    
                    //     public String getGender() {
                    //         return this.gender;
                    //     }
                    
                    //     public void setGender(String gender) {
                    //         this.gender = gender;
                    //     }
                    
                    //     public int getAge() {
                    //         return this.age;
                    //     }
                    
                    //     public void setAge(int age) {
                    //         this.age = age;
                    //     }
                    
                    // }
                    Bus b = new Bus(223);
                    b.addRider(new Busrider("남성", 23));
                    b.addRider(new Busrider("남성", 63));
                    b.addRider(new Busrider("여성", 34));
                    b.showRiderList();

        //         2) 담당교수, 수강 학생
                    // public class Professor {
                    //     private String name;
                    //     private ArrayList<Student> slist;
                    
                    //     public Professor() {
                    //         slist = new ArrayList<Student>();
                    //     }
                    //     public Professor(String name) {
                    //         this.name = name;
                    //         slist = new ArrayList<Student>();
                    //     }
                    
                    //     public void addStudent(Student s) {
                    //         System.out.println("학생이 수강등록했습니다.");
                    //         slist.add(s);
                    //     }
                    //     public void showStudentList() {
                    //         System.out.println(name + "교수 강의 수강 학생 목록");
                    //         if(slist.size()>0) {
                    //             for(Student s:slist) {
                    //                 s.show();
                    //             }
                    //             System.out.println("총 " + slist.size() + "명");
                    //         }else {
                    //             System.out.println("수강 신청한 학생이 없습니다.");
                    //         }
                    //     }
                    
                    //     public String getName() {
                    //         return this.name;
                    //     }
                    
                    //     public void setName(String name) {
                    //         this.name = name;
                    //     }
                    
                    //     public ArrayList<Student> getSlist() {
                    //         return this.slist;
                    //     }
                    
                    //     public void setSlist(ArrayList<Student> slist) {
                    //         this.slist = slist;
                    //     }
                    
                    // }

                    // public class Student {
                    //     private int grade;
                    //     private String major;
                    //     public Student() {
                    //         super();
                    //         // TODO Auto-generated constructor stub
                    //     }
                    
                    //     public Student(int grade, String major) {
                    //         this.grade = grade;
                    //         this.major = major;
                    //     }
                    
                    //     public void show() {
                    //         System.out.println(major + grade + "학년");
                    //     }
                    
                    //     public int getGrade() {
                    //         return this.grade;
                    //     }
                    
                    //     public void setGrade(int grade) {
                    //         this.grade = grade;
                    //     }
                    
                    //     public String getMajor() {
                    //         return this.major;
                    //     }
                    
                    //     public void setMajor(String major) {
                    //         this.major = major;
                    //     }
                    
                    // }

                    Professor p = new Professor("김범수");
                    p.showStudentList();
                    p.addStudent(new Student(3, "실용음악과"));
                    p.addStudent(new Student(1, "전자공학과"));
                    p.showStudentList();

        //         3) 기차, 기차 좌석정보
                    // public class Train {
                    //     private String dest;
                    //     private ArrayList<Seat> slist;
                    
                    //     public Train() {
                    //         slist = new ArrayList<Seat>();
                    //     }
                    //     public Train(String dest) {
                    //         this.dest = dest;
                    //         slist = new ArrayList<Seat>();
                    //     }
                    //     public void addSeat(Seat s) {
                    //         System.out.println(s.getNum() + "좌석이 예약되었습니다.");
                    //     }
                    //     public void showSeatList() {
                    //         System.out.println("예약 좌석 목록");
                    //         if(slist.size()>0) {
                    //             for(Seat s:slist) {
                    //                 s.show();
                    //             }
                    //         }else {
                    //             System.out.println("예약된 좌석이 없습니다.");
                    //         }
                    //     }
                    
                    //     public String getDest() {
                    //         return this.dest;
                    //     }
                    
                    //     public void setDest(String dest) {
                    //         this.dest = dest;
                    //     }
                    
                    //     public ArrayList<Seat> getSlist() {
                    //         return this.slist;
                    //     }
                    
                    //     public void setSlist(ArrayList<Seat> slist) {
                    //         this.slist = slist;
                    //     }
                    
                    // }

                    // public class Seat {
                    //     private String num;
                    //     private String place;
                    //     public Seat() {
                    //         super();
                    //         // TODO Auto-generated constructor stub
                    //     }
                    //     public Seat(String num, String place) {
                    //         this.num = num;
                    //         this.place = place;
                    //     }
                        
                    //     public void show() {
                    //         System.out.println(num + "번 " + place + "좌석");
                    //         slist.add(s);
                    //     }
                    
                    //     public String getNum() {
                    //         return this.num;
                    //     }
                    
                    //     public void setNum(String num) {
                    //         this.num = num;
                    //     }
                    
                    //     public String getPlace() {
                    //         return this.place;
                    //     }
                    
                    //     public void setPlace(String place) {
                    //         this.place = place;
                    //     }
                        
                    // }

                    Train t = new Train("부산행");
                    t.addSeat(new Seat("4B", "창측"));
                    t.addSeat(new Seat("6C", "복도측"));
                    t.addSeat(new Seat("10D", "창측"));
                    t.addSeat(new Seat("1A", "창측"));
                    t.showSeatList();

        // [1단계:개념] 4. 상속의 한계에 대하여 예제와 함께 기술하세요
                    // - 부모 클래스의 private 접근 갖는 필드와 메소드 제외 private 자체가 해당 클래스에서만 사용할 수 있지,
                    //     직접적인 접근 및 처리를 하지 못한다. 단, 간접적으로 다른 메서드나 생성자를 통해서 접근은 가능하다.
                    // - 부모 클래스가 다른 패키지에 있을 경우, default 접근 갖는 필드와 메소드도 제외

        // [1단계:확인] 5. 상위로 탈것(속도)을 선언하고, 이것을 상속받은 하위로 자동차(승객수), 
        //     트럭(중량)를 선언하고 출력하는 메서드를 통해서 출력처리하세요.
                    Car2 c1 = new Car2(120, 3);
                    c1.show();
                    Truck t1 = new Truck(80, 5000);
                    t1.show();
        // [1단계:개념] 6. 상속 관계에서 super()는 생성자관계에서 사용하는 규칙을 기본 예제를 통해서
        //     기술하세요.
                        //  하위 기재

        // [1단계:확인] 7. 상위로 Robot을 생성자로 로봇의 종류를 할당하게 하고, Dagan, Gandam을
        //     상속하여 해당 생성자를 통해서 호출하여 처리하고 출력되게 하세요.
                    Dagan d1 = new Dagan();
                    d1.showRobotKind();
                    Gandam g1 = new Gandam();
                    g1.showRobotKind();

        // [1단계:개념] 8. 메서드 재정의 규칙을 기본예제를 통해서 설명하세요.
                // 1) 부모 클래스의 메소드와 동일한 메소드명을 가져야 한다.
                // 2) 접근 제한을 더 강하게 오버라이딩하는 것을 불가하다.
                //     상위 default(X) ==> 하위 default(X), protected, public
                //     상위 protected ==> 하위 protected, public
                //     상위 public ==> 하위 public

        // [1단계:확인] 9. 상위클래스 Vehicle를 선언하고 필드로 탈것의 종류 선언, 재정의 
        //     메서드로 driving()을 선언하여 하위로 Airplane,
        //     Bus, Ship에서 재정의하여 처리하게 하세요.
                    Airplane a1 = new Airplane();
                    Bus1 b1 = new Bus1();
                    Ship s1 = new Ship();
                    a1.driving();
                    b1.driving();
                    s1.driving();
    }
}
class Homework0511{
    String hw = "있음";
    String finish = "완료";
    Homework0511(String hw, String finish) {
        this.hw = hw;
        this.finish = finish;
    }
    void show() {
        System.out.println("과제가 " + hw);
        System.out.println(finish);
    }
}
class Subject extends Homework0511{
    String subject = "수학";
    // [1단계:개념] 6. 상속 관계에서 super()는 생성자관계에서 사용하는 규칙을 기본 예제를 통해서
            //     기술하세요.
    Subject(){
        super("있음", "완료");
    }
    Subject(String hw, String finish) {
        super(hw, finish);
    }
}

class Vehicle{
    int km;
}
class Car2 extends Vehicle{
    int num;
    Car2(){}
    Car2(int km, int num) {
        this.km = km;
        this.num = num;
    }
    void show() {
        System.out.println("속력 : " + km);
        System.out.println("승객수 : " + num);
    }
}
class Truck extends Vehicle{
    int kg;
    Truck(){}
    Truck(int km, int kg) {
        this.km = km;
        this.kg = kg;
    }
    void show() {
        System.out.println("속력 : " + km);
        System.out.println("중량 : " + kg);
    }
}

class Robot{
    String kind;
    Robot(String kind) {
        this.kind = kind;
    }
    void showRobotKind() {
        System.out.println("로봇의 종류 : " + kind);
    }
}
class Dagan extends Robot{
    Dagan(){
        super("Dagan");
    }
    Dagan(String kind){
        super(kind);
    }
}
class Gandam extends Robot{
    Gandam(){
        super("Gandam");
    }
    Gandam(String kind){
        super(kind);
    }
}

class Vehicle2{
    private String kind;

    public Vehicle2(String kind) {
        this.kind = kind;
    }
    public void driving() {
        System.out.println(kind + "를(을) 탄다.");
    }
}
class Airplane extends Vehicle2{

	public Airplane() {
		super("비행기");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void driving() {
		// TODO Auto-generated method stub
		super.driving();
	}

}
class Bus1 extends Vehicle2{

	public Bus1() {
		super("버스");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void driving() {
		// TODO Auto-generated method stub
		super.driving();
	}

}
class Ship extends Vehicle2{

	public Ship() {
		super("배");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void driving() {
		// TODO Auto-generated method stub
		super.driving();
	}

}
package javaexp.a12_collections;

import java.util.HashSet;
import java.util.Set;

public class A02_Set {

    public static void main(String[] args) {
        /**
        # Set
        1. 컬렉션의 특징
            1) 수학의 집합에 비유
            2) 저장 순서가 유지되지 않음
            3) 객체를 중복저장 불가
            4) 하나의 null만 저장 가능
        2. 구현 클래스
            HashSet,LinkedHashSet, TreeSet
        3. 주요 메서드
            add()
            contains()
            isEmpty
            Interator<E> iterator()
            size()
            clear()
            remove(Object)
         */
        // 상위 인터페이스 = 하위 실체 객체
        Set<String> set = new HashSet<String>();
        set.add("사과");
        set.add("사과");
        set.add("배");
        set.add("바나나");
        set.add("배");
        for(String fruit:set) {
            System.out.println(fruit);
        }
    	// ex)
        Set<String> pouch = new HashSet<String>();
        pouch.add("빨강구슬");
        pouch.add("빨강구슬");
        pouch.add("파랑구슬");
        pouch.add("파랑구슬");
        pouch.add("파랑구슬");
        pouch.add("노랑구슬");
        pouch.add("노랑구슬");
        System.out.println("# 주머니 속에 구슬 #");
        for(String one:pouch) {
            System.out.println(one);
        }
    }
}

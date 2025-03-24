package a0324;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Arraylist1 {
    public static void main(String[] args) {
        // 컬렉션
        ArrayList<Integer> arrlist = new ArrayList<Integer>();

        // add메서드로 요소 저장
        arrlist.add(40);
        arrlist.add(20);
        arrlist.add(30);
        arrlist.add(10);

        for(int i = 0; i < arrlist.size(); i++){
            System.out.print(arrlist.get(i) + " ");
        }
        System.out.println();

        for(int e : arrlist){
            System.out.print(e + " ");
        }
        System.out.println();

        // Collections.sort(arrlist); //정렬기능
        // for(int e : arrlist){
        //     System.out.print(e + " ");
        // }

        Iterator<Integer> iter = arrlist.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next()+ " ");
        }
        System.out.println();

        arrlist.set(0, 20); //변경기능
        for(int e : arrlist){
            System.out.print(e + " ");
        }
        System.out.println();

        arrlist.remove(1); //삭제기능
        for(int e : arrlist){
            System.out.print(e + " ");
        }
        System.out.println();

        arrlist.add(0, 10); //추가기능
        for(int e : arrlist){
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println("리스트의 크기: " + arrlist.size());
    }
}

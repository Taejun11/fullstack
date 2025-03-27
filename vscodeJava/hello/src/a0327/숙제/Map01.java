package a0327.숙제;

import java.util.HashMap;
import java.util.Map;


public class Map01 {
    public static void main(String[] args) {
        HashMap<Integer, String> mapex = new HashMap<>(); //맵 선언
        mapex.put(1, "a");
        mapex.put(2, "b");
        mapex.put(3, "c");//맵에 값 추가
        mapex.put(4, "d");

        

        System.out.println(mapex.keySet()+""+mapex.values());//맵의 모든 값
        System.out.println(mapex.size());//맵의 길이
        mapex.replace(2, "c");//맵의 수정 -> 키값에 있는 밸류값을 수정하는 것
        System.out.println(mapex.keySet()+""+mapex.values());//맵의 모든 값

        System.out.println("------------------------------");
        for(Integer key : mapex.keySet()){ 
            //맵의 반복1
            System.out.println(mapex.get(key));
        }
        System.out.println("------------------------------");
        for(Map.Entry<Integer, String> maps : mapex.entrySet()){
            //맵의 반복2 -> import java.util.Map; 필요
            //import를 못넣어서 파일명 수정했음
            System.out.println(maps.getKey()+", "+maps.getValue());
        }
        System.out.println("------------------------------");
        mapex.remove(1); //해당 키 값을 갖고있는 맵 삭제
        for(Map.Entry<Integer, String> maps : mapex.entrySet()){
            System.out.println(maps.getKey()+", "+maps.getValue());
        }
        System.out.println("------------------------------");
        
    }
}

package a0331;

import java.util.TreeMap;

public class Treemap1 {
    public static void main(String[] args) {
        TreeMap<Integer, String> tm = new TreeMap<>();
        

        tm.put(30,"삼십");
        tm.put(10,"십");
        tm.put(40,"사십");
        tm.put(20,"이십");

        System.out.println("맵에 저장된 키들의 집합: " + tm.keySet());

        for(Integer key : tm.keySet()){
            System.out.printf("키: %s, 값: %s\n", key, tm.get(key));
        }
        
        TreeMap<String, Integer> tm1 = new TreeMap<>();
        tm1.put("ㄷ", 30);
        tm1.put("ㅅ", 10);
        tm1.put("ㄱ", 40);
        tm1.put("ㅎ", 20);
        System.out.println("맵에 저장된 키들의 집합: " + tm1.keySet());

        for(String key : tm1.keySet()){
            System.out.printf("키: %s, 값: %s\n", key, tm1.get(key));
        }

    }
}

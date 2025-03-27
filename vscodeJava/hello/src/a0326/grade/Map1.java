package a0326.grade;

import java.util.HashMap;
import java.util.Iterator;

public class Map1 {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("삼십", 30);
        hm.put("십", 10);
        hm.put("사십", 40);
        hm.put("이십", 20);

        System.out.println("맵에 저장된 키 값: "+hm.keySet());
        for(String key :hm.keySet()){
            System.out.printf("키: %s, 값: %d\n", key, hm.get(key));
        }

        hm.remove("사십");
        Iterator<String> keys = hm.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.printf("키: %s, 값: %d\n", key, hm.get(key));
            
        }

        hm.replace("이십", 200);
        for(String key :hm.keySet()){
            System.out.printf("키: %s, 값: %d\n", key, hm.get(key));
        }

        System.out.println("맵의 크기: " + hm.size());
    }
}

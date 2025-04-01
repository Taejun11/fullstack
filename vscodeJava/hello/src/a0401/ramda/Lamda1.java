package a0401.ramda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lamda1 {
    public static void main(String[] args) {
        // List<String> name = new ArrayList<>();
        // name.add("apple");
        // name.add("banana");
        // name.add("orange");
        // for(int i = 0; i < name.size(); i++){
        // System.out.println(name.get(i));
        // }
        List<String> names = Arrays.asList("apple", "banana", "orange");
        for (String n : names) {
            System.out.println(n);
        }
        // 람다
        names.forEach(n -> System.out.println(n));
        System.out.println();

        // 스트림
        names.stream()
                .filter(n -> n.length() >= 6) //필터링 조건
                .forEach(System.out::println);//필터링된 요소들 출력
    }
}

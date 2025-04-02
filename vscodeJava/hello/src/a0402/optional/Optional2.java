package a0402.optional;

import java.util.Optional;


public class Optional2 {

    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable("alice");
        // 값이 있으면 값을 출력, 없으면 기본값 출력
        String result = name.orElse("guest");
        System.out.println("hello " + result);

        Optional<String> name1 = Optional.ofNullable(null);
        String result1 = name1.orElse("guest");
        System.out.println("hello " + result1);




    }
}
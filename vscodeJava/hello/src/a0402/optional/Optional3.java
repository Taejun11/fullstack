package a0402.optional;

import java.util.Optional;


public class Optional3 {

    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable("alice");
        // 값이 있으면 실행
        name.ifPresent(n -> System.out.println("hello " + n));

        Optional<String> emptyName = Optional.ofNullable(null);
        emptyName.ifPresent(n -> System.out.println("Hello, " + n));  // 출력: 아무 것도 출력되지 않음


    }
}
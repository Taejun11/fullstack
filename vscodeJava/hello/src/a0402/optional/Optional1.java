package a0402.optional;

import java.util.Optional;

// Optional: null값으로 인한 문제 방지, 안전하게 값을 처리
// null이 될 수있는 객체를 감싸는 클래스
public class Optional1 {

    public static void main(String[] args) {
        Optional<String> name = Optional.of("John");
        System.out.println("name: " + name.get());

        Optional<String> emptyname = Optional.empty();
        System.out.println("empty: " + emptyname.isPresent());
        // empty: 빈 Optional 생성

        // Optional.ofNullable: null을 허용하는 Optional 생성
        Optional<String> nullofname = Optional.ofNullable(null);
        System.out.println("nullof: " + nullofname.isPresent());


    }
}
package a0402.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Optional6 {
    private static final Map<Integer, String> userDatabase = new HashMap<>();
    // final: 새로운 객체할당 불가능
    static{
        userDatabase.put(1, "Alice");
        userDatabase.put(2, "Bob");
        userDatabase.put(3, "Charlie");
    }
    // static 블록: 클래스가 최초로 로드될 때 한번만 실행함

    public static void main(String[] args) {
        // userDatabase = new HashMap<>(); //불가능
        Optional<String> user1 = findbyId(2);
        System.out.println("유저id 2번: " + user1.orElse("user not found"));
        Optional<String> user2 = findbyId(5);
        System.out.println("유저id 2번: " + user2.orElse("user not found"));

        System.out.println("유저id 3번(orElse): " + findbyId(3).orElse(getDefaultUser()));
        System.out.println("유저id 3번(orElse): " + findbyId(3).orElseGet(()->getDefaultUser()));
        // orElse: 값의 유무 상관없이 항상 뒷명령 호출함
        // orElseGet: 값이 null일 때만 뒷명령 호출함
    }

    private static String getDefaultUser() {
        System.out.println("getDefaultUser 호출됨");
        return "default user";
    }

    private static Optional<String> findbyId(int id) {
        return Optional.ofNullable(userDatabase.get(id));
    }

    
}
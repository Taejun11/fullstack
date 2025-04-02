package a0402.optional1;

import java.util.Optional;

public class Main1 {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // 존재하는 아이디 검색
        Optional<User> userOptional1 = userRepository.findbyId(2L);
        userOptional1.ifPresentOrElse(user->System.out.println("찾는 사용자: " + user)
        , ()->System.out.println("찾는 사용자가 없음"));

        Optional<User> userOptional2 = userRepository.findbyId(99L);
        userOptional2.ifPresentOrElse(user->System.out.println("찾는 사용자: " + user)
        , ()->System.out.println("찾는 사용자가 없음"));

        Optional<User> userOptional3 = userRepository.findbyId(50L);
        userOptional3.ifPresentOrElse(user->System.out.println("찾는 사용자: " + user)
        , ()->System.out.println("찾는 사용자가 없음"));

        // 기본값 제공
        User defaultUser = userOptional3.orElse(new User(0L, "기본유저"));
        System.out.println("기본 사용자: " + defaultUser);

        // findbyId: 아이디로 사용자 리스트를 검색하고 결과를 Optional<User>로 반환
        // 사용자가 없으면 Optional.empty()로 반환
        // ifPresentOrElse: 값이 있는 경우의 처리, 없는 경우의 처리를 수행
        // orElse: 값이 없으면 기본값을 반환
        // orElseThrow: 값이 없으면 생기는 예외 처리
    }
}

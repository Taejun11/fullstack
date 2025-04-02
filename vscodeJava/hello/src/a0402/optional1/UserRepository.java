package a0402.optional1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        // 더미 데이터 추가
        users.add(new User(1L, "Alice"));
        users.add(new User(2L, "Bob"));
        users.add(new User(3L, "Charlie"));
    }

    public Optional<User> findbyId(long id) {
        // 있으면 해당객체 반환
        // 없으면 null 반환
        // for(User user : users){
        //     if (user.getId() == id) {
        //         return Optional.of(user);
        //     }
        // }
        // return Optional.empty();

        return users.stream()
                    .filter(user -> user.getId()==id)
                    .findFirst();
    }
}

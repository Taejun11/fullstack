package a0402.optional;

import java.util.Optional;

public class Optional5 {

    public static void main(String[] args) {
        // String name = "Mark";
        Optional<String> optionalname = findname("Mark");
        System.out.println(optionalname.orElse("name not found"));
    }

    private static Optional<String> findname(String name) {
        if ("John".equals(name)) {
            return Optional.of(name);
        }
        return Optional.empty();
    }
}
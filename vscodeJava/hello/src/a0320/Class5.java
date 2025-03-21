package a0320;

public class Class5 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 31);

        System.out.printf("이름: %s, 나이: %d", p1.name, p1.age);
    }
}

class Person {
    
    String name;
    int age;
    public Person(String n, int a) {
        name = n;
        age = a;
    }
}
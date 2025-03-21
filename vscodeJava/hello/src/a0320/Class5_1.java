package a0320;

public class Class5_1 {
    public static void main(String[] args) {
        Person1 p1 = new Person1("홍길동",31);
        Person1 p2 = new Person1();
        p2.name = "이순신";
        p2.age = 25;

        System.out.printf("이름: %s, 나이: %d\n", p1.name, p1.age);
        System.out.printf("이름: %s, 나이: %d\n", p2.name, p2.age);
    }
}

class Person1 {
    
    String name;
    int age;
    public Person1(){}
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 아무것도 안적어도 기본으로 초기화 되어 있음
    // public Person1(){

    // }
}
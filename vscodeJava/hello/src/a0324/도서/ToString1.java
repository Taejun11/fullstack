package a0324.도서;

// 모든 자바 클래스는 Object 클래스를 기본으로 상속 , 생략 가능
public class ToString1 extends Object{
    public static void main(String[] args) {
        Person person = new Person("홍길동", 25);
    }
}

class Person{
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person [name" + name + ", age"+ age + "]";
    }
}

// 오버로딩, 오버라이딩 차이 예제
// this, this()의 차이 예제
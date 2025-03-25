package a0325.abstract1;

// 추상클래스 abstract
// 객체 생성 불가능
// 공통기능을 정의하고 자식 클래스에서 구현하는 것을 강제하는 방식
// 일반 메서드 + 추상 메서드 가능
abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    abstract void makesound();// 추상메서드 : 내용이 없음

    void eat() { // 일반 메서드
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal { // 상속받음

    public Dog(String name) {
        super(name);
    }

    @Override
    void makesound() {
        System.out.println(name + " 멍멍");
    }

}

class Cat extends Animal { // 상속받음

    public Cat(String name) {
        super(name);
    }

    @Override
    void makesound() {
        System.out.println(name + " 야옹");
    }

}

class Bird extends Animal { // 상속받음

    public Bird(String name) {
        super(name);
    }

    @Override
    void makesound() {
        System.out.println(name + " 야옹");
    }

}

public class Main3 {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy");
        dog.makesound();
        dog.eat();
        // 추상클래스는 직접 객체를 만들 수 없기 때문에
        // 자식클래스로 객체 생성함
        Animal cat = new Cat("나비");
        cat.makesound();
    }
}
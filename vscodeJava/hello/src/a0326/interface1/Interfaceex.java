package a0326.interface1;


interface Animal{
    void makeSound();
    
}

class Dog implements Animal{

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
    
}
class Cat implements Animal{

    @Override
    public void makeSound() {
        System.out.println("야옹");
    }
    
}

public class Interfaceex {
    public static void main(String[] args) {
        // 인터페이스는 자기 자신을 객체로 만들 수 없음
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.makeSound();
        cat.makeSound();
    }
}

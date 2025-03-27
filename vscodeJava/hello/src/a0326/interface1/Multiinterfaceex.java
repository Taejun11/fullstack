package a0326.interface1;

interface Flyable{
    void fly();
}
interface Swimable{
    void swim();
}
// 인터페이스는 한번에 여러 개 상속 가능
class Bird implements Flyable, Swimable{

    @Override
    public void fly() {
        System.out.println("새가 날음");
    }

    @Override
    public void swim() {
        System.out.println("새가 수영함");
    }

}


public class Multiinterfaceex {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        bird.swim();
    }
}

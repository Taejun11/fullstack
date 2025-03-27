package a0326.interface1;

interface Greeting{
    void hello();
    default void goodbye(){
        System.out.println("안녕히 가세요");
    }
}

class Person implements Greeting{

    @Override
    public void hello() {
        System.out.println("안녕하세요");
    }

    public void intro(){
        System.out.println("저는 person 클래스입니다.");
    }

}

public class Defaultmethodex {
    public static void main(String[] args) {
        Person person = new Person();
        person.hello();
        person.goodbye();
        person.intro();

        Greeting person1 = new Person();
        person1.hello();
        person1.goodbye();
        // person1.intro();
        if (person1 instanceof Person) {//부모자식 관계를 물어봄
            ((Person)person1).intro();
        }
    }
}

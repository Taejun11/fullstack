package a0324.rpg2;

public class Con1 {
    public static void main(String[] args) {
        new BBB();
    }
}

class AAA{
    AAA(){
        System.out.println("AAA() 생성자 호출 완료");
    }
}
class BBB extends AAA{
    BBB(){
        // super(); 생략되어 있음
        System.out.println("BBB() 생성자 호출 완료");
    }
}
// 상속 관계에서 자식 객체가 만들어지만 부모를 먼저 완성
// 자식 생성자는 부모 생성자를 반드시 호출함
// 부모 호출을 생략할 경우 자동으로 호출함
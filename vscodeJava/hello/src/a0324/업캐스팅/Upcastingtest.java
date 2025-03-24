package a0324.업캐스팅;

public class Upcastingtest {
    public static void main(String[] args) {
        Square s = new Square();
        s.name = "정사각형";
        Triangle t = new Triangle();
        t.name = "삼각형";
        Circle c = new Circle();
        c.name = "원";

        Shape[] shapes = {s, t, c};
        for(int i = 0; i < shapes.length; i++){
            System.out.printf("%d인 인덱스의 도형: %s\n", i, shapes[i].name);
        }
    }
}
// 상속관계가 정의된 자식객체는 부모의 타입으로 해석, 즉 업캐스팅 가능
// 서로 다른 자식객체를 부모의 타입으로 묶어서 관리 가능

// 부모클래스
class Shape{ //도형
    String name;
}
// 자식클래스
class Square extends Shape{
    
}
class Triangle extends Shape{

}
class Circle extends Shape{

}
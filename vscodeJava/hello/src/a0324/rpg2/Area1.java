package a0324.rpg2;

public class Area1 {
    public static void main(String[] args) {
        Square s = new Square();
        s.name = "정사각형";
        s.length = 3;
        Triangle t = new Triangle();
        t.name = "삼각형";
        t.base = 4;
        t.height = 3;
        Circle c = new Circle();
        c.name = "원";
        c.radius = 4;

        Shape[] shapes = {s, t, c};
        for(int i = 0; i < shapes.length; i++){
            System.out.printf("%s의 넓이: %.2f\n", shapes[i].name, shapes[i].area());
        }
    }
}
// 상속관계가 정의된 자식객체는 부모의 타입으로 해석, 즉 업캐스팅 가능
// 서로 다른 자식객체를 부모의 타입으로 묶어서 관리 가능

// 부모클래스
class Shape{ //도형
    String name;
    double area(){
        return 0;
    }
}
// 자식클래스
class Square extends Shape{
    int length;
    double area(){
        return length * length;
    }
    
}
class Triangle extends Shape{
    int base;
    int height;
    double area(){
        return (base * height) * 0.5;
    }

}
class Circle extends Shape{
    int radius;
    double area(){
        return radius * radius * Math.PI;
    }

}
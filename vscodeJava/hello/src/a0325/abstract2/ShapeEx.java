package a0325.abstract2;

abstract class Shape {
    String type;

    public Shape(String type) {
        this.type = type;
    }

    abstract double area();
    abstract double length();
}

class Circle extends Shape {
    int r;

    public Circle(int r) {
        super("원");
        this.r = r;
    }

    @Override
    double area() {
        return r * r * Math.PI;
    }

    @Override
    double length() {
        return 2 * r * Math.PI;
    }

    @Override
    public String toString() {
        return "shape [type=" + type + ", r=" + r + "]";
    }

}

class Rectangle extends Shape {
    int width, height;

    public Rectangle(int width, int height) {
        super("사각형");
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    double length() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "shape [type=" + type + ", width=" + width + ", height=" + height + "]";
    }

}

public class ShapeEx {
    public static void main(String[] args) {
        // Shape[] shapes = new Shape[2];
        // shapes[0] = new Circle(10);
        // shapes[1] = new Rectangle(5, 5);

        // for(Shape s : shapes){
        // System.out.println(s);
        // System.out.println("넓이: " + s.area() + " 둘레: " + s.length());
        // }
        Shape c = new Circle(10);
        System.out.println(c);
        System.out.println("넓이: " + c.area() + " 둘레: " + c.length());
        Shape r = new Rectangle(5, 5);
        System.out.println(r);
        System.out.println("넓이: " + r.area() + " 둘레: " + r.length());
    }
}

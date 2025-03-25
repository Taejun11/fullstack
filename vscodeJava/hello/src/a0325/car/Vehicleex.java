package a0325.car;

abstract class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    abstract void move();

    void displayInfo() {
        System.out.println("이 차량은 [" + name + "] 입니다.");
    }
}

class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    void move() {
        System.out.println("자동차 [" + name + "]이(가) 도로를 달립니다.");

    }

}

class Bicycle extends Vehicle {

    public Bicycle(String name) {
        super(name);
    }

    @Override
    void move() {
        System.out.println("자전거 [" + name + "]이(가) 페달을 밟으며 이동합니다.");
    }

}

public class Vehicleex {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Car("Car");
        vehicles[1] = new Bicycle("Bicycle");
        for (Vehicle v : vehicles) {
            v.displayInfo();
            v.move();
        }
    }
}

// 문제 1: 추상 클래스 정의 및 상속
// 다음 요구사항을 만족하는 **추상 클래스 Vehicle**을 작성하고, 이를 상속받는 Car와 Bicycle 클래스를 구현하세요.

// 요구사항
// Vehicle 클래스는 다음과 같은 속성과 메서드를 가집니다.

// String name (차량 이름)

// 생성자를 통해 name을 초기화

// abstract void move(); (추상 메서드)

// 일반 메서드 void displayInfo(); → "이 차량은 [name] 입니다." 출력

// Car 클래스와 Bicycle 클래스는 Vehicle 클래스를 상속받고, move() 메서드를 각각 다르게 구현하세요.

// Car 클래스: "자동차 [name]이(가) 도로를 달립니다." 출력

// Bicycle 클래스: "자전거 [name]이(가) 페달을 밟으며 이동합니다." 출력

// main 메서드를 작성하여 Car와 Bicycle 객체를 생성하고 displayInfo() 및 move() 메서드를 호출하세요.

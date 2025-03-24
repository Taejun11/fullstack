package a0324.rpg2;

public class Cartest {
    public static void main(String[] args) {
        Truck t = new Truck("봉고", 1.5);
    }
}

class Car {
    String name;

    public Car(String _name) {
        name = _name;
        System.out.printf("모델명: %s\n", name);
    }
    void move(){
        System.out.printf("[%s]가 이동\n", name);
    }
}

class Truck extends Car{
    double payload;

    public Truck(String _name, double _payload) {
        super(_name); //부모생성자 호출
        payload = _payload;
    }
    void load(){
        System.out.printf("[%s]가 물건을 적재함 (최대 %.f톤)\n", name, payload);
    }
}
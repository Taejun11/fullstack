package a0321.account;

public class Avengertest {
    public static void main(String[] args) {
        // 객체 만들기와 생성자 호출을 동시에
        Avenger ironman = new Avenger("아이언맨", 100, 120);
        Avenger hulk = new Avenger("헐크", 200, 80);

        System.out.println(ironman.toStr());
        System.out.println(hulk.toStr());
    }
}

class Avenger{
    private String name;
    private int power;
    private int speed;
    public Avenger(String name, int power, int speed) {
        this.name = name;
        this.power = power;
        this.speed = speed;
    }

    public String toStr(){
        return String.format("Avenger(name: %s, power: %d, speed: %d)", name, power, speed);
    }
}
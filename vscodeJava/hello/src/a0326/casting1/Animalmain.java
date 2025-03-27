package a0326.casting1;

public class Animalmain {
    public static void main(String[] args) {
        Animal eagle = new Eagle();
        eagle.sleep();
        // eagle.eat();

        Eagle eagle2 = (Eagle) eagle; //강제 형변환
        eagle2.eat();;
    }
}

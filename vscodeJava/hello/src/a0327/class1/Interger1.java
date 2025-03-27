package a0327.class1;

public class Interger1 {
    public static void main(String[] args) {
        int a = 10; //기본형
        // wrapper 클래스
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(20);
        Integer num3 = new Integer(10);

        System.out.println(num1 < num2);
        System.out.println(num1 == num3);
        System.out.println(num1.equals(num1));
    }
}

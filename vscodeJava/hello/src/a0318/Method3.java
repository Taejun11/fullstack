package a0318;

public class Method3 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;


        System.out.println("덧셈: " + Calculator.add(num1, num2));
        System.out.println("뺄셈: " + Calculator.minus(num1, num2));
        System.out.println("나눗셈: " + Calculator.div(num1, num2));
        System.out.println("나눗셈: " + Calculator.div(num1, 0));
    }
}

class Calculator {

    public static int add(int a, int b) {
        return a+b;
    }
    public static int minus(int a, int b) {
        return a-b;
    }
    public static int multi(int a, int b) {
        return a*b;
    }
    public static double div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없음");
        }
        return (double) a/b;
    }

}
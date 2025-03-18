package a0318;

public class Method5 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        Calculator2 calc2 = new Calculator2();
        // 객체 생성 형식
        // 클래스명 변수명 = new 클래스명();

        calc2.add(num1, num2);
        System.out.println("뺄셈: " + Calculator2.minus(num1, num2));
        System.out.println("나눗셈: " + Calculator2.div(num1, num2));
        System.out.println("나눗셈: " + Calculator2.div(num1, 0));
    }
}

class Calculator2 {

    public void add(int a, int b) {
        // return a+b;
        // void : return 값이 없을 경우 함수 이름 앞에 붙임
        // 객체를 만들 경우 static 필요없음
        // static : 객체 생성 없이 호출 할 경우 붙임
        System.out.println("덧셈: "+ (a+b));
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
package a0318;

public class Method2 {
    public static void main(String[] args) {

        int sum1 = add(5, 10);
        System.out.println("결과1 출력: " + sum1);
        int sum2 = add(15, 90);
        System.out.println("결과2 출력: " + sum2);
        int sum3 = minus(65, 7);
        System.out.println("결과3 출력: " + sum3);
        int sum4 = multi(6, 12);
        System.out.println("결과4 출력: " + sum4);
        int sum5 = div(90, 15);
        System.out.println("결과5 출력: " + sum5);
    }

    public static int add(int a, int b) {//더하기
        System.out.println(a + " + " + b + " 연산수행 ");
        int sum = a + b;
        return sum;
    }
    // 더하기 빼기 곱하기 나누기 함수 만들기

    public static int minus(int a, int b){//빼기
        System.out.println(a + " - " + b + " 연산수행 ");
        int sum = a - b;
        return sum;
    }
    public static int multi(int a, int b){//곱하기
        System.out.println(a + " * " + b + " 연산수행 ");
        int sum = a * b;
        return sum;
    }
    public static int div(int a, int b){//나누기
        System.out.println(a + " / " + b + " 연산수행 ");
        int sum = a / b;
        return sum;
    }
}

package a0318;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println(max(10, 20));
        System.out.println(max(5, 3));

        System.out.println(evenorodd(4));
        System.out.println(evenorodd(7));

        System.out.println(factorial(5));
        System.out.println(factorial(3));
    }

    public static int max(int i, int j) {// 1번문제
        if (i >= j) {
            return i;
        } else {
            return j;
        }
    }

    public static String evenorodd(int i) {// 2번문제
        if (i % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    public static int factorial(int n) {// 4번문제
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}

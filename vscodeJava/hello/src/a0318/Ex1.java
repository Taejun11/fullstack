package a0318;

public class Ex1 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println("x = " + x);
        print(x);
        System.out.println("x = " + x);
        // main의 변수가 영향을 안받음
    }

    public static void print(int x) {
        System.out.println("x = " + x);
        x = x + 10;
        System.out.println("x = " + x);

    }
}

package a0313;

public class Comp1 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(a == b);//f
        System.out.println(a != b);//t
        System.out.println(a > b);//f
        System.out.println(a < b);//t
        System.out.println(a >= b);//f
        System.out.println(a <= b);//t

        boolean result = a == b;
        System.out.println(result);//f
    }
}

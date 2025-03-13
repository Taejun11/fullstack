package a0313;

public class Logical1 {
    public static void main(String[] args) {
        System.out.println("&&: and연산");
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && false);
        
        System.out.println("||: or연산");
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || false);

        System.out.println("!: not연산");
        System.out.println(!true);
        System.out.println(!false);

        System.out.println("변수 활용");
        boolean a = true;
        boolean b = false;
        System.out.println(a && b);//f
        System.out.println(a || b);//t
        System.out.println(!a);//f
        System.out.println(!b);//t

    }
}

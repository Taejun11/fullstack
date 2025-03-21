package a0321;

public class Mymath1 {
    public static void main(String[] args) {
        Mymath mm = new Mymath();

        int m1 = mm.add(5, 6);
        int m2 = mm.minus(5, 6);
        int m3 = mm.multi(5, 6);
        int m4 = mm.div(5, 6);
        int m5 = mm.max(5, 6);

        System.out.println("m1 = "+m1);
        System.out.println("m2 = "+m2);
        System.out.println("m3 = "+m3);
        System.out.println("m4 = "+m4);
        System.out.println("m5 = "+m5);
    }
}

// 사칙연산을 수행하는 메서드를 가진 mymath 클래스

class Mymath{
    int add(int a, int b){
        int result = a + b;
        return result;
    }
    int minus(int a, int b){
        int result = a - b;
        return result;
    }
    int multi(int a, int b){
        int result = a * b;
        return result;
    }
    int div(int a, int b){
        int result = a / b;
        return result;
    }
    // 큰 수 구하기
    int max(int a, int b){
        int result;
        if (a > b) {
            result = a;
        }else{
            result = b;
        }
        return result;
    }
}
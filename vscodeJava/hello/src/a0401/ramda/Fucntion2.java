package a0401.ramda;

public class Fucntion2 {

    public static void main(String[] args) {
        Calc1 mc = (int a, int b) -> a + b;
        // ->를 이용하면 실제 클래스가 없어도 객체를 생성할 수 있음
        int result = mc.sum(3, 4);
        System.out.println(result);
    }
}

interface Calc1 {
    int sum(int a, int b);
    
}


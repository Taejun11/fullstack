package a0401.ramda;

public class Fucntion3 {

    public static void main(String[] args) {
        Calc2 mc = Integer::sum;
        // ::sum : 각 요소를 합산하라는 뜻
        int result = mc.sum(3, 4);
        System.out.println(result);
    }
}

interface Calc2 {
    int sum(int a, int b);
    
}


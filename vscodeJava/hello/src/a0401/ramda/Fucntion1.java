package a0401.ramda;
public class Fucntion1 {

    public static void main(String[] args) {
        Mycalc mc = new Mycalc();
        int result = mc.sum(3, 4);
        System.out.println(result);
    }
}

interface Calc {
    int sum(int a, int b);
    
}

class Mycalc implements Calc{

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

}
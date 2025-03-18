package a0318;

public class RandomNumber {
    public static void main(String[] args) {
        int n = rollDice();
        System.out.printf("주사위의 눈: %d", n);
    }

    private static int rollDice() {
        // return (int) (Math.random() * 6) + 1;
        // // return r;
        double x = 6 * Math.random();
        int temp = (int) x;
        return temp + 1;
    }

}

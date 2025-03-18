package a0318;

public class SquareV {
    public static void main(String[] args) {
        int n = 4;
        int s = squareV(n);
        System.out.printf("한 변의 길이가 %d인 정육면체의 부피: %d", n, s);
    }

    public static int squareV(int length) {
        return length * length * length;
    }

}
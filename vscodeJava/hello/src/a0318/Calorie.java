package a0318;

public class Calorie {
    public static void main(String[] args) {
        int n = 10;
        double cal = calorie(n);
        System.out.printf("삼겹살 %d인분의 칼로리: %.2f kcal", n, cal);
    }

    public static double calorie(int n) {
        double kcal = n * 180 * 5.179;
        return kcal;
    }

}
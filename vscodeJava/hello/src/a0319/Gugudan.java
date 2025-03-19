package a0319;

public class Gugudan {
    public static void main(String[] args) {
        int[][] gugudan = new int[10][10];
        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                gugudan[i][j] = i*j;
            }
        }
        System.out.printf("7 * 2 = %d\n", gugudan[7][2]);
        System.out.printf("9 * 4 = %d\n", gugudan[9][4]);
    }
}

package a0319;

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        int[][] score = {
                { 100, 95, 46 },
                { 20, 20, 20 },
                { 30, 30, 30 },
                { 40, 40, 40 }
        };
        int sum = 0;
        double avg = 0;
        int[] lastSum = new int[score.length];

        System.out.println("번호  국어  영어  수학  합계  평균");
        System.out.println("=====================================");
        for (int i = 0; i < score.length; i++) {
            System.out.print(i + 1 + "    ");
            sum = 0;
            avg = 0;
            for (int j = 0; j < score[i].length; j++) {
                System.out.printf("%4d", score[i][j]);
                sum += score[i][j];
                avg = sum / (double) 3;
                lastSum[j] += score[i][j];
            }
            // lastSum[i] = sum;
            System.out.printf("%4d %.1f", sum, avg);
            System.out.println();
        }
        System.out.println("=====================================");
        System.out.printf("총점: %4d %4d %4d",lastSum[0],lastSum[1],lastSum[2]);
    }

}

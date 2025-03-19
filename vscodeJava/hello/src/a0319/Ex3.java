package a0319;

import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        int[][] score = {
                { 100, 95, 46 },
                { 20, 20, 20 },
                { 30, 30, 30 },
                { 40, 40, 40 }
        };
        System.out.println("번호  국어  영어  수학  합계  평균");
        System.out.println("=====================================");
        rowsum(score);
        System.out.println("=====================================");
        colsum(score);

    }

    public static void rowsum(int[][] score) {// 배열 한 행의 합을 구하는 함수
        for (int i = 0; i < score.length; i++) {
            System.out.print(i + 1 + "    ");
            int sum = 0;
            double avg = 0;
            for (int j = 0; j < score[i].length; j++) {
                System.out.printf("%4d", score[i][j]);
                sum += score[i][j];
                avg = sum / (double) 3;
            }
            System.out.printf("%4d %.1f", sum, avg);
            System.out.println();
        }
    }

    public static void colsum(int[][] score) {// 배열 한 열의 합을 구하는 함수
        int[] colSum = new int[score.length];
        for(int i = 0; i <score.length; i++){
            for(int j = 0; j < score[i].length; j++){
                colSum[j] += score[i][j];
            }
        }
        System.out.printf("총점: %4d %4d %4d",colSum[0],colSum[1],colSum[2]);

    }

}
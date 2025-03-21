package a0320;

import java.util.Arrays;

public class Sum1 {
    public static void main(String[] args) {
        int[][] score = {
                { 100, 95, 46 },
                { 20, 20, 20 },
                { 30, 30, 30 },
                { 40, 40, 40 }
        };
        int kor = 0;
        int eng = 0;
        int mat = 0;
        System.out.println("번호  국어  영어  수학  합계  평균");
        System.out.println("===================================");

        for(int i = 0; i < score.length; i++){
            int sum = 0;
            float avg = 0f;
            // 과목별 총점
            kor = kor + score[i][0]; //국어 총점
            eng = eng + score[i][1]; //영어 총점
            mat = mat + score[i][2]; //수학 총점
            System.out.printf("%d",i+1);
            for(int j = 0; j < score[i].length; j++){
                sum = sum + score[i][j];//가로 합계
                System.out.printf("%5d", score[i][j]);//각 배열 출력
            }
            avg = sum / (float)score[i].length;
            System.out.printf("%5d %5.1f\n",sum,avg);
        }
        System.out.println("===================================");
        System.out.printf("총점: %4d %4d %4d", kor, eng, mat);


        // int k = score.length; //4 , 행 개수
        // System.out.println(k);
        // int m = score[0].length; //3 , 열 개수
        // System.out.println(m);
    }

}

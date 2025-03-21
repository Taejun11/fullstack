package a0320;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;

        while (run) {
            System.out.println("-----------------------------------------------");
            System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
            System.out.println("-----------------------------------------------");
            System.out.printf("선택> ");

            int select = scan.nextInt();

            if (select == 1) {
                System.out.printf("학생수>");
                studentNum = scan.nextInt();
                scores = new int[studentNum];
            }else if(select == 2){
                for (int i = 0; i < scores.length; i++) {
                    System.out.printf("scores[%d]>", i);
                    scores[i] = scan.nextInt();
                }
            }
            else if(select == 3){
                for (int i = 0; i < scores.length; i++) {
                    System.out.printf("scores[%d]: %d\n", i, scores[i]);
                }
            }
            else if(select == 4){
                int max = 0;
                int sum = 0;
                for (int j = 0; j < scores.length; j++) {
                    if (max < scores[j]) {
                        max = scores[j];
                    }
                    sum += scores[j];
                }
                double avg = sum / (double)scores.length;
                System.out.printf("최고 점수: %d\n", max);
                System.out.printf("평균 점수: %.1f\n", avg);
            }else if(select == 5){
                System.out.println("프로그램 종료");
                run = false;
            }
        }
        
        scan.close();
    }
}
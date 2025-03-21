package a0320;

import java.util.Scanner;

public class Ex1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int select = 0;
        int[] scores = new int[0];

        while (select != 5) {
            header();
            select = scan.nextInt();

            switch (select) {
                case 1:
                    System.out.printf("학생수>");
                    int head = scan.nextInt();
                    scores = new int[head];
                    break;
                case 2:
                    for (int i = 0; i < scores.length; i++) {
                        System.out.printf("scores[%d]>", i);
                        scores[i] = scan.nextInt();
                    }
                    break;
                case 3:
                    for (int i = 0; i < scores.length; i++) {
                        System.out.printf("scores[%d]: %d\n", i, scores[i]);
                    }
                    break;
                case 4:
                    int max = 0;
                    int sum = 0;
                    for (int j = 0; j < scores.length; j++) {
                        if (max < scores[j]) {
                            max = scores[j];
                        }
                        sum += scores[j];
                    }
                    double avg = sum / (double) scores.length;
                    System.out.printf("최고 점수: %d\n", max);
                    System.out.printf("평균 점수: %.1f\n", avg);
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    break;

                default:
                    System.out.println("다시입력");
                    break;
            }

        }
        scan.close();
    }

    public static void header() {
        System.out.println("-----------------------------------------------");
        System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
        System.out.println("-----------------------------------------------");
        System.out.printf("선택> ");
    }
}
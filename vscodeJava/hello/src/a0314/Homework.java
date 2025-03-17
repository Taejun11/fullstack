package a0314;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        // 사용자로부터 세 개의 정수를 입력받아, 가장 큰 수를 출력하는 프로그램을 작성하세요.
        // if문으로

        Scanner scan = new Scanner(System.in);
        System.out.println("정수를 세 개 입력하세요: ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if (a > b) {
            if (a > c) {
                System.out.println("가장 큰 수는 " + a);
            } else {
                System.out.println("가장 큰 수는 " + c);
            }

        } else if (b > c) {
            System.out.println("가장 큰 수는 " + b);
        }else {
            System.out.println("가장 큰 수는 " + c);
        }
    }
}

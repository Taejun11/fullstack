package a0314;

import java.util.Scanner;

public class Scanner3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("두 개의 정수를 입력하세요: ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.printf("%d %d",a ,b);

        scan.close();
    }
    
}
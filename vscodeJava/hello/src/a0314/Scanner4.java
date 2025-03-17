package a0314;

import java.util.Scanner;

public class Scanner4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("숫자를 입력하세요: ");
        float a = scan.nextFloat();
        a = (a + 0.005f) * 100;
        int i = (int)a;
        a = (float)i / 100;
        // 자동 반올림기능 내장
        System.out.printf("%.2f",a);

        scan.close();
    }
    
}
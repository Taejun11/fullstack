package a0314;

import java.util.Scanner;

public class If3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // int price = 10000;
        // int age = 10;
        // int disconut = 0;
        // 스캐너로 가격, 나이 입력받고 할인금액, 결제금액 출력

        System.out.println("가격을 입력하세요:");
        int price = scan.nextInt();
        System.out.println("나이를 입력하세요:");
        int age = scan.nextInt();
        int disconut = 0;
        if (price >= 10000) {
            disconut += 1000;
            System.out.println("10000원 이상 1000원 할인");
        }
        if (age <= 10) {
            disconut += 1000;
            System.out.println("어린이 1000원 할인");
        }
        // System.out.println(price);
        // System.out.println(disconut);
        System.out.println("할인금액= "+disconut);
        System.out.println("결제금액= "+(price-disconut));

        scan.close();
    }
}

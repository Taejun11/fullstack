package a0314;

import java.util.Scanner;

public class Switch2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("회원 등급을 정수로 입력하세요: ");
        int grade = scan.nextInt();

        int coupon = switch (grade) {
            //break없으면 다음 case까지 실행
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default -> 500;
        };
        System.out.println("발급받은 쿠폰 "+coupon);
        scan.close();
    }
}

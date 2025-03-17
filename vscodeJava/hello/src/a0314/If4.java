package a0314;

import java.util.Scanner;

public class If4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("회원 등급을 정수로 입력하세요: ");
        int grade = scan.nextInt();
        int coupon = 0;


        if (grade == 1) {
            coupon = 1000;
        }else if (grade == 2) {
            coupon = 2000;
        }else if (grade == 3) {
            coupon = 3000;
        }else{
            coupon = 500;
        }
        System.out.println("발급받은 쿠폰 "+coupon);
        
        scan.close();
    }
}

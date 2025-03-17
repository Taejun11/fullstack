package a0314;

import java.util.Scanner;

public class Scanner5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("월을 나타내는 정수를 입력하세요(1~12): ");
        int month = scan.nextInt();

        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("겨울");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
        
            default:
                System.out.println("잘못된 입력");
                break;
        }
        scan.close();
    }
}

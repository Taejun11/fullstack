package a0314;

import java.util.Scanner;

public class Switch4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("학점을 알파벳(대문자)으로 입력하세요:");

        String grade = scan.nextLine();

        switch (grade) {
            case "A":
                System.out.println("탁월");
                break;
            case "B":
                System.out.println("좋음");
                break;
            case "C":
                System.out.println("준수");
                break;
            case "D":
                System.out.println("향상필요");
                break;
            case "F":
                System.out.println("불합격");
                break;
        
            default:
                System.out.println("잘못입력");
                break;
        }
        scan.close();
    }
}

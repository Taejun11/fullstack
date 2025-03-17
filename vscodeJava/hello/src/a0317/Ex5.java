package a0317;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int select = 0; //선택한 번호
        int bank = 0; //잔고

        do {
            System.out.println("----------------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("----------------------------------");
            System.out.print("선택>");
            select = scan.nextInt();

            switch (select) {
                case 1:
                    System.out.print("예금액>");
                    bank += scan.nextInt();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("출금액>");
                    bank -= scan.nextInt();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("잔고>");
                    System.out.println(bank);
                    System.out.println();
                    break;
                case 4:

                    break;

                default:
                    System.out.println("선택오류");
                    System.out.println();
                    break;
            }

            
        } while (select != 4);

        scan.close();
    }
}

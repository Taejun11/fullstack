package a0317;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int select = 0; //선택한 번호
        int result = 0; //연산값
        int num1 = 0;
        int num2 = 0;

        do {
            System.out.println("----------------------------------");
            System.out.println("1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.종료");
            System.out.println("----------------------------------");
            System.out.print("선택>");
            select = scan.nextInt();

            if (select == 5) {
                continue;
            }
            System.out.print("첫번째 숫자>");
            num1 = scan.nextInt();
            System.out.print("두번째 숫자>");
            num2 = scan.nextInt();
            switch (select) {
                case 1://덧셈
                    result = num1 + num2;
                    System.out.println("결과: " + num1 + " + " + num2 + " = " + result);
                    break;
                case 2://뺄셈
                    result = num1 - num2;
                    System.out.println("결과: " + num1 + " - " + num2 + " = " + result);
                    break;
                case 3://곱셈
                    result = num1 * num2;
                    System.out.println("결과: " + num1 + " * " + num2 + " = " + result);
                    break;
                case 4:// 나눗셈
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없음");
                        break;
                    } else {
                        result = num1 / num2;
                        System.out.println("결과: " + num1 + " / " + num2 + " = " + result);
                        break;
                    }
                // case 5://종료

                //     break;

                default:
                    System.out.println("선택오류");
                    System.out.println();
                    break;
            }
            System.out.println();      
        } while (select != 5);

        scan.close();
    }
}

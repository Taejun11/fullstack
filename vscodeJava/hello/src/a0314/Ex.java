package a0314;

import java.util.Scanner;

public class Ex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String traffic;
        int distance = 0;
        System.out.println("이동할 거리를 입력하세요: ");
        distance = scan.nextInt();
        traffic = (distance <= 1) ? "도보"  : (distance > 1) && (distance <= 10) ? "자전거" : (distance > 10) && (distance <= 100) ? "자동차" : "비행기";

        System.out.println(traffic+ "를 이용하세요.");
        scan.close();
    }
}

package a0314;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double rating;
        System.out.println("추천받을 평점을 입력하세요: ");
        rating = scan.nextDouble();
        if (rating <= 9) {
            System.out.println("'어바웃타임' 추천");
        }
        if (rating <= 8) {
            System.out.println("'토이스토리' 추천");
        }
        if (rating <= 7) {
            System.out.println("'고질라' 추천");
        }
        scan.close();
    }
    
        
}
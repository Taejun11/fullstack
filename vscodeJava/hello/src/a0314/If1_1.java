package a0314;

import java.util.Scanner;

public class If1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("나이를 입력하세요: ");
        int age = scan.nextInt();
        if (age >= 18) 
            System.out.println("성인");
        else
            System.out.println("미성년자");
        
        scan.close();
    }
    
}
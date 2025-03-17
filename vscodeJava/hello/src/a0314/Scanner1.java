package a0314;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("단어를 입력하세요: ");
        String word = scan.next();
        
        System.out.println("입력한 단어: "+word);

        scan.close();
    }
    
}
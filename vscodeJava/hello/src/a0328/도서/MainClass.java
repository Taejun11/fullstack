package a0328.도서;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        BookDAO book = new BookDAO(); // 데이터들 넣고 시작
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("===== 📚 도서 관리 시스템 =====");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 수정");
            System.out.println("5. 도서 목록 보기");
            System.out.println("6. 파일로 저장");
            System.out.println("7. 파일에서 불러오기");
            System.out.println("0. 종료");
            System.out.print(">>");
            int choice;
            // choice에 다른 변수 들어가는 예외 상정
            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                choice = -1;
            }
            // choice에 정상적인 변수가 들어온 상황
            if (choice == 1) {
                // 도서 추가
                book.addBook();
            } else if (choice == 2) {
                // 도서 삭제
                book.delBook();
            } else if (choice == 3) {
                // 도서 검색
                book.searchBook();
            } else if (choice == 4) {
                // 도서 수정
                book.updateBook();
            } else if (choice == 5) {
                // 도서 목록 보기
                book.all();
            } else if (choice == 6) {
                // 파일로 저장
                try {
                    book.save();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (choice == 7) {
                // 파일 불러오기
                book.load();
            } else if (choice == 0) {
                // 종료하기
                System.out.println("시스템 종료");
                scan.close();
                System.exit(0);
            } else {
                System.out.println("다시 선택해주세요.");
            }
        }
    }
}

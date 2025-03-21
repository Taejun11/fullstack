package a0321.book;

import java.util.Scanner;

public class Book {
    private static Library[] libraryArray = new Library[100];
    // 책정보를 하나의 배열에 저장
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("---------------------------------------------------");
            System.out.println("1.책 추가|2.책 목록 조회|3.책 대출|4.책 반납|5.종료");
            System.out.println("---------------------------------------------------");
            System.out.print("선택>");
            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                addbook();
            } else if (select == 2) {
                listbook();
            } else if (select == 3) {
                borrowBook();
            } else if (select == 4) {
                returnBook();
            } else if (select == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }

    // 책 추가 함수
    private static void addbook() {
        System.out.println("---------");
        System.out.println("책 추가");
        System.out.println("---------");

        System.out.print("책 제목: ");
        String title = scan.nextLine();
        System.out.print("책 저자: ");
        String author = scan.nextLine();
        System.out.print("책 상태: ");// Borrowed , Available
        String status = scan.nextLine();

        Library newBook = new Library(title, author, status);
        for (int i = 0; i < libraryArray.length; i++) {
            if (libraryArray[i] == null) {
                libraryArray[i] = newBook;
                System.out.println("책 추가 완료");
                break;
            }
        }
    }

    // 책 목록 조회 함수
    private static void listbook() {
        System.out.println("---------");
        System.out.println("책 목록");
        System.out.println("---------");

        for (int i = 0; i < libraryArray.length; i++) {
            Library book = libraryArray[i];
            if (book != null) {
                System.out.print("책 제목: " + book.getTitle() + " | ");
                System.out.print("책 저자: " + book.getAuthor() + " | ");
                System.out.println("책 상태: " + book.getStatus());
            }
        }
    }

    // 책 대출 함수
    private static void borrowBook() {
        System.out.println("---------");
        System.out.println("책 대출");
        System.out.println("---------");
        System.out.print("대출할 책 제목: ");
        String title = scan.nextLine();
        Library book = findbook(title);

        if (book != null) {
            if (book.getStatus().equals("Available")) {
                System.out.println("대출 완료");
                book.setStatus("Borrowed");
            } else {
                System.out.println("이미 대출 중인 책입니다.");
            }
        } else {
            System.out.println("해당 책은 등록되지 않은 책입니다.");
            return;
        }
    }

    // 책 반납 함수
    private static void returnBook() {
        System.out.println("---------");
        System.out.println("책 반납");
        System.out.println("---------");
        System.out.print("반납할 책 제목: ");
        String title = scan.nextLine();
        Library book = findbook(title);

        if (book != null) {
            if (book.getStatus().equals("Borrowed")) {
                System.out.println("반납 완료");
                book.setStatus("Available");
            } else {
                System.out.println("이미 반납된 책입니다.");
            }
        } else {
            System.out.println("해당 책은 등록되지 않은 책입니다.");
            return;
        }
    }

    // 책 대출, 반납 함수에 쓰일 책 찾기 함수
    private static Library findbook(String title) {
        Library book = null;
        for (int i = 0; i < libraryArray.length; i++) {
            if (libraryArray[i] != null) {
                String dbBook = libraryArray[i].getTitle();
                if (dbBook.equals(title)) {
                    book = libraryArray[i];
                    break;

                }
            }
        }
        return book;
    }
}

// 문제: 도서 관리 프로그램
// 요구 사항:
// 도서 관리 프로그램을 작성해 주세요. 사용자는 책을 추가하고, 책 목록을 확인하며, 책을 대출하거나 반납할 수 있어야 합니다.

// 기능:
// 책 추가: 새로운 책을 목록에 추가합니다. (책 제목, 저자, 대출 여부)
// 책 목록 조회: 전체 책 목록을 보여줍니다.
// 책 대출: 책을 대출할 수 있습니다. 대출된 책은 대출 여부가 '대출 중'으로 표시됩니다.
// 책 반납: 대출된 책을 반납할 수 있습니다. 반납된 책은 '대출 가능' 상태로 바뀝니다.
// 프로그램 종료: 프로그램을 종료합니다.

package a0328.도서;

import java.util.ArrayList;
import java.util.Scanner;

public class BookDAO {
    private ArrayList<BookDTO> books;
    Scanner scan = new Scanner(System.in);
    FileClass file = new FileClass("도서", "도서목록");

    public BookDAO() {// 더미데이터
        books = new ArrayList<BookDTO>();
        books.add(new BookDTO("자바의 정석", "남궁성", "12345", 32000));
        books.add(new BookDTO("Effective Java", "Joshua Bloch", "54321", 45000));
        books.add(new BookDTO("Clean Code", "Robert C. Martin", "67890", 38000));
        books.add(new BookDTO("스프링 부트와 AWS", "이동욱", "98765", 28000));
        books.add(new BookDTO("코틀린 인 액션", "Dmitry Jemerov", "13579", 40000));
    }

    public void addBook() {// 1번
        BookDTO b = new BookDTO();
        System.out.print("책 제목: ");
        b.setTitle(scan.nextLine());
        System.out.print("저자: ");
        b.setAuthor(scan.nextLine());
        System.out.print("ISBN: ");
        b.setIsbn(scan.nextLine());
        System.out.print("가격: ");
        b.setPrice(scan.nextDouble());
        scan.nextLine();
        books.add(b);
        System.out.println("📖 도서 추가 완료!");
    }

    public void delBook() {// 2번
        System.out.print("삭제하고싶은 책의 ISBN을 입력하세요>> ");
        String delIsbn = scan.nextLine();
        int check = search(delIsbn);
        if (check == -1) {
            System.out.println("해당하는 책이 없습니다.");
        } else {
            String msg = books.get(check).getTitle();
            books.remove(check);
            System.out.println("\"" + msg + "\"" + " 책을 삭제했습니다.");
        }

    }

    private int search(String delIsbn) {// 찾기 함수
        int check = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(delIsbn)) {
                check = i;
                break;
            }
        }
        return check;
    }

    public void searchBook() {// 3번
        System.out.print("찾고싶은 책의 ISBN을 입력하세요>>");
        String want = scan.nextLine();
        int check = search(want);
        if (check == -1) {
            System.out.println("해당하는 책이 없습니다.");
        } else {
            BookDTO wantone = returnBook(check);
            System.out.println(wantone);
        }
    }

    private BookDTO returnBook(int check) {// 3번
        return books.get(check);
    }

    public void updateBook() {// 4번
        System.out.print("가격을 수정할 책의 ISBN을 입력해주세요>>");
        String updateIsbn = scan.nextLine();
        int check = search(updateIsbn);
        if (check == -1) {
            System.out.println("해당하는 책이 없습니다.");
        } else {
            BookDTO b = new BookDTO();
            b.setTitle(books.get(check).getTitle());// 고정할 정보
            b.setAuthor(books.get(check).getAuthor());// 고정할 정보
            b.setIsbn(books.get(check).getIsbn());// 고정할 정보
            System.out.print("수정할 가격을 입력해주세요>>");
            b.setPrice(scan.nextDouble());
            scan.nextLine();
            books.set(check, b);
            System.out.println("수정이 완료되었습니다.");
        }
    }

    public void all() {// 5번
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
    }

    public void save() throws Exception {// 6번
        file.create();
        String str = "";
        for (int i = 0; i < books.size(); i++) {
            str += books.get(i).toString() + "\n";
        }
        file.write(str);
    }

    public void load() {// 7번
        try {
            file.read();
        } catch (Exception e) {
            System.out.println("읽을 파일이 없습니다.");
        }
    }

}

package a0325.도서1;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private ArrayList<Library> librarys; //객체를 배열로 받아서 저장할 수 있는 종류
    private ArrayList<Library> booklocation; //객체중 대여한 객체를 저장할 수 있는 종류

    public LibraryManager() {
        librarys = new ArrayList<>(); //실제 책 목록을 담을 리스트
        booklocation = new ArrayList<>(); // 대출한 책 목록을 담을 리스트
        librarys.add(new Library("This is Java", "Shin", "SectionA", "979-11-691-229-8"));
        librarys.add(new Library("First Encounter with React", "Lee", "SectionB", "979-11-6921-169-7"));
        librarys.add(new Library("The Principles of Web Standards", "Ko", "SectionC", "979-11-6303-622-7"));
    }

    public void allLibrary() {
        System.out.println("대출 가능한 도서 보기");
        for (int i = 0; i < librarys.size(); i++) {
            Library library = librarys.get(i);
            if (library.isAvailable()) {
                System.out.println(library);
            }
        }
        // for(Library library: librarys){
        //     if (library.isAvailable()) {
        //         System.out.println(library);
        //     }
        // }
    }

    public boolean booklocations(String name){
        for(Library library: librarys){
            if (library.getTitle().equalsIgnoreCase(name) && library.isAvailable()) {
                library.book(); //대출이 실행되면 대출 불가능으로 변경
                booklocation.add(library);
                return true;
            }
        }
        return false;
    }

    public void booklocation() {
        System.out.println("대출한 도서");
        for(Library location : booklocation){
            System.out.println(location);
        }
    }

    public void addLibrary(String newTitle, String newAuthor, String newLocation, String newIsbn) {
        librarys.add(new Library(newTitle, newAuthor, newAuthor, newIsbn));
    }

    public void delLibrary(String dname) {
        boolean result = false; //도서의 삭제 여부 파악
        for(Library library: librarys){
            if (library.getTitle().equalsIgnoreCase(dname)) {
                if (library.isAvailable()) {//대여중이 아닐 경우 -> 대여가 가능한 상황일 경우 실행
                    librarys.remove(library);
                    result = true;
                    break;
                }else{
                    result = false;
                    break;
                }
            }
        }
        if (result) {
            System.out.println("삭제 완료");
        }else{
            System.out.println("삭제 불가");
        }
    }

    public void updateLibrary(String uname) {
        int i = 0;
        int index = -1;
        int menu = -1;
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        Library newA = new Library();//빈 객체
        System.out.println(uname);
        for(Library a : librarys){ //리스트를 수행하며 같은 이름 찾기
            i++;
            if (a.getTitle().equals(uname)) {
                index = i - 1;
                newA = a; //같은 이름의 객체를 찾으면 빈 객체에 넣어놓음
            }
            System.out.println(a.getTitle().equals(uname) + " " + a.getTitle() + " " + uname);
        }
        if (index != -1) { //같은 이름의 객체를 찾은 경우
            System.out.print("수정할 사항을 입력하세요.\n 1.도서 이름 \t 2.도서 저자 \t 3.도서 위치 \t 4.도서ISBN \n >>");
            menu = scan.nextInt();
            scan.nextLine();
            while (flag) {
                switch (menu) {
                    case 1:
                        System.out.println("수정할 도서 이름으로 입력하세요.");
                        newA.setTitle(scan.nextLine());
                        librarys.set(index, newA); //인덱스 수정 기능
                        flag = false;
                        break;
                    case 2:
                        System.out.println("수정할 도서 저자로 입력하세요.");
                        newA.setAuthor((scan.nextLine()));;
                        librarys.set(index, newA); //인덱스 수정 기능
                        flag = false;
                        break;
                    case 3:
                        System.out.println("수정할 도서 위치로 입력하세요.");
                        newA.setLocation((scan.nextLine()));
                        librarys.set(index, newA); //인덱스 수정 기능
                        flag = false;
                        break;
                    case 4:
                        System.out.println("수정할 도서 ISBN으로 입력하세요.");
                        newA.setIsbn((scan.nextLine()));
                        librarys.set(index, newA); //인덱스 수정 기능
                        flag = false;
                        break;
                
                    default:
                        System.out.println("다시 입력해주세요.");
                        break;
                }
            }
        }else{
            System.out.println("찾는 도서가 없습니다.");
        }
        scan.close();
    }

    public void showLibrary(String sname) {
        for(Library a: librarys){
            if (a.getTitle().equalsIgnoreCase(sname)) {
                System.out.println(a.toString());
            }
        }
    }
}

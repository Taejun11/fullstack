package a0324.도서1;

import java.util.ArrayList;

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
}

package a0325.도서1;

public class Library {
    private String title; // 책 제목
    private String author; // 책 저자
    private String location; //책 위치
    private String isbn;
    private boolean available;

    public Library(){} //기본 생성자

    public Library(String title, String author, String location, String isbn) {
        this.title = title;
        this.author = author;
        this.location = location;
        this.isbn = isbn;
        this.available = true;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "책 제목: " + title + ", 책 저자: " + author + ", 책 위치: " + location + ", ISBN: " + isbn
                + ", 대출 여부: " + (available ? "대출 가능" : "대출 불가능");
    }

    // 책 대출 후 대출 불가능설정하는 메서드
    public void book(){
        this.available = false;
    }
}

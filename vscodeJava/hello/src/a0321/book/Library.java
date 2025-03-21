package a0321.book;

public class Library {
    private String title; // 책 제목
    private String author; // 책 저자
    private String status; // 책 상태 //Borrowed , Available

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

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Library(String title, String author, String status) {
        this.title = title;
        this.author = author;
        this.status = status;
    }

}

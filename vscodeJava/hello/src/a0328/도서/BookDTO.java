package a0328.도서;

public class BookDTO {
    // 제목, 저자, ISBN, 가격
    private String title;
    private String author;
    private String isbn; //기본키
    private double price;

    public BookDTO() {
    }

    public BookDTO(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[제목: " + title + ", 저자: " + author + ", ISBN: " + isbn + ", 가격:" + price + "]";
    }
}

package a0324.도서;

public class EBook extends Book {
    

    private double fileSize; // 파일크기 (MB)
    private String format; // 파일 포맷(pdf 등)

    public EBook(String title, String author, String ISBN, double fileSize, String format) {
        super(title, author, ISBN);
        this.fileSize = fileSize;
        this.format = format;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("file size: " + fileSize + "MB");
        System.out.println("format: " + format);
    }
}

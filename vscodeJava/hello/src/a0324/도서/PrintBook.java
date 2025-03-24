package a0324.도서;

public class PrintBook extends Book {

    private int page; // 페이지 수
    private double weight; // 책 무게

    public PrintBook(String title, String author, String ISBN, int page, double weight) {
        super(title, author, ISBN);
        this.page = page;
        this.weight = weight;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("page: " + page);
        System.out.println("weight: " + weight + " kg");
    }
}

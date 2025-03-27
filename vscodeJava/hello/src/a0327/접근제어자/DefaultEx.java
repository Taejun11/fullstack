package a0327.접근제어자;

public class DefaultEx {
    public static void main(String[] args) {
        DefaultClass obj = new DefaultClass();
        obj.display();
    }
}

class DefaultClass{
    void display(){ //접근제어자 default
        System.out.println("패키지 내부에서만 접근 가능");
    }
}
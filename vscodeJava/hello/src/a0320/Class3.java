package a0320;

public class Class3 {
    public static void main(String[] args) {
        System.out.println("Card.width: " + Card.width);
        System.out.println("Card.height: " + Card.height);
        // Card.width , Card.height  클래스변수

        Card c1 = new Card();
        c1.kind = "heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "spade";
        c2.number = 5;

        System.out.println("c1: "+c1.kind+ ", " +c1.number+ " 크기: "+c1.width+ ", "+ c1.height);
        System.out.println("c2: "+c2.kind+ ", " +c2.number+ " 크기: "+c2.width+ ", "+ c2.height);
        Card.width = 50;
        Card.height = 80;
        System.out.println("c1의 width, height 변경");
        System.out.println("c1: "+c1.kind+ ", " +c1.number+ " 크기: "+Card.width+ ", "+ Card.height);
        System.out.println("c2: "+c2.kind+ ", " +c2.number+ " 크기: "+c2.width+ ", "+ c2.height);
    }

}

class Card {
    String kind;
    int number;
    static int width = 100;
    static int height = 80;
    // 여러 객체가 같은 변수를 활용할 경우 static을 활용하는 것이 더 효율적
    // 같이 쓰는 변수이므로 한 쪽을 바꾸면 다른 쪽도 바뀜
}
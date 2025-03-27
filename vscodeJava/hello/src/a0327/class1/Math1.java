package a0327.class1;

public class Math1 {
    public static void main(String[] args) {
        System.out.println(Math.ceil(10.0)); //올림
        System.out.println(Math.ceil(10.1)); //올림
        System.out.println(Math.floor(10.1)); //내림
        System.out.println(Math.round(10.1)); //반올림
        System.out.println(Math.round(10.5)); //반올림

        System.out.println(Math.max(3.14, 3.141));//큰 값
        System.out.println(Math.min(3.14, 3.141));//작은 값
        System.out.println();

        System.out.println(Math.max(-10, -11));//큰 값(양수에 더 가까운 값)
        System.out.println(Math.min(-10, -11));//작은 값(양수에 더 먼 값)
        System.out.println((int)(Math.random()*100));//0~99 랜덤
    }
}

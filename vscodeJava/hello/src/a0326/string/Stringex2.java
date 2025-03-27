package a0326.string;

public class Stringex2 {
    public static void main(String[] args) {
        String str = new String("abcd");
        System.out.println("원본 문자열: " + str);

        System.out.println(str.compareTo("bcdf"));//문자열 다르면 -1
        System.out.println(str.compareTo("abcd"));//같으면 0
        System.out.println(str.compareTo("Abcd"));
        System.out.println(str.compareToIgnoreCase("Abcd"));
        System.out.println("메소드 호출 후 원본 문자열: "+ str);
    }
}

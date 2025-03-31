package a0331.sort.hak;

public class Compare1 {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        String str3 = "apple";
        System.out.println(str1.compareTo(str2));//-1
        // 아스키코드 97, 98
        System.out.println(str1.compareTo(str3));//0
        // 아스키코드 동일
        System.out.println(str2.compareTo(str1));//1    
        // 아스키코그 98, 97
    }
}

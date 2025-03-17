package a0317;

// 1부터 5까지 출력, 3은 출력하지 않음
public class Continue1 {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}

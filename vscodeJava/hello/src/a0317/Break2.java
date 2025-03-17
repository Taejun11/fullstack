package a0317;
// sum이 10보다 커질 떄 종료

public class Break2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        for (;;) {// 무한반복
            sum += i;
            if (sum > 10) {
                System.out.println("sum이 10보다 커짐, i = " + i + " sum = " + sum);
                break;
            }
            i++;
        }
    }
}

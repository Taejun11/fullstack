package a0317;

public class Break1_1 {
    // 1부터 시작해서 숫자를 누적해서 더하다가
    // 합계가 처음으로 10을 넘을 경우 중단
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        boolean flag = true;
        while (flag) {
            sum += i;
            if (sum > 10) {
                System.out.println("sum이 10보다 커짐, i = "+i+" sum = "+sum);
                flag = false;
            }
            i++;
        }
        // while의 조건을 true로 하면 무한반복
        // break를 걸어야만 빠져나옴
    }
}

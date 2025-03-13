package a0313;

public class Ex01 {
    public static void main(String[] args) {
        // 세자리 정수의 각 자릿수 총 합 출력하기
        // 예: num = 374
        // 정수 $num의 각 자릿수 총합 = 14
        // 3 + 7 + 4 = 14
        // 나눗셈 하고 나머지 사용

        int num = 374;
        int hund = num / 100;
        int ten = (num - hund * 100) / 10; //(num / 10) % 10
        int one = num - (hund * 100 + ten * 10 ); // num % 10
        // System.out.println(hund); //3
        // System.out.println(ten); //7
        // System.out.println(one); //4
        int sum = hund + ten + one;
        System.out.printf("정수 %d의 각 자릿수 총합 = %d", num, sum);

    }
}

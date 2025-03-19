package a0319;

public class ArrayTopara {
    public static void main(String[] args) {
        int[] evens = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18 }; // 짝수
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19 };       // 소수

        int evenSum = sum(evens);
        int primeSum = sum(primes);

        System.out.printf("짝수 배열의 합 : %d\n",evenSum);
        System.out.printf("소수 배열의 합 : %d",primeSum);
    }

    public static int sum(int[] evens) {
        int sum = 0;
        for(int i:evens){
            sum += i;
        }
        return sum;
    }
}

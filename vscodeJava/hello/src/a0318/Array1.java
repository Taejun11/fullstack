package a0318;

public class Array1 {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5 };
        System.out.println(sumArray(numbers));
    }

    public static int sumArray(int[] arr) {
        int r = 0;
        // for (int i = 0; i < arr.length; i++) {
        //     r = arr[i] + r;
        // }
        for(int num:arr){//향상된 for문
            r += num;
        }
        return r;
    }
}

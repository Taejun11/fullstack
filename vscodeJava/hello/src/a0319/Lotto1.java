package a0319;

import java.util.Arrays;

public class Lotto1 {
    public static void main(String[] args) {
        int[] ball = new int[45];

        for(int i = 0; i < ball.length; i++){
            ball[i] = i+1;
        }
        // System.out.println(Arrays.toString(ball));

        int n = 0;
        int temp = 0;
        // for(int j = 0; j < 1000; j++){
        //     n = (int) (Math.random() * 45);
        //     temp = ball[0];
        //     ball[0] = ball[n];
        //     ball[n] = temp;
        // }
        for (int l = 0; l < 6; l++) {
            n = (int) (Math.random() * 45);
            temp = ball[l];
            ball[l] = ball[n];
            ball[n] = temp;
        }
        // System.out.println(Arrays.toString(ball));
        for(int k = 0; k <= 5; k++){
            System.out.printf("ball[%d] = %d\n",k, ball[k]);
        }
    }
}

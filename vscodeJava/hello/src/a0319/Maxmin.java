package a0319;

public class Maxmin {
    public static void main(String[] args) {
        int[] score = {79, 88, 91, 33, 100, 55, 95};
        int max = 0;
        int min = 100;

        for(int i:score){
            if (i > max) {
                max = i;
            }else if (i < min) {
                min = i;
            }
        }

        System.out.println("최대값 : "+max+" 최소값 : "+min);
    }
}

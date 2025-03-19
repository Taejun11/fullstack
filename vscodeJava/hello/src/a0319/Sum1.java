package a0319;

public class Sum1 {
    public static void main(String[] args) {
        int sum = 0;
        float avg = 0f;
        int[] score = {100, 88, 100, 100, 90};
        for(int num:score){
            sum += num;
        }
        avg = sum / (float)score.length;

        System.out.println("총합 = "+sum+" 평균 : "+avg);
    }
    
}
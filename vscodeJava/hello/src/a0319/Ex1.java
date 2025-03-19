package a0319;

public class Ex1 {
    public static void main(String[] args) {//공동 2등은 구별 못함
        int[] arr = {65, 74, 23, 75, 68, 96, 88, 98, 54};
        int max = 0; //1등값
        int second = 0; //2등값
        for(int i = 0; i< arr.length; i++){
            if (arr[i] > max) { //배열의 숫자가 max보다 클 경우 실행
                second = max;   //max의 값을 미리 second에 저장
                max = arr[i];   //max의 값을 인덱스의 값으로 저장
            }else if (arr[i] > second) { //배열의 숫자가 max보단 작고 second보단 클 경우 실행
                second = arr[i];//second의 값을 인덱스의 값으로 저장
            }
        }

        System.out.println("두 번째로 큰 수: " + second);
    }
}

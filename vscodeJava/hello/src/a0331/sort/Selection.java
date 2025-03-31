package a0331.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        // 앞에서부터 해당 원소가 위치 할 곳을 탐색하고 삽입
        int[] array = {63, 34, 25, 17, 22, 11, 90};
        Selection1(array);
        System.out.println("선택 정렬: "+Arrays.toString(array));
    }

    private static void Selection1(int[] array) {
        int n = array.length;
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }
}

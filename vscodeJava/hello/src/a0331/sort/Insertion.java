package a0331.sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        // 앞에서부터 해당 원소가 위치 할 곳을 탐색하고 삽입
        int[] array = {63, 34, 25, 17, 22, 11, 90};
        Insertion1(array);
        System.out.println("삽입 정렬: "+Arrays.toString(array));
    }

    private static void Insertion1(int[] array) {
        int n = array.length;
        for(int i = 1; i < n; i++){
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}

package a0403.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Stream1 {
    public static void main(String[] args) {
        int[] data = { 5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8 };
        // ArrrayList 생성 - 짝수만 포함
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                dataList.add(data[i]);
            }
        }
        // set으로 중복제거
        HashSet<Integer> dataSet = new HashSet<>(dataList);

        // set을 ArrayList로 변경
        ArrayList<Integer> dist = new ArrayList<>(dataSet);

        // 역순정렬
        dist.sort(Comparator.reverseOrder());
        // 순방향정렬: Comparator.naturalOrder()

        // 리스트를 배열로 변환
        int[] result = new int[dist.size()];
        for(int i = 0; i < dist.size(); i++){
            result[i] = dist.get(i);
        }
        for(int num : result){
            System.out.println(num + " ");
        }
    }
}

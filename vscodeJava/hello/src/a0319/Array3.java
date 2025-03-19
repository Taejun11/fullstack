package a0319;

public class Array3 {
    public static void main(String[] args) {// 공동 2등은 구별 못함
        int[] arr = { 65, 74, 23, 75, 68, 96, 88, 98, 54 };
        int secondTop = getsecondTop(arr);

        System.out.println("배열: [65, 74, 23, 75, 68, 96, 88, 98, 54]");
        System.out.println("두 번째로 큰 수: " + arr[secondTop]);
    }

    public static int getsecondTop(int[] arr) {
        int second = 0;
        int top = gettop(arr);
        for(int i = 0; i < arr.length; i++){
            if (i == top) {
                continue;
            }
            if (arr[i] > arr[second]) {
                second = i;
            }
        }
        return second;
    }

    public static int gettop(int[] arr) {
        int topidx = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] > arr[topidx]) {
                topidx = i;
            }
        }

        return topidx;
    }
}

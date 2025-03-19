package a0319;

public class TopScore {
    public static void main(String[] args) {
        String[] name = { "Elena", "Suzie", "Johe", "Emily", "Neda", "Kate", "Alex", "Daniel", "Sam", };
        int[] score = { 65, 74, 23, 75, 68, 96, 88, 98, 54 };
        // int max = 0;
        // int first = 0;

        int i = topindex(score);
        System.out.println("1등: " + name[i] +"(" +score[i]+"점)");


        // for(int i=0; i<name.length; i++){
        // if (score[i] > max) {
        // max = score[i];
        // first = i;
        // }
        // }
        // System.out.println("1등: " + name[first] +"(" +max+"점)");
    }

    public static int topindex(int[] arr) {
        int topind = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[topind] < arr[i]) {
                topind = i;
            }
        }
        return topind;
    }
}

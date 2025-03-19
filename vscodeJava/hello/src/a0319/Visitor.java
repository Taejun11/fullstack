package a0319;

public class Visitor {
    public static void main(String[] args) {
        String[] cities = {"서울","부산","인천","대전","대구"};
        int[] count = {599,51,46,43,27};

        for(int i =0; i<cities.length; i++){
            System.out.println(cities[i] + ": " + count[i] + "명");
        }
    }
}

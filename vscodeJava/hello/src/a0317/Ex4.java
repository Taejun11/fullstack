package a0317;

public class Ex4 {
    public static void main(String[] args) {
        int row = 5;
        for(int i = 1; i <= row; row--){
            for(int j = 1; j <= row; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

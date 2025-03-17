package a0317;

public class Dice {
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        while (true) {
            i = (int) (Math.random()*6)+1;
            j = (int) (Math.random()*6)+1;
            if ((i+j)==5) {
                System.out.println(i + ", " + j);
                break;
            }
        }
    }
}

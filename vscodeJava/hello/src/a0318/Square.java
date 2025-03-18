package a0318;

public class Square {
    public static void main(String[] args) {
        int n = 4;
        int s = square(n);
        System.out.printf("한 변의 길이가 %d인 정사각형의 넓이: %d", n, s);
    }

    public static int square(int length) {
        // public 접근 제한자
        // static 객체 생성 없이 부르는 것
        int result = length * length;
        return result;
    }

}
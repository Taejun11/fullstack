package a0318;
// public 클래스는 하나만 있을 수 있음

public class Square1 {

    public static void main(String[] args) {
        int n = 4;
        int s = SquareUtil.square(n);
        System.out.printf("한 변의 길이가 %d인 정사각형의 넓이: %d", n, s);
    }

}

class SquareUtil {

    public static int square(int length) {
        // public 접근 제한자
        // static 객체 생성 없이 부르는 것
        int result = length * length;
        return result;
    }
}


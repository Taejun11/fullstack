package a0327.exception1;

public class Exception04 {
    public static void main(String[] args) {
        try {
            checkNumber(-5);
        } catch (customException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    private static void checkNumber(int i) throws customException{
        if (i < 0) {
            throw new customException("음수는 허용되지 않습니다.");
        }
        System.out.println("입력값: " + i);
    }
}

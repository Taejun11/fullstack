package a0328.file;

import java.io.IOException;
import java.io.InputStream;

public class Input2 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        // System.in : 키보드로 입력 받겠다는 것
        // InputStream read : 1바이트의 사용자 입력
        int a = in.read();
        int b = in.read();
        int c = in.read();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        // 아스키코드로 출력됨
    }
}
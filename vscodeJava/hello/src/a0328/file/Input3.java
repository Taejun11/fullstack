package a0328.file;

import java.io.IOException;
import java.io.InputStream;

public class Input3 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        // System.in : 키보드로 입력 받겠다는 것
        // InputStream read : 1바이트의 사용자 입력
        byte[] a = new byte[3];
        in.read(a);
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        // 아스키코드로 출력됨
    }
}
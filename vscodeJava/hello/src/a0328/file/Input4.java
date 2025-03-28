package a0328.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input4 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        // System.in : 키보드로 입력 받겠다는 것
        // InputStreamReader : 바이트대신 문자로 입력받겠다는 것
        char[] a = new char[3];
        reader.read(a);
        System.out.println(a[0]);
        // 아스키코드로 출력됨
    }
}
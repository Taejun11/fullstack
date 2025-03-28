package a0328.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input5 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        // System.in : 키보드로 입력 받겠다는 것
        // InputStreamReader : 바이트대신 문자로 입력받겠다는 것
        // BufferedReader : 문장을 입력하겠다는 것
        String a = br.readLine();
        System.out.println(a);
        // 아스키코드로 출력됨
    }
}
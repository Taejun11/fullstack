package a0328.file;

import java.io.FileInputStream;
import java.io.IOException;

public class File6 {
    public static void main(String[] args) throws IOException{
        byte[] b = new byte[1000];
        FileInputStream input = new FileInputStream("d:\\out.txt");
        input.read(b);
        System.out.println(new String(b));
        input.close();
    }
}

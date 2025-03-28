package a0328.file1;

import java.io.File;

public class Fileinfo {
    public static void main(String[] args) {
        File file = new File("d:\\abc\\out.txt");

    System.out.println("파일이름: " + file.getName());
    System.out.println("파일경로: " + file.getAbsolutePath());
    System.out.println("파일존재여부: " + file.exists());
    }
    
}

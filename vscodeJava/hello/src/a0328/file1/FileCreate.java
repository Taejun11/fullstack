package a0328.file1;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
        File file = new File("d:\\test\\ex.txt");

        try {
            File dir = file.getParentFile(); //파일의 부모디렉터리 가져옴
            //폴더가 없을 경우 실행
            if (!dir.exists()) {
                dir.mkdirs();
                System.out.println("폴더 생성됨: " + dir.getAbsolutePath());
            }
            //파일 생성 절차
            if (file.createNewFile()) {
                System.out.println("파일 생성됨: " + file.getAbsolutePath());
            }else{
                System.out.println("파일이 존재함");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

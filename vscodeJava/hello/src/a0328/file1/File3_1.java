package a0328.file1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class File3_1 {
    public static void main(String[] args) throws IOException{
        // 폴더 경로
        String folderPath = "d:\\abc";
        File folder = new File(folderPath);

        // 폴더가 존재하지 않을 경우 실행
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("폴더 생성됨: " + folderPath);
            }else{
                System.out.println("폴더 생성 실패");
                return;
            }
        }

        PrintWriter pw = new PrintWriter("d:\\abc\\out.txt");
        for(int i = 1; i < 11; i++){
            String data = i + "번째 줄";
            pw.println(data);
        }
        // println 가능 -> \r\n 대체
        pw.close();
    }
}

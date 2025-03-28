package a0328.file;

import java.io.FileWriter;
import java.io.IOException;

public class File4 {
    public static void main(String[] args) throws IOException{
        FileWriter rw = new FileWriter("d:/out.txt");
        for(int i = 1; i < 11; i++){
            String data = i + "번째 줄\r\n";
            rw.write(data);
        }
        // println 가능 -> \r\n 대체
        rw.close();



        //파일 추가 모드
        FileWriter rw2 = new FileWriter("d:/out.txt",true);//이어쓰기
        for(int i = 11; i < 21; i++){
            String data = i + "번째 줄\r\n";
            rw2.write(data);
        }
        // println 가능 -> \r\n 대체
        rw2.close();
    }
}

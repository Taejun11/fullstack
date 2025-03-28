package a0328.file2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileClass {
    private File file;  //파일객체
    private String dir; //디렉토리
    private String filename; //파일명
    public FileClass(){
        file = new File("d:\\");
    }
    public FileClass(String dir, String filename) {
        file = new File("d:\\" + dir + "\\" + filename + ".txt");
        this.dir = "d:\\"+dir;
        this.filename = filename+".txt";
    }

    public void create() throws Exception{//6번
        boolean exists = check(file);
        if (exists) {
            file.delete(); //기본 제공하는 메서드
            file.createNewFile();
        }else{
            // 디렉토리 생성 후 파일 생성
            file = new File(dir);//d:\\student
            file.mkdir();//디렉토리 생성
            file = new File(dir + "\\" + filename);//d:\\student\grade.txt
            file.createNewFile();//파일 생성
        }
    }

    private boolean check(File file) {//6번
        if (file.exists()) {
            return true;
        }
        return false;
    }

    public void write(String str) throws Exception{//6번
        FileWriter fw = new FileWriter(file); //파일 쓰기를 위함
        PrintWriter pw = new PrintWriter(fw); //파일에 데이터를 출력하기 편함
        pw.println(str);
        pw.close();
    }

    public void read() throws Exception{//7번
        boolean exists = check(file);
        if (exists) {
            FileReader fr = new FileReader(file);
            BufferedReader bw = new BufferedReader(fr);
            String str;
            while ((str = bw.readLine()) != null) {
                System.out.println(str);
            }
            bw.close();
        }else{
            System.out.println("읽을 파일이 없습니다.");
        }
    }

}

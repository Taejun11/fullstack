package a0328.도서;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileClass {
    private File file;
    private String dir;
    private String filename;

    public FileClass() {
        file = new File("d:\\");
    }

    public FileClass(String dir, String filename) {
        file = new File("d:\\" + dir + "\\" + filename + ".txt");
        this.dir = "d:\\" + dir;
        this.filename = filename + ".txt";
    }

    public void create() throws Exception {// 6번
        boolean exists = check(file);
        if (exists) {
            file.delete();
            file.createNewFile();
        } else {
            file = new File(dir);
            file.mkdir();
            file = new File(dir + "\\" + filename);
            file.createNewFile();
        }
    }

    private boolean check(File file) {// 6번
        if (file.exists()) {
            return true;
        }
        return false;
    }

    public void write(String str) throws Exception{ //6번
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(str);
        pw.close();
    }

    public void read() throws Exception{//7번
        boolean exists = check(file);
        if (exists) {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            br.close();
        } else {
            System.out.println("읽을 파일이 없습니다.");
        }
    }

}

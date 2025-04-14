package a0409;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Wise {
    String wise;    //명언 내용
    String author;  //명언 저자

    public Wise(String wise, String author) {
        this.wise = wise;
        this.author = author;
    }

    private static final File file = new File("D:\\wise\\wise.txt");
    // 원본파일 경로
    private static final File backup_file = new File("D:\\wise\\wise_backup.txt");
    // 백업파일 경로


    @Override
    public String toString() {
        return wise + " " + author;
    }

    public static ArrayList<Wise> happy() throws IOException{
        ArrayList<Wise> happy = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ( (line = br.readLine()) != null) { 
            //파일을 한행씩 읽어와 반복 데이터 있을때까지
            String [] temp = line.split(","); //',' 기준으로 배열을 만듬
            Wise w = new Wise(
                temp[0], // 명언 내용
                temp[1] // 명언 저자 
            );
            happy.add(w); // 명언 객체를 ArrayList에 추가
        }
        br.close();  // 파일 입력 흐름 해제
        return happy;// 명언 객체가 담긴 ArrayList 반환
    }

    public void save() throws IOException{ //관리자 메뉴 1번 입력 시 파일 저장할 메서드
        FileWriter fw = new FileWriter(file, true);
        // 명언파일 대상 이어쓰기모드
        fw.write(this.tofileString()+"\n");
        fw.close();
    }

    private String tofileString() throws IOException{ //명언파일 추가할 때의 저장 형식
        return String.format("\"%s\",-%s-", wise, author);
    }

    public static void del(String wiseNum) throws IOException{ //관리자 메뉴 3번 입력 시 파일 삭제할 메서드
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = ""; //삭제할 문장을 덮어 씌워서 삭제하는 용도의 텍스트
        String line = null;
        int current_line = 1; // 현재 줄 번호를 계속 기록
        while ((line = br.readLine()) != null) {
            // 라인 공백이 없을 경우 계속 반복
            if (Integer.parseInt(wiseNum) != current_line) {
                // 삭제할 줄 번호가 아닐 경우에만 텍스트 백업
                text += line + "\n";
            }
            current_line++;
        }
        br.close();
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        // 백업해둔 텍스트 기록
        fw.close();
    }

    public static void backup() throws IOException{ //4번 입력 시 파일 가져오기
        // 원본파일을 읽고 백업파일에 모두 덮어쓰기
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = "";
        String line = null;

        while ((line = br.readLine()) != null) {
            text += line + "\n";
        }
        br.close();
        FileWriter fw = new FileWriter(backup_file);
        fw.write(text);;
        fw.close();
    }

    public static void getfile() throws IOException{ //5번 입력 시 파일 내보내기
        // 백업파일을 읽고 원본파일에 모두 덮어쓰기
        BufferedReader br = new BufferedReader(new FileReader(backup_file));
        String text = "";
        String line = null;

        while ((line = br.readLine()) != null) {
            text += line + "\n";
        }
        br.close();
        FileWriter fw = new FileWriter(file);
        fw.write(text);;
        fw.close();
    }
    

}

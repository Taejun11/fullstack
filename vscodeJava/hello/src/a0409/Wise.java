package a0409;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Wise {
    String wise;    //명언 내용
    String author;  //명언 저자

    // public Wise(String num ,String wise, String author) {
    //     this.num = num;
    //     this.wise = wise;
    //     this.author = author;
    // }
    public Wise(String wise, String author) {
        this.wise = wise;
        this.author = author;
    }

    private static final File file = new File("D:\\Taejun\\vscodeJava\\hello\\src\\a0409\\wise.txt");


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
    

}

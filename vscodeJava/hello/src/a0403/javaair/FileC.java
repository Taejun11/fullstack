package a0403.javaair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FileC {
    private FlightManager fm = new FlightManager();


    // 폴더가 없는 경우 폴더 생성하기
    // 티켓 여러 장 예매시 덮어쓰기가 되는 현상 막기
    public void ticketSavefile(Map<String, Flight> reservation, String name){
        try {
            File file = new File("d:\\ticket\\ticket.txt");
            File dir = file.getParentFile();
            if (!dir.exists()) {
                dir.mkdir();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
            bufferedWriter.write("");//빈 파일로 만들기
            // bufferedWriter.close();      //라이터 닫기
            // BufferedWriter: 파일에 데이터를 쓸 준비
            // FileWriter: 기존파일에 덮어씀
            // bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            // 라이터 이어쓰기 모드로 다시 열기

            if (file.isFile() && file.canWrite()) {
                
                bufferedWriter.write(fm.ticketPrint(reservation, name));
                bufferedWriter.flush();//저장
                System.out.println("파일 저장 완료");
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("파일 저장 실패");
        }
    }


    public void upload() {
        try {
            File file = new File("d:\\ticket\\schedule1.txt"); //ANSI로 저장하니 고쳐짐
            // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            //UTF-8로 하고싶을 때
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] flight =  line.split("/");
                FlightManager.getFlight().add(new Flight(flight[0], flight[1], Integer.parseInt(flight[2]), Boolean.parseBoolean(line)));
                                                        //목적지   , 출발시간,                      가격,                   국제선 여부
            }
        } catch (FileNotFoundException e) {
            System.out.println("schedule.txt 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
        
    }

}

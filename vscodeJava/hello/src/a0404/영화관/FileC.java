package a0404.영화관;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileC {
    private MovieManager mm = new MovieManager();
    public  FileC(){
        try (FileOutputStream fos = new FileOutputStream("d:\\ticket\\ticket.txt")) {
            //빈 파일로 초기화
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //4번
    public void ticketSavefile(Map<String, MovieList> reserv, String name) {
        try {
            File file = new File("d:\\ticket\\ticket.txt");
            File dir = file.getParentFile();
            // 디렉터리가 없을 경우 생성하고 시작
            if (!dir.exists()) {
                dir.mkdir();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            if (file.isFile() && file.canWrite()) {
                bufferedWriter.write(mm.ticketPrint(reserv, name));
                bufferedWriter.flush();
                System.out.println("파일 저장 완료");
                bufferedWriter.close();
            }
        } catch (IOException e) {
            System.out.println("파일 저장 실패");
        }
    }
    // 5번 영화 목록 업로드 하는 함수
    public void upload() {
        try {
            int i = 0;
            File file = new File("d:\\ticket\\schedule.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");    

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] movie = line.split("/");
                if (i >= mm.getMovie().size()) {
                    // 영화 목록이 리스트 개수를 초과할 경우 리스트에 추가
                    MovieManager.getMovie().add(new MovieList(movie[0], movie[1], movie[2], Integer.parseInt(movie[3]), Integer.parseInt(movie[4])));
                } else {
                    // 영화 목록이 리스트 개수 내에 있을 경우 리스트 수정
                    MovieManager.getMovie().set(i, new MovieList(movie[0], movie[1], movie[2], Integer.parseInt(movie[3]), Integer.parseInt(movie[4])));
                                                               // 영화제목, 상영시간, 러닝타임,                     가격,                   시청 연령가
                }
                i++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("schedule.txt 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패");
        }
        

    }
    
}

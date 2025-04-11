package a0409;

import java.io.IOException;
import java.util.ArrayList;

public class AdminMenu extends AbstractMenu{
    private static final AdminMenu instance = new AdminMenu(null);

    private static final String ADMINMENU_TEXT = //관리자 메뉴에 추가할 분류메뉴 텍스트
    // 아버지 클래스 호출에 넣을 String
    "1. 명언 추가 \n" +
    "2. 명언 목록\n" +
    "3. 명언 삭제\n" +
    "4. 명언파일 내보내기\n" +
    "5. 명언파일 가져오기\n" +
    "m: 메인메뉴로 돌아가기\n";

    public AdminMenu(Menu prevMenu){
        super(ADMINMENU_TEXT, prevMenu);
    }

    public static AdminMenu getInstance(){
        // 싱글톤객체
        return instance;
    }

    @Override
    public Menu next() {
        switch (scan.nextLine()) {
            case "1": //명언 추가
                add();
                return this; 
        
            case "2": //명언 목록
                list();
                return this;
        
            case "3": //명언 삭제
                del();
                return this;

            case "4": //명언파일 백업
                backup();
                return this;
            case "5": //명언파일 가져오기
                getfile();
                return this;
        
            case "m": //메인메뉴로 이동
                
                return prevMenu; // 메인메뉴로 이동하는 것을 반환
        
            default:
                System.out.println("목록에 없는 선택지입니다.");
                return this;
        }
    }


    private void add() { //1번 입력 시 명언 한 줄 추가
        System.out.println("추가할 명언 내용: ");
        String wise = scan.nextLine();
        System.out.println("추가할 명언 저자: ");
        String author = scan.nextLine();
        Wise wises = new Wise(wise, author);
        try {
            wises.save();
        } catch (IOException e) {
            System.out.println(">> 추가에 실패하였습니다.");
        }
    }

    private void list() { //2번 입력시, 삭제 하기 전 전체 리스트 보여주기용
        try {
            ArrayList<Wise> wises = Wise.happy();
            for(int i = 0; i < wises.size(); i++){
                System.out.printf("%d. %s",i+1, wises.get(i).toString());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("데이터 접근에 실패"); // 예외처리
        }
    }

    private void del() { //3번 입력 시 명언 한 줄 삭제
        list();
        System.out.println("삭제할 명언의 번호를 선택하세요:");

        try {
            Wise.del(scan.nextLine());
            System.out.println("삭제가 완료되었습니다.");
        } catch (IOException e) {
            System.out.println("삭제가 실패했습니다.");
        }
    }

    private void backup() { //4번 입력 시 파일 내보내기
        try {
            Wise.backup();
            System.out.println("파일 백업이 완료되었습니다.");
        } catch (IOException e) {
            System.out.println("파일을 백업하는데 실패했습니다.");
        }
    }
    
    private void getfile() { //5번 입력 시 파일 가져오기
        try {
            Wise.getfile();
            System.out.println("백업파일을 가져오는데 성공했습니다.");
        } catch (IOException e) {
            System.out.println("백업파일을 가져오는데 실패했습니다.");
        }
    }
}

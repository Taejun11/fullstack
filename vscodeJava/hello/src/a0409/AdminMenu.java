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
        
            case "m": //메인메뉴로 이동
                
                return prevMenu; // 메인메뉴로 이동하는 것을 반환
        
            default:
                System.out.println("목록에 없는 선택지입니다.");
                return this;
        }
    }

    private void add() { //1번 입력시
        
    }

    private void list() { //2번 입력시, 삭제 하기 전 전체 리스트 보여주기용
        try {
            ArrayList<Wise> wises = Wise.happy();
            for(int i = 0; i < wises.size(); i++){
                System.out.printf("%s", wises.get(i).toString());
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("데이터 접근에 실패"); // 예외처리
        }
    }

    private void del() { //3번 입력시
        list();
        System.out.println("삭제할 명언의 번호를 선택하세요:");

        // try {
            
        // } catch (IOException e) {
        //     System.out.println("삭제 실패");
        // }
    }
}

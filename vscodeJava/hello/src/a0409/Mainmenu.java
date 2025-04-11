package a0409;

import java.io.IOException;
import java.util.ArrayList;

class Mainmenu extends AbstractMenu {
    private static final Mainmenu instance = new Mainmenu(null);

    public static Mainmenu getInstance() {
        // 싱글톤객체
        return instance;
    }

    private static final String MAINMENU_TEXT = // 첫 메뉴에 추가할 분류메뉴 텍스트
            // 아버지 클래스 호출에 넣을 String
            "1. 랜덤 명언 출력 \n" +
                    "0. 관리자메뉴\n" +
                    "q: 종료\n";

    private Mainmenu(Menu prevMenu) {
        super(MAINMENU_TEXT, prevMenu);
    }

    // 메뉴 선택
    @Override // 할아버지 인터페이스의 next()구문
    public Menu next() {
        //
        switch (scan.nextLine()) {
            case "1": // 랜덤명언
                wises();
                return this; // 이 싱글톤객체를 다시 반환하여 프로그램을 이어감

            case "0": // 관리자메뉴
                if (!checkRoot()) { //관리자 비밀번호 입력받음
                    System.out.println("비밀번호를 틀렸습니다.");
                    return this;
                }
                AdminMenu adminMenu = AdminMenu.getInstance(); // 관리자 객체를 가져옴
                adminMenu.setPrevMenu(this); // mainMenu메인 메뉴를 이전 메뉴로 등록
                return adminMenu; // 관리자 메뉴 반환

            case "q": // 프로그램 종료

                return null; // 다시 반환하는 것이 없으므로 프로그램을 종료함

            default:
                System.out.println("목록에 없는 선택지입니다.");
                return this;
        }
    }

    private boolean checkRoot() {
        System.out.println("관리자 비밀번호를 입력하세요:");
        // scan.nextLine();
        return "root".equals(scan.nextLine());
        // 비밀번호 root
    }

    private void wises() { // 랜덤명언 1번선택시
        try {
            ArrayList<Wise> happy = Wise.happy();
            int i = (int) (Math.random() * happy.size());
            // txt파일에 적힌 명언 개수 만큼 랜덤돌림
            System.out.printf("%s\n", happy.get(i).toString());
            // 실행할 때 마다 랜덤명언 한줄 출력 후 메뉴로 돌아감

        } catch (IOException e) {
            System.out.printf("파일 입출력에 문제 발생: %s\n", e.getMessage());
            e.printStackTrace(); // 예외 스택 추적 출력
        } catch (Exception e) {
            System.out.printf("출력 실패: %s\n",e.getMessage());

        }
    }
}

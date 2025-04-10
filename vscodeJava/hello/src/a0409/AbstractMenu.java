package a0409;

import java.util.Scanner;

abstract class AbstractMenu implements Menu{
    // Menu 인터페이스를 상속받은 추상클래스 AbstractMenu
    // 족보 상 아버지 클래스
    protected String menuText; //기본 출력 메뉴텍스트
    protected Menu prevMenu;   //이전메뉴 
    protected static final Scanner scan = new Scanner(System.in);

    public void print(){
        // 할아버지 인터페이스에 있는 것
        // 자식 클래스에서는 따로 안적어도 됨
        System.out.print(menuText + "\n>>"); //메뉴출력
    }

    public AbstractMenu(String menuText, Menu prevMenu) {
        // 자식에게 호출될 구조체 형식
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }

    public void setPrevMenu(Menu prevMenu) {
        // 관리자메뉴 진입 시 이전메뉴는 메인메뉴로 설정해놓고
        // 관리자메뉴 탈출 시 설정해놓은 메인메뉴로 나오기 위함
        this.prevMenu = prevMenu;
    }
}

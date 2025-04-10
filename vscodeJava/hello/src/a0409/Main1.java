package a0409;

public class Main1 {
    public static void main(String[] args) {
        System.out.println("선택할 작업을 입력하세요.");
        Menu menu = Mainmenu.getInstance();
        // Menu 인터페이스로 만들어진 menu 객체는
        // 할아버지 인터페이스를 상속받는 아버치 클래스를 상속받는 자식 클래스를 가져옴
        while (menu != null) { //메뉴가 계속 있을 경우 실행
            menu.print();      //현재 메뉴 출력, 인스턴스에 있음
            menu = menu.next();//메뉴 선택받음, Mainmenu next에 있음
        }//이 while이 끝나면 프로그램이 종료되는 것
        // 프로그램 종료시
        System.out.println("프로그램을 종료합니다.");
    }
}

interface Menu {
    // 모든 메뉴의 부모클래스가 될 AbstractMenu의 부모 인터페이스
    // 족보 상 할아버지 인터페이스
    void print(); //메뉴 출력
    Menu next();  //선택 시 명언 출력
}
package a0409;

class Mainmenu extends AbstractMenu{
    private static final Mainmenu instance = new Mainmenu(null);
    public static Mainmenu getInstance(){
        // 싱글톤객체
        return instance;
    }
    private static final String MAINMENU_TEXT = //첫 메뉴에 추가할 분류메뉴 텍스트
    // 아버지 클래스 호출에 넣을 String
    "1. 행복 \n" +
    "2. 주식\n" +
    "3. 정신건강\n" +
    "0. 관리자메뉴\n" +
    "q: 종료\n";
    private Mainmenu(Menu prevMenu){
        super(MAINMENU_TEXT, prevMenu);
    }

    // 메뉴 선택
    @Override //할아버지 인터페이스의 next()구문
    public Menu next() {
        // 
        switch (scan.nextLine()) {
            case "1": //행복명언
                
                return this; // 이 싱글톤객체를 다시 반환하여 프로그램을 이어감
        
            case "2": //주식명언
                
                return this;
        
            case "3": //정신건강명언
                
                return this;
        
            case "0": //관리자메뉴
                
                return this;
        
            case "q": //프로그램 종료
                
                return null; //다시 반환하는 것이 없으므로 프로그램을 종료함
        
            default:
                return this;
        }
    }
}

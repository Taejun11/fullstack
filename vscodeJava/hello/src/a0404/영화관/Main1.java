package a0404.영화관;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        FileC fc = new FileC();
        Root root = new Root();

        System.out.println("어서오세요. 무엇을 도와드릴까요");

        end : while (true) {
            System.out.println("---------------------------------------");
            System.out.println("1. 영화 목록 보기\n2. 좌석 예매 하기\n3. 내 예매 조회\n4. 내 예매 저장\n5. 영화 목록 업로드(관리자전용) \n0.종료\n");
            System.out.print("선택> ");
            String menuStr = scan.next();
            scan.nextLine();
            
            int menu = -1;
            try {
                menu = Integer.parseInt(menuStr);
            } catch (NumberFormatException e) {
                menu = 9;
            }

            switch (menu) {
                case 1:
                    // 영화 목록 보기
                    mm.viewList("현재 상영 중인 영화");
                    break;
                case 2:
                    // 좌석 예매 하기
                    try {
                        mm.reserv();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    //내 예매 조회
                    mm.checkReserv();
                    break;
                case 4:
                    // 내 예매 저장
                    mm.ticketSave();
                    break;
                case 5:
                    //영화 목록 업로드
                    //관리자권한 확인하는 메소드
                    if (checkRoot(scan, root)) {
                        fc.upload();
                        break;
                    } else {
                        System.out.println("메인메뉴로 돌아갑니다.");
                        break;
                    }
                case 0:
                    //종료
                    System.out.println("프로그램 종료");
                    scan.close();
                    break end;
            
                default:
                    break;
            }
        }
    }

    //관리자권한 확인하는 메소드
    private static boolean checkRoot(Scanner scan, Root root) {
        try {
            System.out.println("관리자 권한을 확인해 주십시오.");
                System.out.print("관리자 아이디: ");
                String id = scan.next();
                scan.nextLine();
                System.out.print("관리자 비밀번호: ");
                String pw = scan.next();
                scan.nextLine();
                if (id.equals(root.getId()) && pw.equals(root.getPw())) {
                    //관리자 로그인이 됐을 경우 실행
                    System.out.println("관리자 권한이 인증되었습니다.");
                    return true;
                }else{
                    // 관리자 로그인이 안됐을 경우 실행
                    System.out.println("관리자 권한이 거절되었습니다.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("잘못된 접근입니다.");
                return false;
            }
    }

}

package a0403.영화관;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MovieManager mm = new MovieManager();
        FileC fc = new FileC();
        System.out.println("어서오세요. 무엇을 도와드릴까요");

        end : while (true) {
            System.out.println("1. 영화 목록 보기\n2. 좌석 예매 하기\n3. 내 예매 조회\n4. 내 예매 저장\n5. 영화 목록 업로드 \n0.종료\n");
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
                    fc.upload();
                    break;
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
}

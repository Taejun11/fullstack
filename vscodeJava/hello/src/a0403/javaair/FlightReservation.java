package a0403.javaair;

import java.util.Scanner;

public class FlightReservation {
    public static void main(String[] args) {
        FlightManager fm = new FlightManager();
        Scanner scan = new Scanner(System.in);
        FileC fc = new FileC();
        System.out.println(fm.airplane);
        System.out.println("--------JavaAir에 오신 것을 환영합니다.--------");

        Outter:while (true) {
            System.out.println("1. 항공편 목록\n2. 항공편 예매\n3. 예약 조회\n4. 티켓 저장\n5. 항공편 업로드 \n0.종료\n");
            System.out.print("메뉴입력>");

            String menuStr = scan.next();
            scan.nextLine(); //버퍼 비우기

            int menu = -1;

            try {
                menu = Integer.parseInt(menuStr);
            } catch (NumberFormatException e) {
                menu = 9;
            }

            switch (menu) {
                case 1:
                    // 항공편 목록
                    fm.displayFlightList("항공편 목록");
                    break;
                case 2:
                    // 항공편 예매
                    try {
                        fm.bookFlight();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    // 예매 확인
                    fm.checkReservtion();
                    break;
                case 4:
                    // 예매 파일 저장
                    fm.ticketSave();
                    break;
                case 5:
                    // 예매 파일 저장
                    fc.upload();
                    break;
                case 0:
                    // 예매 파일 저장
                    System.out.println("프로그램 종료");
                    scan.close();
                    break Outter;
                default:
                    break;
            }
        }
    }
}

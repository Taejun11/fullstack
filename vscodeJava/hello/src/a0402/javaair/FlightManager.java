package a0402.javaair;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FlightManager {
    private static ArrayList<Flight> flights; //항공편 정보 저장
    private static ArrayList<Passenger> passengers; //예약된 승객 정보 저장
    Scanner scan = new Scanner(System.in);

    // 키: 승객, 예약된 항공편: 값
    private static Map<String, Flight> reservation = new HashMap<>();
    private static FileC fc = new FileC(); //파일 작업

    public FlightManager(){
        flights = new ArrayList<>();
        flights.add(new Flight("제주","11:55", 78000, false));
        flights.add(new Flight("이스탄불","17:10",1200000,true));
        flights.add(new Flight("방콕","21:35",280000,true));

        passengers = new ArrayList<>();
        Flight sf = flights.get(0);
        reservation.put("테스트", sf);

        
    }

    public String airplane = "                       |                      \n"
                           + "                      _|_                     \n" 
                           + "                    /_____\\                  \n"
                           + "                   /oo   oo\\                 \n" 
                         + " \\_________________\\       /_________________/\n"
                          + "  `-------|---|-----\\_____/-----|---|-------'\n" 
                          + "         ( ) ( )  O|OOo|oOO|O  ( ) ( )   \n";



    public void displayFlightList(String str) {
        // 항공편 목록 출력 -> tostring 이용
        System.out.println("--------------------" + str + "--------------------");
        int count = 1;
        for(Flight f : flights){
            System.out.println(count + "" + f.toString());
            count++;
        }
        System.out.println("---------------------------------------------------");
    }



    public void bookFlight() throws InterruptedException {
        // 국제선 - 사용자이름, 생년월일 받아서 나이 확인하고 만15세 미만이면 예약거절
        for(;;){//무한루프
            displayFlightList("항공편 예매");
            System.out.print("예매할 항공편을 입력해주세요.>>");
            try {
                int bookNum = Integer.parseInt(scan.next());
                if (bookNum > flights.size() || bookNum < 1) {
                    // 예약할 수 있는 개수보다 크거나 없는 번호를 입력할 경우
                    System.out.println("잘못된 입력입니다.");
                    continue;
                    // 다시 돌아감
                }
                System.out.println("선택한 항공편");
                System.out.println("---------------------------------------------------");
                System.out.println(bookNum + "" + flights.get(bookNum-1));
                System.out.println("---------------------------------------------------");
                Flight sf = flights.get(bookNum-1);
                if (flights.get(bookNum-1).getInternationalFlight()) {
                    System.out.println("국제선은 만 15세 이상만 예매할 수 있습니다.");
                    passengerInfo(sf);
                }else{
                    passengerInfo(sf);
                } //예약하는 함수

                if (passengers != null && !passengers.isEmpty()) {
                    String seatNum = Integer.toString(seatSelection(sf)); //좌석 선택 함수
                    passengers.get(passengers.size()-1).setSeat(seatNum);
                    // 리스트에서 가장 마지막에 추가된 승객 좌석번호를 설정
                    System.out.println("예약중입니다.");
                    Thread.sleep(2000);

                    System.out.println("---------------------------------------------------");
                    System.out.println("예약에 성공했습니다.");
                    System.out.println("[" + passengers.get(passengers.size()-1).getName() + "] 님의 예약정보: ");
                    System.out.println(bookNum + "" + sf);
                    System.out.println("---------------------------------------------------");
                    System.out.println("잠시 후 메인화면으로 이동합니다.");
                    Thread.sleep(2000);
                    reservation.put(passengers.get(passengers.size()-1).getName(), sf);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }



    private int seatSelection(Flight sf) {
        //좌석
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("---------------------------------------------------");
                sf.seatTostring(); //빈좌석 출력해주는 함수
                System.out.println("좌석번호를 선택하세요.");
                System.out.println(">>");
                int seatint = scan.nextInt()-1;
                scan.nextLine();
                if (seatint+1 < 1 || seatint+1 > 20) {
                    //좌석 범위 넘을 때
                    System.out.println("존재하지 않는 좌석입니다.");
                }else if (sf.getSeats().get(seatint).equals("XX")) {
                    // 이미 예약된 좌석일 떄
                    System.out.println("이미 예약된 좌석입니다.");
                }else{
                    // 예약 가능
                    sf.getSeats().set(seatint, "XX");
                    System.out.println("좌석 선택이 완료되었습니다.");
                    seatNum = seatint;
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                scan.nextLine();
            }
        }
        return seatNum;
    }

    private void passengerInfo(Flight sf) {
        System.out.println("예매자의 정보를 입력하세요.");
        System.out.print("이름: ");
        String name = scan.next();
        System.out.print("생년월일(6자리): ");
        try {
            int birthdate = Integer.parseInt(scan.next());
            Passenger p = new Passenger(name, birthdate);
            if (!p.man15(p) && sf.getInternationalFlight()) {
                // 예매자가 15세 미만이면서 국제선이여야만 실행 -> 예약 불가
                System.out.println("만 15세 미만은 국제선을 예약할 수 없습니다.");
                // return;
            }else{
                System.out.println("결제 비밀번호를 입력해주세요. ");
                String pw = scan.next();
                p = new Passenger(name, birthdate, pw);
                passengers.add(p);//빠졌던 부분
            }
        } catch (DateTimeException e) {
            System.out.println("생년월일을 6자리로 입력해주세요.");
        }
    }

    public void checkReservtion() {
        int index = search("예약확인");
        checkPw(index);
    }



    private void checkPw(int index) {
        for(;;){
            if (index != -1) {
                System.out.println("결제 비밀번호를 입력해주세요.");
                String pw = scan.next();
                System.out.println();
                if (passengers.get(index).getPw().equals(pw)) {
                    System.out.println("비밀번호 일치");
                    System.out.println(ticketPrint(reservation, passengers.get(index).getName()));
                    break;
                }
            }
        }
    }



    private String ticketPrint(Map<String, Flight> reservation, String name) {
        int index = -1;
        if (passengers != null) {
            for(int i = 0; i < passengers.size(); i++){
                if (passengers.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        int seat = Integer.parseInt(passengers.get(index).getSeat()+1);
        return  "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n" +
        "\t" + name + "님의 티켓정보" +
        "| 좌석 : " + seat + "번\n"+
        "." + reservation.get(name) + "\n\n" +
        "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
    }



    private int search(String str) {
        System.out.println("--------------------" + str + "--------------------");
        System.out.print("예약자 이름: ");
        String name = scan.next();
        scan.nextLine();
        int index = -1;
        if (passengers != null) {
            for(int i = 0; i < passengers.size(); i++){
                if (passengers.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        return index;
    }

}

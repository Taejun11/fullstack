package a0403.영화관;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MovieManager {
    private static ArrayList<MovieList> movieLists; //영화 정보 저장
    private static ArrayList<Customer> customers;   //고객 정보 저장
    Scanner scan = new Scanner(System.in);
    // 고객, 예매한 영화를 맵으로 저장
    private static Map<String, MovieList> reserv = new HashMap<>();
    private static FileC fc = new FileC();

    public MovieManager() {
        movieLists = new ArrayList<>();
        //제목, 시작시간, 길이, 금액, 청불여부
        movieLists.add(new MovieList("공포특급", "12:30", "91", 12000, 15));
        movieLists.add(new MovieList("미키 17", "22:00", "137", 12000, 15));
        movieLists.add(new MovieList("김동하 : 커넥트", "18:00", "85", 12000, 19));
        movieLists.add(new MovieList("고독한 미식가 더 무비", "17:10", "110", 12000, 0));

        customers = new ArrayList<>();
        MovieList mv = movieLists.get(0);
        reserv.put("테스트", mv);
    }
    // 1번 영화 목록 보여주는 함수
    public void viewList(String str) {
        System.out.println("-------------"+str+"-------------");
        int count = 1;
        for(MovieList m : movieLists){
            System.out.println(count +"" + m.toString());
            count++;
        }
        System.out.println("---------------------------------------------------");
        
    }
    // 2번 영화 예매하는 함수
    public void reserv() throws InterruptedException{
        for(;;){
            viewList("좌석 예매 하기");
            System.out.println("예매할 영화를 입력해주세요.");
            System.out.print("메인메뉴로 돌아가시려면 0을 입력하세요.\n>>");
            try {
                int bookNum = Integer.parseInt(scan.next());
                if (bookNum > movieLists.size() || bookNum < 1) {
                    if (bookNum == 0) {
                        System.out.println("메인메뉴로 돌아갑니다.");
                        break;
                    }
                    System.out.println("잘못된 입력입니다.");
                    continue;
                    // 다시 돌아감
                }

                System.out.println("선택한 영화");
                System.out.println("---------------------------------------------------");
                System.out.println(bookNum + "" + movieLists.get(bookNum-1));
                System.out.println("---------------------------------------------------");
                MovieList mm = movieLists.get(bookNum-1);
                if (movieLists.get(bookNum-1).getAdultOnly() >= 19) {
                    System.out.println("해당 영화는 만 19세 미만은 시청할 수 없습니다.");
                    customersInfo(mm);
                }else{
                    customersInfo(mm);
                }//예약하는 함수

                if (customers != null && !customers.isEmpty()) {
                    String seatNum = Integer.toString(seatSelection(mm));
                    customers.get(customers.size() - 1).setSeat(seatNum);
                    System.out.println("선택하신 내용이 맞으시다면 \"확인\"을 입력해주세요.");
                    System.out.println("다시 선택하실 원하신다면 \"취소\"를 입력해주세요.");
                    String ok = scan.next();
                    scan.nextLine();

                    if (ok.equals("확인")) {
                        System.out.println("예약중입니다.");
                        Thread.sleep(2000);

                        System.out.println("예약에 성공했습니다.");
                        System.out.println("[" + customers.get(customers.size() - 1).getName() + "] 님의 예약정보: ");
                        System.out.println(bookNum + "" + mm.toString());
                        System.out.println("잠시 후 메인화면으로 이동합니다.");
                        Thread.sleep(2000);
                        reserv.put(customers.get(customers.size() - 1).getName(), mm);
                        break;
                    } else if (ok.equals("취소")) {
                        System.out.println("영화 선택으로 돌아갑니다.");
                        continue;
                    }

                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
    // 예매자 나이 확인하는 함수
    private void customersInfo(MovieList mm) { 
        System.out.println("예매자의 정보를 입력하세요.");
        System.out.print("이름: ");
        String name = scan.next();
        System.out.print("생년월일(주민번호 앞 6자리): ");
        try {
            int birthdate = Integer.parseInt(scan.next());
            Customer c = new Customer(name, birthdate);
            if (!c.man19(c) && mm.getAdultOnly()>=19) {
                // 예매자가 19세 미만이면서 청불영화일 경우에만 실행 -> 예매 불가
                System.out.println("만 19세 미만은 해당 영화를 예약할 수 없습니다.");
                return;
            }else{
                System.out.println("결제 비밀번호를 입력해주세요. ");
                String pw = scan.next();
                c = new Customer(name, birthdate, pw);
                customers.add(c);//빠졌던 부분
            }
        } catch (DateTimeException e) {
            System.out.println("생년월일을 6자리로 입력해주세요.");
        }
    }
    // 예매자 좌석 갱신하는 함수
    private int seatSelection(MovieList mm) {
        //좌석 선택 함수
        int seatNum = -1;
        while (true) {
            try {
                System.out.println("---------------------------------------------------");
                mm.seatTostring();
                System.out.println("좌석번호를 선택하세요.");
                System.out.print(">>");
                int seatint = scan.nextInt()-1;
                scan.nextLine();
                if (seatint+1 < 1 || seatint+1 > 40) {
                    System.out.println("존재하지 않는 좌석입니다.");
                }else if (mm.getSeats().get(seatint).equals("XX")) {
                    System.out.println("이미 예약된 좌석입니다.");
                }else{
                    mm.getSeats().set(seatint, "XX");
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
    // 3번
    public void checkReserv() {
        int index = search("예약확인");
        checkPw(index);
        if (index == -1) {
            System.out.println("해당 고객의 예약이 없습니다.");
        }
    }
    // 본인 이름이 있는지 찾는 함수
    private int search(String str) {
        System.out.println(str);
        System.out.print("예매자 이름: ");
        String name = scan.next();
        scan.nextLine();
        int index = -1;
        if (customers != null) {
            for(int i = 0; i < customers.size(); i++){
                if (customers.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        return index;
    }
    // 본인 확인을 비밀번호로 하는 함수
    private void checkPw(int index) {
        for(;;){
            if (index != -1) {
                System.out.println("결제 비밀번호를 입력해주세요.");
                String pw = scan.next();
                System.out.println();
                if (customers.get(index).getPw().equals(pw)) {
                    System.out.println("비밀번호 일치");
                    System.out.println(ticketPrint(reserv, customers.get(index).getName()));
                    break;
                }
            }else{
                break;
            }
        }
    }
    // 본인 확인이 완료된 고객의 티켓을 출력하는 함수
    String ticketPrint(Map<String, MovieList> reserv, String name) {
        int index = -1;
        if (customers != null) {
            for(int i = 0; i < customers.size(); i++){
                if (customers.get(i).getName().equals(name)) {
                    index = i;
                }
            }
        }
        int seat = Integer.parseInt(customers.get(index).getSeat())+1;
        return  "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n" +
        "\t" + name + "님의 티켓정보" +
        "| 좌석 : " + seat + "번\n"+
        "." + reserv.get(name) + "\n\n" +
        "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n";
    }
    // 4번 내 예약 현황을 파일로 저장하는 함수
    public void ticketSave() {
        try {
            int index = search("예약 현황 조회");
            checkPw(index);
            fc.ticketSavefile(reserv, customers.get(index).getName());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("해당 고객의 예약이 없습니다.");

        }
    }
    // 영화 목록을 외부에서 접근 가능한 get
    public static ArrayList<MovieList> getMovie() {
        return movieLists;
    }
    // 예약정보를 외부에서 접근 가능한 get
    public static Map<String, MovieList> getReserv() {
        return reserv;
    }

}

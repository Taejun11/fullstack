package a0331.book;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StoreService {
    
    private boolean reorder = false; //재주문 변수
    private int orderNum = 1;        //고객 번호
    Map<String, Integer> orderList;  //고객의 주문 내역
    public StoreService(){
        orderList = new LinkedHashMap<>();
    }
    Book book = Book.getInstance();  //싱글톤 책 객체
    Customer customer;               //손님객체
    Thread t = new Thread();
    Scanner scan = new Scanner(System.in);

	public void start() {
        System.out.println("어서오세요.");
        customer = new Customer(orderNum); //손님의 초기 상태 객체
        book.getMenu();                    //메뉴 불러오는 함수
        order();                           //주문받기
        totalorder(customer);              //최종주문 확인 함수
        
        try {
            System.out.println("기다려주시면 주문하신 책이 나옵니다.");
            t.sleep(2000);
            end();                         //주문내역 출력 함수 
        } catch (Exception e) {
            e.printStackTrace();
        }
	} 

    private void order() { //주문받기
        System.out.println("주문을 취소하시려면 0을 입력해주세요.");
        end: while (true) {
            try {
                System.out.println("주문할 책의 번호를 입력해주세요.");
                String choice = scan.next();
                int choiceNum = Integer.parseInt(choice.substring(0,1));
                if (choiceNum == 0) {
                    System.out.println("주문을 취소합니다.");
                    System.exit(0);
                }
                scan.nextLine();
                String bookName = book.bookList.get(choiceNum-1);
                System.out.println("선택하신 책은 " + bookName + " 입니다. 몇 권 주문하시겠습니까?");
                int orderCount = scan.nextInt();
                scan.nextLine();
                // 재주문
                if (reorder) { //재주문 하는 경우
                    for(String book : orderList.keySet()){//같은 책 주문하는 경우
                        if (book.equals(bookName)) {
                            int addCount = orderList.get(book).intValue() + orderCount;
                            orderList.replace(bookName, addCount);
                            // 같은 책 주문 갱신
                        }else{
                            orderList.put(bookName, orderCount);
                            break;
                            // 다른 책 주문 추가
                        }
                    }
                }else{      //재주문 안하는 경우
                    orderList.put(bookName, orderCount);
                }
                customer.setBookOrder(orderList);
                // 추가주문
                addorder();
                break end;

            } catch (Exception e) {
                System.out.println("잘못된 선택입니다.");
                continue;
            }
        }
    }

    private void addorder() {
        reorder = false;
        System.out.println("\n주문을 계속 하시겠습니까?");
        System.out.println("예(Y)/아니오(N)");
        String yn = scan.next();
        if (yn.equals("예") || yn.equalsIgnoreCase("y")) {
            book.getMenu();
            reorder = true;
            order();
        } else if (yn.equals("아니오") || yn.equalsIgnoreCase("n")) {
            return;
        }
    }

    private void totalorder(Customer customer) {
        int s = 1;
        int totalmoney = 0;
        int bookPrice = 0;
        String name = customer.getOrderName() + "번";
        DecimalFormat f = new DecimalFormat("###,000원");
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|             " + name + "고객님 의 주문 내역 입니다         | " + "\n");
        
        for(Map.Entry<String, Integer> order : customer.getBookOrder().entrySet()){
            String bookname = order.getKey();
            int orderCount = order.getValue();
            int bookUnitPrice = book.menu.get(bookname);
            bookPrice = bookUnitPrice * orderCount;
            totalmoney = totalmoney + bookPrice;

            String pay = f.format(bookPrice); // 가격 포맷팅
            message.append(String.format(" | [%d] %-20s : %2d권  %7s |\n", s, bookname, orderCount, pay));
            s++;
            message.append(" |                                                    |\n ")
                    .append("+----------------------------------------------------+ \n")
                    .append(" ============ 총 결제 금액은 " + f.format(totalmoney) + "입니다 ========== \n");
            System.out.println(message);
            payment(totalmoney); //결제하는 함수
        }
    }

    private void payment(int totalmoney) {
        System.out.println("\n결제를 도와드리겠습니다. 카드를 넣어주세요.");
        int payresult = customer.getMoney() - totalmoney;

        try {
            t.sleep(2500);
            System.out.println("결제중입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (payresult < 0) {
            System.out.println("잔액이 부족합니다.");
        }else{
            customer.setMoney(payresult);
            System.out.println("결제가 완료되었습니다.");
            orderNum++;
        }
    }

    private void end() {
        int s = 1;
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|           " + customer.getOrderName() + " 고객님 주문하신 책 나왔습니다         | " + "\n");
        System.out.print(message);
        for(Map.Entry<String, Integer> order : customer.getBookOrder().entrySet()){
            System.out.printf(" | [%d] %-20s : %2d권  %7s |\n", s, order.getKey(), order.getValue(), "");
            s++;
        }
        System.out.println(" |                                                    |");
        System.out.println(" +----------------------------------------------------+");
    }
    
}

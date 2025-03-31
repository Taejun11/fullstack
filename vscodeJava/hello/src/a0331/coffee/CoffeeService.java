package a0331.coffee;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeService {

    private boolean reorder = false; // 고객의 추가주문 여부
    private int orderNum = 1; // 고객 주문번호
    Map<String, Integer> orderList;

    public CoffeeService() {
        orderList = new LinkedHashMap<>();
    }// 고객 주문저장

    Coffee coffee = Coffee.getInstance(); // 커피객체, 싱글톤객체
    Customer customer; // 손님객체
    Thread t = new Thread();
    Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("어서오세요 커피샵입니다.");
        customer = new Customer(orderNum);
        coffee.getmenu();
        order();
        totalorder(customer);
        try {
            System.out.println("기다려주시면 주문하신 음료가 나옵니다.");
            t.sleep(2000);
            end();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void order() {
        System.out.println("취소를 원하시면 0을 입력해주세요.");

        end: while (true) {
            try {
                System.out.print("주문할 음료의 번호를 입력해주세요.");
                String choice = scan.next();
                int choiceNum = Integer.parseInt(choice.substring(0, 1)); // 한 글자만 추출
                if (choiceNum == 0) {
                    System.out.println("주문을 취소합니다.");
                    System.exit(0);
                }
                scan.nextLine();
                String coffeeName = coffee.coffeeList.get(choiceNum - 1);
                System.out.println("선택하신 음료는 " + coffeeName + " 입니다. 몇 잔 주문하시겠습니까>");
                int orderCount = scan.nextInt();
                scan.nextLine();
                // 재주문
                if (reorder) {
                    for (String coff : orderList.keySet()) {
                        if (coff.equals(coffeeName)) {// 똑같은거 시킬 경우
                            int addCount = orderList.get(coff).intValue() + orderCount;
                            // 현재 수량에 추가 수량 추가
                            orderList.replace(coffeeName, addCount); // 수량 변경
                        } else {
                            orderList.put(coffeeName, orderCount);
                            break;
                        }
                    }
                } else {
                    orderList.put(coffeeName, orderCount);
                }
                // 추가주문
                customer.setCoffeeOrder(orderList);
                addorder();
                break end;

            } catch (Exception e) {
                System.out.println("잘못된 선택입니다.");
                continue;
            }
        }
    }

    private void end() {
        int s = 1;
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|           " + customer.getOrderName() + " 고객님 주문하신 음료 나왔습니다         | " + "\n");
        System.out.print(message);
        for (Map.Entry<String, Integer> order : customer.getCoffeeOrder().entrySet()) {
            System.out.printf(" | [%d] %-20s : %2d잔  %7s |\n", s, order.getKey(), order.getValue(), "");
            s++;
        }
        System.out.println(" |                                                    |");
        System.out.println(" +----------------------------------------------------+");
    }

    private void addorder() {
        reorder = false;
        System.out.println("\n주문을 계속 하시겠습니까?");
        System.out.println("예(Y)/아니오(N)");
        String yn = scan.next();
        if (yn.equals("예") || yn.equalsIgnoreCase("y")) {
            coffee.getmenu();
            reorder = true;
            order();
        } else if (yn.equals("아니오") || yn.equalsIgnoreCase("n")) {
            return;
        }
    }

    private void totalorder(Customer customer) {
        int s = 1;
        int totalmoney = 0;
        int coffeePrice = 0;
        DecimalFormat f = new DecimalFormat("###,000원");

        String name = customer.getOrderName() + "번";
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|             " + name + "고객님 의 주문 내역 입니다         | " + "\n");
        for (Map.Entry<String, Integer> order : customer.getCoffeeOrder().entrySet()) {
            // coffeePrice = coffee.menu.get(order.getKey()) +
            // customer.getCoffeeOrder().get(order.getKey());
            String coffeeName = order.getKey(); // 커피이름
            int orderCount = order.getValue(); // 커피수량
            int coffeeUnitPrice = coffee.menu.get(coffeeName); // 개당 커피가격
            coffeePrice = coffeeUnitPrice * orderCount;
            totalmoney = totalmoney + coffeePrice;

            String pay = f.format(coffeePrice); // 가격 포맷팅
            message.append(String.format(" | [%d] %-20s : %2d잔  %7s |\n", s, coffeeName, orderCount, pay));

            s++; // 리스트 인덱스 증가
            message.append(" |                                                    |\n ")
                    .append("+----------------------------------------------------+ \n")
                    .append(" ============ 총 결제 금액은 " + f.format(totalmoney) + "입니다 ========== \n");
            System.out.println(message);
            payment(totalmoney);

        }
    }

    // 결제하는 함수
    private void payment(int totalmoney) {
        System.out.println("\n결제를 도와드리겠습니다. 카드를 넣어주세요.");
        int payresult = customer.getMoney() - totalmoney;

        try {
            t.sleep(2500);
            System.out.println("결제중입니다.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (payresult < 0) {
            System.out.println("잔액이 부족합니다.");
        } else {
            customer.setMoney(payresult);
            System.out.println("결제가 완료되었습니다.");
            orderNum++;
        }
    }
}

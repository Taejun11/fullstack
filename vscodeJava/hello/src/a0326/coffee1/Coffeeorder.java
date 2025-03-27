package a0326.coffee1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coffeeorder {
    public static void main(String[] args) {
        Map<String, Integer> menu = new HashMap<>();
        menu.put("Americano", 3000);
        menu.put("Latte", 4000);
        menu.put("Mocha", 4500);
        menu.put("Espresso", 2500);

        Map<String, Integer> order = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        System.out.print("몇 명의 주문을 받으시겠습니까? ");
        int people = scan.nextInt();
        scan.nextLine();

        for(int i = 1; i <= people; i++){
            System.out.printf("\n%d번째 고객님 주문을 시작합니다.\n", i);
            while (true) {
                // System.out.println("메뉴");
                // for(Map.Entry<String, Integer> entry : menu.entrySet()){
                // System.out.println(entry.getKey() + " - " + entry.getValue() + "원");
                // }
                // menu.entrySet() : 커피이름, 가격 저장
    
                for (String coffee : menu.keySet()) {
                    System.out.println(coffee + " - " + menu.get(coffee) + "원");
                }
                System.out.println("주문할 커피 이름: (종료 exit)");
                String coffee = scan.nextLine();
                if (coffee.equals("exit")) {
                    break;
                }
                if (!menu.containsKey(coffee)) {// 입력한 메뉴가 맵에 없는 경우
                    System.out.println("해당 메뉴는 없습니다.");
                }
    
                System.out.print("수량: ");
                int quantity;
                while (true) {
                    try {
                        quantity = Integer.parseInt(scan.nextLine());
                        if (quantity <= 0) {
                            System.out.println("1 이상의 숫자를 입력하세요.");
                            continue;
                        }
                        break;
    
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력해주세요.");
                        // continue;
                    }
                }
    
                // order.put(coffee, quantity);
                order.put(coffee, order.getOrDefault(coffee, 0) + quantity);
                // getOrDefault: 맵에서 키가 존재하지 않을 경우 기본값을 반환하는 메서드
                // if (menu.containsKey(coffee)) {
                // order.put(coffee, quantity);
                // }
                System.out.println(coffee + " " + quantity + "개 추가되었습니다.");
                break;
            }
        }

        scan.close();
        System.out.println("\n주문내역");
        double total = 0;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            int price = menu.get(entry.getKey()) * entry.getValue();
            System.out.println(entry.getKey() + " * " + entry.getValue() + " = " + price + "원");
            total += price;
        }
        if (total >= 20000) {
            System.out.printf("할인 적용: 10%% 할인 - %.0f 원\n", total * 0.1);
            total = total * 0.9;
        }
        System.out.printf("총 금액: %.0f원", total);
    }
}

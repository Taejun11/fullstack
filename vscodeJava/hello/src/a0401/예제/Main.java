package a0401.예제;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Customer {
    private final String name;
    private final String city;

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Order {
    private final int id;
    private final Customer customer;
    private final String product;
    private final int quantity;

    public Order(int id, Customer customer, String product, int quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Kim", "Seoul");
        Customer customer2 = new Customer("Lee", "Busan");
        Customer customer3 = new Customer("Park", "Seoul");
        Customer customer4 = new Customer("Choi", "Seoul");

        List<Order> orders = Arrays.asList(
                new Order(1, customer1, "Laptop", 1),
                new Order(2, customer2, "Smartphone", 2),
                new Order(3, customer3, "Keyboard", 1),
                new Order(4, customer1, "Mouse", 3),
                new Order(5, customer4, "Monitor", 1),
                new Order(6, customer3, "USB Cable", 2)
        );

        // 여기에 답을 작성하세요.
        // 1. 서울의 고객의 주문만 출력
        answer1(orders);
        // 2. 모든 주문의 총 수량 출력, mapToInt 사용
        answer2(orders);
        // 3. 각 고객의 이름과 제품명 출력
        answer3(orders);
        // 4. Kim의 주문만 출력
        answer4(orders);
        // 5. 수량이 2 이상인 주문만 출력
        answer5(orders);
        // 6. 고객이 주문한 제품의 종류를 중복없이 출력
        answer6(orders);
        // 7. 모든 고객의 주문을 수량 기준 내림차순으로 정렬
        answer7(orders);
        // 8. 각 도시별 고객 수 출력 , count 이용
        answer8(orders);
    }

    

    private static void answer8(List<Order> orders) {
        long result = orders.stream()
                            .filter(or -> "Seoul".equals(or.getCustomer().getCity()))
                            .count();
        System.out.println("문제8: "+result);
        
    }



    private static void answer7(List<Order> orders) {
        List<Order> result = orders.stream()
                                    .sorted(Comparator.comparing(Order::getQuantity).reversed())
                                    .collect(Collectors.toList());
        System.out.println("문제7: "+result);
    }

    private static void answer6(List<Order> orders) {
        List<String> result = orders.stream()
                                    .map(Order::getProduct)
                                    .distinct()
                                    .collect(Collectors.toList());
        System.out.println("문제6: "+result);
    }

    private static void answer5(List<Order> orders) {
        List<Order> result = orders.stream()
                                    .filter(or -> 2 <= or.getQuantity())
                                    .collect(Collectors.toList());
        System.out.println("문제5: "+result);

    }

    private static void answer4(List<Order> orders) {
        List<Order> result = orders.stream()
                                    .filter(or -> "Kim".equals(or.getCustomer().getName()))
                                    .collect(Collectors.toList());
        System.out.println("문제4: "+result);

    }

    private static void answer3(List<Order> orders) {
        List<String> result = orders.stream()
                                    .map(Order::getProduct)
                                    .collect(Collectors.toList());
        List<String> result2 = orders.stream()
                                    .map(Order::getCustomer)
                                    .map(Customer::getName)
                                    .collect(Collectors.toList());

        System.out.println("문제3: "+result +""+result2);

    }

    private static void answer2(List<Order> orders) {
        int result = orders.stream()
                            .mapToInt(Order::getQuantity)
                            .sum();
        System.out.println("문제2: "+result);
    }

    private static void answer1(List<Order> orders) {
        List<Order> result = orders.stream()
                                .filter(or -> ("Seoul").equals(or.getCustomer().getCity()))
                                .collect(Collectors.toList());
        System.out.println("문제1: "+result);
    }
}
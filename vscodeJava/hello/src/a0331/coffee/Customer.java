package a0331.coffee;

import java.util.Map;

public class Customer {
    private int ordurNum; // 고객의 주문 번호
    private int money; // 고객의 돈
    private Map<String, Integer> coffeeOrder; // 고객의 주문을 저장

    public Customer(int ordurNum) {
        this.ordurNum = ordurNum;
        this.money = 20000;
    }

    public Map<String, Integer> getCoffeeOrder() {
        return coffeeOrder;
    }

    public void setCoffeeOrder(Map<String, Integer> coffeeOrder) {
        this.coffeeOrder = coffeeOrder;
    }

    public int getOrdurNum() {
        return ordurNum;
    }

    public void setOrdurNum(int ordurNum) {
        this.ordurNum = ordurNum;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getOrderName() {//고객1, 고객2 ......
        return "고객" + ordurNum;
    }

}

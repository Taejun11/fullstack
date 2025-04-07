import java.util.ArrayList;

public class lot {
    private static ArrayList<Car> cars = new ArrayList<>();

    public static void parkCar(String number, int inTime) {
        // 1번
        cars.add(new Car(number, inTime));
        System.out.println(number + "입차 완료");
    }

    public static void exitCar(String number, int outTime) {
        // 2번
        for (Car c : cars) {
            if (c.getCarNumber().equals(number)) {
                int price = (outTime - c.getInTime());
                System.out.println("요금: " + price*100 + "원");
                cars.remove(c);
                break;
            }
        }

    }

    public static void showCars() {
        // 3번
        System.out.println("현재 주차 차량:");
        for (Car c : cars) {
            System.out.print("차량 번호: ");
            System.out.println(c.getCarNumber() + ", 입차시간: " + c.getInTime());
        }
    }

}

package a0325.숙소;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotelmanager {
    private ArrayList<Accommodation> accommodations; // 객체를 배열로 저장
    private ArrayList<Accommodation> accLoc;// 예약된 객체를 저장

    public Hotelmanager() {
        accommodations = new ArrayList<>();
        accLoc = new ArrayList<>();
        accommodations.add(new Accommodation("Hotel A", "Seoul", 100.0)); // 이름, 지역, 평점
        accommodations.add(new Accommodation("a", "a", 1)); // 이름, 지역, 평점
        accommodations.add(new Accommodation("Hotel B", "Busan", 80.0));
        accommodations.add(new Accommodation("Hotel C", "Jeju", 120.0));
    }

    public void allHotel() {// 1번
        System.out.println("예약 가능한 숙소 보기");
        for (Accommodation acc : accommodations) {
            if (acc.isAvailable()) {
                System.out.println(acc);
            }
        }
    }

    public boolean reservation(String reserv) {// 2번
        for (Accommodation acc : accommodations) {
            if (acc.getName().equalsIgnoreCase(reserv) && acc.isAvailable()) {
                acc.reservation();
                accLoc.add(acc);
                return true;
            }
        }
        return false;
    }

    public void already() {// 3번
        for (Accommodation acc : accLoc) {
            System.out.println(acc);
        }
    }

    public void add(String newName, String newLocation, double newPrice) {
        // 4번
        accommodations.add(new Accommodation(newName, newLocation, newPrice));
    }

    public void del(String delName) {// 5번
        boolean result = false;
        for (Accommodation acc : accommodations) {
            if (acc.getName().equalsIgnoreCase(delName)) {
                if (acc.isAvailable()) {
                    accommodations.remove(acc);
                    result = true;
                    break;
                }
            }
            // } else {
            // result = false;
            // break;
            // }
        }
        if (result) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("이미 삭제되었거나 없는 이름입니다.");
        }
    }

    public void update(String update, Scanner scan) {// 6번
        int i = 0;
        int index = -1;
        int menu = -1;
        boolean flag = true;
        // Scanner scan = new Scanner(System.in);
        Accommodation newA = new Accommodation();

        for (Accommodation acc : accommodations) {
            i++;
            if (acc.getName().equals(update)) {
                index = i - 1;
                newA = acc;
            }
        }
        if (index != -1) { // 같은 이름의 객체를 찾은 경우
            System.out.println("수정할 사항을 입력하세요.");
            System.out.println("1.숙소 이름");
            System.out.println("2.숙소 지역");
            System.out.println("3.숙소 평점");
            menu = Integer.parseInt(scan.nextLine());
            // scan.nextLine();

            while (flag) {
                switch (menu) {
                    case 1:
                        System.out.println("수정할 숙소 이름으로 입력하세요.");
                        newA.setName(scan.nextLine());
                        accommodations.set(index, newA);
                        flag = false;
                        break;
                    case 2:
                        System.out.println("수정할 숙소 지역으로 입력하세요.");
                        newA.setLocation(scan.nextLine());
                        accommodations.set(index, newA);
                        flag = false;
                        break;
                    case 3:
                        System.out.println("수정할 숙소 평점으로 입력하세요.");
                        newA.setPrice(scan.nextDouble());
                        scan.nextLine();
                        accommodations.set(index, newA);
                        flag = false;
                        break;

                    default:
                        System.out.println("다시 입력해주세요.");
                        menu = scan.nextInt();
                        scan.nextLine();
                        break;
                }
            }
        } else {
            System.out.println("찾는 숙소가 없습니다.");
        }
        // scan.close();
    }

    public void show(String search) {// 7번
        for (Accommodation acc : accommodations) {
            if (acc.getName().equalsIgnoreCase(search)) {
                System.out.println(acc.toString());
            }
        }
    }

}

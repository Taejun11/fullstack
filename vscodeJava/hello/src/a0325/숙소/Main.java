package a0325.숙소;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        Hotelmanager manager = new Hotelmanager();
        while (flag) {
            System.out.println("\n숙소 예약 시스템에 오신 것을 환영합니다.");
            System.out.println("1. 예약 가능한 숙소 보기");
            System.out.println("2. 숙소 예약하기");
            System.out.println("3. 예약한 숙소 보기");
            System.out.println("4. 숙소 추가하기");
            System.out.println("5. 숙소 삭제하기");
            System.out.println("6. 숙소 정보 수정하기");// 할 차례
            System.out.println("7. 숙소 정보 조회하기");
            System.out.println("8. 종료");
            System.out.print("원하는 작업을 선택하세요 > ");
            int choice = Integer.parseInt(scan.nextLine());
            // scan.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("예약 가능한 숙소");
                    manager.allHotel();
                    break;
                case 2:
                    System.out.println("숙소 예약");
                    System.out.println("예약할 숙소의 이름을 입력하세요: ");
                    String reserv = scan.nextLine();
                    if (manager.reservation(reserv)) {
                        System.out.println("숙소 예약이 되었습니다.");
                    } else {
                        System.out.println("예약이 이미 다 되었거나 불가능합니다.");
                    }
                    break;
                case 3:
                    System.out.println("이미 예약된 숙소");
                    manager.already();
                    break;
                case 4:
                    System.out.println("숙소 추가");
                    // 이름, 지역, 평점
                    System.out.println("추가할 숙소 이름:");
                    String newName = scan.nextLine();
                    System.out.println("추가할 숙소 지역:");
                    String newLocation = scan.nextLine();
                    System.out.println("추가할 숙소 평점:");
                    double newPrice = scan.nextDouble();
                    scan.nextLine();
                    manager.add(newName, newLocation, newPrice);
                    System.out.println("숙소 추가 완료");
                    break;
                case 5:
                    System.out.println("숙소 삭제");
                    System.out.println("삭제할 숙소 이름: ");
                    String delName = scan.nextLine();
                    manager.del(delName);
                    break;
                case 6:
                    System.out.println("숙소 정보 수정");
                    System.out.println("수정할 숙소의 이름을 적어주세요.");
                    String update = scan.nextLine();
                    if (update.equals("")) {
                        System.out.println("다시 입력해 주세요.");
                        update = scan.nextLine();
                    }
                    manager.update(update, scan);
                    break;
                case 7:
                    System.out.println("숙소 정보 조회");
                    System.out.println("조회할 숙소의 이름을 적어주세요");
                    String search = scan.nextLine();
                    if (search.equals("")) {
                        System.out.println("다시 입력해 주세요.");
                        search = scan.nextLine();
                    }
                    manager.show(search);
                    break;
                case 8:
                    System.out.println("시스템 종료");
                    flag = false;
                    // System.exit(0);
                    break;

                default:
                    break;
            }
        }

        scan.close();
    }
}
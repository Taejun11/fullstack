package a0327.멤버1;

import java.util.Scanner;

public class Menbership {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MemberManager manager = new MemberManager();

        while (true) {
            System.out.println("\n===== 회원 관리 프로그램 =====");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 검색");
            System.out.println("3. 회원 수정");
            System.out.println("4. 회원 삭제");
            System.out.println("5. 전체 회원 목록 보기");
            System.out.println("6. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scan.nextInt();
            scan.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    // 이름, 나이, 이메일 입력받아 회원 추가하는 메서드
                    manager.addmember(scan);
                    break;
                case 2:
                    // 회원 한 명의 정보를 출력하는 메서드
                    System.out.print("검색할 회원의 이름을 입력하세요: ");
                    String searchName = scan.nextLine();
                    Member foundMember = manager.findMember(searchName);
                    if (foundMember != null) {
                        System.out.println("회원 정보: " + foundMember);
                    } else {
                        System.out.println("해당 이름의 회원이 없습니다.");
                    }
                    break;
                case 3:
                    // 회원 정보 수정하는 메서드
                    manager.updatemember(scan);
                    break;
                case 4:
                    // 회원 정보 삭제하는 메서드
                    manager.delmember(scan);
                    break;
                case 5:
                    // 회원 전체 정보를 출력하는 메서드
                    manager.displayAllMembers();
                    break;
                case 6:
                    System.out.println("프로그램 종료");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("다시 입력해주세요.");
                    break;
            }
        }
    }
}

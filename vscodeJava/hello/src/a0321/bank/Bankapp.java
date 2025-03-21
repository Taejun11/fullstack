package a0321.bank;

import java.util.Scanner;

public class Bankapp {
    private static Account[] accountArray = new Account[100];
    // 계좌정보를 하나의 배열에 저장
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("-----------------------------------------------------");
            System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.계좌이체|6.종료");
            System.out.println("-----------------------------------------------------");
            System.out.print("선택>");
            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                createAccount();
            } else if (select == 2) {
                accountList();
            } else if (select == 3) {
                deposit();
            } else if (select == 4) {
                withdraw();
            } else if (select == 5) {
                // 이체
                transfer();
            } else if (select == 6) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }

    // 계좌 생성 함수
    private static void createAccount() {
        System.out.println("---------");
        System.out.println("계좌 생성");
        System.out.println("---------");

        System.out.print("계좌번호: ");
        String ano = scan.nextLine();
        System.out.print("계좌주: ");
        String owner = String.format(scan.nextLine());
        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(scan.nextLine());

        Account newAccount = new Account(ano, owner, balance);
        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) {
                accountArray[i] = newAccount;
                System.out.println("결과: 계좌가 생성되었습니다.");
                break;
            }
        }
    }

    // 계좌 출력 함수
    private static void accountList() {
        System.out.println("---------");
        System.out.println("계좌 목록");
        System.out.println("---------");

        for (int i = 0; i < accountArray.length; i++) {
            Account account = accountArray[i];
            if (account != null) {
                System.out.print(account.getAno());
                System.out.print("    ");
                System.out.print(account.getOwner());
                System.out.print("    ");
                System.out.print(account.getBalance());
                System.out.println();
            }
        }
    }

    // 예금 함수
    private static void deposit() {
        System.out.println("---------");
        System.out.println("예금");
        System.out.println("---------");

        // 계좌번호, 예금액 받기
        System.out.print("계좌번호: ");
        String ano = scan.nextLine();
        System.out.print("예금액: ");
        int money = Integer.parseInt(scan.nextLine());

        Account account = findAccount(ano);
        if (account == null) {
            System.out.println("결과: 해당 계좌가 없습니다.");
            return;
        }
        account.setBalance(account.getBalance() + money);
    }

    // 출금 함수
    private static void withdraw() {
        System.out.println("---------");
        System.out.println("출금");
        System.out.println("---------");

        // 계좌번호, 예금액 받기
        System.out.print("계좌번호: ");
        String ano = scan.nextLine();
        System.out.print("출금액: ");
        int money = Integer.parseInt(scan.nextLine());

        Account account = findAccount(ano);
        if (account == null) {
            System.out.println("결과: 해당 계좌가 없습니다.");
            return;
        }
        account.setBalance(account.getBalance() - money);
    }

    // 예금 출금을 위한 계좌번호 찾는 함수
    private static Account findAccount(String ano) {
        Account account = null; // 빈 객체 생성, 일치하는 계정 찾으면 여기에 넣음
        for (int i = 0; i < accountArray.length; i++) { // 모든 객체 탐색
            if (accountArray[i] != null) { // 객체가 null이 아닐 경우 분석
                String dbAno = accountArray[i].getAno(); // 해당 계좌번호 임시저장
                if (dbAno.equals(ano)) {
                    account = accountArray[i];
                    break;
                    // 계좌번호 맞으면 객체로 옮김
                }
            }
        }
        return account;
    }

    // 계좌이체 함수
    private static void transfer() {
        System.out.println("---------");
        System.out.println("계좌이체");
        System.out.println("---------");

        System.out.print("입금할 계좌번호: ");// 돈이 들어와야 함
        String ano1 = scan.nextLine();
        System.out.print("출금할 계좌번호: ");// 돈이 나가야 함
        String ano2 = scan.nextLine();
        System.out.print("입금할 금액: ");
        int money = Integer.parseInt(scan.nextLine());

        Account account1 = findAccount(ano1);
        Account account2 = findAccount(ano2);
        if (account1 == null) {
            System.out.println("결과: 입금할 계좌가 없습니다.");
            return;
        }
        if (account2 == null) {
            System.out.println("결과: 출금할 계좌가 없습니다.");
            return;
        }

        account1.setBalance(account1.getBalance() + money);
        account2.setBalance(account2.getBalance() - money);

        System.out.println("결과: 계좌이체가 완료 되었습니다.");
    }
}
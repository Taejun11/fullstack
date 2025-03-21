package a0321.account;

public class Accounttest {
    public static void main(String[] args) {
        Account acc = new Account();
        // acc.balance = 1000;
        // System.out.println(acc.balance);
        acc.setBalance(1000);
        System.out.printf("잔액: %d", acc.getBalance());
    }
}

class Account {
    // private 다른 클래스에서 접근 불가
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // public void setBalance(int n) {
    //     balance = n;
    //     // private에 접근 가능
    // }
    // public int getBalance() {
    //     return balance;
    //     // private에 접근 가능
    // }
}
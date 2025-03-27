package a0327.멤버1;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
    // private ArrayList<Member> members = new ArrayList<>();;

    private ArrayList<Member> members;

    public MemberManager() {
        members = new ArrayList<>();
    }

    public void addmember(Scanner scan) {// 1번
        System.out.print("추가할 이름을 입력하세요.: ");
        String name = scan.nextLine();
        System.out.print("추가할 나이를 입력하세요.: ");
        int age = Integer.parseInt(scan.nextLine());
        System.out.print("추가할 이메일을 입력하세요.: ");
        String email = scan.nextLine();
        members.add(new Member(name, age, email));
        System.out.println("회원이 추가되었습니다.");
    }

    public Member findMember(String name) {// 2번
        for (Member m : members) {
            if (m.getName().equals(name)) {
                return m;
            }
        }
        return null;
    }

    public void updatemember(Scanner scan) {// 3번
        System.out.print("수정할 회원의 이름을 입력하세요.: ");
        String newname = scan.nextLine();
        System.out.print("새로운 나이를 입력하세요.: ");
        int newage = Integer.parseInt(scan.nextLine());
        System.out.print("새로운 이메일을 입력하세요.: ");
        String newemail = scan.nextLine();

        // Member m = findMember(newname);
        // if (m != null) {
        // m.setAge(newage);
        // m.setEmail(newemail);
        // System.out.println("회원이 수정되었습니다.");

        // } else {
        // System.out.println("회원을 찾을 수 없습니다.");
        // }
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(newname)) {
                members.set(i, new Member(newname, newage, newemail));
                System.out.println("회원이 수정되었습니다.");
                return;

            }
        }
        System.out.println("회원을 찾을 수 없습니다.");

    }

    public void delmember(Scanner scan) {// 4번
        System.out.print("삭제할 회원의 이름을 입력하세요.: ");
        String delname = scan.nextLine();

        Member m = findMember(delname);
        if (m != null) {
            members.remove(m);
            System.out.println("회원이 삭제되었습니다.");

        } else {
            System.out.println("회원을 찾을 수 없습니다.");
        }
    }

    public void displayAllMembers() {// 5번
        if (members.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
        } else {
            for (Member m : members) {
                System.out.println(m);
            }
        }

    }
}

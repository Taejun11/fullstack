package a0326.grade;

import java.util.ArrayList;
import java.util.Scanner;

public class Grademanager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);
    private static int idcounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== 성적 관리 프로그램 ===");
            System.out.println("1. 성적 추가");
            System.out.println("2. 성적 조회");
            System.out.println("3. 성적 수정");
            System.out.println("4. 성적 삭제");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.out.println("프로그램 종료");
                    scan.close();
                    System.exit(0);
                    // return;
                // break;

                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

    private static void addStudent() {
        System.out.print("학생 이름: ");
        String name = scan.nextLine();
        System.out.print("점수 입력: ");
        int score = Integer.parseInt(scan.nextLine());
        // Student student = new Student();
        // student.setId(idcounter++);
        // student.setName(name);
        // student.setScore(score);
        Student students = new Student(idcounter++, name, score);
        // students.add(idcounter++, name, score);
        System.out.println("성적이 추가되었습니다.");
    }

    private static void viewStudent() {
        if (students.isEmpty()) {// 등록된 학생이 없을 경우 실행
            System.out.println("등록된 성적이 없습니다.");
        } else {
            System.out.println("성적 목록");
            for (Student s : students) {
                s.display();

            }
        }
    }

    private static void updateStudent() {
        System.out.println("수정할 학생 id 입력: ");
        int id = scan.nextInt();
        scan.nextLine();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("새로운 점수 입력: ");
                int newScore = scan.nextInt();
                scan.nextLine();
                s.setScore(newScore);
                System.out.println("성적이 수정되었습니다.");
                return; // return 없으면 계속해서 for문 수행함
            }
        }
        System.out.println("해당 id의 학생을 찾을 수가 없습니다.");
    }

    private static void removeStudent() {
        System.out.println("삭제할 학생 id 입력: ");
        int id = scan.nextInt();
        scan.nextLine();
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("성적이 삭제되었습니다.");
                return; // return 없으면 계속해서 for문 수행함
            }
        }
        System.out.println("해당 id의 학생을 찾을 수가 없습니다.");
    }
}

package a0328.file2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
    private ArrayList<StudentDTO> sList;
    Scanner scan = new Scanner(System.in);
    FileClass file = new FileClass("student", "grade");

    public StudentDAO() {//기본
        sList = new ArrayList<StudentDTO>();

        StudentDTO s1 = new StudentDTO(0, "테스트1", 11, 100, 90, 80);
        StudentDTO s2 = new StudentDTO(1, "테스트2", 22, 90, 89, 91);
        StudentDTO s3 = new StudentDTO(2, "테스트3", 33, 85, 77, 55);
        StudentDTO s4 = new StudentDTO(3, "테스트4", 44, 77, 68, 85);
        sList.add(s1);
        sList.add(s2);
        sList.add(s3);
        sList.add(s4);
    }

    public void userInsert() {// 1번
        StudentDTO s = new StudentDTO();
        s.setId(sList.size());
        System.out.println("학생 추가하기");
        System.out.print("이름: ");
        s.setName(scan.next());// 바로 입력받고 바로 추가
        System.out.print("나이: ");
        s.setAge(scan.nextInt());
        scan.nextLine();
        System.out.print("국어점수: ");
        s.setKor(scan.nextInt());
        scan.nextLine();
        System.out.print("영어점수: ");
        s.setEng(scan.nextInt());
        scan.nextLine();
        System.out.print("수학점수: ");
        s.setMath(scan.nextInt());
        scan.nextLine();

        // sList.add(s);
        insert(s);
        System.out.println("학생이 추가되었습니다.");
    }

    private void insert(StudentDTO s) {// 1번
        sList.add(s);
    }

    public void userDelete() {// 2번
        System.out.println("학생 삭제하기");
        int index = searchIndex();
        if (index == -1) {
            System.out.println("찾는 학생이 없습니다.");
        } else {
            String name = sList.get(index).getName();
            delete(index);
            System.out.println(name + " 학생정보를 삭제했습니다.");
        }
    }

    private void delete(int index) {// 2번
        sList.remove(index);
    }

    private int searchIndex() {// 찾기 함수
        int index = -1;
        System.out.println("학생이름을 입력하세요");
        System.out.print(">>");
        String name = scan.next();
        for (int i = 0; i < sList.size(); i++) {
            if (sList.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void userSelect() {// 3번
        System.out.println("학생 정보보기");
        int index = searchIndex();
        if (index == -1) {
            System.out.println("찾는 학생이 없습니다.");
        } else {
            System.out.println("이름\t나이\t국어\t영어\t수학\n" + "-------------------------------------");
            StudentDTO s = select(index);
            System.out.println(s);
        }
    }

    private StudentDTO select(int index) {// 3번
        return sList.get(index);// 해당 인덱스 번호에 있는 객체를 반환
    }

    public void userUpdate() {// 4번
        System.out.println("학생 정보수정");
        int index = searchIndex();
        if (index == -1) {
            System.out.println("찾는 학생이 없습니다.");
        } else {
            StudentDTO s = new StudentDTO();
            s.setId(sList.get(index).getId());// 고정해둘 정보
            s.setName(sList.get(index).getName());// 고정해둘 정보
            s.setAge(sList.get(index).getAge());// 고정해둘 정보
            System.out.println(sList.get(index).getName() + " 학생 점수 수정");
            System.out.print("국어점수: ");
            s.setKor(scan.nextInt());
            scan.nextLine();
            System.out.print("영어점수: ");
            s.setEng(scan.nextInt());
            scan.nextLine();
            System.out.print("수학점수: ");
            s.setMath(scan.nextInt());
            scan.nextLine();
            // sList.set(index, s);
            update(index, s);
        }
    }

    private void update(int index, StudentDTO s) {//4번
        sList.set(index, s);
    }

    public void printAll() {//5번
        System.out.println("이름\t나이\t국어\t영어\t수학\n" + "-------------------------------------");
        for(int i = 0; i < sList.size(); i++){
            System.out.println(sList.get(i).toString());
        }
    }

    public void datasave() throws Exception{//6번
        file.create();
        String str = "이름\t나이\t국어\t영어\t수학\n" + "-------------------------------------\n";
        for(int i = 0; i < sList.size(); i++){
            str += sList.get(i).toString()+"\n";
        }
        file.write(str);
    }

    public void dataload() {//7번
        try {
            file.read();
        } catch (Exception e) {
            System.out.println("읽을 파일이 없습니다.");
        }
    }

}

package a0401;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class List3 {
    public static void main(String[] args) {
        // ArrayList 생성
        List<Student> studentList = new ArrayList<>();

        // 객체추가
        studentList.add(new Student(101, "Alice", 20));
        studentList.add(new Student(102, "Bob", 22));
        studentList.add(new Student(103, "Charlie", 21));
        // Arraylist 내용 출력
        System.out.println("리스트 출력");
        // studentList.sort(Comparator.comparing(Student::getName));
        // studentList.forEach(s -> System.out.println(s));
        printList(studentList);
        System.out.println();
        // 1번인덱스 가져온 후 출력
        // System.out.println(studentList.get(1).getName());
        Student s = studentList.get(1);
        String name = studentList.get(1).getName();
        System.out.println(s + " " + name);

        // 모든 student의 이름만 출력
        studentList.stream()
                .map(Student::getName)
                .forEach(System.out::println);
        // 데이터 추가 104, "David", 23

        studentList.add(new Student(104, "David", 23));
        // 데이터 변경 102, "Robert", 25
        updateStudent(studentList, 102, "Robert", 25);
        printList(studentList);
        // 데이터 삭제
        System.out.println("\n특정 학생 삭제");
        deleteStudent(studentList, 103);
        printList(studentList);
        // 특정 학생 검색
        System.out.println("\n 특정 학생 검색");
        Student searchedStudent = findStudentById(studentList, 104);
        System.out.println(searchedStudent != null ? searchedStudent : "학생을 찾을 수 없습니다.");

    }

    private static Student findStudentById(List<Student> studentList, int id) {
        return studentList.stream()
                        .filter(student -> student.getId()==id)
                        .findFirst()
                        .orElse(null);
    }

    private static void deleteStudent(List<Student> studentList, int id) {
        boolean removed = studentList.removeIf(student -> student.getId() == id);
        System.out.println( removed ? "학생 id: " + id + " 정보 삭제완료" : "해당 id없음");
    }

    private static void updateStudent(List<Student> studentList, int id, String string, int age) {
        boolean updated = studentList.stream()
                                    .filter(student -> student.getId() == id)
                                    .peek(student -> {
                                        student.setName(string);
                                        student.setAge(age);
                                    })
                                    .findFirst()
                                    .isPresent();
        System.out.println( updated ? "학생 id: " + id + " 정보 수정완료" : "해당 id없음");
    }

    private static void printList(List<Student> studentList) {
        studentList.forEach(System.out::println);
    }

}

class Student {

    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
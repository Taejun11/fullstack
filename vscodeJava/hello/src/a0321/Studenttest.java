package a0321;

public class Studenttest {
    public static void main(String[] args) {
        Student park = new Student(2019122104, "park");
        Student kim = new Student(2019122132, "kim");
        Student lee = new Student(2019122111, "lee");

        System.out.printf("Student 객체의 수 : %d",Student.count);
    }
}

class Student{
    // 전역변수
    static int count = 0;

    // 인스턴스 변수
    int id;
    String name;

    // 생성자
    Student(int i, String n){
        Student.count++;
        id = i;
        name = n;
    }
}
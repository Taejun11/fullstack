package a0320;

public class Class4 {
    public static void main(String[] args) {
        Student s = new Student("asd", 3, "asd과");
        Student s1 = new Student("qwe", 2, "qwe과");
        System.out.printf("이름:%s\n학년:%d\n학과:%s\n", s.name, s.grade, s.department);
        System.out.printf("이름:%s\n학년:%d\n학과:%s\n", s1.name, s1.grade, s1.department);
    }
}

class Student {
    

    String name;
    int grade;
    String department;
    public Student(String n, int g, String d) {
        name = n;
        grade = g;
        department = d;
    }
}
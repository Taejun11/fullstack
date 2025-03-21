package a0321.account;

public class Main2 {
    public static void main(String[] args) {
        Student student1 = new Student("홍길동", 20231234, 90, 85, 92);
        // 학생정보 출력
        System.out.println("이름: " + student1.getName());
        System.out.println("학번: " + student1.getStudentId());
        System.out.println("국어: " + student1.getkor());
        System.out.println("수학: " + student1.getmat());
        System.out.println("영어: " + student1.geteng());
        System.out.println("평균: " + student1.getavg());

        Student student2 = new Student();
        student2.setName("asd");
        student2.setStudentId(20135987);
        student2.setkor(90);
        student2.setmat(85);
        student2.seteng(95);

        System.out.println("이름: " + student2.getName());
        System.out.println("학번: " + student2.getStudentId());
        System.out.println("국어: " + student2.getkor());
        System.out.println("수학: " + student2.getmat());
        System.out.println("영어: " + student2.geteng());
        System.out.println("평균: " + student2.getavg());

    }
}

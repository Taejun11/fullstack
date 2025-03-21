package a0321.account;

public class Student {
    private String name;
    private int StudentId;
    private int kor, mat, eng;

    public Student(String name, int StudentId, int kor, int mat, int eng){
        this.name = name;
        this.StudentId = StudentId;
        this.kor = kor;
        this.mat = mat;
        this.eng = eng;
    }
    public Student(){}

    public String getName(){
        return name;
    }
    public int getStudentId(){
        return StudentId;
    }
    public int getkor(){
        return kor;
    }
    public int getmat(){
        return mat;
    }
    public int geteng(){
        return eng;
    }



    public void setName(String name){
        // return name;
        this.name = name;
    }
    public void setStudentId(int StudentId){
        // return StudentId;
        this.StudentId = StudentId;
    }
    public void setkor(int kor){
        // return kor;
        this.kor = kor;
    }
    public void setmat(int mat){
        // return mat;
        this.mat = mat;
    }
    public void seteng(int eng){
        // return eng;
        this.eng = eng;
    }

    public double getavg() {
        double result = (kor + mat + eng) / 3;
        return result;
    }
}

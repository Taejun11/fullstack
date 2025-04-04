package a0404.영화관;

import java.time.LocalDate;
import java.time.Period;

public class Customer {
    // 예매정보 저장, 나이 검증
    private String name;    //이름
    private int birthdate;  //주민번호 앞자리
    private String pw;      //비밀번호
    private String seat;    //예매한 좌석
    
    public Customer(String name, int birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
    public Customer(String name, int birthdate, String pw) {
        this.name = name;
        this.birthdate = birthdate;
        this.pw = pw;
    }



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }

    // 예매자의 연령 확인
    public int manAge(Customer c){
        int y = c.birthdate / 10000;// 831016 / 10000 = 83 년도 추출
        int m = (c.birthdate % 10000) / 100;// 831016 % 10000 = 1016 / 100 = 10 월 추출
        int d = c.birthdate % 100; // 831016 % 100 = 16 일 추출 

        if (y > 0 && y <= 25) {
            y += 2000;
        }else{
            y += 1900;
        }

        LocalDate birthDate2 = LocalDate.of(y, m, d);
        LocalDate curreDate = LocalDate.now();
        int age = Period.between(birthDate2, curreDate).getYears();
        return age;
    }
}

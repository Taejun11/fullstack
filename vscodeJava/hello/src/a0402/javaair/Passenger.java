package a0402.javaair;

import java.time.LocalDate;
import java.time.Period;

public class Passenger {
    // 예매정보 저장, 나이검증
    private String name;
    private int birthdate; //000000 주민번호 앞자리
    private String pw;
    private String seat;
    public Passenger(String name, int birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
    public Passenger(String name, int birthdate, String pw) {
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


    // 15세 이상만 국제선 가능
    public boolean man15(Passenger p){ 
        int y = p.birthdate / 10000;// 831016 / 10000 = 83 년도 추출
        int m = (p.birthdate % 10000) / 100;// 831016 % 10000 = 1016 / 100 = 10 월 추출
        int d = p.birthdate % 100; // 831016 % 100 = 16 일 추출

        if (y>0 && y<=25) {
            y = y + 2000;
        }else{
            y = y + 1900;
        }

        LocalDate birthdate2 = LocalDate.of(y, m, d); //승객의 생년월일
        LocalDate currentdate = LocalDate.now();      //오늘 날짜
        int age = Period.between(birthdate2, currentdate).getYears();
        // Period.between : 두 날짜의 차이를 구하는 함수
        // System.out.println(age);
        return age > 15;
    }
}

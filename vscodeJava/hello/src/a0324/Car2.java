package a0324;

public class Car2 {
    // 필드
    String color;
    String company;
    String type;

    Car2(String color, String company, String type) {
        this.color = color;
        this.company = company;
        this.type = type;
    }
    Car2(String com, String t) {
        this("white", com, t);
    }
    Car2(String t) {
        this("white", "기아", t);
    }

    Car2(){
        this("white", "기아", "경차");
    }

    // public String toString(){
    //     return color + "-" + company + "-" + type;
    // }
    // @Override
    // public String toString(){
    //     return "Car2 [color = "+ color + ", company = " + company + ", type = " + type+"]";
    // }

    // toString() : 기본적으로는 주소값을 반환
    // toString() 재정의 : 객체 정보를 의미있게 출력
    // System.out.println("c1 = "+c1); 기본으로 .toString()이 생략된 상태
    
}

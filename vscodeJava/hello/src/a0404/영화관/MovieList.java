package a0404.영화관;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MovieList {
    private String title;   //영화제목
    private String time;    //영화 시작시간
    private String runningtime;//영화 길이
    private int price;      //영화 금액
    private int adultOnly;//영화 연령가
    private DecimalFormat priceFormat = new DecimalFormat("#,###원"); //금액 형식



    // 더미데이터 넣을 구조체 제목, 시작시간, 길이, 금액, 영화 연령가
    public MovieList(String title, String time, String runningtime, int price, int adultOnly) {
        this.title = title;
        this.time = time;
        this.runningtime = runningtime;
        this.price = price;
        this.adultOnly = adultOnly;
        seats = new ArrayList<>();
        for(int i = 1; i <= 40; i++){
            seats.add(i+"");
        }
    }
    private ArrayList<String> seats;//좌석
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    // 영화제목

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    //영화 시작시간

    public String getRunningtime() {
        return runningtime;
    }
    public void setRunningtime(String runningtime) {
        this.runningtime = runningtime;
    }
    //영화 길이

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    //영화 금액

    public int getAdultOnly() {
        return adultOnly;
    }
    public void setAdultOnly(int adultOnly) {
        this.adultOnly = adultOnly;
    }
    //영화 청불여부

    public ArrayList<String> getSeats() {
        return seats;
    }
    public void setSeats(ArrayList<String> seats) {
        this.seats = seats;
    }
    //좌석

    public DecimalFormat getPriceFormat() {
        return priceFormat;
    }
    public void setPriceFormat(DecimalFormat priceFormat) {
        this.priceFormat = priceFormat;
    }

    @Override
    public String toString() {
        // 스트링, 인트, 인트
        String priceForm = priceFormat.format(price);
        return ". "+"[" + title + " / " + time + " / " + runningtime + "분 / " + priceForm + " / " + adultOnly + "세]";
            //[영화제목/상영시간/러닝타임/금액/청불여부]
    }

    // 빈 좌석 보여주는 함수
    public void seatTostring(){
        for(int i = 0; i < seats.size(); i+=8){
            System.out.printf("|[%2s][%2s]  [%2s][%2s][%2s][%2s]  [%2s][%2s]\n"
            ,seats.get(i),seats.get(i+1),seats.get(i+2),seats.get(i+3),seats.get(i+4),seats.get(i+5),seats.get(i+6),seats.get(i+7));
        }
    }
}

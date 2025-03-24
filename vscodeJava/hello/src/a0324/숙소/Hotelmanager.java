package a0324.숙소;

import java.util.ArrayList;

public class Hotelmanager {
    private ArrayList<Accommodation> accommodations; // 객체를 배열로 저장
    private ArrayList<Accommodation> accLoc;// 예약된 객체를 저장

    public Hotelmanager() {
        accommodations = new ArrayList<>();
        accLoc = new ArrayList<>();
        accommodations.add(new Accommodation("Hotel A", "Seoul", 100.0)); // 이름, 지역, 평점
        accommodations.add(new Accommodation("Hotel B", "Busan", 80.0));
        accommodations.add(new Accommodation("Hotel C", "Jeju", 120.0));
    }

    public void allHotel() {
        System.out.println("예약 가능한 숙소 보기");
        for(Accommodation acc: accommodations){
            if (acc.isAvailable()) {
                System.out.println(acc);
            }
        }
    }

    public boolean reservation(String reserv) {
        for(Accommodation acc: accommodations){
            if (acc.getName().equalsIgnoreCase(reserv) && acc.isAvailable()) {
                acc.reservation();
                accLoc.add(acc);
                return true;
            }
        }
        return false;
    }

    public void already() {
        for(Accommodation acc: accLoc){
            System.out.println(acc);
        }
    }

    public void add(String newName, String newLocation, double newPrice) {
        accommodations.add(new Accommodation(newName, newLocation, newPrice));
    }

}

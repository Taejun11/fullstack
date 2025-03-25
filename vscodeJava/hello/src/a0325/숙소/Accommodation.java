package a0325.숙소;

public class Accommodation {
    private String name;
    private String location;
    private double price;
    private boolean available;

    public Accommodation() {}

    public Accommodation(String name, String location, double price) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "숙소 이름: " + name + ", 숙소 지역: " + location + ", 숙소 평점: " + price + ", 숙소 예약 가능 여부: "
                + (available ? "예약 가능" : "예약 불가능");
    }

    public void reservation() {
        this.available = false;
    }
}

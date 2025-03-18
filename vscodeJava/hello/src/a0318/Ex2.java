package a0318;

// 휘발유 8.86리터(L)를 충전한 자동차의 총 주행거리가 182.736km일 때, 해당 자동차의 연비를 
// 계산하는 프로그램을 작성하시오. 단, 연비 계산 과정은 메소드의 호출과 정의를 통해 구한다.
// 연비 = 이동거리 / 기름양
public class Ex2 {
    public static void main(String[] args) {
        double oil = 8.86;
        double km = 182.736;
        double yearoil = fuelEfficiency(oil, km);
        System.out.printf("휘발유 %.2f를 충전한 자동차의 주행거리가 %.3f일 때의 이 자동차의 연비: %.2f", oil, km ,yearoil);
    }

    public static double fuelEfficiency(double oil, double km) {
        return km / oil;
    }
}

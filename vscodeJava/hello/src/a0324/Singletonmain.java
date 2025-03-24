package a0324;

public class Singletonmain {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        // Singleton s4 = new Singleton(); //실행 안됨
        // 객체를 한번만 만드는 방식
        // 하나의 인스턴스만 유지하여 메모리 절역, 성능 최적화를 노리는 패턴
    }
}

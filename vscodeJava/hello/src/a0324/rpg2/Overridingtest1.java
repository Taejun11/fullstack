package a0324.rpg2;

public class Overridingtest1 {
    public static void main(String[] args) {
        Archer a = new Archer();
        Archer ma = (Archer)new MasterArcher();//()는 생략가능, 업캐스팅

        a.shoot();
        ma.shoot();
        // ma는 연결 객체를 부모객체로 해석하지만 실제로 연결된 객체는 자식객체
        // 오버라이딩 결과: 부모객체의 함수가 아닌 자식객체의 함수를 수행

    }
}
//부모클래스
class Archer{
    void shoot(){
        System.out.println("[아처]의 활 공격이 20만큼 피해를 주었다.");
    }
}

//자식클래스
class MasterArcher extends Archer{
    void shoot(){
        System.out.println("[마스터아처]의 활 공격이 30만큼 피해를 주었다.");
    }
}
package a0327.패키지2;

import a0327.패키지1.Parent;

public class Main1 {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
        // 상속 받은 클래스에선 접근 가능

        Parent parent = new Parent();
        // System.out.println(parent.message);
        // 다른 패키지에서 직접 접근 불가능
        // parent.showmessage();
        // 상속없이 직접 호출 불가능
    }
}

// public
// 어디서든 접근 가능

// protected
// 같은 패키지거나 다른 패키지는 상속받은 경우에만 접근 가능

// default
// 같은 패키지에만 접근 가능, 다른 패키지는 상속받아도 접근 불가능

// private
// 같은 클래스에서만 접근 가능
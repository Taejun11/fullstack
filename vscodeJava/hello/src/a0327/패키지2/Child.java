package a0327.패키지2;

import a0327.패키지1.Parent;

public class Child extends Parent{
    public void display(){
        System.out.println("자식클래스에 접근: " + message);
        showmessage();
    }
}

package a0325.product;

import java.util.ArrayList;

public class Productmanager {
    private ArrayList<Product> products = new ArrayList<>(); //객체 모음을 관리하는 리스트
    private int nextId = 1; //제품 id, 자동으로 증가
    // 생성자에서 더미데이터 추가
    public Productmanager(){
        products.add(new Product(nextId++, "Laptop", 1200.0));
        products.add(new Product(nextId++, "Mouse", 50.0));
        products.add(new Product(nextId++, "Keyboard", 100.0));
    }

    public void addProduct(String name, double price) {
        products.add(new Product(nextId++, name, price));
        System.out.println("제품이 추가되었습니다.");
    }

    public void listProduct() {
        if (products.isEmpty()) {//리스트가 비어있으면 true, 내용이 있으면 false 반환
            System.out.println("제품이 없습니다.");
        }else{
            for(Product p : products){
                System.out.println(p);
            }
        }
    }

    public boolean updateProduct(int id, String newName, double newPrice) {
        for(Product p : products){
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("제품이 수정되었습니다.");
                return true;
            }
        }
        System.out.println("해당 제품이 없습니다.");
        return false;
    }

    public boolean deleteProduct(int id) {
        for(Product p : products){
            if (p.getId() == id) {
                products.remove(p);
                // System.out.println("제품이 삭제되었습니다.");
                return true;
            }
        }
        // System.out.println("해당 제품이 없습니다.");
        return false;
    }
}

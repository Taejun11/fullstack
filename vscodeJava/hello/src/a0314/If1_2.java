package a0314;

public class If1_2 {
    public static void main(String[] args) {
        int age = 20;
        String status;
        // if (age >= 18) 
        //     status = "성인";
        // else
        //     status = "미성년자";

        // (age >= 18) ? (status = "성인") : (status = "미성년자");
        status = (age >= 18) ? "성인" : "미성년자";
        
        System.out.println("age = "+age+" status = "+status);
    }
    
}
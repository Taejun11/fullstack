package a0403.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream8 {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();
        Member m1 = new Member("박태호",Member.MALE,30);
        Member m2 = new Member("김연경",Member.FEMALE, 29);
        Member m3 = new Member("손유일", Member.MALE, 32);
        Member m4 = new Member("안재홍", Member.MALE, 27);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        // 남성객체의 평균나이 구하기
        int count = 0;
        double sum = 0;
        double avgAge = 0;

        for(int i = 0; i < list.size(); i++){//방법 1
            if (list.get(i).getGender() == Member.MALE) {
                sum += list.get(i).getAge();
                count++;
            }
        }
        avgAge = sum / count;
        System.out.println(avgAge);
        System.out.println();
        Double avgAge1 = list.stream() //방법 2
                    .filter(m -> m.getGender() == Member.MALE)
                    .mapToInt(Member::getAge) //객체를 int로 바꿔서 계산하기 위함
                    .average()      //평균 계산
                    .getAsDouble(); //값을 double로 변환
        System.out.println(avgAge1);
    }
}

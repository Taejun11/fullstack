package a0327.wordlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Brain implements Interface {
    static HashMap<String, String> word = new HashMap<>();

    public Brain() {
        word.put("Peach", "복숭아");
        word.put("Plum", "자두");
        word.put("Pomegranate", "석류");
        word.put("Persimon", "감");
    }

    @Override
    public void Menu() {
        System.out.println("등록된 단어 수: " + word.size());
        System.out.println("---- 선택 해주세요. ----");
        System.out.println(" 1. 단어 등록 ");
        System.out.println(" 2. 단어 조회 ");
        System.out.println(" 3. 단어 삭제 ");
        System.out.println(" 4. 테스트 ");
        System.out.println(" 5. 단어 목록보기");
        System.out.println(" 6. 종료 ");
        System.out.println("-----------------------");
    }

    @Override
    public void Addword() {// 1번
        String eng = null;
        String kor = null;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("등록할 영단어를 입력하세요.(돌아가려면 Menu 입력) : ");
            eng = scan.nextLine();
            if (eng.equals("Menu") || eng.equals("menu")) {
                break;
            } else {
                if (word.containsKey(eng)) {
                    System.out.println("이미 등록된 단어입니다. 수정을 원하시면 삭제 후 다시 입력해주세요.");
                } else {
                    System.out.print("뜻을 입력해주세요. : ");
                    kor = scan.nextLine();
                    try {
                        word.put(eng, kor);
                    } catch (Exception e) {
                        System.out.println("다시 입력해주세요.");
                        e.printStackTrace();
                    } finally {
                        System.out.println("입력이 완료되었습니다.");
                    }
                }
            }
        }
    }

    @Override
    public void WordSearch() {// 2번
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("조회하고싶은 영단어를 입력하세요. (돌아가려면 Menu 입력) : ");
            String eng = scan.nextLine();
            if (eng.equals("Menu") || eng.equals("menu")) {
                break;
            }else{
                if (word.containsKey(eng)) {
                    System.out.println(word.get(eng));
                }else{
                    System.out.println("등록되지 않은 단어입니다.");
                }
            }
        }

    }

    @Override
    public void DeleteWord() {//3번
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("=== 단어 목록 ===");
            if (word.isEmpty()) {
                System.out.println("저장된 단어가 없습니다.");
            }else{
                for(String key : word.keySet()){
                    System.out.println("※  " + key +  " : " +word.get(key));
                }
            }
            System.out.println("============================");
            System.out.print("삭제하고싶은 단어를 입력하세요.(돌아가려면 Menu 입력) : ");
            String del = scan.nextLine().trim();
            if (del.equalsIgnoreCase("menu")) {
                System.out.println("메뉴로 돌아갑니다.");
                break;
            }
            if (word.containsKey(del)) {
                // System.out.println("입력한 단어 " + del + " : " + word.remove(del) + " 삭제되었습니다.");
                System.out.println(" 입력한 단어 (" + del + " : " + word.remove(del) + ") 가 삭제되었습니다.");
            }
        }
    }

    @Override
    public void Test() {//4번
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("1.시작하기");
            System.out.println("2.종료하기");
            System.out.print("번호를 입력하세요. (돌아가려면 Menu 입력) : ");
            if (!scan.hasNextInt()) {  // 숫자 입력이 아닌 경우 예외 처리
                System.out.println("숫자를 입력하세요.");
                scan.next();  // 잘못된 입력 제거
                continue;
            }

            int a = scan.nextInt();
            scan.nextLine(); // 입력 버퍼 문제 방지

            if (a == 1) {
                int correctCount = 0;
                int totalCount = 0;
                System.out.println("뜻에 맞는 영단어를 입력하세요.");
                for(String key : word.keySet()){
                    System.out.println(word.get(key));
                    System.out.print("답 입력: ");
                    String answer = scan.nextLine().trim();
                    if (answer.equalsIgnoreCase(key)) {
                        System.out.println("정답입니다.");
                        correctCount++;
                    }else{
                        System.out.println("틀렸습니다. 정답은 (" + key + ") 입니다.");
                    }
                    totalCount++;
                }
                System.out.println("결과 : " + correctCount + " / " + totalCount + "\n");
                break;
            }else if (a == 2) {
                System.out.println("종료합니다.");
                break;
            }else{
                System.out.println("1 또는 2를 입력해주세요.");

            }
        }
    }

    @Override
    public void Wordlist() {//5번
        System.out.println("=== 단어 목록 ===");
        if (word.isEmpty()) {
            System.out.println("저장된 단어가 없습니다.");
        }else{
            for(String key : word.keySet()){
                System.out.println("※  " + key +  " : " +word.get(key));
            }
        }
        System.out.println("============================");
    }

    @Override
    public void Exit() {//6번
        System.out.println("프로그램을 종료합니다.");
    }
}

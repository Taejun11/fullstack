package a0321.account;

public class Webtoontest {
    public static void main(String[] args) {
        Webtoon levelUp = new Webtoon("나혼자만 레벨업", "판타지", "ㅁㄴㅇ");
        Webtoon sweethome = new Webtoon("스위트홈", "스릴러", "ㅁㄴㅇ");
        Webtoon Itaewon = new Webtoon("이태원 클라스", "드라마", "ㅁㄴㅇ");

        Webtoon[] webtoons = {levelUp,sweethome,Itaewon};
        for(int i = 0; i < webtoons.length; i++){
            System.out.println(webtoons[i].toStr());
        }
        System.out.println(Webtoon.getCount());
    }
}

class Webtoon{
    private String title; //제목
    private String genre; //장르
    private String author; //작가
    private static int count = 0; //생성된 웹툰 객채 수

    public Webtoon(String title, String genre, String author){
        Webtoon.count++;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public String toStr(){
        return String.format("webtoon(title: %s, genre: %s, author: %s)", title, genre, author);
    }

    public static int getCount(){
        return count;
    }
}
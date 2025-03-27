package a0327.exception1;

public class customException extends Exception{
    public customException(String message){
        super(message);
    }
}
//Exception: 자바의 최상위예외
// 최상위예외를 상속받아 커스텀예외를 만듦
package test.performance.backend.exception;

public class PostNotFountException extends RuntimeException{

    public PostNotFountException() {
        super("글을 찾을 수 없습니다.");
    }
}

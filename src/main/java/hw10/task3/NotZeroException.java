package hw10.task3;

public class NotZeroException extends RuntimeException {

    public NotZeroException() {
        super("This parameter can`t = 0 ");
    }
}

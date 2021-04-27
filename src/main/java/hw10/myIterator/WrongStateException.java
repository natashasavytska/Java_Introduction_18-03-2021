package hw10.myIterator;

public class WrongStateException extends RuntimeException{

    public WrongStateException() {
        super("Method next() wasn't used.");
    }
}

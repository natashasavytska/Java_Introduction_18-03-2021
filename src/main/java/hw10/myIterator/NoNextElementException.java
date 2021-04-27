package hw10.myIterator;

public class NoNextElementException extends RuntimeException{

    public NoNextElementException() {
        super("There is no next element on the collection.");
    }
}

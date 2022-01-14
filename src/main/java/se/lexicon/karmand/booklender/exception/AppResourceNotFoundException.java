package se.lexicon.karmand.booklender.exception;


public class AppResourceNotFoundException extends RuntimeException{
    public AppResourceNotFoundException(String message) {
        super(message);
    }
}

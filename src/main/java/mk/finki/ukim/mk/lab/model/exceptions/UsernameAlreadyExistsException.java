package mk.finki.ukim.mk.lab.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username) {
        super("Username already exists");

    }
}

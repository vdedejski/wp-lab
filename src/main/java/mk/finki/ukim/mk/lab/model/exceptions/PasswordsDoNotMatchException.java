package mk.finki.ukim.mk.lab.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Passwords don't match");
    }

}
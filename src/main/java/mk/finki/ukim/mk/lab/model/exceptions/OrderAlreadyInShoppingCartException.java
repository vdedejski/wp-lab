package mk.finki.ukim.mk.lab.model.exceptions;

public class OrderAlreadyInShoppingCartException extends RuntimeException{
    public OrderAlreadyInShoppingCartException() {
        super("Already in shopping cart");
    }
}

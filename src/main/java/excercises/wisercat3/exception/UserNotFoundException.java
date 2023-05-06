package excercises.wisercat3.exception;

public class UserNotFoundException extends IllegalArgumentException{

    private String message;

    public UserNotFoundException(String s, String message) {
        super(s);
        this.message = message;
    }
}

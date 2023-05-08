package excercises.wisercat3.exception;

public class PetSystemException extends IllegalArgumentException{

    private String message;

    public PetSystemException(String message) {
        this.message = message;
    }
}

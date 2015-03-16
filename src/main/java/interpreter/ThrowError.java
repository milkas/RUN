package interpreter;

public class ThrowError extends RuntimeException {

    public ThrowError(String message) {
        super(message);
    }
}

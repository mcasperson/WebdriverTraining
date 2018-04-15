package academy.learnprogramming.exceptions;

public class WebElementException extends RuntimeException {

    public WebElementException() {
    }

    public WebElementException(final String message) {
        super(message);
    }

    public WebElementException(final String message, final Throwable ex) {
        super(message, ex);
    }

    public WebElementException(final Exception ex) {
        super(ex);
    }
}
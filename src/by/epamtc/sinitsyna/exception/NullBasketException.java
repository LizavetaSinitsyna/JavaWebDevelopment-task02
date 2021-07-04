package by.epamtc.sinitsyna.exception;

public class NullBasketException extends Exception {

	private static final long serialVersionUID = 1L;

	public NullBasketException() {
		super();
	}

	public NullBasketException(String message) {
		super(message);
	}

	public NullBasketException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullBasketException(Throwable cause) {
		super(cause);
	}
}

package test.exception;

public class CantReadFileException extends Exception{

	public CantReadFileException() {
		super();
	}

	public CantReadFileException(String s) {
		super(s);
	}

	public CantReadFileException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public CantReadFileException(Throwable throwable) {
		super(throwable);
	}

}

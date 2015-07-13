package kr.co.ipmall.model.exception;

public class AlreadyExistingUserException extends RuntimeException {

	public AlreadyExistingUserException(String message) {
		super(message);
	}

}

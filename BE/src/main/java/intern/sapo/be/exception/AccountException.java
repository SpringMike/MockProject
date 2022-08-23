package intern.sapo.be.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AccountException extends RuntimeException {
	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}
}

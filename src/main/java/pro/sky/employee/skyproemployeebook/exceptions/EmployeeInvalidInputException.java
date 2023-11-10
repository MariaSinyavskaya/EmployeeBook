package pro.sky.employee.skyproemployeebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeInvalidInputException extends RuntimeException {
    public EmployeeInvalidInputException() {
    }

    public EmployeeInvalidInputException(String message) {
        super(message);
    }

    public EmployeeInvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeInvalidInputException(Throwable cause) {
        super(cause);
    }

    public EmployeeInvalidInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package pro.sky.employee.skyproemployeebook;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

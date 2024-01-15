package pro.sky.employeespringhomework;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee is already added")
public class EmployeeAlreadyAddedInListException extends RuntimeException {
    public EmployeeAlreadyAddedInListException(String message) {

        super(message);
    }
}


package com.supmti.employee.exception;

;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;



@Getter
@Setter
@ToString
public class ErrorResponse {

    private Integer httpStatus;
    private String exception;
    private String message;
    private List<FieldError> fieldErrors;

}

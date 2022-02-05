package com.supmti.employee.dto;

import com.supmti.employee.model.Department;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class EmployeeDTO {

    private Long id;
    @NotNull(message = "name is not allowed to be empty!")
    @Size(max = 50)
    private String name;
    @Min(value = 0L, message = "The age must be positive")
    private Integer age;
    @NotNull(message = "function is not allowed to be empty!")
    @Size(max = 50)
    private String function;
    @DecimalMin(value = "0.0", inclusive = false, message = "The salary must be positive")
    private Float salary;
    @NotNull(message = "service id is not allowed to be empty!")
    private Department department;

}








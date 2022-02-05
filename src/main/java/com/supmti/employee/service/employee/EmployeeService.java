package com.supmti.employee.service.employee;



import com.supmti.employee.dto.EmployeeDTO;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO get(final Long id);
    Long create(final EmployeeDTO employeeDTO);
    void update(final Long id, final EmployeeDTO employeeDTO);
    void delete(final Long id);
}

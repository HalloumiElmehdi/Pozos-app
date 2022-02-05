package com.supmti.employee.dao.employee;

import com.supmti.employee.model.Employee;

import java.util.List;
import java.util.Optional;




public interface EmployeeDao {
    List<Employee> findAll();
    Optional<Employee> findById(final Long id);
    Long save(final Employee book);
    void deleteById(final Long id);

}

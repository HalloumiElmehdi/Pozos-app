package com.supmti.employee.dao.department;

import com.supmti.employee.model.Department;
import com.supmti.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentDao {

    List<Department> findAll();
    Optional<Department> findById(final Long id);
    Long save(final Department department);
    void deleteById(final Long id);
}

package com.supmti.employee.dao.employee;


import com.supmti.employee.model.Employee;
import com.supmti.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImp implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    public EmployeeDaoImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Long save(Employee book) {
        return employeeRepository.save(book).getId();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}

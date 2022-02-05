package com.supmti.employee.dao.employee;


import com.supmti.employee.model.Employee;
import com.supmti.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImp implements EmployeeDao {

    private final EmployeeRepository bookRepository;

    public EmployeeDaoImp(EmployeeRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Employee> findAll() {
        return bookRepository.findAll();
    }


    @Override
    public Optional<Employee> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Long save(Employee book) {
        return bookRepository.save(book).getId();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}

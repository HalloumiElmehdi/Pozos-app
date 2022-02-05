package com.supmti.employee.dao.department;

import com.supmti.employee.model.Department;
import com.supmti.employee.repository.DepartmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentDaoImp implements DepartmentDao{

   private final DepartmentRepository departmentRepository;

    public DepartmentDaoImp(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Long save(Department department) {
        return departmentRepository.save(department).getId();
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }
}

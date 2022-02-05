package com.supmti.employee.mapper;

import com.supmti.employee.dto.DepartmentDTO;
import com.supmti.employee.model.Department;

public class DepartmentMapper implements Mapper<Department, DepartmentDTO> {

    @Override
    public DepartmentDTO mapToDTO(Department department, DepartmentDTO departmentDTO) {
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setLocation(department.getLocation());
        return departmentDTO;
    }

    @Override
    public Department mapToEntity(DepartmentDTO departmentDTO, Department department) {
        department.setName(department.getName());
        departmentDTO.setLocation(department.getLocation());
        return department;
    }
}

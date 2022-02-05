package com.supmti.employee.mapper;


import com.supmti.employee.dto.EmployeeDTO;
import com.supmti.employee.model.Employee;

public class EmployeeMapper implements Mapper<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO mapToDTO(Employee employee, EmployeeDTO employeeDTO) {
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setAge(employee.getAge());
        employeeDTO.setFunction(employee.getFunction());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setDepartment(employee.getDepartment());
        return employeeDTO;
    }

    @Override
    public Employee mapToEntity(EmployeeDTO employeeDTO, Employee employee) {
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setFunction(employeeDTO.getFunction());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDepartment(employeeDTO.getDepartment());
        return employee;
    }
}


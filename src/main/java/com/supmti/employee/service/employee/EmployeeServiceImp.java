package com.supmti.employee.service.employee;
import com.supmti.employee.dao.employee.EmployeeDao;
import com.supmti.employee.dto.EmployeeDTO;
import com.supmti.employee.mapper.EmployeeMapper;
import com.supmti.employee.mapper.Mapper;
import com.supmti.employee.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final Mapper<Employee, EmployeeDTO> mapper = new EmployeeMapper();

    public EmployeeServiceImp(EmployeeDao bookDao) {
        this.employeeDao = bookDao;
    }


    @Override
    public List<EmployeeDTO> findAll() {
        log.info("fetching all employees...");
        return employeeDao.findAll()
                .stream()
                .map(employee -> mapper.mapToDTO(employee, new EmployeeDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO get(Long id) {
        log.info("fetching employee with id: {}", id);
        return employeeDao.findById(id)
                .map(employee -> mapper.mapToDTO(employee, new EmployeeDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Long create(EmployeeDTO employeeDTO) {
        final Employee employee = Employee.builder().build();
        mapper.mapToEntity(employeeDTO, employee);
        log.info("creating new employee: {}", employee);
        return employeeDao.save(employee);
    }

    @Override
    public void update(Long id, EmployeeDTO employeeDTO) {
        final Employee employee = employeeDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapper.mapToEntity(employeeDTO, employee);
        log.info("updating employee: {}",employee);
        employeeDao.save(employee);
    }

    @Override
    public void delete(Long id) {
        log.info("deleting employee with id: {}", id);
        employeeDao.deleteById(id);
    }


}

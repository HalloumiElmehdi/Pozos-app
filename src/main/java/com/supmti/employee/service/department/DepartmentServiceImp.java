package com.supmti.employee.service.department;

import com.supmti.employee.dao.department.DepartmentDao;
import com.supmti.employee.dto.DepartmentDTO;
import com.supmti.employee.mapper.DepartmentMapper;
import com.supmti.employee.mapper.Mapper;
import com.supmti.employee.model.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentServiceImp implements DepartmentService{

    private final DepartmentDao departmentDao;
    private final Mapper<Department, DepartmentDTO> mapper = new DepartmentMapper();

    public DepartmentServiceImp(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }


    @Override
    public List<DepartmentDTO> findAll() {
        log.info("fetching all departments...");
        return departmentDao.findAll()
                .stream()
                .map(department -> mapper.mapToDTO(department, new DepartmentDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO get(Long id) {
        log.info("fetching department with id: {}", id);
        return departmentDao.findById(id)
                .map(department -> mapper.mapToDTO(department, new DepartmentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Long create(DepartmentDTO departmentDTO) {
        final Department department = Department.builder().build();
        mapper.mapToEntity(departmentDTO, department);
        log.info("creating new department: {}", department);
        return departmentDao.save(department);
    }

    @Override
    public void update(Long id, DepartmentDTO departmentDTO) {
        final Department department = departmentDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapper.mapToEntity(departmentDTO, department);
        log.info("updating department: {}",department);
        departmentDao.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentDao.deleteById(id);
        log.info("deleting department with id: {}", id);
    }
}

package com.supmti.employee.service.department;

import com.supmti.employee.dto.DepartmentDTO;
import java.util.List;

public interface DepartmentService {

    List<DepartmentDTO> findAll();
    DepartmentDTO get(final Long id);
    Long create(final DepartmentDTO departmentDTO);
    void update(final Long id, final DepartmentDTO departmentDTO);
    void delete(final Long id);
}

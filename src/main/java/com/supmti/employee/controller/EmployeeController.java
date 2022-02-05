package com.supmti.employee.controller;


import com.supmti.employee.dto.DepartmentDTO;
import com.supmti.employee.dto.EmployeeDTO;
import com.supmti.employee.service.department.DepartmentService;
import com.supmti.employee.service.employee.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    public EmployeeController(final EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<EmployeeDTO> employees = employeeService.findAll();
        List<DepartmentDTO> departments = departmentService.findAll();
        log.info("fetching departments {}", departments);
        model.addAttribute("employees", employees);
        model.addAttribute("departments", departments);
        model.addAttribute("employeeDTO", new EmployeeDTO());
        return "index";
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute EmployeeDTO employeeDTO, Model model) {
        log.info("employee : {}", employeeDTO);
        employeeService.create(employeeDTO);
        return "redirect:/";
    }
}

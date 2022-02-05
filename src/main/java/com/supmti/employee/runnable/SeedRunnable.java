package com.supmti.employee.runnable;

import com.supmti.employee.model.Employee;
import com.supmti.employee.model.Department;
import com.supmti.employee.repository.EmployeeRepository;
import com.supmti.employee.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class SeedRunnable implements CommandLineRunner {


    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository serviceRepository;

    public SeedRunnable(EmployeeRepository employeeRepository, DepartmentRepository serviceRepository) {
        this.employeeRepository = employeeRepository;
        this.serviceRepository = serviceRepository;
    }


    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        // init services
        var serviceRH = Department
                            .builder()
                            .name("RH")
                            .location("Oujda")
                            .build();
        var serviceIT = Department
                            .builder()
                            .name("IT")
                            .location("Oujda")
                            .build();
        var serviceAccounting =
                        Department
                            .builder()
                            .name("Accounting")
                            .location("Oujda")
                            .build();



        // init employees
        List<Employee> employees = List.of(
                 Employee
                         .builder()
                         .name("Dan jack")
                         .age(28)
                         .function("Assistant RH")
                         .salary(8_000.00F)
                        .department(serviceRH)
                         .build(),
                Employee
                        .builder()
                        .name("John Doe")
                        .age(35)
                        .function("Accountant")
                        .salary(12_000.00F)
                        .department(serviceAccounting)
                        .build(),
                Employee
                        .builder()
                        .name("Mark Smith")
                        .age(28)
                        .function("IT technician")
                        .salary(10_000.00F)
                        .department(serviceIT)
                        .build(),
                Employee
                        .builder()
                        .name("Elmehdi Halloumi")
                        .age(29)
                        .function("Software Engineer")
                        .salary(55_000.00F)
                        .department(serviceIT)
                        .build()
        );

        log.info("saving services... {}",
                serviceRepository
                        .saveAll(
                                List.of(serviceRH, serviceAccounting, serviceIT)));

        log.info("saving employees... {}",
                employeeRepository
                        .saveAll(employees));
    }
}


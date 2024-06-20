package com.campuslands.modules.employee.infrastructure;

import java.util.List;
import java.util.Optional;

import com.campuslands.modules.employee.domain.Employee;
import com.campuslands.modules.status.domain.Status;

public interface EmployeeRepository {
    void save(Employee status);
    void update(Employee status);
    Optional<Employee> findById(int id);
    void delete(int id);
    List<Employee> findAll();
    
}

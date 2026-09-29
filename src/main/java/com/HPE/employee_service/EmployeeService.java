package com.HPE.employee_service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee create(Employee employee) {
        if (repository.existsById(employee.getEmployeeId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Employee already exists: " + employee.getEmployeeId());
        }
        return repository.save(employee);
    }

    public Employee update(String id, Employee updated) {
        Employee existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Employee not found: " + id));
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setTitle(updated.getTitle());
        return repository.save(existing);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Employee not found: " + id);
        }
        repository.deleteById(id);
    }
}

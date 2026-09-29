package com.HPE.employee_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    public DataLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            repository.save(new Employee("E001", "Ada", "Lovelace", "ada@example.com", "Engineer"));
            repository.save(new Employee("E002", "Grace", "Hopper", "grace@example.com", "Engineer"));
            repository.save(new Employee("E003", "Alan", "Turing", "alan@example.com", "Researcher"));
        }
    }
}
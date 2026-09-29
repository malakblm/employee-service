package com.HPE.employee_service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employees {

    @JsonProperty("Employees")
    private final List<Employee> employees;

    public Employees() {
        this.employees = List.of(
            new Employee("E001", "Ada", "Lovelace", "ada@example.com", "Engineer"),
            new Employee("E002", "Grace", "Hopper", "grace@example.com", "Engineer"),
            new Employee("E003", "Alan", "Turing", "alan@example.com", "Researcher")
        );
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
package com.HPE.employee_service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeesResponse {

    @JsonProperty("Employees")
    private final List<Employee> employees;

    public EmployeesResponse(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
package com.springboot.SpringBootBackend.service;

import com.springboot.SpringBootBackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeesById(long id);
    Employee updateEmployees(Employee employee, long id);
    void deleteEmployee(long id);
}

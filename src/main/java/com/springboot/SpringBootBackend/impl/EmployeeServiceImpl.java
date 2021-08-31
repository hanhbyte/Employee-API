package com.springboot.SpringBootBackend.impl;

import com.springboot.SpringBootBackend.exception.ResourceNotFoundException;
import com.springboot.SpringBootBackend.model.Employee;
import com.springboot.SpringBootBackend.repository.EmployeeRepository;
import com.springboot.SpringBootBackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeesById(long id){
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employees", "Id", id));
    }

    @Override
    public Employee updateEmployees(Employee employee, long id) {
        Employee existingEmployees = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employees", "Id", id));

        existingEmployees.setFistName(employee.getFistName());
        existingEmployees.setLastName(employee.getLastName());
        existingEmployees.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployees);
        return existingEmployees;
    }

    @Override
    public void deleteEmployee(long id){
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }
}

package com.pplflw.test.service;

import com.pplflw.test.exception.HTTP404Exception;
import com.pplflw.test.model.EMPLOYEE_STATUS;
import com.pplflw.test.model.Employee;
import com.pplflw.test.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee createEmployee(Employee employee){

        employee.setStatus(EMPLOYEE_STATUS.ADDED);

        return employeeRepository.save(employee);

    }

    public Employee updateEmployee(Employee employee, Long id){

     Employee emp = this.getEmployeeById(id);

        if (employee.getStatus() != null){
            emp.setStatus(employee.getStatus());
        }

        return employeeRepository.save(emp);

    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(()->new HTTP404Exception("Sorry, Employee not found"));
    }
}

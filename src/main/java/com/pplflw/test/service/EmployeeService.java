package com.pplflw.test.service;

import com.pplflw.test.model.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee, Long id);

    Employee getEmployeeById(Long id);
}

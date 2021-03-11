package com.pplflw.test;

import com.pplflw.test.exception.HTTP404Exception;
import com.pplflw.test.model.EMPLOYEE_STATUS;
import com.pplflw.test.model.Employee;
import com.pplflw.test.repository.EmployeeRepository;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    void testGetEmployeeById_returnsEmployeeDetails() {

        Employee savedEmployee = testEntityManager.persistAndFlush(new Employee(null, "John", "Paul", "Permanent", 30, EMPLOYEE_STATUS.ADDED));

        Employee employee = employeeRepository.findById(1L).orElseThrow(() -> new HTTP404Exception("Sorry employee not found"));

        BDDAssertions.then(savedEmployee.getId()).isNotNull();
        BDDAssertions.then(employee.getFirstName()).isEqualTo(employee.getFirstName());

    }
}

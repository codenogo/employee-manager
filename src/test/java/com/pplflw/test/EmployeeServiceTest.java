package com.pplflw.test;

import com.pplflw.test.exception.HTTP404Exception;
import com.pplflw.test.model.EMPLOYEE_STATUS;
import com.pplflw.test.model.Employee;
import com.pplflw.test.repository.EmployeeRepository;
import com.pplflw.test.service.EmployeeService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @DisplayName("Returns saved employee")
    @Test
    void getEmployeeById_forSavedEmployee_isReturned(){

        Employee savedEmployee = employeeService.createEmployee(new Employee(null,"John","Paul","Permanent",20, EMPLOYEE_STATUS.ADDED));

        Employee employee = employeeService.getEmployeeById(savedEmployee.getId());

        BDDAssertions.then(employee.getFirstName()).isEqualTo(savedEmployee.getFirstName());
        BDDAssertions.then(employee.getId()).isNotNull();

    }

    @Test
    void getEmployeeById_whenNoEmployeeFound_notFoundExceptionThrown(){

        Long id = 432L;
        Throwable throwable = catchThrowable(()-> employeeService.getEmployeeById(id));
        BDDAssertions.then(throwable).isInstanceOf(HTTP404Exception.class);
    }





}

package com.pplflw.test;

import com.pplflw.test.model.EMPLOYEE_STATUS;
import com.pplflw.test.model.Employee;
import com.pplflw.test.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void getEmployee_forSavedSavedEmployee_isReturned() throws Exception {
        //given
        BDDMockito.given(employeeService.getEmployeeById(anyLong())).willReturn(
                Employee.builder().id(1l)
                .firstName("John")
                .lastName("Paul")
                .age(30)
                .contractInformation("Permanent")
                .status(EMPLOYEE_STATUS.ADDED)
                .build()
        );

        //when //then
        this.mockMvc.perform(get("/api/v1/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("status").value("00"))
                .andExpect(jsonPath("message").value("Success"));

    }

    @Test
    public void updateEmployee_forSavedEmployee_updatedEmployeeReturned() throws Exception {

        //given
        BDDMockito.given(employeeService.getEmployeeById(anyLong())).willReturn(
                Employee.builder().id(1l)
                        .firstName("John")
                        .lastName("Paul")
                        .age(30)
                        .contractInformation("Permanent")
                        .status(EMPLOYEE_STATUS.ADDED)
                        .build()
        );
        String data = "{\"status\":\"IN_CHECK\"}";


        mockMvc.perform(patch("/api/v1/employees/1")
                .content(data)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}

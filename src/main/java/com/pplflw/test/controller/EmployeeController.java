package com.pplflw.test.controller;

import com.pplflw.test.model.Employee;
import com.pplflw.test.service.EmployeeService;
import com.pplflw.test.util.ResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;


    @PostMapping("/v1/employees")
    public ResponseEntity<?> createEmployee(@Validated @RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseModel<>("00","Employee added successfully",employeeService.createEmployee(employee)));
    }

    @GetMapping("/v1/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id){
        return ResponseEntity.ok(new ResponseModel<>("00","Success",employeeService.getEmployeeById(id)));
    }

    @PatchMapping("/v1/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(new ResponseModel<>("00","Employee Status Updated", employeeService.updateEmployee(employee,id)));
    }


}

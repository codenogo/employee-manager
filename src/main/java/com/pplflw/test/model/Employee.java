package com.pplflw.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@Data
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME",length = 30)
    private String firstName;

    @Column(name = "LAST_NAME", length = 30)
    private String lastName;

    @Column(name = "CONTRACT_INFORMATION")
    private String contractInformation;

    @Column(name = "AGE")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 30)
    private EMPLOYEE_STATUS status;

}

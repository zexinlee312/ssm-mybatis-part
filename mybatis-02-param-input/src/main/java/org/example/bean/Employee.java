package org.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}

package org.example.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {
    private Integer empId;
    private String empName;
    private Double empSalary;
}

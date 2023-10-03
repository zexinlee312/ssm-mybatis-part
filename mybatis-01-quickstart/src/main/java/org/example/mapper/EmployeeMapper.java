package org.example.mapper;

import org.example.bean.Employee;

public interface EmployeeMapper {
    Employee queryById(Integer empId);
}

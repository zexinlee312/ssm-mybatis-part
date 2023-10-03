package org.example.mapper;

import org.example.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    int selectEmployeeCount();

    Employee selectEmployeeById(Integer id);

    Map<String, Object> selectEmpNameAndMaxSalary();

    List<Employee> selectAllEmployee();

    int insertEmployee(Employee employee);

    Employee selectEmployeeByResultMap(Integer empId);

}

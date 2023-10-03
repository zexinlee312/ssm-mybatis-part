package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.bean.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmployeeByCondition(@Param("name")String name, @Param("salary")Double salary);

    int update(Employee employee);

    int insertBatch(@Param("list")List<Employee> employeeList);
}

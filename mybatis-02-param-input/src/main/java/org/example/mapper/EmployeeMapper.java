package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    Employee queryById(Integer id);

    int deleteById(Integer id);

    List<Employee> queryBySalary(Double salary);

    int insertEmployee(Employee employee);

    int inertEmployeeByMap(Map<String, Object> paramMap);

    int updateEmployee(@Param("empId")Integer empId, @Param("empSalary") Double empSalary);

    int selectEmployeeCount();

}

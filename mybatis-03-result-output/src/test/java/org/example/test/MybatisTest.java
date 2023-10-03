package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.bean.Employee;
import org.example.mapper.EmployeeMapper;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MybatisTest {
    private static SqlSession session;
    @BeforeEach
    public void beforeTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void test01() throws IOException {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int count = mapper.selectEmployeeCount();
        System.out.println(count);
    }

    @Test
    public void test02() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeById(2);
        System.out.println(employee);
    }

    @Test
    public void test03() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> resultMap = mapper.selectEmpNameAndMaxSalary();
        Set<Map.Entry<String, Object>> entrySet = resultMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    @Test
    public void test04() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = mapper.selectAllEmployee();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void test05() {
        Employee employee = new Employee();
        employee.setEmpName("jack");
        employee.setEmpSalary(987.65);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.insertEmployee(employee);
    }

    @Test
    public void test06() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectEmployeeByResultMap(3);
        System.out.println(employee);
    }

    @AfterEach
    public void afterTest() {
        session.commit();
        session.close();
    }
}

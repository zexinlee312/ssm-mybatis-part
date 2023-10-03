package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.bean.Employee;
import org.example.mapper.EmployeeMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    private static SqlSession session;

    private EmployeeMapper employeeMapper;
    @BeforeEach
    public void beforeTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        employeeMapper = session.getMapper(EmployeeMapper.class);
    }

    @Test
    public void test01() {
        employeeMapper.selectEmployeeByCondition("tom", 92.1);
    }

    @Test
    public void test02() {
        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("tim");
        employeeMapper.update(employee);
    }

    @AfterEach
    public void afterTest() {
        session.commit();
        session.close();
    }
}

package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.bean.Employee;
import org.example.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void testSelectEmployee() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println(employee);
        session.commit();
        session.close();
    }
}

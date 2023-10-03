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
import java.util.HashMap;

public class MybatisTest {
    @Test
    public void test01() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
//        System.out.println(employee);
//        int x = mapper.insertEmployee(new Employee(4, "alex", 600.44));
//        session.commit();
//        System.out.println(x);
        mapper.deleteById(7);
        mapper.updateEmployee(3, 7839.321);

        HashMap<String, Object> map = new HashMap<>();
        map.put("empNameKey", "Tim");
        map.put("empSalaryKey",100.2);
        mapper.inertEmployeeByMap(map);

        int count = mapper.selectEmployeeCount();
        System.out.println("********人数为********" + count);
        session.commit();
        session.close();
    }
}

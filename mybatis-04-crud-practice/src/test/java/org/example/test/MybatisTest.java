package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.bean.User;
import org.example.mapper.UserMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    private SqlSession session;

    private UserMapper userMapper;

    @BeforeEach
    public void actionBefore() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void test01() {
        User user = new User();
        user.setUsername("lee");
        user.setPassword("123456");
        userMapper.insertUser(user);
    }

    @Test void test02() {
        User user = new User();
        user.setUsername("lee");
        user.setPassword("654321");
        userMapper.updateUser(user);
    }

    @AfterEach
    public void actionAfter() {
        session.commit();
        session.close();
    }

}

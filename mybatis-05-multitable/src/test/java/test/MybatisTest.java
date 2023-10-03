package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.bean.Customer;
import org.example.bean.Order;
import org.example.mapper.CustomerMapper;
import org.example.mapper.OrderMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSession session;

    private OrderMapper orderMapper;

    private CustomerMapper customerMapper;

    @BeforeEach
    public void actionBefore() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession();
        orderMapper = session.getMapper(OrderMapper.class);
        customerMapper = session.getMapper(CustomerMapper.class);
    }


    @Test
    public void test01() {
        Order order = orderMapper.selectOrderWithCustomer(2);
        System.out.println(order);
    }

    @Test
    public void test02() {
        Customer customer = customerMapper.selectCustomerWithOrderList(1);
        List<Order> orderList = customer.getOrderList();
        orderList.forEach(item -> {
            System.out.println(item);
        });
        System.out.println(customer.getCustomerName());
    }

    @AfterEach
    public void actionAfter() {
        session.commit();
        session.close();
    }

}

package org.example.mapper;

import org.example.bean.Order;

public interface OrderMapper {
    Order selectOrderWithCustomer(Integer orderId);
}

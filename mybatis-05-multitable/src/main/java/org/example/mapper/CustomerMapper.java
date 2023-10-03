package org.example.mapper;

import org.example.bean.Customer;

public interface CustomerMapper {
    Customer selectCustomerWithOrderList(Integer customerId);
}

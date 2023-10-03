package org.example.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Customer {
    private Integer customerId;
    private String customerName;
    private List<Order> orderList;
}

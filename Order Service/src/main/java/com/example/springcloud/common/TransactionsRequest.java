package com.example.springcloud.common;

import com.example.springcloud.entity.Order;
import lombok.Data;

@Data
public class TransactionsRequest {
    private Order order;
    private Payment payment;
}

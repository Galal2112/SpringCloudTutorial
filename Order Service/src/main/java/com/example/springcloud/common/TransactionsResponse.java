package com.example.springcloud.common;

import com.example.springcloud.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsResponse {
    private Order order;
    private double amount;
    private String transactionId;
    private String message;
}

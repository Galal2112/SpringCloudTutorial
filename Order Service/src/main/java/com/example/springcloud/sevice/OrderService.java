package com.example.springcloud.sevice;

import com.example.springcloud.common.Payment;
import com.example.springcloud.common.TransactionsResponse;
import com.example.springcloud.common.TransactionsRequest;
import com.example.springcloud.entity.Order;
import com.example.springcloud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public TransactionsResponse saveOrder (TransactionsRequest request){
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
       Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
      response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed":"there is a failure in payment api, order addedto cart";
         repository.save(order);
       return new TransactionsResponse(order, paymentResponse.getAmount(),paymentResponse.getTransactionId(),response);
    }
}

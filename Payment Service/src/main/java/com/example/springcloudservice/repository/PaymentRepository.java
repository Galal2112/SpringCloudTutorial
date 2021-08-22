package com.example.springcloudservice.repository;


import com.example.springcloudservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {


}

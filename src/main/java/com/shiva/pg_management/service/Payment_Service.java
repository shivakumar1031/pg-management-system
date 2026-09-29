package com.shiva.pg_management.service;

import com.shiva.pg_management.entity.Payment;
import com.shiva.pg_management.entity.Tenant;
import com.shiva.pg_management.repository.Payment_Repository;
import com.shiva.pg_management.repository.Tenant_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Payment_Service {

    @Autowired
    private Payment_Repository paymentRepository;

    @Autowired
    private Tenant_Repository tenantRepository;

    public Payment addPayment(Payment payment) {

        Integer tenantId = payment.getTenant().getTenantId();

        Tenant tenant =
                tenantRepository.findById(tenantId).orElse(null);

        payment.setTenant(tenant);

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Integer paymentId) {

        return paymentRepository.findById(paymentId).orElse(null);
    }

    public Payment updatePayment(Integer paymentId, Payment payment) {

        Payment existingPayment =
                paymentRepository.findById(paymentId).orElse(null);

        if (existingPayment != null) {

            existingPayment.setAmount(payment.getAmount());
            existingPayment.setPaymentDate(payment.getPaymentDate());
            existingPayment.setPaymentMethod(payment.getPaymentMethod());
            existingPayment.setPaymentStatus(payment.getPaymentStatus());

            return paymentRepository.save(existingPayment);
        }

        return null;
    }

    public String deletePayment(Integer paymentId) {

        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
            return "Payment deleted successfully";
        }

        return "Payment not found";
    }
}
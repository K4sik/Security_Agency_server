package com.kas.security_agency.service;

import com.kas.security_agency.entity.PaymentType;
import com.kas.security_agency.exception.PaymentTypeNotFoundException;
import com.kas.security_agency.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    public PaymentType saveOrUpdatePaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    public Iterable<PaymentType> findAll() {
        return paymentTypeRepository.findAll();
    }

    public PaymentType findById(Long id) {
        return paymentTypeRepository.getById(id).orElseThrow(() -> new PaymentTypeNotFoundException("Payment Type with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        PaymentType paymentType = findById(id);
        paymentTypeRepository.delete(paymentType);
    }
}

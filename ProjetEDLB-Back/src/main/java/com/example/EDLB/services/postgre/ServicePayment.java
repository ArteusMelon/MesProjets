package com.example.EDLB.services.postgre;

import com.example.EDLB.models.entities.Payment;
import com.example.EDLB.repositories.JPA.RepositoryPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServicePayment implements IServicePostgre<Payment> {

    @Autowired
    private RepositoryPayment repositoryPayment;

    @Override
    public List<Payment> getAll() {
        return repositoryPayment.findAll();
    }

    @Override
    public Optional<Payment> getById(UUID paymentId) {
        return repositoryPayment.findById(paymentId);
    }

    @Override
    public void delete(UUID paymentId) {
        Optional<Payment> payment = getById(paymentId);
        if(payment.isPresent()){
            repositoryPayment.delete(payment.get());
        }
    }

    @Override
    public Payment save(Payment payment) {
        return repositoryPayment.save(payment);
    }
}
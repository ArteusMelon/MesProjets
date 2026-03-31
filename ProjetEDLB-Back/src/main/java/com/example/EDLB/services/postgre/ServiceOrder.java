package com.example.EDLB.services.postgre;

import com.example.EDLB.models.entities.*;
import com.example.EDLB.repositories.JPA.RepositoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceOrder implements IServicePostgre<Order> {

    @Autowired
    private RepositoryOrder repositoryOrder;

    @Override
    public List<Order> getAll() {
        return repositoryOrder.findAll();
    }

    @Override
    public Optional<Order> getById(UUID id) {
        return repositoryOrder.findById(id);
    }

    @Override
    public void delete(UUID id) {
        Optional<Order> order = getById(id);
        if(order.isPresent()){
            repositoryOrder.delete(order.get());
        }
    }

    @Override
    public Order save(Order order) {
        return repositoryOrder.save(order);
    }
}
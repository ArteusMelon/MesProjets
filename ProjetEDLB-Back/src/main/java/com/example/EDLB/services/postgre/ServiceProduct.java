package com.example.EDLB.services.postgre;

import com.example.EDLB.models.entities.Product;
import com.example.EDLB.repositories.JPA.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceProduct implements IServicePostgre<Product> {

    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public List<Product> getAll() {
        return repositoryProduct.findAll();
    }

    @Override
    public Optional<Product> getById(UUID productId) {
        return repositoryProduct.findById(productId);
    }

    @Override
    public void delete(UUID productId) {
        Optional<Product> product = getById(productId);
        if (product.isPresent()) {
            repositoryProduct.delete(product.get());
        }
    }

    @Override
    public Product save(Product product) {
        return repositoryProduct.save(product);
    }
}
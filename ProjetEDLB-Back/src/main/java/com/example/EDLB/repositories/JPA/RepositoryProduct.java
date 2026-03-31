package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryProduct extends JpaRepository<Product, UUID> {
}
package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.Litter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RepositoryLitter extends JpaRepository<Litter, UUID> {
}
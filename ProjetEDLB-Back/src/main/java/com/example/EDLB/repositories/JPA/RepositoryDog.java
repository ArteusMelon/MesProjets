package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.Dog;
import com.example.EDLB.models.entities.Litter;
import com.example.EDLB.models.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.List;


@Repository
public interface RepositoryDog extends JpaRepository<Dog, UUID> {
    List<Dog> findByUser(User user);
    List<Dog> findByLitter(Litter litter);
    List<Dog> findByDogCode(String dogCode);
    List<Dog> findByNumberLOF(String numberLOF);
}
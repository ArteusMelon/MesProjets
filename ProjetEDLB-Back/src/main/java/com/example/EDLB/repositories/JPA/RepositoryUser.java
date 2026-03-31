package com.example.EDLB.repositories.JPA;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EDLB.models.entities.User;
import java.util.List;


@Repository
public interface RepositoryUser extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> findByNickname(String nickname);

}
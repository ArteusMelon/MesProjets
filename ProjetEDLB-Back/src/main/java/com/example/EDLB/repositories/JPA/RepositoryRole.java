package com.example.EDLB.repositories.JPA;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EDLB.models.entities.Role;

@Repository
public interface RepositoryRole extends JpaRepository<Role, UUID> {
    Optional<Role> findByRoleName(String roleName);
    boolean existsByRoleName(String roleName);

}
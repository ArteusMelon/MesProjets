package com.example.EDLB.repositories.JPA.Security;

import com.example.EDLB.models.entities.User;
import com.example.EDLB.models.security.Token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {
  Optional<Token> findByTokenValue(String token);
  Optional<Token> findByUser(User usr);
  void deleteByUser(User usr);
}
package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.UserMedia;
import com.example.EDLB.models.entities.UserMediaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryUserMedia extends JpaRepository<UserMedia, UserMediaId> {
    List<UserMedia> findByUserMediaIdIdUser(UUID id);
    List<UserMedia> findByUserMediaIdIdMedia(String id);
}

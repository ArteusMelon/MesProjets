package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.LitterMedia;
import com.example.EDLB.models.entities.LitterMediaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryLitterMedia extends JpaRepository<LitterMedia, LitterMediaId> {
    List<LitterMedia> findByLitterMediaIdIdLitter(UUID id);
    List<LitterMedia> findByLitterMediaIdIdMedia(String id);
}

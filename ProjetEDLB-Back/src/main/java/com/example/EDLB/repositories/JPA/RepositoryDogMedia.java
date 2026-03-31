package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.DogMedia;
import com.example.EDLB.models.entities.DogMediaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryDogMedia extends JpaRepository<DogMedia, DogMediaId> {
  List<DogMedia> findByDogMediaIdIdDog(UUID id);
  List<DogMedia> findByDogMediaIdIdMedia(String id);
}

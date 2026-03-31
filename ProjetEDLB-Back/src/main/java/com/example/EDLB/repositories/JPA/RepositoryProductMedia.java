package com.example.EDLB.repositories.JPA;

import com.example.EDLB.models.entities.ProductMedia;
import com.example.EDLB.models.entities.ProductMediaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryProductMedia extends JpaRepository<ProductMedia, ProductMediaId> {
    List<ProductMedia> findByProductMediaIdIdProduct(UUID id);
    List<ProductMedia> findByProductMediaIdIdMedia(String id);
}

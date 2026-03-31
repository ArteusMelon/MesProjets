package com.example.EDLB.repositories.mongo;

import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.EDLB.models.documents.Media;

@Repository
public interface RepositoryMedia extends MongoRepository<Media, ObjectId> {
    Optional<Media> findById(ObjectId id);
    boolean existsById(ObjectId id);
}
package com.example.EDLB.repositories.mongo;

import com.example.EDLB.models.documents.Publication;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryPublication extends MongoRepository<Publication, ObjectId> {
    Optional<Publication> findById(ObjectId id);
    boolean existsById(ObjectId id);
}
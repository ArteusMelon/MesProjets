package com.example.EDLB.repositories.mongo;

import com.example.EDLB.models.documents.Reaction;
import com.example.EDLB.models.documents.ReactionReference;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryReactionReference extends MongoRepository<ReactionReference, ObjectId> {
    Optional<ReactionReference> findById(ObjectId id);
    boolean existsById(ObjectId id);
}
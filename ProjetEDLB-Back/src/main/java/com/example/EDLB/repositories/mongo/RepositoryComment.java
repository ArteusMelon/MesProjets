package com.example.EDLB.repositories.mongo;

import com.example.EDLB.models.documents.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositoryComment extends MongoRepository<Comment, ObjectId> { //QuerydslPredicateExecutor<Person>
    Optional<Comment> findById(ObjectId id);
    boolean existsById(ObjectId id);
}
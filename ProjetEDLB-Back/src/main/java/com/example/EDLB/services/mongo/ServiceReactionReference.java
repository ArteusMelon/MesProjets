package com.example.EDLB.services.mongo;

import com.example.EDLB.DTO.documentDTO.DTOReactionReference;
import com.example.EDLB.models.documents.ReactionReference;
import com.example.EDLB.repositories.mongo.RepositoryReactionReference;
import jakarta.persistence.EntityNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceReactionReference implements IServiceMongo<ReactionReference> {

    @Autowired
    RepositoryReactionReference repositoryReactionReference;

    @Override
    public List<ReactionReference> getAll() {
        return repositoryReactionReference.findAll();
    }

    @Override
    public Optional<ReactionReference> getById(ObjectId id) {
        return repositoryReactionReference.findById(id);
    }

    @Override
    public void delete(ObjectId id) {
        Optional<ReactionReference> reactionReference = getById(id);
        if (reactionReference.isPresent()) {
            repositoryReactionReference.delete(reactionReference.get());
        }
    }

    @Override
    public ReactionReference save(ReactionReference reacRef) {
        return repositoryReactionReference.save(reacRef);
    }

    public ReactionReference updateReactionReference(ObjectId id, DTOReactionReference dtoReactionReference) {
        return getById(id).map(existingReactionReference -> {
            if (!dtoReactionReference.getName().isBlank()
                    && !dtoReactionReference.getName().equals(existingReactionReference.getName())) {
                existingReactionReference.setName(dtoReactionReference.getName());
            }
            if (!dtoReactionReference.getDescription().isBlank()
                    && !dtoReactionReference.getDescription().equals(existingReactionReference.getDescription())) {
                existingReactionReference.setDescription(dtoReactionReference.getDescription());
            }
            return save(existingReactionReference);
        }).orElseThrow(() -> new EntityNotFoundException("ID ReactionReference : " + id + " not found."));
    }
}
package com.example.EDLB.services.mongo;

import com.example.EDLB.DTO.documentDTO.DTOComment;
import com.example.EDLB.models.documents.Comment;
import com.example.EDLB.repositories.mongo.RepositoryComment;
import jakarta.persistence.EntityNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceComment implements IServiceMongo<Comment>{

    @Autowired
    private RepositoryComment repositoryComment;
    @Override
    public List<Comment> getAll() {
        return repositoryComment.findAll();
    }

    @Override
    public Optional<Comment> getById(ObjectId id) {
        return repositoryComment.findById(id);
    }

    @Override
    public void delete(ObjectId id) {
        Optional<Comment> comment = getById(id);
        if(comment.isPresent()){
            repositoryComment.delete(comment.get());
        }
    }

    @Override
    public Comment save(Comment comment) {
        return repositoryComment.save(comment);
    }

    public Comment updateComment(ObjectId id, DTOComment dtoComment){
        return getById(id).map(existingComment -> {
            if(!dtoComment.getMessage().isBlank() && !dtoComment.getMessage().equals(existingComment.getMessageComment())){existingComment.setMessageComment(dtoComment.getMessage());}
            if(dtoComment.getUpdateDate()!=null){existingComment.setDateOfUpdateComment(dtoComment.getUpdateDate());}
            return save(existingComment);
        }).orElseThrow(() -> new EntityNotFoundException("ID comment : "+id+" not found."));
    }
}
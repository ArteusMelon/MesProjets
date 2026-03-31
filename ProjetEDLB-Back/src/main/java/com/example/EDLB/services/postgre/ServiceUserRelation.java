package com.example.EDLB.services.postgre;

import com.example.EDLB.models.entities.*;
import com.example.EDLB.repositories.JPA.RepositoryUserRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserRelation {
    @Autowired
    RepositoryUserRelation repositoryUserRelation;

    public List<UserRelation> getAll() {
        return repositoryUserRelation.findAll();
    }

    public Optional<UserRelation> getById(UserRelationId id) {
        return repositoryUserRelation.findById(id);
    }

    public void delete(UserRelationId id) {
        Optional<UserRelation> userRelation = getById(id);
        if(userRelation.isPresent()){
            repositoryUserRelation.delete(userRelation.get());
        }
    }

    public UserRelation save(UserRelation userRelation) {
        return repositoryUserRelation.save(userRelation);
    }
}
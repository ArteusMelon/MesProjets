package com.example.EDLB.services.postgre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.models.entities.RelationType;
import com.example.EDLB.repositories.JPA.RepositoryRelationType;

@Service
public class ServiceRelationType implements IServicePostgre<RelationType> {

    @Autowired
    private RepositoryRelationType repositoryRelationType;

    @Override
    public List<RelationType> getAll() {
        return repositoryRelationType.findAll();
    }

    @Override
    public Optional<RelationType> getById(UUID relationTypeId) {
        return repositoryRelationType.findById(relationTypeId);
    }

    @Override
    public void delete(UUID relationTypeId) {
        Optional<RelationType> relationType = getById(relationTypeId);
        if(relationType.isPresent()){
            repositoryRelationType.delete(relationType.get());
        }
    }

    @Override
    public RelationType save(RelationType relationType) {
        return repositoryRelationType.save(relationType);
    }
}
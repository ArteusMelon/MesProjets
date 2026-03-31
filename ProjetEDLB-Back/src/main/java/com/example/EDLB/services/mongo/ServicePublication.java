package com.example.EDLB.services.mongo;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EDLB.DTO.documentDTO.DTOPublication;
import com.example.EDLB.models.documents.Publication;
import com.example.EDLB.repositories.mongo.RepositoryPublication;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicePublication implements IServiceMongo<Publication> {

    @Autowired
    RepositoryPublication repositoryPublication;

    @Override
    public List<Publication> getAll() {
        return repositoryPublication.findAll();
    }

    @Override
    public Optional<Publication> getById(ObjectId id) {
        return repositoryPublication.findById(id);
    }

    @Override
    public void delete(ObjectId id) {
        Optional<Publication> publication = getById(id);
        if(getById(id).isPresent()){
            repositoryPublication.delete(publication.get());
        }
    }

    @Override
    public Publication save(Publication publi) {
        return repositoryPublication.save(publi);
    }

    public Publication updatePublication(ObjectId id, DTOPublication dtoPublication){
        return getById(id).map(existingPublication -> {
            if(!dtoPublication.getMessage().isBlank() && !dtoPublication.getMessage().equals(existingPublication.getMessagePublication())){
                existingPublication.setMessagePublication(dtoPublication.getMessage());
            }
            if(dtoPublication.getUpdateDate()!=null){
                existingPublication.setUpdateDate(dtoPublication.getUpdateDate());
            }
            return save(existingPublication);
        }).orElseThrow(() -> new EntityNotFoundException("ID Publication : "+id+" not found."));
    }
}

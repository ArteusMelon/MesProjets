package com.example.EDLB.services.postgre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.jpaDTO.DTOLitter;
import com.example.EDLB.models.entities.Litter;
import com.example.EDLB.repositories.JPA.RepositoryLitter;

@Service
public class ServiceLitter implements IServicePostgre<Litter> {

    @Autowired
    private RepositoryLitter repositoryLitter;

    @Override
    public List<Litter> getAll() {
        return repositoryLitter.findAll();
    }

    @Override
    public Optional<Litter> getById(UUID id) {
        return repositoryLitter.findById(id);
    }

    @Override
    public void delete(UUID id) {
        Optional<Litter> litter = getById(id);
        if(litter.isPresent()){
            repositoryLitter.delete(litter.get());
        }
    }

    @Override
    public Litter save(Litter litter) {
        return repositoryLitter.save(litter);
    }

    public Litter addLitter(DTOLitter dtoLitter){
        if(dtoLitter == null){
            throw new IllegalArgumentException("Missing fields. Can't create a new litter without litter's informations.");
        }
        if(dtoLitter.getMatingDate()==null){
            throw new IllegalArgumentException("Missing field. Mating date are required.");
        }
        Litter litter = new Litter();
        litter.setNumberLOF(dtoLitter.getNumberLOF());
        litter.setNumberLitter(dtoLitter.getNumberLitter());
        litter.setMatingDate(dtoLitter.getMatingDate());
        litter.setBirthDate(dtoLitter.getBirthDate());
        return save(litter);
    }

    public Litter updateLitter(UUID id, DTOLitter dtoLitter){
        return getById(id).map(existingLitter -> {
            if(!dtoLitter.getNumberLOF().isBlank() && !dtoLitter.getNumberLOF().equals(existingLitter.getNumberLOF())){
                existingLitter.setNumberLOF(dtoLitter.getNumberLOF());
            }
            if(!dtoLitter.getNumberLitter().isBlank() && !dtoLitter.getNumberLitter().equals(existingLitter.getNumberLitter())){
                existingLitter.setNumberLitter(dtoLitter.getNumberLitter());
            }
            if(dtoLitter.getMatingDate()!=null && !dtoLitter.getMatingDate().equals(existingLitter.getMatingDate())){
                existingLitter.setMatingDate(dtoLitter.getMatingDate());
            }
            if(dtoLitter.getBirthDate()!=null && !dtoLitter.getBirthDate().equals(existingLitter.getBirthDate())){
                existingLitter.setBirthDate(dtoLitter.getBirthDate());
            }
            return save(existingLitter);
        }).orElseThrow(() -> new EntityNotFoundException("ID Litter : "+id+" not found."));
    }
}
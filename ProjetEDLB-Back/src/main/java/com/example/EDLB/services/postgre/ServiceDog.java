package com.example.EDLB.services.postgre;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.jpaDTO.DTODog;
import com.example.EDLB.models.entities.Dog;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.repositories.JPA.RepositoryDog;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceDog implements IServicePostgre<Dog> {

    @Autowired
    private RepositoryDog repositoryDog;

    @Override
    public List<Dog> getAll() {
        return repositoryDog.findAll();
    }

    @Override
    public Optional<Dog> getById(UUID id) {
        return repositoryDog.findById(id);
    }

    @Override
    public void delete(UUID id) {
        Optional<Dog> dog = getById(id);
        if(dog.isPresent()){
            repositoryDog.delete(dog.get());
        }
    }

    @Override
    public Dog save(Dog dog) {
        return repositoryDog.save(dog);
    }

    public Dog addDog(DTODog dtoDog){
        if(dtoDog == null){
            throw new IllegalArgumentException("Missing fields. Can't create a new dog without dog's informations.");
        }
        Dog dog = new Dog();
        dog.setName(dtoDog.getName());
        dog.setNumberLOF(dtoDog.getNumberLOF());
        dog.setNumberICAD(dtoDog.getNumberICAD());
        dog.setWeight(dtoDog.getWeight());
        dog.setDogCode(dtoDog.getDogCode());
        dog.setBirthdate(dtoDog.getBirthdate());
        dog.setSex(dtoDog.getSex());
        dog.setCollarColor(dtoDog.getCollarColor());
        dog.setLitter(dtoDog.getLitter());
        dog.setUser(dtoDog.getUser());
        return save(dog);
    }

    public Dog updateDog(UUID id, DTODog dtoDog){
        return getById(id).map(existingDog -> {
            if(!dtoDog.getName().isBlank() && !dtoDog.getName().equals(existingDog.getName())){
                existingDog.setName(dtoDog.getName());
            }
            if(!dtoDog.getNumberLOF().isBlank() && !dtoDog.getNumberLOF().equals(existingDog.getNumberLOF())){
                existingDog.setNumberLOF(dtoDog.getNumberLOF());
            }
            if(!dtoDog.getNumberICAD().isBlank() && !dtoDog.getNumberICAD().equals(existingDog.getNumberICAD())){
                existingDog.setNumberICAD(dtoDog.getNumberICAD());
            }
            if(dtoDog.getWeight()!=null && !dtoDog.getWeight().equals(existingDog.getWeight())){
                existingDog.setWeight(dtoDog.getWeight());
            }
            if(!dtoDog.getDogCode().isBlank() && !dtoDog.getDogCode().equals(existingDog.getDogCode())){
                existingDog.setDogCode(dtoDog.getDogCode());
            }
            if(dtoDog.getBirthdate()!=null && !dtoDog.getBirthdate().equals(existingDog.getBirthdate())){
                existingDog.setBirthdate(dtoDog.getBirthdate());
            }
            if(dtoDog.getModificationDate()!=null && !dtoDog.getModificationDate().equals(existingDog.getModificationDate())){
                existingDog.setModificationDate(dtoDog.getModificationDate());
            }
            if(dtoDog.getSex()!=null && !dtoDog.getSex().equals(existingDog.getSex())){
                existingDog.setSex(dtoDog.getSex());
            }
            if(!dtoDog.getCollarColor().isBlank() && !dtoDog.getCollarColor().equals(existingDog.getCollarColor())){
                existingDog.setCollarColor(dtoDog.getCollarColor());
            }
            if(dtoDog.getLitter()!=null && !dtoDog.getLitter().equals(existingDog.getLitter())){
                existingDog.setLitter(dtoDog.getLitter());
            }
            if(dtoDog.getUser()!=null && !dtoDog.getUser().equals(existingDog.getUser())){
                existingDog.setUser(dtoDog.getUser());
            }
            return save(existingDog);
        }).orElseThrow(() -> new EntityNotFoundException("ID Dog : "+id+" not found."));
    }


    public List<Dog> findByUserDogs(User usr){
        return repositoryDog.findByUser(usr);
    }
}
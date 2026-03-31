package com.example.EDLB.services.postgre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.DTO.jpaDTO.DTODeliveryMode;
import com.example.EDLB.models.entities.DeliveryMode;
import com.example.EDLB.repositories.JPA.RepositoryDeliveryMode;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceDeliveryMode implements IServicePostgre<DeliveryMode> {

    @Autowired
    RepositoryDeliveryMode repositoryDeliveryMode;

    @Override
    public List<DeliveryMode> getAll(){
        return repositoryDeliveryMode.findAll();
    }

    @Override
    public Optional<DeliveryMode> getById(UUID id){
        return repositoryDeliveryMode.findById(id);
    }

    @Override
    public void delete(UUID id){
        Optional<DeliveryMode> deliveryMode = getById(id);
        if(deliveryMode.isPresent()){
            repositoryDeliveryMode.delete(deliveryMode.get());
        }
    }

    @Override
    public DeliveryMode save(DeliveryMode deliveryMode){
        return repositoryDeliveryMode.save(deliveryMode);
    }

    public DeliveryMode addDeliveryMode(DTODeliveryMode dtoDeliveryMode){
        if(dtoDeliveryMode == null){
            throw new IllegalArgumentException("Missing fields. Can't create a new delivery methode without its information");
        }
        DeliveryMode deliveryMode = new DeliveryMode();
        deliveryMode.setName(dtoDeliveryMode.getName());
        deliveryMode.setDescription(dtoDeliveryMode.getDescription());
        deliveryMode.setPrice(dtoDeliveryMode.getPrice());
        return save(deliveryMode);
    }

    public DeliveryMode updateDeliveryMode(UUID id, DTODeliveryMode dtoDeliveryMode){
        return getById(id).map(existingDeliveryMode -> {
            if(!dtoDeliveryMode.getName().isBlank() && !dtoDeliveryMode.getName().equals(existingDeliveryMode.getName())){
                existingDeliveryMode.setName(dtoDeliveryMode.getName());
            }
            if(!dtoDeliveryMode.getDescription().isBlank() && !dtoDeliveryMode.getDescription().equals(existingDeliveryMode.getDescription())){
                existingDeliveryMode.setDescription(dtoDeliveryMode.getDescription());
            }
            if(dtoDeliveryMode.getPrice() != null && !dtoDeliveryMode.getPrice().equals(existingDeliveryMode.getPrice())){
                existingDeliveryMode.setPrice(dtoDeliveryMode.getPrice());
            }
            return save(existingDeliveryMode);
        }).orElseThrow(() -> new EntityNotFoundException("ID DeliveryMode : "+id+" not found."));
    }
}
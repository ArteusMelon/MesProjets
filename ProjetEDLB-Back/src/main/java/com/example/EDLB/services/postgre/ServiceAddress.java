package com.example.EDLB.services.postgre;

import com.example.EDLB.DTO.jpaDTO.DTOAddress;
import com.example.EDLB.models.entities.Address;
import com.example.EDLB.repositories.JPA.RepositoryAddress;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceAddress implements IServicePostgre<Address> {

    @Autowired
    RepositoryAddress repositoryAddress;

    @Override
    public List<Address> getAll() {
        return repositoryAddress.findAll();
    }

    @Override
    public Optional<Address> getById(UUID id) {
        return repositoryAddress.findById(id);
    }

    @Override
    public void delete(UUID id) {
        Optional<Address> address = getById(id);
        if(address.isPresent()){
            repositoryAddress.delete(address.get());
        }
    }

    @Override
    public Address save(Address address) {
        return repositoryAddress.save(address);
    }

    public Address addAddress(DTOAddress dtoAddress){
        if(dtoAddress == null){
            throw new IllegalArgumentException("Missing fields. Can't create a new address without address's informations.");
        }
        Address address = new Address();
        address.setName(dtoAddress.getName());
        address.setCompany(dtoAddress.getCompany());
        address.setStreetNumber(dtoAddress.getStreetNumber());
        address.setStreetName(dtoAddress.getStreetName());
        address.setAdditionalInfo(dtoAddress.getAdditionalInfo());
        address.setPostalCode(dtoAddress.getPostalCode());
        address.setCity(dtoAddress.getCity());
        address.setRegion(dtoAddress.getRegion());
        address.setCountry(dtoAddress.getCountry());
        address.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return save(address);
    }

    public Address updateAddress(UUID id, DTOAddress dtoAddress){
        return getById(id).map(existingAddress -> {
            if(!dtoAddress.getName().isBlank() && !dtoAddress.getName().equals(existingAddress.getName())){
                existingAddress.setName(dtoAddress.getName());
            }
            if(!dtoAddress.getCompany().isBlank() && !dtoAddress.getCompany().equals(existingAddress.getCompany())){
                existingAddress.setCompany(dtoAddress.getCompany());
            }
            if(!dtoAddress.getStreetNumber().isBlank() && !dtoAddress.getStreetNumber().equals(existingAddress.getStreetNumber())){
                existingAddress.setStreetNumber(dtoAddress.getStreetNumber());
            }
            if(!dtoAddress.getStreetName().isBlank() && !dtoAddress.getStreetName().equals(existingAddress.getStreetName())){
                existingAddress.setStreetName(dtoAddress.getStreetName());
            }
            if(!dtoAddress.getAdditionalInfo().isBlank() && !dtoAddress.getAdditionalInfo().equals(existingAddress.getAdditionalInfo())){
                existingAddress.setAdditionalInfo(dtoAddress.getAdditionalInfo());
            }
            if(!dtoAddress.getPostalCode().isBlank() && !dtoAddress.getPostalCode().equals(existingAddress.getPostalCode())){
                existingAddress.setPostalCode(dtoAddress.getPostalCode());
            }
            if(!dtoAddress.getCity().isBlank() && !dtoAddress.getCity().equals(existingAddress.getCity())){
                existingAddress.setCity(dtoAddress.getCity());
            }
            if(!dtoAddress.getRegion().isBlank() && !dtoAddress.getRegion().equals(existingAddress.getRegion())){
                existingAddress.setRegion(dtoAddress.getRegion());
            }
            if(!dtoAddress.getCountry().isBlank() && !dtoAddress.getCountry().equals(existingAddress.getCountry())){
                existingAddress.setCountry(dtoAddress.getCountry());
            }
            existingAddress.setUpdatedAt(Timestamp.valueOf(LocalDateTime.now()));
            return save(existingAddress);
        }).orElseThrow(() -> new EntityNotFoundException("ID Address : "+id+" not found."));
    }
}
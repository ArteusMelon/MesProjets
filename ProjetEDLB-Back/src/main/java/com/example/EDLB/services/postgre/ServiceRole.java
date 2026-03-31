package com.example.EDLB.services.postgre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.models.entities.Role;
import com.example.EDLB.repositories.JPA.RepositoryRole;

@Service
public class ServiceRole implements IServicePostgre<Role> {

    @Autowired
    private RepositoryRole repositoryRole;

    @Override
    public List<Role> getAll() {
        return repositoryRole.findAll();
    }
    
    @Override
    public Optional<Role> getById(UUID roleId) {
        return repositoryRole.findById(roleId);
    }

    @Override
    public void delete(UUID roleId) {
        Optional<Role> role = getById(roleId);
        if(role.isPresent()){
            repositoryRole.delete(role.get());
        }
    }

    @Override
    public Role save(Role role) {
        return repositoryRole.save(role);
    }
}
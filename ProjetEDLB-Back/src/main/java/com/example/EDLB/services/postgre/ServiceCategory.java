package com.example.EDLB.services.postgre;

import com.example.EDLB.DTO.jpaDTO.DTOCategory;
import com.example.EDLB.DTO.jpaDTO.DTODeliveryMode;
import com.example.EDLB.models.entities.Category;
import com.example.EDLB.repositories.JPA.RepositoryCategory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceCategory implements IServicePostgre<Category> {

    @Autowired
    private RepositoryCategory repositoryCategory;

    @Override
    public List<Category> getAll() {
        return repositoryCategory.findAll();
    }

    @Override
    public Optional<Category> getById(UUID id) {
        return repositoryCategory.findById(id);
    }

    @Override
    public void delete(UUID id) {
        Optional<Category> cat = getById(id);
        if (cat.isPresent()) {
            repositoryCategory.delete(cat.get());
        }
    }

    @Override
    public Category save(Category cat) {
        return repositoryCategory.save(cat);
    }

    public Category addCategory(DTOCategory dtoCategory){
        if(dtoCategory == null){
            throw new IllegalArgumentException("Missing fields. Can't create a new category withou it's informations.");
        }
        Category category = new Category();
        category.setName(dtoCategory.getName());
        category.setDescription(dtoCategory.getDescription());
        return save(category);
    }

    public Category updateCategory(UUID id, DTOCategory dtoCategory){
        return getById(id).map(existingCategory -> {
            if(!dtoCategory.getName().isBlank() && !dtoCategory.getName().equals(existingCategory.getName())){
                existingCategory.setName(dtoCategory.getName());
            }
            if(!dtoCategory.getDescription().isBlank() && !dtoCategory.getDescription().equals(existingCategory.getDescription())){
                existingCategory.setDescription(dtoCategory.getDescription());
            }
            return save(existingCategory);
        }).orElseThrow(() -> new EntityNotFoundException("ID Category : "+id+" not found."));
    }
}
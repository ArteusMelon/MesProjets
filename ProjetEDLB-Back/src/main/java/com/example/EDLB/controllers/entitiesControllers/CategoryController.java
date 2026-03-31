package com.example.EDLB.controllers.entitiesControllers;

import com.example.EDLB.DTO.documentDTO.DTOComment;
import com.example.EDLB.DTO.jpaDTO.DTOCategory;
import com.example.EDLB.models.entities.Category;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/categories")
public class CategoryController {

    @Autowired
    private ServiceCategory serviceCategory;

    // GET
    @GetMapping
    public ResponseEntity<List<Category>> allCategories() {
        List<Category> categories = serviceCategory.getAll();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<Category> categoryById(@PathVariable UUID id) {
        Optional<Category> category = serviceCategory.getById(id);
        if (category.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(category.get());
    }

    // POST
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody DTOCategory dtoCategory) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCategory.addCategory(dtoCategory));
    }

    // PATCH
    @PatchMapping("/{idCategory}")
    public ResponseEntity<Category> updateCategory(@PathVariable UUID id, @RequestBody DTOCategory dtoCategory,
            @AuthenticationPrincipal User principal) {
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceCategory.updateCategory(id, dtoCategory));
    }

    // DELETE
    @DeleteMapping("/{idCategory}")
    public ResponseEntity<Category> deleteCategory(@PathVariable UUID id, @AuthenticationPrincipal User principal) {
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceCategory.delete(id);
        return ResponseEntity.ok().build();
    }
}
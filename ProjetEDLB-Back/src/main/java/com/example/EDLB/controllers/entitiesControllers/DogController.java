package com.example.EDLB.controllers.entitiesControllers;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.EDLB.DTO.jpaDTO.DTODog;
import com.example.EDLB.models.entities.Dog;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceDog;

@RestController
@RequestMapping("/api/dogs")
public class DogController {

    @Autowired
    private ServiceDog serviceDog;

    // GET
    @GetMapping("/{idDog}")
    public ResponseEntity<Dog> dogById(@PathVariable UUID idDog){
        Optional<Dog> dog = serviceDog.getById(idDog);
        if(dog.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(dog.get());
    }

    // POST
    @PostMapping
    public ResponseEntity<Dog> addDog(@RequestBody DTODog dtoDog){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceDog.addDog(dtoDog));
    }

    // PATCH
    @PatchMapping("/{idDog}")
    public ResponseEntity<Dog> updateDog(@PathVariable UUID id, @RequestBody DTODog dtoDog, @AuthenticationPrincipal User principal){
        if(!principal.equals(serviceDog.getById(id).get().getUser()) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceDog.updateDog(id, dtoDog));
    }

    // DELETE
    @DeleteMapping("/{idDog}")
    public ResponseEntity<Dog> deleteDog(@PathVariable UUID id, @AuthenticationPrincipal User principal){
        if(!principal.equals(serviceDog.getById(id).get().getUser()) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceDog.delete(id);
        return ResponseEntity.ok().build();
    }
}
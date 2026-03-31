package com.example.EDLB.controllers.entitiesControllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import com.example.EDLB.DTO.jpaDTO.DTOUser;
import com.example.EDLB.mappers.MapperUserProfile;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.postgre.ServiceUser;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    
    private ServiceUser serviceUser;

    
    // GET
    @GetMapping
    public ResponseEntity<List<User>> allUsers() {
        List<User> user = serviceUser.getAll();
        return ResponseEntity.ok(user);
    }

    // GET
    @GetMapping("/{idUser}")
    public ResponseEntity<User> userById(@PathVariable UUID userId) {
        Optional<User> user = serviceUser.getById(userId);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user.get());
    }

    // POST
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody DTOUser userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceUser.addUser(userDTO));
    }

    // PATCH
    @PatchMapping("/{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody DTOUser dtoUser, @AuthenticationPrincipal User principal) {
        if (!principal.getIdUser().equals(id) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceUser.updateUser(id, dtoUser));
    }
    // DELETE
    @DeleteMapping("/{idUser}")
    public ResponseEntity<User> deleteUser(@PathVariable UUID id, @AuthenticationPrincipal User principal) {
        if (!principal.getIdUser().equals(id) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceUser.delete(id);
        return ResponseEntity.ok().build();
    }
}
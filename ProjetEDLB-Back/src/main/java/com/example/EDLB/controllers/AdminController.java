package com.example.EDLB.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.EDLB.DTO.jpaDTO.DTODeliveryMode;
import com.example.EDLB.DTO.jpaDTO.DTOLitter;
import com.example.EDLB.models.entities.*;
import com.example.EDLB.services.postgre.*;
import org.bson.types.ObjectId;
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
import com.example.EDLB.DTO.documentDTO.DTOReactionReference;
import com.example.EDLB.mappers.MapperReactionReference;
import com.example.EDLB.models.documents.Comment;
import com.example.EDLB.models.documents.Publication;
import com.example.EDLB.models.documents.ReactionReference;
import com.example.EDLB.services.mongo.ServiceComment;
import com.example.EDLB.services.mongo.ServicePublication;
import com.example.EDLB.services.mongo.ServiceReactionReference;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ServiceAddress serviceAddress;
    @Autowired
    private ServiceDeliveryMode serviceDeliveryMode;
    @Autowired
    private ServiceUser serviceUser;
    @Autowired
    private ServiceDog serviceDog;
    @Autowired
    private ServiceLitter serviceLitter;
    @Autowired
    private ServicePublication servicePublication;
    @Autowired
    private ServiceComment serviceComment;
    @Autowired
    private ServiceReactionReference serviceReactionReference;
    @Autowired
    private MapperReactionReference mapperReactionReference;

    // GET
    // Entities
    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> allAddresses() {
        List<Address> addresses = serviceAddress.getAll();
        if (addresses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> allDogs() {
        List<Dog> dogs = serviceDog.getAll();
        if (dogs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dogs);
    }

    @GetMapping("/litters")
    public ResponseEntity<List<Litter>> allLitters() {
        List<Litter> litters = serviceLitter.getAll();
        if (litters.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(litters);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = serviceUser.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    // Documents
    @GetMapping("/publications")
    public ResponseEntity<List<Publication>> allPublications() {
        List<Publication> publications = servicePublication.getAll();
        if (publications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(publications);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> allComments() {
        List<Comment> comments = serviceComment.getAll();
        if (comments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/reactions")
    public ResponseEntity<List<DTOReactionReference>> allReactionReferences() {
        List<ReactionReference> reactionReferences = serviceReactionReference.getAll();
        if (reactionReferences.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<DTOReactionReference> dtoReactionReferences = reactionReferences.stream()
                .map(reactionReference -> mapperReactionReference.convertToDTOReactionReference(reactionReference))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoReactionReferences);
    }

    // PATCH
    @PatchMapping("/deliverymodes/{idDeliveryMode}")
    public ResponseEntity<DeliveryMode> updateDeliveryMode(@PathVariable UUID id,
            @RequestBody DTODeliveryMode dtoDeliveryMode, @AuthenticationPrincipal User principal) {
        Optional<DeliveryMode> optionalDeliveryMode = serviceDeliveryMode.getById(id);
        if (optionalDeliveryMode.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceDeliveryMode.updateDeliveryMode(id, dtoDeliveryMode));
    }

    @PatchMapping("/litters/{idLitter}")
    public ResponseEntity<Litter> updateLitter(@PathVariable UUID id, @RequestBody DTOLitter dtoLitter,
            @AuthenticationPrincipal User principal) {
        Optional<Litter> optLitter = serviceLitter.getById(id);
        if (optLitter.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceLitter.updateLitter(id, dtoLitter));
    }

    @PatchMapping("/reactions/{reactionReferenceId}")
    public ResponseEntity<ReactionReference> ReactionReferenceUpdate(@PathVariable ObjectId id,
            @RequestBody DTOReactionReference dtoReactionReference, @AuthenticationPrincipal User principal) {
        Optional<ReactionReference> optionalReactionReference = serviceReactionReference.getById(id);
        if (optionalReactionReference.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceReactionReference.updateReactionReference(id, dtoReactionReference));
    }

    // POST
    @PostMapping("/deliverymodes")
    public ResponseEntity<DeliveryMode> addDeliveryMode(@RequestBody DTODeliveryMode dtoDeliveryMode,
            @AuthenticationPrincipal User principal) {
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceDeliveryMode.addDeliveryMode(dtoDeliveryMode));
    }

    @PostMapping("/litters")
    public ResponseEntity<Litter> addLitter(@RequestBody DTOLitter dtoLitter, @AuthenticationPrincipal User principal) {
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceLitter.addLitter(dtoLitter));
    }

    // @PostMapping("/reactions")
    // // TODO : Fix this and others mongo Post methodes
    // public ResponseEntity<ReactionReference> addReactionReferences(@RequestBody
    // DTOReactionReference dtoReactionReference, @AuthenticationPrincipal User
    // principal) {
    // if (principal.getRoles().stream().noneMatch(role ->
    // "Admin".equals(role.getRoleName()))) {
    // return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    // }
    // ReactionReference reactionReference =
    // serviceReactionReference.getById(dtoReactionReference.getId()).get();
    // serviceReactionReference.save(reactionReference);
    // }

    // DELETE
    @DeleteMapping("/deliverymodes")
    public ResponseEntity<DeliveryMode> deleteDeliveryMode(@PathVariable UUID id,
            @AuthenticationPrincipal User principal) {
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceDeliveryMode.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/litters/{idLitter}")
    public ResponseEntity<Litter> deleteLitter(@PathVariable UUID id, @AuthenticationPrincipal User principal) {
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceLitter.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/reactions/{reactionReferenceId}")
    public ResponseEntity<ReactionReference> deleteReactionReference(@PathVariable ObjectId id,
            @AuthenticationPrincipal User principal) {
        if (principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        serviceComment.delete(id);
        return ResponseEntity.ok().build();
    }
}
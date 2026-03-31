package com.example.EDLB.controllers.documentsControllers;

import com.example.EDLB.DTO.documentDTO.DTOPublication;
import com.example.EDLB.mappers.MapperPublication;
import com.example.EDLB.models.documents.Publication;
import com.example.EDLB.models.entities.User;
import com.example.EDLB.services.mongo.ServicePublication;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private MapperPublication mapperPublication;
    @Autowired
    private ServicePublication servicePublication;

    // GET
    @GetMapping
    public ResponseEntity<List<DTOPublication>> allPublications() {
        List<Publication> publications = servicePublication.getAll();
        if (publications.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<DTOPublication> dtoPublications = publications.stream()
                .map(publication -> mapperPublication.convertToDTOPublication(publication))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoPublications);
    }

    @GetMapping("/{idPublication}")
    public ResponseEntity<DTOPublication> PublicationById(@PathVariable ObjectId id) {

        Optional<Publication> publication = servicePublication.getById(id);
        if (publication.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(mapperPublication.convertToDTOPublication(publication.get()));
    }

    // POST
    @PostMapping
    public Publication addPublications(@RequestBody DTOPublication dtoPublication) {
        Publication publication = servicePublication.getById(dtoPublication.getId()).get();
        return servicePublication.save(publication);
    }

    // PUT
    // @RequestMapping("/api/Publications/{PublicationId}")
    // public void updatePublication(Publication publication){
    // PublicationService.save(publication);
    // }

    // PATCH
    @PatchMapping("/{idPublication}")
    public ResponseEntity<Publication> publicationUpdate(@PathVariable ObjectId id, @RequestBody DTOPublication dtoPublication, @AuthenticationPrincipal User principal) {
        Optional<Publication> optionalPublication = servicePublication.getById(id);
        if (optionalPublication.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (!principal.getIdUser().equals(UUID.fromString(optionalPublication.get().getIdUser()))) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(servicePublication.updatePublication(id, dtoPublication));
    }

    // DELETE
    @DeleteMapping("/{idPublication}")
    public ResponseEntity<Publication> publicationDelete(@PathVariable ObjectId id, @AuthenticationPrincipal User principal) {
        if (!principal.getIdUser().equals(UUID.fromString(servicePublication.getById(id).get().getIdUser())) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        servicePublication.delete(id);
        return ResponseEntity.ok().build();
    }
}
package com.example.EDLB.controllers.documentsControllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.EDLB.models.entities.*;
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
import com.example.EDLB.DTO.documentDTO.DTOMedia;
import com.example.EDLB.mappers.MapperMedia;
import com.example.EDLB.models.documents.Media;
import com.example.EDLB.services.mongo.ServiceMedia;
import com.example.EDLB.services.postgre.ServiceDogMedia;
import com.example.EDLB.services.postgre.ServiceLitterMedia;
import com.example.EDLB.services.postgre.ServiceProductMedia;
import com.example.EDLB.services.postgre.ServiceUserMedia;

@RestController
@RequestMapping("/api/medias")
public class MediaController {

    @Autowired
    private MapperMedia mapperMedia;
    @Autowired
    private ServiceMedia serviceMedia;
    @Autowired
    private ServiceUserMedia serviceUserMedia;
    @Autowired
    private ServiceLitterMedia serviceLitterMedia;
    @Autowired
    private ServiceDogMedia serviceDogMedia;
    @Autowired
    private ServiceProductMedia serviceProductMedia;

    // GET
    @GetMapping
    public ResponseEntity<List<DTOMedia>> allMedias() {
        List<Media> medias = serviceMedia.getAll();
        if (medias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<DTOMedia> dtoMedias = medias.stream()
                .map(media -> mapperMedia.convertToDTOMedia(media))
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoMedias);
    }

    @GetMapping("/{idMedia}")
    public ResponseEntity<DTOMedia> MediaById(@PathVariable ObjectId id) {

        Optional<Media> media = serviceMedia.getById(id);
        if (media.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(mapperMedia.convertToDTOMedia(media.get()));
    }

    // POST
    @PostMapping
    public Media addMedias(@RequestBody DTOMedia dtoMedia) {
        Media media = serviceMedia.getById(dtoMedia.getIdMedia()).get();
        return serviceMedia.save(media);
    }

    // PATCH
    @PatchMapping("/{idMedia}")
    public ResponseEntity<Media> mediaUpdate(@PathVariable ObjectId id, @RequestBody DTOMedia dtoMedia, @AuthenticationPrincipal User principal) {
        Optional<Media> optionalMedia = serviceMedia.getById(id);
        if (optionalMedia.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (!serviceUserMedia.getUsersOfMedia(id.toString()).contains(principal)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(serviceMedia.updateMedia(id, dtoMedia));
    }

    // DELETE
    @DeleteMapping("/{idMedia}")
    public ResponseEntity<Media> MediaDelete(@PathVariable ObjectId id, @AuthenticationPrincipal User principal) {
        if(!serviceUserMedia.getUsersOfMedia(id.toString()).contains(principal.getIdUser()) && principal.getRoles().stream().noneMatch(role -> "Admin".equals(role.getRoleName()))){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String idMedia = id.toString();
        UserMediaId userMediaId = new UserMediaId(principal.getIdUser(), idMedia);
        List<User> linkedUsers = serviceUserMedia.getUsersOfMedia(idMedia);
        if(principal.getRoles().contains("Admin")){
            if(!linkedUsers.isEmpty()){
                linkedUsers.forEach(user -> {
                    serviceUserMedia.delete(new UserMediaId(user.getIdUser(), idMedia));
                    linkedUsers.remove(user);
                });
                List<Product> linkedProducts = serviceProductMedia.getProductsOfMedia(idMedia);
                if(!linkedProducts.isEmpty()){
                    linkedProducts.forEach(product -> {
                        serviceProductMedia.delete(new ProductMediaId(product.getIdProduct(), idMedia));
                    });
                }
            }
        }else if(!Optional.of(userMediaId).isEmpty()){
            serviceUserMedia.delete(userMediaId);
        }
        if(linkedUsers.isEmpty()){
            List<Dog> linkedDogs = serviceDogMedia.getDogsOfMedia(idMedia);
            if(!linkedDogs.isEmpty()){
                linkedDogs.forEach(dog -> {
                    serviceDogMedia.delete(new DogMediaId(dog.getIdDog(), idMedia));
                });
            }
            List<Litter> linkedLitters = serviceLitterMedia.getLittersOfMedia(idMedia);
            if(!linkedLitters.isEmpty()){
                linkedLitters.forEach(litter -> {
                    serviceLitterMedia.delete(new LitterMediaId(litter.getIdLitter(), idMedia));
                });
            }
            serviceMedia.delete(id);
        }
        return ResponseEntity.ok().build();
    }
}
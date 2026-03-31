package com.example.EDLB.services.postgre;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EDLB.models.documents.Media;
import com.example.EDLB.models.entities.Dog;
import com.example.EDLB.models.entities.DogMedia;
import com.example.EDLB.models.entities.DogMediaId;
import com.example.EDLB.repositories.JPA.RepositoryDog;
import com.example.EDLB.repositories.JPA.RepositoryDogMedia;
import com.example.EDLB.services.mongo.ServiceMedia;

@Service
public class ServiceDogMedia  {

    @Autowired
    private RepositoryDogMedia repositoryDogMedia;
    @Autowired
    private RepositoryDog repositoryDog;
    @Autowired
    private ServiceMedia serviceMedia;

    public List<DogMedia> getAll() {
        return repositoryDogMedia.findAll();
    }

    public Optional<DogMedia> getById(DogMediaId id) {
        return repositoryDogMedia.findById(id);
    }

    /// find all medias linked to a dog of id 'id'
    public List<Media> getMediasForDog(UUID id){
        List<DogMedia> dogMediaList = repositoryDogMedia.findByDogMediaIdIdDog(id);
        if(dogMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return dogMediaList.stream().map(
            dogMedia -> serviceMedia.getByStringId(dogMedia.getDogMediaId().getIdMedia())
                .orElseThrow(() -> new RuntimeException("Media "+dogMedia.getDogMediaId().getIdMedia()+" not found."))
        ).collect(Collectors.toList());
    }

    /// find all dogs linked to a media of id 'id'
    public List<Dog> getDogsOfMedia(String id){
        List<DogMedia> dogMediaList = repositoryDogMedia.findByDogMediaIdIdMedia(id);
        if(dogMediaList.isEmpty()){
            return Collections.emptyList();
        }
        return dogMediaList.stream().map(
            dogMedia -> repositoryDog.findById(dogMedia.getDogMediaId().getIdDog())
                .orElseThrow(() -> new RuntimeException("Where the dog at ?"+dogMedia.getDogMediaId().getIdDog()))
        ).collect(Collectors.toList());
    }

    public void delete(DogMediaId id) {
        Optional<DogMedia> dogMedia = getById(id);
        if(dogMedia.isPresent()){
            repositoryDogMedia.delete(dogMedia.get());
        }
    }

    public DogMedia save(DogMedia dogMedia) {
        return repositoryDogMedia.save(dogMedia);
    }
}